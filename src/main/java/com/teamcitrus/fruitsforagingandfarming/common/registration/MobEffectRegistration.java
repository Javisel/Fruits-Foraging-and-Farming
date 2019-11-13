package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.common.effects.Infestation;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FruitsForagingAndFarming.MODID)
@GameRegistry.ObjectHolder(FruitsForagingAndFarming.MODID)
public class MobEffectRegistration {


    public static final Potion INFESTATION = null;

    @SubscribeEvent
    public static final void register(@Nonnull final RegistryEvent.Register<Potion> event) {

        event.getRegistry().registerAll(
                new Infestation()
        );

    }
}
