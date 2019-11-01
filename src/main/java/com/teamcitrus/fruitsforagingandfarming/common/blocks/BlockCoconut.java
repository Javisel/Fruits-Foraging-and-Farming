package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
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

public class BlockCoconut extends BlockBase {
    public static final PropertyInteger TYPE = net.minecraft.block.properties.PropertyInteger.create("type", 0, 1);


    private static final AxisAlignedBB[] COCONUT_AABB = {

            new AxisAlignedBB(0, 0, 0, 0.25, 0.25, 0.25).offset(0.375, 0, 0.375),
            new AxisAlignedBB(0, 0, 0, 0.25, 0.25, 0.25).offset(0.375, 0.75, 0.375)
    };

    public BlockCoconut() {
        super(Material.PLANTS, "coconut_block", 2, 2, SoundType.STONE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(getTypeInteger(), Integer.valueOf(0)));

        setLightOpacity(10);
    }

    protected static PropertyInteger getTypeInteger() {
        return TYPE;
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
        return new BlockStateContainer(this, TYPE);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return COCONUT_AABB[(state.getValue(getTypeInteger())).intValue()];
    }


    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        if (facing == EnumFacing.DOWN) {
            return this.getDefaultState().withProperty(TYPE, Integer.valueOf(1));
        } else {
            return this.getDefaultState().withProperty(TYPE, Integer.valueOf(0));
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
        return this.getDefaultState().withProperty(getTypeInteger(), Integer.valueOf(type));
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
        return state.getValue(getTypeInteger()).intValue();
    }
}
