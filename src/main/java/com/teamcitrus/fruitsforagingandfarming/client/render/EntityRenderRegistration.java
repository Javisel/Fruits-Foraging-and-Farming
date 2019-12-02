package com.teamcitrus.fruitsforagingandfarming.client.render;

import com.teamcitrus.fruitsforagingandfarming.common.entities.EntityCoconutCrab;
import com.teamcitrus.fruitsforagingandfarming.common.entities.EntityGoldenChicken;
import net.minecraft.client.model.ModelChicken;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityRenderRegistration {


    public  static  void RegisterEntityRenderers() {

        RenderingRegistry.registerEntityRenderingHandler(EntityGoldenChicken.class, RenderGoldenChicken::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCoconutCrab.class,RenderCoconutCrab::new);

    }

}
