package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockFruit extends BlockBush {

    private static final AxisAlignedBB[] FRUITAABB = {

            new AxisAlignedBB(0, 0, 0, 0.9375, 0.8125,0.9375).offset(0.0625, 0.1875, 0.0625)

    };


    public BlockFruit(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);

    }



    protected BlockFruit(Material materialIn, MapColor mapColorIn) {
        super(materialIn, mapColorIn);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {


        return worldIn.getBlockState(pos.up()).getBlock() instanceof BlockLeaves;
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return super.canSustainBush(state);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

        if (!(worldIn.getBlockState(pos.up()).getBlock() instanceof BlockLeaves)) {
            this.dropBlockAsItem(worldIn,pos,state,0);
        }
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);
    }

    @Override
    protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state) {
        super.checkAndDropBlock(worldIn, pos, state);
    }

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {

        return (worldIn.getBlockState(pos.up()).getBlock() instanceof  BlockLeaves);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return FRUITAABB[0];
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return super.getPlant(world, pos);
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return super.getBlockLayer();
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_) {
        return super.getBlockFaceShape(p_193383_1_, p_193383_2_, p_193383_3_, p_193383_4_);
    }
}
