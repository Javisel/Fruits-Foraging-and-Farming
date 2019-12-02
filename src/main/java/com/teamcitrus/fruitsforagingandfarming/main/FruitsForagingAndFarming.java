package com.teamcitrus.fruitsforagingandfarming.main;

import com.teamcitrus.fruitsforagingandfarming.client.creativetabs.CreativeTab;
import com.teamcitrus.fruitsforagingandfarming.common.damagesource.SilverfishAlien;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.EntityRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree.TreeGenerator;
import com.teamcitrus.fruitsforagingandfarming.proxy.CommonProxy;
import net.minecraft.util.DamageSource;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.File;

@Mod(modid = FruitsForagingAndFarming.MODID, name = FruitsForagingAndFarming.NAME, version = FruitsForagingAndFarming.VERSION)
public class FruitsForagingAndFarming {
    public static File config;
    public static final String MODID = "fruits_foraging_and_farming";
    public static final String NAME = "Fruits, Foraging and Farming";
    public static final String VERSION = "1.0.2.0";
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
        ConfigManager.sync(MODID, Config.Type.INSTANCE);
            proxy.preInit(event);
        logger = event.getModLog();

    }
 
    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);

        MinecraftForge.EVENT_BUS.register(new com.teamcitrus.fruitsforagingandfarming.main.EventHandler());
        BlockRegistration.RegisterOre();
        if (ConfigHandler.worldGeneration.EnableWorldGeneration) {
            GameRegistry.registerWorldGenerator(new TreeGenerator(), 0);
        }
    }





    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }


    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void ModifyLoot(LootTableLoadEvent event) {

            if (event.getName().getResourcePath().equals("entities/silverfish")) {
                LootCondition[] conditions = new LootCondition[] {new KilledByPlayer(false), new RandomChance(1)};
                LootFunction[] functions = new LootFunction[]{new SetCount(conditions, new RandomValueRange(1,4))};
                LootEntryItem[] entries = new LootEntryItem[]{new LootEntryItem(ItemRegistration.INFESTED_EGGS,1,1,functions,conditions,MODID + ":infested_pebbles")};
                LootPool pool = new LootPool(entries,conditions,new RandomValueRange(1,4),new RandomValueRange(1,2),MODID +":infested_pebbles");
                event.getTable().addPool(pool);
            }
        }

    }
}
