package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.common.effects.Infestation;
import net.minecraft.potion.Potion;
import net.minecraftforge.registries.IForgeRegistry;

public class MobEffectRegistration {


    public  static final Potion infestation = new Infestation();

    public static void register(IForgeRegistry<Potion> registry) {

        registry.registerAll(
             infestation
        );

    }
}
