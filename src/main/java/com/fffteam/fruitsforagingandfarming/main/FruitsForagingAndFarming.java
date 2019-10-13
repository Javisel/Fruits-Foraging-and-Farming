package com.fffteam.fruitsforagingandfarming.main;
import com.fffteam.fruitsforagingandfarming.client.creativetabs.CreativeTab;
import com.fffteam.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.fffteam.fruitsforagingandfarming.common.registration.EnchantmentRegistration;
import com.fffteam.fruitsforagingandfarming.common.registration.EntityRegistration;
import com.fffteam.fruitsforagingandfarming.common.registration.ItemRegistration;
import com.fffteam.fruitsforagingandfarming.proxy.CommonProxy;
import com.sun.deploy.association.RegisterFailedException;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = FruitsForagingAndFarming.MODID, name = FruitsForagingAndFarming.NAME, version = FruitsForagingAndFarming.VERSION)
public class FruitsForagingAndFarming
{
    public static final String MODID = "fruits_foraging_and_farming";
    public static final String NAME = "Fruits, Foraging and Farming";
    public static final String VERSION = "0.1";
    public static final CreativeTab fffCreativeTab = new CreativeTab("fruits_foraging_and_farming");

    private static Logger logger;
    @Mod.Instance(FruitsForagingAndFarming.MODID)
    public static FruitsForagingAndFarming INSTANCE;
    @SidedProxy(clientSide = "com.fffteam.fruitsforagingandfarming.proxy.ClientProxy", serverSide = "com.fffteam.fruitsforagingandfarming.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        EntityRegistration.RegisterEntities();

        proxy.preInit(event);
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        proxy.init(event);
        MinecraftForge.EVENT_BUS.register(new com.fffteam.fruitsforagingandfarming.main.EventHandler());


    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ItemRegistration.registerItems(event.getRegistry());

            BlockRegistration.registerItemBlocks(event.getRegistry());

        }




        @SubscribeEvent
        public static void RegisterPotions(RegistryEvent.Register<Potion> event) {

        }
        @SubscribeEvent
        public static void RegisterEnchantments(RegistryEvent.Register<Enchantment> event) {
            EnchantmentRegistration.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ItemRegistration.registerModels();
            BlockRegistration.registerModels();


        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            BlockRegistration.register(event.getRegistry());
            BlockRegistration.registerOre();

        }


    }
}
