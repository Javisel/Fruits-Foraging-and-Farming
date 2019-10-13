package com.fffteam.fruitsforagingandfarming.common.blocks;

import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class CropBase extends BlockCrops {

    Item seed;
    Item crop;
    public CropBase(String name, Item seed, Item crop) {



        setRegistryName(name);
        setUnlocalizedName(name);
        this.seed=seed;
        this.crop=crop;
    }



    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return super.getBoundingBox(state, source, pos);
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return super.canSustainBush(state);
    }

    @Override
    protected PropertyInteger getAgeProperty() {
        return super.getAgeProperty();
    }

    @Override
    public int getMaxAge() {
        return super.getMaxAge();
    }

    @Override
    protected int getAge(IBlockState state) {
        return super.getAge(state);
    }

    @Override
    public IBlockState withAge(int age) {
        return super.withAge(age);
    }

    @Override
    public boolean isMaxAge(IBlockState state) {
        return super.isMaxAge(state);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);
    }

    @Override
    public void grow(World worldIn, BlockPos pos, IBlockState state) {
        super.grow(worldIn, pos, state);
    }

    @Override
    protected int getBonemealAgeIncrease(World worldIn) {
        return super.getBonemealAgeIncrease(worldIn);
    }

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        return super.canBlockStay(worldIn, pos, state);
    }

    @Override
    protected Item getSeed() {
        return seed;
    }

    @Override
    protected Item getCrop() {
        return crop;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        super.getDrops(drops, world, pos, state, fortune);
    }

    @Override
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return super.getItemDropped(state, rand, fortune);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return super.getItem(worldIn, pos, state);
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return super.canGrow(worldIn, pos, state, isClient);
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return super.canUseBonemeal(worldIn, rand, pos, state);
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        super.grow(worldIn, rand, pos, state);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return super.getStateFromMeta(meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return super.getMetaFromState(state);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return super.createBlockState();
    }

    public void registerItemModel(Item itemBlock) {
        String name = this.getUnlocalizedName();


        name = name.subSequence(5,name.length()).toString();


        FruitsForagingAndFarming.proxy.registerItemRenderer(itemBlock, 0, name);

    }
    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
