package com.fffteam.fruitsforagingandfarming.common.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GrassSeeds extends SeedBase {
    public GrassSeeds() {
        super("grass_seeds", Blocks.GRASS, Blocks.DIRT);
    }


    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack)  && worldIn.isAirBlock(pos.up()))
        {

            if (worldIn.getBlockState(pos).getBlock() instanceof BlockDirt) {
                worldIn.setBlockState(pos, Blocks.GRASS.getDefaultState());
            }
            else if (worldIn.getBlockState(pos).getBlock() instanceof BlockGrass) {
                worldIn.setBlockState(pos.up(),Blocks.TALLGRASS.getStateFromMeta(1));

            }
            else if (worldIn.getBlockState(pos).getBlock() instanceof BlockTallGrass && worldIn.isAirBlock(pos.up(2))) {

                worldIn.setBlockToAir(pos);
                Blocks.DOUBLE_PLANT.placeAt(worldIn,pos, BlockDoublePlant.EnumPlantType.GRASS,0);


            }
            if (player instanceof EntityPlayerMP)
            {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), itemstack);
            }

            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        }
        else
        {
            return EnumActionResult.FAIL;
        }
    }
}
