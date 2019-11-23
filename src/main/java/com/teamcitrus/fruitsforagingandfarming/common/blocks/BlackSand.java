package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockSand;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

public class BlackSand extends BlockFalling {

    public BlackSand(){
        super(Material.SAND);
        setRegistryName("black_sand");
        setUnlocalizedName("black_sand");
        setHardness(0.5F);
        setSoundType(SoundType.SAND);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);
    }


}
