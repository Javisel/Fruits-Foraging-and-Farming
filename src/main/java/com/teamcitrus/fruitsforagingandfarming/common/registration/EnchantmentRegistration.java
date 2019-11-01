package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.common.enchantments.Devour;
import com.teamcitrus.fruitsforagingandfarming.common.enchantments.Lifesteal;
import com.teamcitrus.fruitsforagingandfarming.common.enchantments.Void;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FruitsForagingAndFarming.MODID)
@GameRegistry.ObjectHolder(FruitsForagingAndFarming.MODID)
public class EnchantmentRegistration {

    public static final Enchantment LIFESTEAL = null;
    public static final Enchantment DEVOUR = null;
    public static final Enchantment VOID = null;

    @SubscribeEvent
    public static final void register(@Nonnull final RegistryEvent.Register<Enchantment> event) {

        event.getRegistry().registerAll(
                new Lifesteal(),
                new Devour(),
                new Void());


    }

}
