package com.teamcitrus.fruitsforagingandfarming.common.items.weapon;

import com.google.common.collect.Multimap;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BaseWeapon extends Item implements IWeapon {

    float attackDamage;
    double attackSpeed;
    ToolMaterial material;
    boolean twoHanded;

    public BaseWeapon(String name, Boolean isTwoHanded, ToolMaterial material, float attackDamage, double attackSpeed) {
        // super(material);
        this.material = material;
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.attackDamage = material.getAttackDamage() + attackDamage;
        this.attackSpeed = attackSpeed;
        this.setMaxStackSize(1);
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);
        twoHanded = isTwoHanded;
    }


    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public double getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public boolean isTwoHanded() {
        return twoHanded;
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.attackDamage, 0));
            double attackspeedcalculation = (4.00 - this.attackSpeed) * -1;
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", attackspeedcalculation, 0));
        }

        return multimap;
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        if (isTwoHanded()) {

            if (entityIn instanceof EntityLivingBase) {
                EntityLivingBase entityLivingBase = (EntityLivingBase) entityIn;

                if (entityLivingBase.getHeldItemMainhand() == stack && !entityLivingBase.getHeldItemOffhand().isEmpty()) {

                    entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE,20,4));

                }
               else  if (entityLivingBase.getHeldItemOffhand() == stack && !entityLivingBase.getHeldItemMainhand().isEmpty()) {

                    entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE,20,4));

                }



            }


        }


    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {


        return (enchantment.type == EnumEnchantmentType.WEAPON || enchantment.type == EnumEnchantmentType.ALL);


    }


}


