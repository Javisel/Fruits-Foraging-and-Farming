package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class FenceGateBase extends BlockFenceGate {


    public FenceGateBase(String name) {
        super(BlockPlanks.EnumType.OAK);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);


    }


}


