package com.fffteam.fruitsforagingandfarming.client.creativetabs;

import com.fffteam.fruitsforagingandfarming.common.registration.ItemRegistration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
    public CreativeTab(int index, String label) {
        super(index, label);
    }

    public CreativeTab(String label) {
        super(label);
        this.hasSearchBar();
      //  this.setBackgroundImageName("fruits_foraging_and_farming");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemRegistration.scytheDiamond);
    }
}
