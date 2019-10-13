package com.fffteam.fruitsforagingandfarming.common.registration;


import com.fffteam.fruitsforagingandfarming.common.entities.EntityBrownChicken;
import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.awt.*;

public class EntityRegistration {

  private static int id = 0;

  public static void RegisterEntities() {

      registerLivingEntityWithEgg("brown_chicken", EntityBrownChicken.class,Color.HSBtoRGB(0,25,75),Color.red.getRed());

  }
    private static void registerLivingEntityWithEgg(final String name,final Class<? extends Entity> entity, final int eggPrimaryColor,
                                                    final int eggSecondaryColor)
    {

        EntityRegistry.registerModEntity(new ResourceLocation(FruitsForagingAndFarming.MODID,name), entity, name, id++, FruitsForagingAndFarming.INSTANCE, 80, 3, true, eggPrimaryColor,
                eggSecondaryColor);

    }
}