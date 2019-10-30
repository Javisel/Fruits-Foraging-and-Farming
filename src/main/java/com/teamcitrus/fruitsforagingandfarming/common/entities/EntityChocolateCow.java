package com.teamcitrus.fruitsforagingandfarming.common.entities;

import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityChocolateCow extends EntityCow {
    public EntityChocolateCow(World worldIn) {
        super(worldIn);
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.capabilities.isCreativeMode && !this.isChild()) {
            if (itemstack.getItem() == Items.BUCKET) {
                player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
                itemstack.shrink(1);

                if (itemstack.isEmpty()) {
                    player.setHeldItem(hand, new ItemStack(ItemRegistration.chocolateMilkBucket));
                } else if (!player.inventory.addItemStackToInventory(new ItemStack(ItemRegistration.chocolateMilkBucket))) {
                    player.dropItem(new ItemStack(ItemRegistration.chocolateMilkBucket), false);
                }

                return true;
            } else if (itemstack.getItem() == Items.GLASS_BOTTLE) {
                player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
                itemstack.shrink(1);

                if (player.inventory.addItemStackToInventory(new ItemStack(ItemRegistration.chocolateMilkBottle))) {
                    player.setHeldItem(hand, new ItemStack(ItemRegistration.chocolateMilkBottle));
                } else if (!player.inventory.addItemStackToInventory(new ItemStack(ItemRegistration.chocolateMilkBottle))) {
                    player.dropItem(new ItemStack(ItemRegistration.chocolateMilkBottle), false);
                }

                return true;
            }

        }

        return super.processInteract(player, hand);

    }

    public EntityChocolateCow createChild(EntityAgeable ageable) {
        return new EntityChocolateCow(this.world);
    }
}
