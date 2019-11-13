package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.common.items.*;
import com.teamcitrus.fruitsforagingandfarming.common.items.weapon.WeaponScythe;
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

        event.getRegistry().register(new ItemFoodBase("avocado", 3, 2.4F));
        event.getRegistry().register(new ItemFoodBase("banana", 2, 3.2F));
        event.getRegistry().register(new ItemFoodBase("blueberry", 1, 0.4F));
        event.getRegistry().register(new ItemFoodBase("coconut", 3, 5.6F));
        event.getRegistry().register(new ItemFoodBase("corn", 1, 3));
        event.getRegistry().register(new ItemFoodBase("honeymelon_slice", 4, 7.8F));
        event.getRegistry().register(new ItemFoodBase("kiwi", 2, 2.8F));
        event.getRegistry().register(new ItemFoodBase("kiwano", 3, 2F));
        event.getRegistry().register(new ItemFoodBase("lemon", 2, 2.2F));
        event.getRegistry().register(new ItemFoodBase("lime", 2, 2.2F));
        event.getRegistry().register(new ItemFoodBase("mango", 3, 3.4F));
        event.getRegistry().register(new ItemFoodBase("orange", 1, 8.2F));
        event.getRegistry().register(new ItemFoodBase("pear", 3, 4.6F));
        event.getRegistry().register(new ItemFoodBase("pineapple", 3, 4.2F));
        event.getRegistry().registerAll(new SeedCornKernel());
        event.getRegistry().register(new ItemFoodBase("plum", 1, 2.5F));

        event.getRegistry().register(new ItemFoodBase("turnip", 1, 2));
        event.getRegistry().register(new ItemFoodBase("infested_pebble", 1, 1));
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
