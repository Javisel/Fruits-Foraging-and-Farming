package com.teamcitrus.fruitsforagingandfarming.common;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

public class BlockStateHolder implements IBlockState {
    @Override
    public Collection<IProperty<?>> getPropertyKeys() {
        return null;
    }

    @Override
    public <T extends Comparable<T>> T getValue(IProperty<T> property) {
        return null;
    }

    @Override
    public <T extends Comparable<T>, V extends T> IBlockState withProperty(IProperty<T> property, V value) {
        return null;
    }

    @Override
    public <T extends Comparable<T>> IBlockState cycleProperty(IProperty<T> property) {
        return null;
    }

    @Override
    public ImmutableMap<IProperty<?>, Comparable<?>> getProperties() {
        return null;
    }

    @Override
    public Block getBlock() {
        return null;
    }

    @Override
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, int id, int param) {
        return false;
    }

    @Override
    public void neighborChanged(World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

    }

    @Override
    public Material getMaterial() {
        return null;
    }

    @Override
    public boolean isFullBlock() {
        return false;
    }

    @Override
    public boolean canEntitySpawn(Entity entityIn) {
        return false;
    }

    @Override
    public int getLightOpacity() {
        return 0;
    }

    @Override
    public int getLightOpacity(IBlockAccess world, BlockPos pos) {
        return 0;
    }

    @Override
    public int getLightValue() {
        return 0;
    }

    @Override
    public int getLightValue(IBlockAccess world, BlockPos pos) {
        return 0;
    }

    @Override
    public boolean isTranslucent() {
        return false;
    }

    @Override
    public boolean useNeighborBrightness() {
        return false;
    }

    @Override
    public MapColor getMapColor(IBlockAccess p_185909_1_, BlockPos p_185909_2_) {
        return null;
    }

    @Override
    public IBlockState withRotation(Rotation rot) {
        return null;
    }

    @Override
    public IBlockState withMirror(Mirror mirrorIn) {
        return null;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean hasCustomBreakingProgress() {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType() {
        return null;
    }

    @Override
    public int getPackedLightmapCoords(IBlockAccess source, BlockPos pos) {
        return 0;
    }

    @Override
    public float getAmbientOcclusionLightValue() {
        return 0;
    }

    @Override
    public boolean isBlockNormalCube() {
        return false;
    }

    @Override
    public boolean isNormalCube() {
        return false;
    }

    @Override
    public boolean canProvidePower() {
        return false;
    }

    @Override
    public int getWeakPower(IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return 0;
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return false;
    }

    @Override
    public int getComparatorInputOverride(World worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public float getBlockHardness(World worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public float getPlayerRelativeBlockHardness(EntityPlayer player, World worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public int getStrongPower(IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return 0;
    }

    @Override
    public EnumPushReaction getMobilityFlag() {
        return null;
    }

    @Override
    public IBlockState getActualState(IBlockAccess blockAccess, BlockPos pos) {
        return null;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos) {
        return null;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, BlockPos pos, EnumFacing facing) {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockAccess worldIn, BlockPos pos) {
        return null;
    }

    @Override
    public void addCollisionBoxToList(World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185908_6_) {

    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockAccess blockAccess, BlockPos pos) {
        return null;
    }

    @Override
    public RayTraceResult collisionRayTrace(World worldIn, BlockPos pos, Vec3d start, Vec3d end) {
        return null;
    }

    @Override
    public boolean isTopSolid() {
        return false;
    }

    @Override
    public boolean doesSideBlockRendering(IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean doesSideBlockChestOpening(IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public Vec3d getOffset(IBlockAccess access, BlockPos pos) {
        return null;
    }

    @Override
    public boolean causesSuffocation() {
        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess p_193401_1_, BlockPos p_193401_2_, EnumFacing p_193401_3_) {
        return null;
    }
}
