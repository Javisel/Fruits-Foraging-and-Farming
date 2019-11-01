package com.teamcitrus.fruitsforagingandfarming.common.utilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class MobUtilities {


    public static Entity spawnCreature(World world, EntityLiving entitycreature, double x, double y, double z) {


        entitycreature.setLocationAndAngles(x, y, z, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
        entitycreature.rotationYawHead = entitycreature.rotationYaw;
        entitycreature.renderYawOffset = entitycreature.rotationYaw;

        world.spawnEntity(entitycreature);

        entitycreature.spawnExplosionParticle();
        entitycreature.playLivingSound();


        return entitycreature;
    }
}
