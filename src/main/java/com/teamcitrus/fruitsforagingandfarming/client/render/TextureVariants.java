package com.teamcitrus.fruitsforagingandfarming.client.render;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;

public class TextureVariants {

    public static final DataParameter<Integer> TYPE = EntityDataManager.<Integer>createKey(EntityZombie.class, DataSerializers.VARINT);





}
