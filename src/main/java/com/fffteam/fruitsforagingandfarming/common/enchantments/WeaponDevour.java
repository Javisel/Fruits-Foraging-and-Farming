package com.fffteam.fruitsforagingandfarming.common.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDurability;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;

public class WeaponDevour extends Enchantment {
    public WeaponDevour() {
        super(Rarity.UNCOMMON, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
        setName("devour");
        setRegistryName("devour");
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {

        return (!(ench instanceof WeaponLifesteal));
    }

    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {

        if (user instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) user;

            if (player.getFoodStats().getFoodLevel() < 20) {
                player.getFoodStats().addStats(1 + 1 * level, 2 + 1 * level);
                player.getHeldItemMainhand().damageItem(2, user);
            }
        }


    }
}
