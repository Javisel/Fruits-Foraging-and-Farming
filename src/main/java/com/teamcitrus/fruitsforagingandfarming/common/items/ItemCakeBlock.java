package com.teamcitrus.fruitsforagingandfarming.common.items;

import com.teamcitrus.fruitsforagingandfarming.common.blocks.CakeBase;
import net.minecraft.item.ItemBlock;

public class ItemCakeBlock extends ItemBlock {


    int foodlevel;
    float saturation;

    public ItemCakeBlock(CakeBase block) {
        super(block);
        foodlevel = block.getFoodheal();
        saturation = block.getSaturation();
    }

    public int getFoodlevel() {
        return foodlevel;
    }

    public float getSaturation() {
        return saturation;
    }

}
