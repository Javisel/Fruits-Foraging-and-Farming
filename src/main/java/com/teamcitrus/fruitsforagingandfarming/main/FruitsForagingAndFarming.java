package com.teamcitrus.fruitsforagingandfarming.main;
import com.teamcitrus.fruitsforagingandfarming.client.creativetabs.CreativeTab;
import com.teamcitrus.fruitsforagingandfarming.common.damagesource.SilverfishAlien;
import com.teamcitrus.fruitsforagingandfarming.common.registration.*;
import com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree.TreeGenerator;
import com.teamcitrus.fruitsforagingandfarming.proxy.ClientProxy;
import com.teamcitrus.fruitsforagingandfarming.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
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
public class FruitsForagingAndFarming
{
    public static final String MODID = "fruits_foraging_and_farming";
    public static final String NAME = "Fruits, Foraging and Farming";
    public static final String VERSION = "0.1";
    public static final CreativeTab fffCreativeTab = new CreativeTab("fruits_foraging_and_farming");
   public static final  DamageSource silverfishAlien = new SilverfishAlien();

    private static Logger logger;
    @Mod.Instance(FruitsForagingAndFarming.MODID)
    public static FruitsForagingAndFarming INSTANCE;
    @SidedProxy(clientSide = "com.teamcitrus.fruitsforagingandfarming.proxy.ClientProxy", serverSide = "com.teamcitrus.fruitsforagingandfarming.proxy.ServerProxy")
    public static CommonProxy proxy;
//    public static ClientProxy clientproxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        EntityRegistration.RegisterEntities();
        GameRegistry.registerWorldGenerator(new TreeGenerator(),0);

        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        MinecraftForge.EVENT_BUS.register(new com.teamcitrus.fruitsforagingandfarming.main.EventHandler());


    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            BlockRegistration.registerItemBlocks(event.getRegistry());

            ItemRegistration.registerItems(event.getRegistry());

            BlockRegistration.registerOre();

        }


        @SubscribeEvent
        public static void ModdifyDrops(LootTableLoadEvent e) {





        }


        @SubscribeEvent
        public static void RegisterPotions(RegistryEvent.Register<Potion> event) {
            MobEffectRegistration.register(event.getRegistry());
        }
        @SubscribeEvent
        public static void RegisterEnchantments(RegistryEvent.Register<Enchantment> event) {
            EnchantmentRegistration.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            BlockRegistration.registerModels();

            ItemRegistration.registerModels();


        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            BlockRegistration.register(event.getRegistry());

        }


    }
}
