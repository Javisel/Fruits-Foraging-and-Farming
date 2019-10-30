package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockFenceBase extends BlockFence {


    public BlockFenceBase(String name, Material materialIn, MapColor mapColorIn) {
        super(materialIn, mapColorIn);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);

    }



}
