package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCoconut extends BlockFalling implements IGrowable {

    public static final PropertyInteger STAGE = net.minecraft.block.properties.PropertyInteger.create("type", 0, 4);


    private static final AxisAlignedBB[] COCONUT_AABB = {


            //STAGE 0 "Newborn"
            new AxisAlignedBB(0, 0, 0, 0.25, 0.25, 0.25).offset(0.375, 0.75, 0.375),
            //Stage 1: Mid-Way
            new AxisAlignedBB(0, 0, 0, 0.375, 0.375, 0.375).offset(0.250, 0.625, .25),
            //Stage 2 Adult, on Tree
            new AxisAlignedBB(0, 0, 0, .5, .5, .5).offset(.10, .3125, .10),
            //Stage 3 Adult, about to fall
            new AxisAlignedBB(0, 0, 0, .5, .5, .5).offset(.10, 0, .10),

            //Stage 4, On Ground
            new AxisAlignedBB(0, 0, 0, .5, .5, .5).offset(.10, 0, .10)

    };

    public BlockCoconut() {
        super(Material.PLANTS);
        this.setRegistryName("coconut");
        setUnlocalizedName("coconut");
        this.setDefaultState(this.blockState.getBaseState().withProperty(getAgeProperty(), Integer.valueOf(0)));

        setLightOpacity(0);
    }

    protected PropertyInteger getAgeProperty() {
        return STAGE;
    }
    protected int getAge(IBlockState state) {
        return state.getValue(this.getAgeProperty()).intValue();
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(BlockRegistration.COCONUT_BLOCK);
    }

    public int quantityDropped(Random random) {
        return 1;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, Random random) {
        return 1;
    }

    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }


    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, STAGE);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return COCONUT_AABB[(state.getValue(getAgeProperty())).intValue()];
    }


    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        if (facing == EnumFacing.DOWN) {
            return this.getDefaultState().withProperty(STAGE, Integer.valueOf(1));
        } else {
            return this.getDefaultState().withProperty(STAGE, Integer.valueOf(0));
        }

    }


    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isNormalCube(IBlockState state) {
        return false;
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.withAge(meta);
    }

    public IBlockState withAge(int type) {
        return this.getDefaultState().withProperty(getAgeProperty(), Integer.valueOf(type));
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;

    }


    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }


    public int getMetaFromState(IBlockState state) {
        return this.getType(state);
    }

    public int getType(IBlockState state) {
        return state.getValue(getAgeProperty()).intValue();
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {

    }
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);

        if (!worldIn.isAreaLoaded(pos, 1))
            return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
            int i = this.getAge(state);

            if (i < 4) {
                float f = MathHelper.getInt(rand,1,100);

                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int) (25.0F / f) + 1) == 0)) {
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                }

                if (i==3) {


                }


            }
        }
    }


}
