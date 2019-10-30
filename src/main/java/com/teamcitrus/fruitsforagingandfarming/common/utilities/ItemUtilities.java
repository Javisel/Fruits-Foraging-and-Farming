package com.teamcitrus.fruitsforagingandfarming.common.utilities;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

public class ItemUtilities {

    public static boolean hasExactEnchantment(ItemStack stack, Enchantment enchantment) {


        if (!stack.isItemEnchanted()) {
            return false;
        } else {

            for (int i = 0; i < stack.getEnchantmentTagList().tagCount(); i++) {
                if (Enchantment.getEnchantmentByID(stack.getEnchantmentTagList().getCompoundTagAt(i).getShort("id")).getName().equalsIgnoreCase(enchantment.getName())) {


                    return true;


                }

            }
        }

        return false;

    }

}
