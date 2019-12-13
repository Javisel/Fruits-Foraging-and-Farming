package com.teamcitrus.fruitsforagingandfarming.client.render;

import com.teamcitrus.fruitsforagingandfarming.common.capabilities.EntityDataProvider;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class RenderChicken extends net.minecraft.client.renderer.entity.RenderChicken {

    private static final ResourceLocation BROWN_CHICKEN_TEXTURES = new ResourceLocation(FruitsForagingAndFarming.MODID + ":" + "textures/entity/brown_chicken.png");

    public RenderChicken(RenderManager p_i47211_1_) {
        super(p_i47211_1_);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityChicken entity) {


        return  entity.getCapability(EntityDataProvider.ENTITY_DATA_CAPABILITY,null).getEntityType() == 0 ?super.getEntityTexture(entity) :BROWN_CHICKEN_TEXTURES ;
    }



}
