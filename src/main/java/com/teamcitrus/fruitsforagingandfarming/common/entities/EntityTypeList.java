package com.teamcitrus.fruitsforagingandfarming.common.entities;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;

import java.util.HashMap;

public class EntityTypeList {

    public static HashMap<Class,Integer> types = new HashMap<>();

    static {

        types.put(EntityChicken.class,1 );



    }



}
