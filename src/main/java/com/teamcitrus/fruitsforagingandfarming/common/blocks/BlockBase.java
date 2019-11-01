package com.teamcitrus.fruitsforagingandfarming.common.blocks;


import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {


    public BlockBase(Material material, String name, float hardness, float resistance, SoundType soundType) {

        super(material);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);
        setHardness(hardness);
        setResistance(resistance);
        setSoundType(soundType);
        setRegistryName(name);
        setUnlocalizedName(name);
    }


}
