package com.teamcitrus.fruitsforagingandfarming.main;

import com.teamcitrus.fruitsforagingandfarming.common.items.weapon.BaseWeapon;
import com.teamcitrus.fruitsforagingandfarming.common.registration.EnchantmentRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.MobEffectRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.utilities.MobUtilities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class EventHandler {





    @SubscribeEvent
    public void VoidBlockDrop(BlockEvent.HarvestDropsEvent e) {


        if (e.getHarvester() != null && !e.getHarvester().getHeldItemMainhand().isEmpty() && e.getHarvester().getHeldItemMainhand().isItemEnchanted()) {



            if (EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistration.allVoid,e.getHarvester().getHeldItemMainhand()) > 0) {
                    e.setDropChance(0);
            }

        }
    }

    @SubscribeEvent
    public void VoidItemDrop(LivingDropsEvent e) {
        if (e.getSource().getTrueSource() instanceof EntityPlayer && !(e.getEntityLiving() instanceof EntityWither)) {

            for (int i = 0; i < e.getDrops().size(); i++) {
                if (e.getDrops().get(i).getItem().isItemEnchanted()) {
                    return;
                } else if (e.getDrops().get(i).getItem().getItem() instanceof ItemSkull) {

                    return;
                }
            }

            EntityPlayer harvester = (EntityPlayer) e.getSource().getTrueSource();

                    if (EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistration.allVoid,harvester.getHeldItemMainhand()) > 0) {
                        e.setCanceled(true);
                    }

                }


        }


    @SubscribeEvent
    public void InfestedStone(LivingDropsEvent e) {

        if (e.getEntityLiving() instanceof EntitySilverfish) {

            Random r = new Random();
            int low = 0;
            int high = 3;
            int result = r.nextInt(high - low) + low;

            if (result > 0) {

                EntityItem theitem = new EntityItem(e.getEntityLiving().getEntityWorld(), e.getEntityLiving().posX, e.getEntityLiving().posY, e.getEntityLiving().posZ, new ItemStack(ItemRegistration.foodInfestedPebble, result));
                e.getDrops().add(theitem);
            }

        }

    }

    @SubscribeEvent
    public void InfestationExplosion(LivingDeathEvent e) {

        if (e.getEntityLiving().getActivePotionEffect(MobEffectRegistration.infestation) != null) {

            int remainingduration = e.getEntityLiving().getActivePotionEffect(MobEffectRegistration.infestation).getDuration() % 20;

            for (int i = 0; i < remainingduration * (1 + e.getEntityLiving().getActivePotionEffect(MobEffectRegistration.infestation).getAmplifier()); i++) {

                MobUtilities.spawnCreature(e.getEntityLiving().getEntityWorld(),
                        new EntitySilverfish(e.getEntityLiving().world), e.getEntityLiving().posX,
                        e.getEntityLiving().posY + (e.getEntityLiving().height * 0.5), e.getEntityLiving().posZ);
            }


        }


    }

    @SubscribeEvent
    public void Lifesteal(LivingDamageEvent e) {

        if (e.getSource().getTrueSource() instanceof EntityLivingBase) {
            EntityLivingBase attacker = (EntityLivingBase) e.getSource().getTrueSource();

            if (e.getSource().getImmediateSource() == attacker) {
                if (attacker.getHealth() < attacker.getMaxHealth()) {

                    for (int i = 0; i < attacker.getHeldItemMainhand().getEnchantmentTagList().tagCount(); i++) {

                        if (EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistration.weaponLifesteal,attacker.getHeldItemMainhand()) > 0) {

                            float healamount = e.getAmount() * (0.10F + (0.05F * EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistration.weaponLifesteal,attacker.getHeldItemMainhand())));
                            attacker.heal(healamount);
                            attacker.getHeldItemMainhand().damageItem(1, attacker);

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

                if (((BaseWeapon) e.getTo().getItem()).isTwoHanded()) {

                    if (!e.getEntityLiving().getHeldItemOffhand().isEmpty()) {
                        ItemStack oldstack = e.getEntityLiving().getHeldItemOffhand();

                        e.getEntityLiving().entityDropItem(oldstack, 0);

                        e.getEntityLiving().setHeldItem(EnumHand.OFF_HAND, ItemStack.EMPTY);


                    }

                }
            }
        } else if (e.getSlot() == EntityEquipmentSlot.OFFHAND) {

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
