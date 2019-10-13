package com.fffteam.fruitsforagingandfarming.main;

import com.fffteam.fruitsforagingandfarming.common.enchantments.AllVoid;
import com.fffteam.fruitsforagingandfarming.common.enchantments.WeaponLifesteal;
import com.fffteam.fruitsforagingandfarming.common.items.weapon.BaseWeapon;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void VoidBlockDrop(BlockEvent.HarvestDropsEvent e) {


        if ( e.getHarvester()!=null && !e.getHarvester().getHeldItemMainhand().isEmpty() && e.getHarvester().getHeldItemMainhand().isItemEnchanted()) {

            for (int i =0; i <e.getHarvester().getHeldItemMainhand().getEnchantmentTagList().tagCount();i++) {

                if (Enchantment.getEnchantmentByID(e.getHarvester().getHeldItemMainhand().getEnchantmentTagList().getCompoundTagAt(i).getShort("id")) instanceof AllVoid) {
                    e.setDropChance(0.0F);
                }

            }

        }
    }
    @SubscribeEvent
    public void VoidItemDrop(LivingDropsEvent e) {
        if (e.getSource().getTrueSource() instanceof  EntityPlayer && !(e.getEntityLiving() instanceof  EntityWither)){

            for (int i =0; i<e.getDrops().size();i++) {
                if (e.getDrops().get(i).getItem().isItemEnchanted()) {
                    return;
                }
                else if (e.getDrops().get(i).getItem().getItem() instanceof ItemSkull) {

                    return;
                }
            }

            EntityPlayer harvester = (EntityPlayer) e.getSource().getTrueSource();
       if (harvester.getHeldItemMainhand().isItemEnchanted()) {

            for (int i =0; i <harvester.getHeldItemMainhand().getEnchantmentTagList().tagCount();i++) {

                if (Enchantment.getEnchantmentByID(harvester.getHeldItemMainhand().getEnchantmentTagList().getCompoundTagAt(i).getShort("id")) instanceof AllVoid) {
                    e.setCanceled(true);
                }

            }}

        }
    }


    @SubscribeEvent
    public void Lifesteal(LivingDamageEvent e) {

        if (e.getSource().getTrueSource() instanceof EntityLivingBase){
            EntityLivingBase attacker = (EntityLivingBase) e.getSource().getTrueSource();

            if (e.getSource().getImmediateSource() == attacker) {
               if (attacker.getHeldItemMainhand().isItemEnchanted() && attacker.getHealth() < attacker.getMaxHealth()) {

                   for (int i=0; i<attacker.getHeldItemMainhand().getEnchantmentTagList().tagCount();i++) {

                       if (Enchantment.getEnchantmentByID(attacker.getHeldItemMainhand().getEnchantmentTagList().getCompoundTagAt(i).getShort("id")) instanceof   WeaponLifesteal) {

                     float healamount = e.getAmount() * (0.10F+(0.05F*attacker.getHeldItemMainhand().getEnchantmentTagList().getCompoundTagAt(i).getShort("lvl")));
                    attacker.heal(healamount);

                    if (attacker instanceof EntityPlayer) {
                        ((EntityPlayer) attacker).getFoodStats().setFoodSaturationLevel(((EntityPlayer) attacker).getFoodStats().getSaturationLevel()-2.0F);

                    }
                      }

                   }
               }

            }

        }

    }

    @SubscribeEvent
    public void TwoHandedWeapon(LivingEquipmentChangeEvent e) {

        if (e.getSlot() == EntityEquipmentSlot.MAINHAND) {

            if (e.getTo().getItem() instanceof BaseWeapon) {

                if ( ((BaseWeapon) e.getTo().getItem()).isTwoHanded()) {

                    if (!e.getEntityLiving().getHeldItemOffhand().isEmpty()) {
                        ItemStack oldstack = e.getEntityLiving().getHeldItemOffhand();

                        e.getEntityLiving().entityDropItem(oldstack, 0);

                        e.getEntityLiving().setHeldItem(EnumHand.OFF_HAND, ItemStack.EMPTY);


                    }

                }
            }
        }
        else if (e.getSlot() == EntityEquipmentSlot.OFFHAND) {

            if (e.getEntityLiving().getHeldItemMainhand().getItem() instanceof BaseWeapon) {

                if (((BaseWeapon) e.getEntityLiving().getHeldItemMainhand().getItem()).isTwoHanded()) {
                    ItemStack oldstack = e.getEntityLiving().getHeldItemOffhand();

                    e.getEntityLiving().entityDropItem(oldstack, 0);

                    e.getEntityLiving().setHeldItem(EnumHand.OFF_HAND, ItemStack.EMPTY);


                }
            }
        }

    }
}
