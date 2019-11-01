package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockStairBase extends BlockStairs {


    public BlockStairBase(String name, IBlockState modelState) {
        super(modelState);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);
        this.useNeighborBrightness = true;
    }

}
