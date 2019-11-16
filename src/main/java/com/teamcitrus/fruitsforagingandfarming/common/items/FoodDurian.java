package com.teamcitrus.fruitsforagingandfarming.common.items;

import com.teamcitrus.fruitsforagingandfarming.main.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class FoodDurian extends ItemFoodBase {
    public FoodDurian() {
        super("durian", ConfigHandler.DURIAN_SHANKS, ConfigHandler.DURIAN_SAT);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {




    }
}
