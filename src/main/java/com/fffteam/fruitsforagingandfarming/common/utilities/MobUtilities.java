package com.fffteam.fruitsforagingandfarming.common.utilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class MobUtilities {


    public static Entity spawnCreature(World world, EntityLiving entitycreature, double x, double y, double z) {

        Entity entity = null;

        entity = entitycreature;
        EntityLiving entityliving = (EntityLiving) entity;
        entity.setLocationAndAngles(x, y, z, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
        entityliving.rotationYawHead = entityliving.rotationYaw;
        entityliving.renderYawOffset = entityliving.rotationYaw;
        entityliving.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(entityliving)),
                (IEntityLivingData) null);
        if (!world.isRemote) {

            world.spawnEntity(entity);

            entityliving.playLivingSound();

        }
        return entity;
    }
}
