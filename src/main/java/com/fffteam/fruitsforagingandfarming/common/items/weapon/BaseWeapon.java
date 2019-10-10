package com.fffteam.fruitsforagingandfarming.common.items.weapon;

import com.fffteam.fruitsforagingandfarming.common.items.IModelRegisterable;
import com.fffteam.fruitsforagingandfarming.common.utilities.ItemUtilities;
import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

import javax.tools.Tool;

public class BaseWeapon extends Item implements  IWeapon, IModelRegisterable {

    float attackDamage;
    double attackSpeed;
    ToolMaterial material;
    public BaseWeapon(String name, ToolMaterial material, float attackDamage, double attackSpeed) {

        this.material=material;
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.attackDamage=material.getAttackDamage()+attackDamage;
        this.attackSpeed=attackSpeed;
        this.setMaxStackSize(1);
        this.setMaxDamage(material.getMaxUses());

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
        return false;
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
                double attackspeedcalculation = (4.00 - this.attackSpeed) *-1;
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", attackspeedcalculation, 0));
        }

        return multimap;
    }

    @Override
    public void registerItemModel() {
        String name = this.getUnlocalizedName();


                name = name.subSequence(5,name.length()).toString();


        FruitsForagingAndFarming.proxy.registerItemRenderer(this, 0, name);

    }
}

