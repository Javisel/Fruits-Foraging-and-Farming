package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.common.items.*;
import com.teamcitrus.fruitsforagingandfarming.common.items.weapon.WeaponScythe;
import com.teamcitrus.fruitsforagingandfarming.main.ConfigHandler;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FruitsForagingAndFarming.MODID)
@GameRegistry.ObjectHolder(FruitsForagingAndFarming.MODID)
@SuppressWarnings("null")

public class ItemRegistration {


    //FOOD

    public static final ItemFoodBase AVOCADO = null;
    public static final ItemFoodBase BANANA = null;
    public static final ItemFoodBase BLUEBERRY = null;
    public static final ItemFoodBase KIWANO = null;
    public static final ItemFoodBase COCONUT = null;
    public static final ItemFoodBase CORN = null;
    public static final FoodDurian DURIAN = null;

    public static final ItemFoodBase HONEYMELON_SLICE = null;
    public static final ItemFoodBase KIWI = null;
    public static final ItemFoodBase LEMON = null;
    public static final ItemFoodBase LIME = null;
    public static final ItemFoodBase MANGO = null;
    public static final ItemFoodBase ORANGE = null;
    public static final ItemFoodBase PEAR = null;
    public static final ItemFoodBase PINEAPPLE = null;
    public static final ItemFoodBase PLUM = null;
    public static final ItemFoodBase TURNIP = null;
    public static final ItemFoodBase INFESTED_PEBBLE = null;


    public static final ChocolateMilkBucket CHOCOLATE_MILK_BUCKET = null;
    public static final ChocolateMilkBottle CHOCOLATE_MILK_BOTTLE = null;

    //SEED
    public static final HoneymelonSeeds HONEYMELON_SEEDS = null;
    public static final GrassSeeds GRASS_SEEDS = null;
    public static final TurnipSeeds TURNIP_SEEDS = null;
    public static final SeedCornKernel CORN_KERNEL = null;

    //TOOLS & WEAPONS
    public static final WeaponScythe WOODEN_SCYTHE = null;
    public static final WeaponScythe STONE_SCYTHE = null;
    public static final WeaponScythe GOLDEN_SCYTHE = null;
    public static final WeaponScythe IRON_SCYTHE = null;
    public static final WeaponScythe DIAMOND_SCYTHE = null;


    @SubscribeEvent
    public static final void registerItemEvent(@Nonnull final RegistryEvent.Register<Item> event) {

        event.getRegistry().register(new ItemFoodBase("avocado", ConfigHandler.AVOCADO_SHANK, ConfigHandler.AVOCADO_SAT));
        event.getRegistry().register(new ItemFoodBase("banana", ConfigHandler.BANANA_SHANK, ConfigHandler.BANANA_SAT));
        event.getRegistry().register(new ItemFoodBase("blueberry", ConfigHandler.BLUEBERRY_SHANK, ConfigHandler.BLUEBERRY_SAT));
        event.getRegistry().register(new ItemFoodBase("coconut", ConfigHandler.COCONUT_SHANK, ConfigHandler.COCONUT_SAT));
        event.getRegistry().register(new ItemFoodBase("corn", ConfigHandler.CORN_SHANK, ConfigHandler.CORN_SAT));
        event.getRegistry().register(new ItemFoodBase("honeymelon_slice", ConfigHandler.HONEYMELON_SHANK, ConfigHandler.HONEYMELON_SAT));
        event.getRegistry().register(new ItemFoodBase("kiwi", ConfigHandler.KIWI_SHANK, ConfigHandler.KIWI_SAT));
        event.getRegistry().register(new ItemFoodBase("kiwano", ConfigHandler.KIWANO_SHANK, ConfigHandler.KIWANO_SAT));
        event.getRegistry().register(new ItemFoodBase("lemon", ConfigHandler.LEMON_SHANK, ConfigHandler.LEMON_SAT));
        event.getRegistry().register(new ItemFoodBase("lime", ConfigHandler.LIME_SHANK, ConfigHandler.LIME_SAT));
        event.getRegistry().register(new ItemFoodBase("mango", ConfigHandler.MANGO_SHANK, ConfigHandler.MANGO_SAT));
        event.getRegistry().register(new ItemFoodBase("orange", ConfigHandler.ORANGE_SHANK, ConfigHandler.ORANGE_SAT));
        event.getRegistry().register(new ItemFoodBase("pear", ConfigHandler.PEAR_SHANK, ConfigHandler.PEAR_SAT));
        event.getRegistry().register(new ItemFoodBase("pineapple", ConfigHandler.PINAPPLE_SHANK, ConfigHandler.PINAPPLE_SAT));
        event.getRegistry().registerAll(new SeedCornKernel());
        event.getRegistry().register(new ItemFoodBase("plum", ConfigHandler.PLUM_SHANK, ConfigHandler.PLUM_SAT));

        event.getRegistry().register(new ItemFoodBase("turnip", ConfigHandler.TURNIP_SHANK, ConfigHandler.TURNIP_SAT));
        event.getRegistry().register(new ItemFoodBase("infested_pebble", ConfigHandler.INFESTED_PEBBLE_SHANK, ConfigHandler.INFESTED_PEBBLE_SAT));
        event.getRegistry().register(new FoodDurian());
        event.getRegistry().register(new ChocolateMilkBucket());
        event.getRegistry().register(new ChocolateMilkBottle());
        event.getRegistry().register(new HoneymelonSeeds());
        event.getRegistry().register(new GrassSeeds());
        event.getRegistry().register(new TurnipSeeds());
        event.getRegistry().register(new WeaponScythe("wooden_scythe", Item.ToolMaterial.WOOD, 1));
        event.getRegistry().register(new WeaponScythe("stone_scythe", Item.ToolMaterial.STONE, 2));
        event.getRegistry().register(new WeaponScythe("golden_scythe", Item.ToolMaterial.GOLD, 3));
        event.getRegistry().register(new WeaponScythe("iron_scythe", Item.ToolMaterial.IRON, 4));
        event.getRegistry().register(new WeaponScythe("diamond_scythe", Item.ToolMaterial.DIAMOND, 5));
    }


}
