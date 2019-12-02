package com.teamcitrus.fruitsforagingandfarming.client.render;

import com.teamcitrus.fruitsforagingandfarming.client.model.ModelCoconutCrab;
import com.teamcitrus.fruitsforagingandfarming.common.entities.EntityCoconutCrab;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCoconutCrab extends RenderLiving<EntityCoconutCrab> {
    private static final ResourceLocation COCONUTCRABTEXTURES = new ResourceLocation(FruitsForagingAndFarming.MODID + ":" + "textures/entity/coconut_crab.png");



    public RenderCoconutCrab(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCoconutCrab(), 0.25F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCoconutCrab entity) {
        return COCONUTCRABTEXTURES;
    }
}
