package com.teamcitrus.fruitsforagingandfarming.common.items;

import com.teamcitrus.fruitsforagingandfarming.main.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class ChocolateMilkBottle extends ItemBase implements IEdible{
    public ChocolateMilkBottle() {
        super("chocolate_milk_bottle");
        setMaxStackSize(1);
    }

    @Override
    public Item getContainerItem() {
        return Items.GLASS_BOTTLE;
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        if (!worldIn.isRemote)
            if (entityLiving instanceof EntityPlayerMP) {
                EntityPlayerMP entityplayermp = (EntityPlayerMP) entityLiving;
                CriteriaTriggers.CONSUME_ITEM.trigger(entityplayermp, stack);
                entityplayermp.addStat(StatList.getObjectUseStats(this));
                entityplayermp.getFoodStats().addStats(ConfigHandler.CHOCOLATE_MILK_BOTTLE.shanks, ConfigHandler.CHOCOLATE_MILK_BOTTLE.getSaturation());
            }

        if (entityLiving instanceof EntityPlayer && !((EntityPlayer) entityLiving).capabilities.isCreativeMode) {
            stack.shrink(1);
        }

        return stack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : stack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, net.minecraft.nbt.NBTTagCompound nbt) {
        return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

    @Override
    public int getFoodLevel() {
        return ConfigHandler.CHOCOLATE_MILK_BOTTLE.shanks;
    }

    @Override
    public float getSaturation() {
        return ConfigHandler.CHOCOLATE_MILK_BOTTLE.getSaturation();
    }
}
