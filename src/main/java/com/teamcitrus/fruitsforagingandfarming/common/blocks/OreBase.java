package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.Random;

public class OreBase extends BlockOre {

    Item drop;

    public OreBase(String name, Item drop, float hardness, float resistance) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.drop = drop;
        this.setHardness(hardness);
        this.setResistance(resistance);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);

    }



    public Item getItemDropped(IBlockState state, Random rand, int fortune) {


        return drop;

    }


}
