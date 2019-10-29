package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class WoodFenceBase extends BlockFenceBase {


    public WoodFenceBase(String name,  MapColor mapColorIn) {
        super(name, Material.WOOD, mapColorIn);
        setSoundType(SoundType.WOOD);
        setHardness(2);
        setResistance(5);
        setHarvestLevel("axe",1);
        BlockRegistration.BLOCKS.add(this);

    }
}
