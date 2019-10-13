package com.fffteam.fruitsforagingandfarming.common.registration;

import com.fffteam.fruitsforagingandfarming.common.enchantments.AllVoid;
import com.fffteam.fruitsforagingandfarming.common.enchantments.WeaponDevour;
import com.fffteam.fruitsforagingandfarming.common.enchantments.WeaponLifesteal;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.IForgeRegistry;

public class EnchantmentRegistration {

    public static final Enchantment weaponLifesteal = new WeaponLifesteal();
    public static final Enchantment weaponDevour = new WeaponDevour();
    public static final Enchantment allVoid = new AllVoid();

    public static  void register(IForgeRegistry<Enchantment> registry) {

        registry.register(weaponLifesteal);
        registry.register(weaponDevour);
        registry.register(allVoid);

    }

}
