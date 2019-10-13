package com.fffteam.fruitsforagingandfarming.client.render;

import com.fffteam.fruitsforagingandfarming.common.entities.EntityBrownChicken;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityRenderRegistration {


    public static void RegisterEntity() {

        RenderingRegistry.registerEntityRenderingHandler(EntityBrownChicken.class,RenderBrownChicken::new);
    }

}
