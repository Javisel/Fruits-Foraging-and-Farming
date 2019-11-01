package com.teamcitrus.fruitsforagingandfarming.common.items;

import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String name) {

        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);

    }


}
