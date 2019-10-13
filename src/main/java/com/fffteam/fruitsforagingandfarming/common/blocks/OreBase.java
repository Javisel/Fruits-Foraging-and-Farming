package com.fffteam.fruitsforagingandfarming.common.blocks;

import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Random;

public class OreBase extends BlockOre {

    Item drop;

    public OreBase(String name, Item drop, float hardness, float resistance) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.drop = drop;
       this. setHardness(hardness);
        this.setResistance(resistance);
    }

    public void registerItemModel(Item itemBlock) {
        String name = this.getUnlocalizedName();


        name = name.subSequence(5, name.length()).toString();


        FruitsForagingAndFarming.proxy.registerItemRenderer(itemBlock, 0, name);

    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune){


        return drop;

    }


    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
