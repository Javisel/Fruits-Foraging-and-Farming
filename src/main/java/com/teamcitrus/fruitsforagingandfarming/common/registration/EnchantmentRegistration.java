package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.common.enchantments.Devour;
import com.teamcitrus.fruitsforagingandfarming.common.enchantments.Lifesteal;
import com.teamcitrus.fruitsforagingandfarming.common.enchantments.Void;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.IForgeRegistry;

public class EnchantmentRegistration {

    public static final Enchantment weaponLifesteal = new Lifesteal();
    public static final Enchantment weaponDevour = new Devour();
    public static final Enchantment allVoid = new Void();

    public static void register(IForgeRegistry<Enchantment> registry) {

        registry.register(weaponLifesteal);
        registry.register(weaponDevour);
        registry.register(allVoid);

    }

}
