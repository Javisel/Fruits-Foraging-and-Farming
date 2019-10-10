package com.fffteam.fruitsforagingandfarming.common.items;

import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;

public class ItemFood extends net.minecraft.item.ItemFood implements IModelRegisterable{


    public ItemFood(String name, int amount, float saturation) {
        super(amount, saturation, false);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }

    public ItemFood(String name, int amount) {
        super(amount, false);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }

    @Override
    public void registerItemModel() {
        FruitsForagingAndFarming.proxy.registerItemRenderer(this, 0, this.getUnlocalizedName());

    }
}
