package com.fffteam.fruitsforagingandfarming.common.items;

import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IModelRegisterable{

            public ItemBase(String name) {

                setRegistryName(name);
                setUnlocalizedName(name);

            }

    public void registerItemModel() {


        FruitsForagingAndFarming.proxy.registerItemRenderer(this, 0, this.getUnlocalizedName());

    }

}
