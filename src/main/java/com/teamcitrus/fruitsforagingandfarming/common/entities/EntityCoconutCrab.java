package com.teamcitrus.fruitsforagingandfarming.common.entities;

import com.teamcitrus.fruitsforagingandfarming.common.entities.generalai.EntityAINocturnal;
import com.teamcitrus.fruitsforagingandfarming.common.entities.generalai.EntityAINocturnalTerrestrial;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityCoconutCrab extends EntityMob {
    public EntityCoconutCrab(World worldIn) {
        super(worldIn);
        this.setSize(1,0.4375F);

    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {

        return  EnumCreatureAttribute.ARTHROPOD;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {

        if (source==DamageSource.FALL || source==DamageSource.GENERIC) {
            amount /= 4;
        }
        return super.attackEntityFrom(source, amount);
    }

    protected void applyEntityAttributes()
    {


        super.applyEntityAttributes();
    this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(10);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAINocturnalTerrestrial(this, 0.5));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.tasks.addTask(5, new EntityAINocturnal(this,2));
    }




}
