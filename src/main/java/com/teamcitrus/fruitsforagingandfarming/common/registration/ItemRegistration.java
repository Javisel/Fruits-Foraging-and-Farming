package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.common.items.*;
import com.teamcitrus.fruitsforagingandfarming.common.items.weapon.WeaponScythe;
import com.teamcitrus.fruitsforagingandfarming.main.ConfigHandler;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
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
    public static final ItemFoodBase COCONUT_CHUNK = null;
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

        event.getRegistry().registerAll(
                new ItemFoodBase("avocado", ConfigHandler.AVOCADO_SHANK, ConfigHandler.AVOCADO_SAT),
                new ItemFoodBase("banana", ConfigHandler.BANANA_SHANK, ConfigHandler.BANANA_SAT),
                new ItemFoodBase("blueberry", ConfigHandler.BLUEBERRY_SHANK, ConfigHandler.BLUEBERRY_SAT),
                new ItemFoodBase("coconut_chunk", ConfigHandler.COCONUT_SHANK, ConfigHandler.COCONUT_SAT),
                new ItemFoodBase("corn", ConfigHandler.CORN_SHANK, ConfigHandler.CORN_SAT),
                new ItemFoodBase("honeymelon_slice", ConfigHandler.HONEYMELON_SHANK, ConfigHandler.HONEYMELON_SAT),
                new ItemFoodBase("kiwi", ConfigHandler.KIWI_SHANK, ConfigHandler.KIWI_SAT),
                new ItemFoodBase("kiwano", ConfigHandler.KIWANO_SHANK, ConfigHandler.KIWANO_SAT),
                new ItemFoodBase("lemon", ConfigHandler.LEMON_SHANK, ConfigHandler.LEMON_SAT),
                new ItemFoodBase("lime", ConfigHandler.LIME_SHANK, ConfigHandler.LIME_SAT),
                new ItemFoodBase("pear", ConfigHandler.PEAR_SHANK, ConfigHandler.PEAR_SAT),
                new ItemFoodBase("plum", ConfigHandler.PLUM_SHANK, ConfigHandler.PLUM_SAT),
                new ItemFoodBase("turnip", ConfigHandler.TURNIP_SHANK, ConfigHandler.TURNIP_SAT),
                new ItemFoodBase("infested_pebble", ConfigHandler.INFESTED_PEBBLE_SHANK, ConfigHandler.INFESTED_PEBBLE_SAT),
                new FoodDurian(),
                new ChocolateMilkBucket(),
                new ChocolateMilkBottle(),
                new ItemFoodBase("pineapple", ConfigHandler.PINAPPLE_SHANK, ConfigHandler.PINAPPLE_SAT),
        new SeedCornKernel(),
                new HoneymelonSeeds(),
                new GrassSeeds(),
                new TurnipSeeds(),
                new WeaponScythe("wooden_scythe", Item.ToolMaterial.WOOD, 1),
                new WeaponScythe("stone_scythe", Item.ToolMaterial.STONE, 2),
                new WeaponScythe("golden_scythe", Item.ToolMaterial.GOLD, 3),
                new WeaponScythe("iron_scythe", Item.ToolMaterial.IRON, 4),
                new WeaponScythe("diamond_scythe", Item.ToolMaterial.DIAMOND, 5)

                );




    }

    public static void registerFurnaceRecipes()  {

        FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistration.BLACK_SAND,new ItemStack(Items.IRON_NUGGET,1),0.1F);
    }

}
