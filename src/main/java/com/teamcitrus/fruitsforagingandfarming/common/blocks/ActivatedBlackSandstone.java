package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ActivatedBlackSandstone extends BlockBase {
    public ActivatedBlackSandstone() {
        super(Material.ROCK, "black_sandstone_chiseled", .8F, .5F, SoundType.STONE);
    }


    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(BlockRegistration.BLACK_SANDSTONE_CHISELED);
    }




    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {

        return  new ItemStack(Item.getItemFromBlock(BlockRegistration.ACTIVATED_BLACK_SANDSTONE),1);
    }
}
