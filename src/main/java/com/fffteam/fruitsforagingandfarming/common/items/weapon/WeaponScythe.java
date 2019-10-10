package com.fffteam.fruitsforagingandfarming.common.items.weapon;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentSweepingEdge;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

public class WeaponScythe extends BaseWeapon {
    public WeaponScythe(String name, ToolMaterial material, float attackDamage) {
        super(name, material, attackDamage, 1.20);

    }
    @Override
    public boolean isTwoHanded() {
        return true;
    }
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {




        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
    @Override
    public int getItemEnchantability()
    {
        return this.material.getEnchantability();
    }


    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {

        if (enchantment==Enchantments.SWEEPING) { return false;}

        return (enchantment.type == EnumEnchantmentType.WEAPON || enchantment.type==EnumEnchantmentType.ALL);

    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        super.onCreated(stack, worldIn, playerIn);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {

        if (player.getCooledAttackStrength(0)==1.0F) {
            for (EntityLivingBase entitylivingbase : player.world.getEntitiesWithinAABB(EntityLivingBase.class, entity.getEntityBoundingBox().grow(1.0D, 0.25D, 1.0D)))
            {
                if (entitylivingbase != player && entitylivingbase != entity && !player.isOnSameTeam(entitylivingbase) && player.getDistanceSq(entitylivingbase) < 9.0D)
                {
                //     entitylivingbase.knockBack(player, 0.4F, (double) MathHelper.sin(player.rotationYaw * 0.017453292F), (double)(-MathHelper.cos(player.rotationYaw * 0.017453292F)));
                    entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage(player), this.getAttackDamage());
                }
            }

            player.world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, player.getSoundCategory(), 1.0F, 1.0F);
            player.spawnSweepParticles();
        }
        return false;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

        if (!(attacker instanceof EntityPlayer)) {
            for (EntityLivingBase entitylivingbase : attacker.world.getEntitiesWithinAABB(EntityLivingBase.class, target.getEntityBoundingBox().grow(1.0D, 0.25D, 1.0D)))
            {
                if (entitylivingbase != attacker && entitylivingbase != target && !attacker.isOnSameTeam(entitylivingbase) && attacker.getDistanceSq(entitylivingbase) < 9.0D)
                {
                    entitylivingbase.attackEntityFrom(DamageSource.causeMobDamage(attacker), this.getAttackDamage());
                }
            }

            attacker.world.playSound((EntityPlayer) null, attacker.posX, attacker.posY, attacker.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, attacker.getSoundCategory(), 1.0F, 1.0F);
            double d0 = (double)(-MathHelper.sin(attacker.rotationYaw * 0.017453292F));
            double d1 = (double)MathHelper.cos(attacker.rotationYaw * 0.017453292F);

            if (attacker.world instanceof WorldServer)
            {
                ((WorldServer)attacker.world).spawnParticle(EnumParticleTypes.SWEEP_ATTACK, attacker.posX + d0, attacker.posY + (double)attacker.height * 0.5D, attacker.posZ + d1, 0, d0, 0.0D, d1, 0.0D);
            }
        }

        
        stack.damageItem(1,attacker);
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add( "Two-Handed");
        tooltip.add("Sweeps when swung at 100% Charge for 100% Damage");
        tooltip.add("Harvesting crops also harvests horizontally adjacent blocks.");


    }

    /*

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {

                if (state.getBlock() instanceof BlockCrops) {
                    stack.damageItem(1,entityLiving);
                    System.out.println("Pos X: "  +pos.getX() + " Pos Y: " + pos.getY() + " Pos Z: " + pos.getZ());
                        BlockPos breakposfirst;
                        BlockPos breakpossecond;
                        if (entityLiving.getHorizontalFacing().equals(EnumFacing.NORTH) || entityLiving.getHorizontalFacing() == EnumFacing.SOUTH) {
                            breakposfirst=pos.west();
                            breakpossecond=pos.east();

                        }
                        else {
                            breakposfirst = pos.north();
                            breakpossecond = pos.south();
                        }




                    if (worldIn.getBlockState(breakposfirst).getBlock() instanceof BlockCrops) {
                        worldIn.destroyBlock(breakposfirst,true);
                    }
                    if (worldIn.getBlockState(breakpossecond).getBlock() instanceof BlockCrops) {
                        worldIn.destroyBlock(breakpossecond,true);
                    }
                    System.out.println("Pos X: "  +breakposfirst.getX() + " Pos Y: " + breakposfirst.getY() + " Pos Z: " + breakposfirst.getZ());
                    double d0 = (double)(-MathHelper.sin(entityLiving.rotationYaw * 0.017453292F));
                    double d1 = (double)MathHelper.cos(entityLiving.rotationYaw * 0.017453292F);

                    if (entityLiving.world instanceof WorldServer)
                    {
                        ((WorldServer)entityLiving.world).spawnParticle(EnumParticleTypes.SWEEP_ATTACK, entityLiving.posX + d0, entityLiving.posY + (double)entityLiving.height * 0.5D, entityLiving.posZ + d1, 0, d0, 0.0D, d1, 0.0D);
                    }
                }
     else {
                    stack.damageItem(2,entityLiving);
                }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }


     */





    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {

        if (state.getBlock() instanceof BlockCrops) {
            stack.damageItem(1,entityLiving);
     //       System.out.println("Pos X: "  +pos.getX() + " Pos Y: " + pos.getY() + " Pos Z: " + pos.getZ());
            BlockPos breakposfirst;
            BlockPos breakpossecond;
            double div = 360.0D / 8.0D;
            double quantized = (int) ((entityLiving.rotationYaw + div / 2.0D) / div) % 8;

           quantized *=-1;

                    if (quantized == 0) {
                //TODO
                        breakposfirst=pos.north();
                        breakposfirst=breakposfirst.east();
                        breakpossecond=pos.south();
                        breakpossecond=breakpossecond.west();
            }
         else   if (quantized==1) {
                breakposfirst = pos.north();
                breakpossecond = pos.south();
            }

            else   if (quantized == 2) {
                breakposfirst=pos.south();
                breakposfirst=breakposfirst.east();
                breakpossecond=pos.north();
                breakpossecond=breakpossecond.west();
            }
            else   if (quantized == 3) {
                breakposfirst=pos.west();
                breakpossecond=pos.east();

            }
            else if (quantized==4) {
                breakposfirst=pos.south();
                breakposfirst=breakposfirst.west();
                breakpossecond=pos.north();
                breakpossecond=breakpossecond.east();
            }

                    else   if ( quantized == 5) {
                        breakposfirst = pos.north();
                        breakpossecond = pos.south();
                    }

            else if ( quantized == 6) {
                 breakposfirst=pos.north();
                 breakposfirst=breakposfirst.west();
                 breakpossecond=pos.south();
                 breakpossecond=breakpossecond.east();

            }
          else  if ( quantized == 7) {
                breakposfirst=pos.west();
                breakpossecond=pos.east();

            }


          else {
              breakposfirst=pos;
              breakpossecond=pos;
          System.out.println("Unrecognized Numerical: " +quantized);
            }

         //   System.out.println("Facing: " + entityLiving.getHorizontalFacing().getName() +" Quantified: " + quantized);




            if (worldIn.getBlockState(breakposfirst).getBlock() instanceof BlockCrops) {
                worldIn.destroyBlock(breakposfirst,true);

            }
            if (worldIn.getBlockState(breakpossecond).getBlock() instanceof BlockCrops) {
                worldIn.destroyBlock(breakpossecond,true);

            }

            double d0 = (double)(-MathHelper.sin(entityLiving.rotationYaw * 0.017453292F));
            double d1 = (double)MathHelper.cos(entityLiving.rotationYaw * 0.017453292F);

            if (entityLiving.world instanceof WorldServer)
            {
                ((WorldServer)entityLiving.world).spawnParticle(EnumParticleTypes.SWEEP_ATTACK, entityLiving.posX + d0, entityLiving.posY + (double)entityLiving.height * 0.5D, entityLiving.posZ + d1, 0, d0, 0.0D, d1, 0.0D);
            }
        }
        else {
            stack.damageItem(2,entityLiving);
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }





}