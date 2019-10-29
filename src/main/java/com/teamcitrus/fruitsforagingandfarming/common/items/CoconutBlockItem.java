package com.teamcitrus.fruitsforagingandfarming.common.items;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoconutBlockItem  extends ItemBlock {
    public CoconutBlockItem() {
        super(BlockRegistration.coconut);
    }

    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();

        if (block == BlockRegistration.palmLeaves) {
            if (facing != EnumFacing.DOWN) {
                return EnumActionResult.FAIL;
            }

            pos = pos.offset(facing);

            if (worldIn.isAirBlock(pos)) {
                IBlockState iblockstate1 = BlockRegistration.coconut.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, 0, player, hand);
                worldIn.setBlockState(pos, iblockstate1, 10);

                if (!player.capabilities.isCreativeMode) {
                    player.getHeldItem(hand).shrink(1);
                }

                return EnumActionResult.SUCCESS;
            }
        }
        else {
            pos = pos.offset(facing);

            if (worldIn.isAirBlock(pos)) {
                IBlockState iblockstate1 = BlockRegistration.coconut.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, 0, player, hand);
                worldIn.setBlockState(pos, iblockstate1, 10);
                if (!player.capabilities.isCreativeMode) {
                    player.getHeldItem(hand).shrink(1);
                }

                return EnumActionResult.SUCCESS;

            }
        }

        return EnumActionResult.FAIL;

    }
}


