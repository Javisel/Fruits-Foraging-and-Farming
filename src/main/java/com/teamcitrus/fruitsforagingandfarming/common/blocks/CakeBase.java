package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.BlockCake;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CakeBase extends BlockCake {


    int foodheal;
    float saturation;

    public CakeBase(String name, int foodheal, float saturation) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);

        this.setHardness(0.5F);
        setSoundType(SoundType.CLOTH);
        this.foodheal = foodheal;
        this.saturation = saturation;
    }

    public int getFoodheal() {
        return foodheal;
    }

    public float getSaturation() {
        return saturation;
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            return this.eatCake(worldIn, pos, state, playerIn);
        } else {
            ItemStack itemstack = playerIn.getHeldItem(hand);
            return this.eatCake(worldIn, pos, state, playerIn) || itemstack.isEmpty();
        }
    }

    private boolean eatCake(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (!player.canEat(false)) {
            return false;
        } else {
            player.addStat(StatList.CAKE_SLICES_EATEN);
            player.getFoodStats().addStats(foodheal, saturation);
            int i = state.getValue(BITES).intValue();

            if (i < 6) {
                worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                worldIn.setBlockToAir(pos);
            }

            return true;
        }
    }


}
