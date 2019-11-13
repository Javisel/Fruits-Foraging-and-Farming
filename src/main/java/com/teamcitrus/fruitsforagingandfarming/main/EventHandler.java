package com.teamcitrus.fruitsforagingandfarming.main;

import com.teamcitrus.fruitsforagingandfarming.common.items.weapon.BaseWeapon;
import com.teamcitrus.fruitsforagingandfarming.common.registration.EnchantmentRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.MobEffectRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.utilities.MobUtilities;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;


public class EventHandler {


    static final Item[] fruits = {ItemRegistration.AVOCADO, ItemRegistration.KIWANO, ItemRegistration.BANANA, ItemRegistration.BLUEBERRY, ItemRegistration.KIWI, ItemRegistration.LEMON, ItemRegistration.LIME, ItemRegistration.MANGO, ItemRegistration.DURIAN, ItemRegistration.ORANGE, ItemRegistration.PEAR, ItemRegistration.PLUM, ItemRegistration.PINEAPPLE};
    static final Item[] seeds={ItemRegistration.GRASS_SEEDS,ItemRegistration.HONEYMELON_SEEDS,ItemRegistration.CORN_KERNEL};
    static  final  Item[] vanillaseeds={Items.WHEAT_SEEDS,Items.BEETROOT_SEEDS,Items.PUMPKIN_SEEDS,Items.MELON_SEEDS};
    @SubscribeEvent
    public void ModifyBlockDrops(BlockEvent.HarvestDropsEvent e) {

        if (e.getHarvester() !=null && !e.isSilkTouching() ) {
            if (e.getState() == Blocks.LEAVES.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE)) {

                for (int i = 0; i < e.getDrops().size(); i++) {

                    if (e.getDrops().get(i).getItem() == Item.getItemFromBlock(Blocks.LEAVES)) {
                        return;
                    }
                    Random random = new Random();
                    if (MathHelper.getInt(random, 1, 100) > (80 - (10 * e.getFortuneLevel()))) {

                        e.getDrops().add(new ItemStack(fruits[MathHelper.getInt(random, 0, fruits.length)], MathHelper.getInt(random, 1, 3)));


                    }


                }


            }

        }

        else if (e.getState()==Blocks.TALLGRASS) {

            Random random = new Random();

            if (e.getFortuneLevel() >0) {

                if (MathHelper.getInt(random,1,100) > (90-(10*e.getFortuneLevel()))) {

                    e.getDrops().add(new ItemStack(vanillaseeds[MathHelper.getInt(random,0,vanillaseeds.length)],MathHelper.getInt(random,1,e.getFortuneLevel())));

                }



            }

            if (MathHelper.getInt(random, 1, 100) > (50 - (10 * e.getFortuneLevel()))) {


                e.getDrops().add(new ItemStack(seeds[MathHelper.getInt(random, 0, seeds.length)], MathHelper.getInt(random, 1, 3)));


            }




            }


    }

    @SubscribeEvent
    public void VoidBlockDrop(BlockEvent.HarvestDropsEvent e) {


        if (e.getHarvester() != null && !e.getHarvester().getHeldItemMainhand().isEmpty() && e.getHarvester().getHeldItemMainhand().isItemEnchanted()) {


            if (EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistration.VOID, e.getHarvester().getHeldItemMainhand()) > 0) {
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

            if (EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistration.VOID, harvester.getHeldItemMainhand()) > 0) {
                e.setCanceled(true);
            }

        }


    }


    @SubscribeEvent

    public void PatreonDonation(ItemTooltipEvent e) {


    }



    @SubscribeEvent
    public void InfestationExplosion(LivingDeathEvent e) {

        if (e.getEntityLiving().getActivePotionEffect(MobEffectRegistration.INFESTATION) != null) {

            int remainingduration = e.getEntityLiving().getActivePotionEffect(MobEffectRegistration.INFESTATION).getDuration() % 20;

            for (int i = 0; i < remainingduration * (1 + e.getEntityLiving().getActivePotionEffect(MobEffectRegistration.INFESTATION).getAmplifier()); i++) {

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

                        if (EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistration.LIFESTEAL, attacker.getHeldItemMainhand()) > 0) {

                            float healamount = e.getAmount() * (0.05F + (0.05F * EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistration.LIFESTEAL, attacker.getHeldItemMainhand())));
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
