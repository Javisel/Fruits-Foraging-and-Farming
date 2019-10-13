package com.fffteam.fruitsforagingandfarming.common.items;

import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IModelRegisterable{

            public ItemBase(String name) {

                setRegistryName(name);
                setUnlocalizedName(name);
                this.setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);

            }

    @Override
    public void registerItemModel() {
        String name = this.getUnlocalizedName();


        name = name.subSequence(5,name.length()).toString();


        FruitsForagingAndFarming.proxy.registerItemRenderer(this, 0, name);

    }

}
