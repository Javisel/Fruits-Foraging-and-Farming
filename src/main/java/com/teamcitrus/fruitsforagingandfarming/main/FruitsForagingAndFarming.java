package com.teamcitrus.fruitsforagingandfarming.main;

import com.teamcitrus.fruitsforagingandfarming.client.creativetabs.CreativeTab;
import com.teamcitrus.fruitsforagingandfarming.common.damagesource.SilverfishAlien;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.EnchantmentRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.EntityRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.MobEffectRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree.TreeGenerator;
import com.teamcitrus.fruitsforagingandfarming.proxy.CommonProxy;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = FruitsForagingAndFarming.MODID, name = FruitsForagingAndFarming.NAME, version = FruitsForagingAndFarming.VERSION)
public class FruitsForagingAndFarming {
    public static final String MODID = "fruits_foraging_and_farming";
    public static final String NAME = "Fruits, Foraging and Farming";
    public static final String VERSION = "0.1";
    public static final CreativeTab fffCreativeTab = new CreativeTab("fruits_foraging_and_farming");
    public static final DamageSource silverfishAlien = new SilverfishAlien();
    @Mod.Instance(FruitsForagingAndFarming.MODID)
    public static FruitsForagingAndFarming INSTANCE;
    @SidedProxy(clientSide = "com.teamcitrus.fruitsforagingandfarming.proxy.ClientProxy", serverSide = "com.teamcitrus.fruitsforagingandfarming.proxy.ServerProxy")
    public static CommonProxy proxy;
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        EntityRegistration.RegisterEntities();
        GameRegistry.registerWorldGenerator(new TreeGenerator(), 0);

        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        MinecraftForge.EVENT_BUS.register(new com.teamcitrus.fruitsforagingandfarming.main.EventHandler());
        BlockRegistration.RegisterOre();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}
