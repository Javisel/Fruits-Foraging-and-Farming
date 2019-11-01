package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockHoneyMelon extends BlockBase {
    public static final PropertyInteger ROTATION = net.minecraft.block.properties.PropertyInteger.create("rotation", 0, 4);


    private static final AxisAlignedBB[] HONEY_MELONAABB = {

//STANDING
            new AxisAlignedBB(0, 0, 0, 0.75, .75, 0.75).offset(0.125,0,0.125),


            //NORTH
            new AxisAlignedBB(0, 0, 0, 0.75, 0.75, 0.75).offset(0.125,0,.25),
            //EAST
            new AxisAlignedBB(0, 0, 0, 0.75, 0.75, 0.75).offset(0,0,0.125),

            //SOUTH
            new AxisAlignedBB(0, 0, 0, 0.75, 0.75, 0.75).offset(0.125,0,0),

                //WEST
            new AxisAlignedBB(0, 0, 0, 0.75, 0.75, 0.75).offset(0.25,0,0.125),
            //

    };

    public BlockHoneyMelon() {
        super(Material.PLANTS, "honeymelon_block", 2, 2, SoundType.STONE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(getRotationInteger(), Integer.valueOf(0)));
        setLightOpacity(10);
    }

    protected static PropertyInteger getRotationInteger() {
        return ROTATION;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ItemRegistration.HONEYMELON_SLICE;
    }

    public int quantityDropped(Random random) {
        return 4;
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


    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ROTATION);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return HONEY_MELONAABB[(state.getValue(getRotationInteger())).intValue()];
    }


    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        if (facing == EnumFacing.DOWN || facing == EnumFacing.UP) {
            return this.getDefaultState().withProperty(ROTATION, Integer.valueOf(0));
        } else if (facing==EnumFacing.NORTH) {
            return this.getDefaultState().withProperty(ROTATION, Integer.valueOf(1));
        } else if (facing==EnumFacing.EAST) {
            return this.getDefaultState().withProperty(ROTATION, Integer.valueOf(2));
        }
        else if (facing==EnumFacing.SOUTH) {
            return this.getDefaultState().withProperty(ROTATION, Integer.valueOf(3));
        }
        else if (facing==EnumFacing.WEST) {
            return this.getDefaultState().withProperty(ROTATION, Integer.valueOf(4));
        } else {
            return this.getDefaultState().withProperty(ROTATION,Integer.valueOf(0));
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
        return this.withType(meta);
    }

    public IBlockState withType(int type) {
        return this.getDefaultState().withProperty(getRotationInteger(), Integer.valueOf(type));
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;

    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
        return false;
    }

    public int getMetaFromState(IBlockState state) {
        return this.getType(state);
    }

    public int getType(IBlockState state) {
        return state.getValue(getRotationInteger()).intValue();
    }
}
