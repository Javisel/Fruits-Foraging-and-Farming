package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockDoorBase extends BlockDoor {
    public BlockDoorBase(String name, Material materialIn, SoundType soundType) {
        super(materialIn);
        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(soundType);
    }
}
