package com.teamcitrus.fruitsforagingandfarming.main;

import com.google.common.eventbus.Subscribe;
import com.teamcitrus.fruitsforagingandfarming.common.blocks.BlockCoconut;
import com.teamcitrus.fruitsforagingandfarming.common.capabilities.EntityData;
import com.teamcitrus.fruitsforagingandfarming.common.capabilities.EntityDataProvider;
import com.teamcitrus.fruitsforagingandfarming.common.effects.MobEffect;
import com.teamcitrus.fruitsforagingandfarming.common.entities.EntityTypeList;
import com.teamcitrus.fruitsforagingandfarming.common.items.IEdible;
import com.teamcitrus.fruitsforagingandfarming.common.items.ItemCakeBlock;
import com.teamcitrus.fruitsforagingandfarming.common.items.ItemPlaceableFruit;
import com.teamcitrus.fruitsforagingandfarming.common.items.weapon.BaseWeapon;
import com.teamcitrus.fruitsforagingandfarming.common.network.EntityDataMessage;
import com.teamcitrus.fruitsforagingandfarming.common.network.PacketHandler;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.EnchantmentRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.MobEffectRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.utilities.MobUtilities;
import com.teamcitrus.fruitsforagingandfarming.common.world.generation.biome.BlackSandBeach;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.biome.BiomeRiver;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;


public class EventHandler {


    static final Item[] fruits = {ItemRegistration.AVOCADO, ItemRegistration.KIWANO, ItemRegistration.BANANA, ItemRegistration.BLUEBERRY, ItemRegistration.KIWI, ItemRegistration.LEMON, ItemRegistration.LIME, Item.getItemFromBlock(BlockRegistration.MANGO), ItemRegistration.DURIAN, Item.getItemFromBlock(BlockRegistration.ORANGE), ItemRegistration.PEAR, ItemRegistration.PLUM, ItemRegistration.PINEAPPLE};
    static final Item[] seeds = {ItemRegistration.GRASS_SEEDS, ItemRegistration.HONEYMELON_SEEDS, ItemRegistration.CORN_KERNEL};
    static final Item[] vanillaseeds = {Items.WHEAT_SEEDS, Items.BEETROOT_SEEDS, Items.PUMPKIN_SEEDS, Items.MELON_SEEDS};


    @SubscribeEvent
    public void varaintTextures(EntityJoinWorldEvent e) {

        if (e.getEntity().hasCapability(EntityDataProvider.ENTITY_DATA_CAPABILITY,null)&& !e.getWorld().isRemote) {

            if (EntityTypeList.types.get(e.getEntity().getClass()) !=null) {
                e.getEntity().getCapability(EntityDataProvider.ENTITY_DATA_CAPABILITY,null).setEntityType(MathHelper.getInt(e.getWorld().rand,0,EntityTypeList.types.get(e.getEntity().getClass())));



                PacketHandler.INSTANCE.sendToAllTracking(new EntityDataMessage((EntityLivingBase) e.getEntity()),e.getEntity());

            }

        }


    }





    @SubscribeEvent
    public void dogkiller(PlayerInteractEvent.EntityInteract e ) {


        if (e.getTarget()!=null && e.getTarget() instanceof EntityWolf || e.getTarget() instanceof EntityParrot || e.getTarget() instanceof EntityChicken) {

         if ((e.getItemStack().getItem() instanceof ItemDye && e.getItemStack().getMetadata()==12) || e.getItemStack().getItem()== Items.COOKIE  || e.getItemStack().getItem() == ItemRegistration.CHOCOLATE_MILK_BOTTLE) {
             e.getItemStack().shrink(1);
                ((EntityLivingBase) e.getTarget()).addPotionEffect(new PotionEffect(MobEffects.POISON,250,3));
         }
         else if (e.getItemStack().getItem() == ItemRegistration.CHOCOLATE_MILK_BUCKET) {

             e.getItemStack().damageItem(1,e.getEntityLiving());

             ((EntityWolf) e.getTarget()).addPotionEffect(new PotionEffect(MobEffects.POISON,250,3));


         }



        }



    }



    @SubscribeEvent
    public void EnderPickup(LivingEquipmentChangeEvent e) {

        if (e.getEntityLiving() instanceof EntityEnderman) {

            if (e.getSlot()==EntityEquipmentSlot.MAINHAND || e.getSlot() == EntityEquipmentSlot.OFFHAND) {

                if (e.getTo().getItem()==Item.getItemFromBlock(BlockRegistration.BLACK_SANDSTONE)) {
                    e.getTo().shrink(e.getTo().getCount());

                    e.getEntityLiving().setHeldItem(EnumHand.MAIN_HAND, new ItemStack(BlockRegistration.ACTIVATED_BLACK_SANDSTONE));


                }


            }

        }

    }


    @SubscribeEvent
    public void craftingChocolateMilk(PlayerEvent.ItemCraftedEvent e) {

        if (e.crafting.getItem() == ItemRegistration.CHOCOLATE_MILK_BOTTLE) {

         for (int i =0; i <e.craftMatrix.getSizeInventory();i++) {

             if (e.craftMatrix.getStackInSlot(i).getItem() ==  ItemRegistration.CHOCOLATE_MILK_BUCKET) {

                ItemStack stack =          e.craftMatrix.getStackInSlot(i);
                stack.damageItem(1,e.player);
                if (!stack.isEmpty())
                 e.player.addItemStackToInventory(stack);

             }

         }

        }


    }



    @SubscribeEvent
    public void ModifyBlockDrops(BlockEvent.HarvestDropsEvent e) {

        if (e.getHarvester() != null && !e.isSilkTouching()) {
            if (e.getState() == Blocks.LEAVES.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, false).withProperty(BlockLeaves.DECAYABLE, true)) {


                Random random = new Random();

                if (MathHelper.getInt(random, 1, 100) >= (80 - (10 * e.getFortuneLevel()))) {
                    e.getDrops().add(new ItemStack(fruits[MathHelper.getInt(random, 0, fruits.length)], MathHelper.getInt(random, 1, 3)));


                }


            }


        } else if (e.getState().getBlock() == Blocks.TALLGRASS) {

            Random random = new Random();

            if (e.getFortuneLevel() > 0) {

                if (MathHelper.getInt(random, 1, 100) > (90 - (10 * e.getFortuneLevel()))) {

                    e.getDrops().add(new ItemStack(vanillaseeds[MathHelper.getInt(random, 0, vanillaseeds.length - 1)], MathHelper.getInt(random, 1, e.getFortuneLevel())));

                }


            }

            if (MathHelper.getInt(random, 1, 100) > (50 - (10 * e.getFortuneLevel()))) {


                e.getDrops().add(new ItemStack(seeds[MathHelper.getInt(random, 0, seeds.length - 1)], MathHelper.getInt(random, 1, 3)));


            }


        }


    }



    @SubscribeEvent
    public void enderShutdown(PlayerInteractEvent.RightClickBlock e) {



        if (e.getItemStack().getItem() == Items.ENDER_EYE && e.getWorld().getBlockState(e.getPos()).getBlock()==BlockRegistration.ACTIVATED_BLACK_SANDSTONE) {

            e.getWorld().setBlockState(e.getPos(),BlockRegistration.BLACK_SANDSTONE_CHISELED.getDefaultState());




        }


    }






    @SubscribeEvent
    public void CoconutCracking(PlayerInteractEvent.LeftClickBlock e) {


        if (!e.getWorld().isRemote && e.getWorld().getBlockState(e.getPos()).getBlock() == BlockRegistration.COCONUT && e.getItemStack().getItem() instanceof ItemSword || e.getItemStack().getItem() instanceof ItemAxe) {


            int stage =BlockRegistration.COCONUT.getMetaFromState(e.getWorld().getBlockState(e.getPos()));

            if (stage >=2 && stage<4 && e.getWorld().isAirBlock(e.getPos().down())) {

                EntityFallingBlock entityfallingblock = new EntityFallingBlock(e.getWorld(), (double)e.getPos().getX() + 0.5D, (double)e.getPos().getY(), (double)e.getPos().getZ() + 0.5D, BlockRegistration.COCONUT.getStateFromMeta(4));
                entityfallingblock.setHurtEntities(true);
                e.getWorld().spawnEntity(entityfallingblock);
                e.getItemStack().damageItem(1, e.getEntityPlayer());



            }
       else if (stage ==4) {

           int faceplace = 6;
           if (e.getEntityPlayer().getHorizontalFacing()== EnumFacing.SOUTH ||e.getEntityPlayer().getHorizontalFacing()==EnumFacing.NORTH){
               faceplace=5;
           }

                e.getWorld().setBlockState(e.getPos(),BlockRegistration.COCONUT.withAge(faceplace));


            }
            else if (stage>=5) {
                 e.getWorld().setBlockToAir(e.getPos());
                Block.spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(ItemRegistration.COCONUT_CHUNK, 4));


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
    @SideOnly(Side.CLIENT)

    public void FoodInfo(ItemTooltipEvent e) {


        if (e.getEntityPlayer() != null && e.getEntityPlayer().getEntityWorld().isRemote) {

            if (e.getItemStack().getItem() instanceof ItemPlaceableFruit || e.getItemStack().getItem() instanceof ItemFood || e.getItemStack().getItem() instanceof IEdible) {
                int foodlevel;
                float saturation;
                if (e.getItemStack().getItem() instanceof ItemPlaceableFruit) {
                    ItemPlaceableFruit placeableFruit = (ItemPlaceableFruit) e.getItemStack().getItem();
                    foodlevel = placeableFruit.getFoodlevel();
                    saturation = placeableFruit.getSaturation();

                } else if (e.getItemStack().getItem() instanceof ItemFood) {
                    ItemFood food = (ItemFood) e.getItemStack().getItem();
                    foodlevel = food.getHealAmount(e.getItemStack());
                    saturation = food.getSaturationModifier(e.getItemStack());

                }
                else if (e.getItemStack().getItem() instanceof IEdible) {
                    IEdible food = (IEdible) e.getItemStack().getItem();
                    foodlevel = food.getFoodLevel();
                    saturation = food.getSaturation();

                }

                else {
                    foodlevel = -1;
                    saturation = -1;
                }


                e.getToolTip().add("Hunger Restored: " + foodlevel + " " + "Saturation: " + saturation);
            } else if (e.getItemStack().getItem() instanceof ItemCakeBlock) {

                int foodlevel = ((ItemCakeBlock) e.getItemStack().getItem()).getFoodlevel();
                float saturation = ((ItemCakeBlock) e.getItemStack().getItem()).getSaturation();

                e.getToolTip().add("Hunger Restored per slice: " + foodlevel + " " + "Saturation per slice: " + saturation);

            }

        }

    }

    @SideOnly(Side.CLIENT)
    public void PatreonDonation(ItemTooltipEvent e) {


        if (e.getEntityPlayer() != null && e.getEntityPlayer().getEntityWorld().isRemote) {

            if (PatreonData.getContributedItem(e.getEntityPlayer().getUniqueID()) !=null) {

                e.getToolTip().add(TextFormatting.ITALIC + "Thank you for your contribution, " + e.getEntityPlayer().getName() + "!");
            }
        }
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



}
