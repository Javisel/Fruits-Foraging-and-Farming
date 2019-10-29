package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.common.entities.EntityGoldenChicken;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.awt.*;

public class EntityRegistration {

  private static int id = 0;

  public static void RegisterEntities() {

      registerLivingEntityWithEgg("golden_chicken", EntityGoldenChicken.class,Color.YELLOW.getRGB(),Color.RED.getRGB());

  }
    private static void registerLivingEntityWithEgg(final String name,final Class<? extends Entity> entity, final int eggPrimaryColor,
                                                    final int eggSecondaryColor)
    {

        EntityRegistry.registerModEntity(new ResourceLocation(FruitsForagingAndFarming.MODID,name), entity, name, id++, FruitsForagingAndFarming.INSTANCE, 80, 3, true, eggPrimaryColor,
                eggSecondaryColor);

    }
}