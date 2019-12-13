package com.teamcitrus.fruitsforagingandfarming.common.entities.generalai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;

public class EntityAINocturnalTerrestrial extends EntityAIWanderAvoidWater {
    public EntityAINocturnalTerrestrial(EntityCreature p_i47301_1_, double p_i47301_2_) {
        super(p_i47301_1_, p_i47301_2_);
    }

    public EntityAINocturnalTerrestrial(EntityCreature p_i47302_1_, double p_i47302_2_, float p_i47302_4_) {
        super(p_i47302_1_, p_i47302_2_, p_i47302_4_);
    }

    @Override
    public boolean shouldExecute() {
        return !this.entity.getEntityWorld().isDaytime() &&     super.shouldExecute();
    }
}
