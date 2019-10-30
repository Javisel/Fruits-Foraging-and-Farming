package com.teamcitrus.fruitsforagingandfarming.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.Random;

public class foodDurian extends ItemFoodBase {
    public foodDurian() {
        super("durian", 2, 1.0F);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {


        if (entityIn instanceof EntityPlayer) {

            EntityPlayer player = (EntityPlayer) entityIn;

            for (int i = 0; i < 8; i++) {
                if (player.inventory.mainInventory.get(i).getItem() == this && player.getActivePotionEffect(MobEffects.NAUSEA) != null) {
                    Random r = new Random();
                    int low = 5;
                    int high = 1000;
                    int result = r.nextInt(high - low) + low;

                    if (result == 5) {
                        player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200));
                    }
                    break;
                }

            }
        }


    }
}
