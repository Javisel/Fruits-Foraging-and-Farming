package com.teamcitrus.fruitsforagingandfarming.main;

import com.teamcitrus.fruitsforagingandfarming.common.enchantments.Void;
import com.teamcitrus.fruitsforagingandfarming.common.enchantments.Lifesteal;
import com.teamcitrus.fruitsforagingandfarming.common.items.ChocolateMilkBucket;
import com.teamcitrus.fruitsforagingandfarming.common.items.weapon.BaseWeapon;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.MobEffectRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.utilities.MobUtilities;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.Random;

public class EventHandler {

    @SubscribeEvent
    public void ChocolateMilkBuckets(PlayerEvent.ItemCraftedEvent e) {

            if (e.crafting.getItem()== Item.getItemFromBlock(BlockRegistration.chocolateCake)) {
                e.player.addItemStackToInventory(new ItemStack(Items.BUCKET,3));
        }
            else if (e.crafting.getItem()==ItemRegistration.chocolateMilkBottle) {
                for (int i = 0; i < e.craftMatrix.getFieldCount();i++) {
                    if (e.craftMatrix.getStackInSlot(i).getItem() instanceof ChocolateMilkBucket) {
                       ItemStack thebucket = e.craftMatrix.getStackInSlot(i);
                       thebucket.damageItem(1,e.player);

                       if (thebucket.isEmpty()) {
                       e.player.addItemStackToInventory(new ItemStack(Items.BUCKET));
                       } else{
                           e.player.addItemStackToInventory(thebucket);
                       }



                    }

                }
            }
    }

  @  SubscribeEvent
    public void DropCorn(BlockEvent.HarvestDropsEvent e) {

        if (e.getWorld().getBlockState(e.getPos()).getBlock() ==  BlockRegistration.cropCorn) {

            for (int i=0; i <e.getDrops().size(); i++) {

                if (e.getDrops().get(i).getItem() == ItemRegistration.foodCorn) {
                    if (e.getDrops().get(i).getCount() <4);
                    e.getDrops().get(i).setCount(4);
                    break;
                }

            }
        }

    }

    @SubscribeEvent
    public void VoidBlockDrop(BlockEvent.HarvestDropsEvent e) {


        if ( e.getHarvester()!=null && !e.getHarvester().getHeldItemMainhand().isEmpty() && e.getHarvester().getHeldItemMainhand().isItemEnchanted()) {

            for (int i =0; i <e.getHarvester().getHeldItemMainhand().getEnchantmentTagList().tagCount();i++) {

                if (Enchantment.getEnchantmentByID(e.getHarvester().getHeldItemMainhand().getEnchantmentTagList().getCompoundTagAt(i).getShort("id")) instanceof Void) {
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

                if (Enchantment.getEnchantmentByID(harvester.getHeldItemMainhand().getEnchantmentTagList().getCompoundTagAt(i).getShort("id")) instanceof Void) {
                    e.setCanceled(true);
                }

            }}

        }
    }

    @SubscribeEvent
    public void InfestedStone(LivingDropsEvent e) {

        if (e.getEntityLiving() instanceof EntitySilverfish) {

            Random r = new Random();
            int low = 0;
            int high = 3;
            int result = r.nextInt(high-low) + low;

            if (result>0) {

                EntityItem theitem = new EntityItem(e.getEntityLiving().getEntityWorld(),e.getEntityLiving().posX,e.getEntityLiving().posY,e.getEntityLiving().posZ,new ItemStack(ItemRegistration.foodInfestedPebble,result));
                e.getDrops().add (theitem);
            }

        }

    }

    @SubscribeEvent
    public void InfestationExplosion(LivingDeathEvent e) {

        if (e.getEntityLiving().getActivePotionEffect(MobEffectRegistration.infestation) !=null) {

            int remainingduration = e.getEntityLiving().getActivePotionEffect(MobEffectRegistration.infestation).getDuration() % 20;

            for (int i = 0; i <remainingduration * (1+ e.getEntityLiving().getActivePotionEffect(MobEffectRegistration.infestation).getAmplifier());i++) {

                MobUtilities.spawnCreature(e.getEntityLiving().getEntityWorld(),
                        new EntitySilverfish(e.getEntityLiving().world), e.getEntityLiving().posX,
                        e.getEntityLiving().posY + (e.getEntityLiving().height * 0.5), e.getEntityLiving().posZ);
            }


        }


    }

    @SubscribeEvent
    public void Lifesteal(LivingDamageEvent e) {

        if (e.getSource().getTrueSource() instanceof EntityLivingBase){
            EntityLivingBase attacker = (EntityLivingBase) e.getSource().getTrueSource();

            if (e.getSource().getImmediateSource() == attacker) {
               if (attacker.getHeldItemMainhand().isItemEnchanted() && attacker.getHealth() < attacker.getMaxHealth()) {

                   for (int i=0; i<attacker.getHeldItemMainhand().getEnchantmentTagList().tagCount();i++) {

                       if (Enchantment.getEnchantmentByID(attacker.getHeldItemMainhand().getEnchantmentTagList().getCompoundTagAt(i).getShort("id")) instanceof Lifesteal) {

                     float healamount = e.getAmount() * (0.10F+(0.05F*attacker.getHeldItemMainhand().getEnchantmentTagList().getCompoundTagAt(i).getShort("lvl")));
                    attacker.heal(healamount);
                        attacker.getHeldItemMainhand().damageItem(1,attacker);
                    if (attacker instanceof EntityPlayer) {

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
