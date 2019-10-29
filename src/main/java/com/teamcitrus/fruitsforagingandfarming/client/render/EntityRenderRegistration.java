package com.teamcitrus.fruitsforagingandfarming.client.render;

import com.teamcitrus.fruitsforagingandfarming.common.entities.EntityGoldenChicken;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityRenderRegistration {


    public static void RegisterEntity() {

        RenderingRegistry.registerEntityRenderingHandler(EntityGoldenChicken.class, RenderGoldenChicken::new);
    }

}
