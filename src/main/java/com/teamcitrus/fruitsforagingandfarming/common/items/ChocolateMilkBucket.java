package com.teamcitrus.fruitsforagingandfarming.common.items;

import com.teamcitrus.fruitsforagingandfarming.main.*;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ChocolateMilkBucket extends ItemBucketMilk {
    public ChocolateMilkBucket() {
        setRegistryName("CHOCOLATE_MILK_BUCKET");
        setUnlocalizedName("chocolate_milk_bucket");
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);
        this.setMaxStackSize(1);
        this.setMaxDamage(8);
    }

    @Nullable
    @Override
    public Item getContainerItem() {
        return Items.BUCKET;
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        if (!worldIn.isRemote)
            if (entityLiving instanceof EntityPlayerMP) {
                EntityPlayerMP entityplayermp = (EntityPlayerMP) entityLiving;
                CriteriaTriggers.CONSUME_ITEM.trigger(entityplayermp, stack);
                entityplayermp.addStat(StatList.getObjectUseStats(this));
                entityplayermp.getFoodStats().addStats(ConfigHandler.CHOC_MILK_SHANK, ConfigHandler.CHOC_MILK_SAT);
            }

        if (entityLiving instanceof EntityPlayer && !((EntityPlayer) entityLiving).capabilities.isCreativeMode) {
            stack.damageItem(1, entityLiving);
        }

        return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
    }


}
