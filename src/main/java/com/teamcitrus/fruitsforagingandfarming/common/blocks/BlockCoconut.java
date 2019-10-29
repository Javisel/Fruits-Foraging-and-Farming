package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.items.CoconutBlockItem;
import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import scala.tools.nsc.doc.model.Public;

import javax.annotation.Nullable;

public class BlockCoconut extends BlockBase {
    public static final PropertyInteger TYPE = net.minecraft.block.properties.PropertyInteger.create("type", 0, 1);


    private static final AxisAlignedBB[] COCONUT_AABB = {

            new AxisAlignedBB(0,0,0,0.25,0.25,0.25).offset(0.375,0,0.375),
            new AxisAlignedBB(0,0,0,0.25,0.25,0.25).offset(0.375,0.75,0.375)
    };
    public BlockCoconut() {
        super(Material.ROCK, "coconut_block", 1.0F, 1.0F, SoundType.STONE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getTypeInteger(), Integer.valueOf(0)));

        setLightOpacity(10);
    }

    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public Item createItemBlock() {
        return new CoconutBlockItem().setRegistryName(getRegistryName());
    }

    protected static PropertyInteger getTypeInteger() {
        return TYPE;
    }
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE});
    }
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return COCONUT_AABB[(state.getValue(this.getTypeInteger())).intValue()];
    }



    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta,   EntityLivingBase placer)
    {
        if (facing == EnumFacing.DOWN)
        {
            return this.getDefaultState().withProperty(TYPE, Integer.valueOf(1));
        }
    else {
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
    public IBlockState getStateFromMeta(int meta)
    {
        return this.withType(meta);
    }

    public IBlockState withType(int type)
    {
        return this.getDefaultState().withProperty(this.getTypeInteger(), Integer.valueOf(type));
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
    public int getMetaFromState(IBlockState state)
    {
        return this.getType(state);
    }
    public int getType(IBlockState state)
    {
        return ((Integer)state.getValue(this.getTypeInteger())).intValue();
    }
}
