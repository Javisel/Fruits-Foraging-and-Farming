package com.teamcitrus.fruitsforagingandfarming.main;

import com.teamcitrus.fruitsforagingandfarming.client.creativetabs.*;
import com.teamcitrus.fruitsforagingandfarming.common.damagesource.*;
import com.teamcitrus.fruitsforagingandfarming.common.registration.*;
import com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree.*;
import com.teamcitrus.fruitsforagingandfarming.proxy.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.*;
import net.minecraft.world.storage.loot.functions.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.registry.*;
import org.apache.logging.log4j.*;

import java.io.*;

@Mod(modid = FruitsForagingAndFarming.MODID, name = FruitsForagingAndFarming.NAME, version = FruitsForagingAndFarming.VERSION)
public class FruitsForagingAndFarming {
    public static File config;
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


    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void ModifyLoot(LootTableLoadEvent event) {

            if (event.getName().getResourcePath().equals("entities/silverfish")) {
                LootCondition[] conditions = new LootCondition[] {new KilledByPlayer(false), new RandomChance(1)};
                LootFunction[] functions = new LootFunction[]{new SetCount(conditions, new RandomValueRange(1,4))};
                LootEntryItem[] entries = new LootEntryItem[]{new LootEntryItem(ItemRegistration.INFESTED_PEBBLE,1,1,functions,conditions,MODID + ":infested_pebbles")};
                LootPool pool = new LootPool(entries,conditions,new RandomValueRange(1,4),new RandomValueRange(1,2),MODID +":infested_pebbles");
                event.getTable().addPool(pool);
            }
        }

    }
}
