package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;

public class BlockRotatedPillarBase extends BlockRotatedPillar {


    protected BlockRotatedPillarBase(String name, Material materialIn) {
        super(materialIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);
    }
}
