package com.teamcitrus.fruitsforagingandfarming.common.items;

import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;

public class ItemSeedFoodBase extends ItemSeedFood {
    public ItemSeedFoodBase(String name, int healAmount, float saturation, Block crops, Block soil) {
        super(healAmount, saturation, crops, soil);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);

    }


}
