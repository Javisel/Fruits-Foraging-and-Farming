package com.fffteam.fruitsforagingandfarming.common.items;

import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;

public class ItemSeedFoodBase extends ItemSeedFood implements IModelRegisterable{
    public ItemSeedFoodBase( String name, int healAmount, float saturation, Block crops, Block soil) {
        super(healAmount, saturation, crops, soil);
        setRegistryName(name);
        setUnlocalizedName(name);

    }

    @Override
    public void registerItemModel() {
        String name = this.getUnlocalizedName();


        name = name.subSequence(5,name.length()).toString();


        FruitsForagingAndFarming.proxy.registerItemRenderer(this, 0, name);

    }
}
