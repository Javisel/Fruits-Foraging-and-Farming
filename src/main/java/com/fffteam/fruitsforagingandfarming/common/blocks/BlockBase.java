package com.fffteam.fruitsforagingandfarming.common.blocks;


import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {


    public BlockBase(Material material, String name, float hardness, float resistance, SoundType soundType) {

        super(material);

        setHardness(hardness);
        setResistance(resistance);
        setSoundType(soundType);
        setRegistryName(name);
        setUnlocalizedName(name);
    }

    public void registerItemModel(Item itemBlock) {
        String name = this.getUnlocalizedName();


        name = name.subSequence(5,name.length()).toString();


        FruitsForagingAndFarming.proxy.registerItemRenderer(itemBlock, 0, name);

    }
    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}