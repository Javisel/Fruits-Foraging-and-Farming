package com.teamcitrus.fruitsforagingandfarming.common.items;

import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemFoodBase extends ItemFood {

    int maxItemUseDuration;

    public ItemFoodBase(String name, int shanks, float saturation) {
        super(shanks, saturation, false);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        maxItemUseDuration = 32;
        this.setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);

    }

    public ItemFoodBase(String name, int amount) {
        super(amount, false);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return maxItemUseDuration;
    }

    public void setMaxItemUseDuration(int amount) {
        maxItemUseDuration = amount;
    }


}
