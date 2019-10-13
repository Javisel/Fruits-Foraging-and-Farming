package com.fffteam.fruitsforagingandfarming.common.items;

import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;

public class ItemFoodBase extends net.minecraft.item.ItemFood implements IModelRegisterable{


    public ItemFoodBase(String name, int amount, float saturation) {
        super(amount, saturation, false);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

        this.setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);

    }

    public ItemFoodBase(String name, int amount) {
        super(amount, false);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }

    @Override
    public void registerItemModel() {
        String name = this.getUnlocalizedName();


        name = name.subSequence(5,name.length()).toString();


        FruitsForagingAndFarming.proxy.registerItemRenderer(this, 0, name);

    }
}
