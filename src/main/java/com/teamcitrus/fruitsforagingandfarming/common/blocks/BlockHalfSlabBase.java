package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;

public class BlockHalfSlabBase extends BlockSlabBase
{
    public BlockHalfSlabBase(String name, Material material, SoundType sound, BlockSlab half)
    {
        super(name, material, half);
        setSoundType(sound);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);

    }

    @Override
    public boolean isDouble()
    {
        return false;
    }
    public Item createItemBlock() {

        return new ItemSlab(this,this, BlockRegistration.palmdoubleslab).setRegistryName(getRegistryName());
    }

    public void registerItemModel(Item itemBlock) {
        String name = this.getUnlocalizedName();


        name = name.subSequence(5,name.length()).toString();


        FruitsForagingAndFarming.proxy.registerItemRenderer(itemBlock, 0, name);

    }
}