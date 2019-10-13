package com.fffteam.fruitsforagingandfarming.common.utilities;

import com.fffteam.fruitsforagingandfarming.common.enchantments.WeaponLifesteal;
import com.google.common.collect.Multimap;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class ItemUtilities {

            public static boolean hasEnchantment(ItemStack stack, Enchantment enchantment) {


                if (!stack.isItemEnchanted())  {return false;}

                else {

                    for (int i =0; i < stack.getEnchantmentTagList().tagCount(); i ++) {
                        if (Enchantment.getEnchantmentByID(stack.getEnchantmentTagList().getCompoundTagAt(i).getShort("id")).getName().equalsIgnoreCase( enchantment.getName())) {


                            return  true;



                        }

                    }
                }

        return  false;

            }

}
