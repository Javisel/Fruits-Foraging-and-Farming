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
    public static final ItemFoodBase COCONUT_CHUNK = null;
    public static final ItemFoodBase CORN = null;
    public static final ItemFoodBase DURIAN = null;

    public static final ItemFoodBase HONEYMELON_SLICE = null;
    public static final ItemFoodBase KIWI = null;
    public static final ItemFoodBase LEMON = null;
    public static final ItemFoodBase LIME = null;
    public static final ItemFoodBase PEAR = null;
    public static final ItemFoodBase PINEAPPLE = null;
    public static final ItemFoodBase PLUM = null;
    public static final ItemFoodBase TURNIP = null;
    public static final InfestedPebble INFESTED_EGGS = null;


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

    //MIS
    public static final CrackedCoconut CRACKED_COCONUT = null;


    @SubscribeEvent
    public static final void registerItemEvent(@Nonnull final RegistryEvent.Register<Item> event) {

        event.getRegistry().registerAll(
                new ItemFoodBase("avocado", ConfigHandler.AVOCADO.shanks, ConfigHandler.AVOCADO.getSaturation()),
                new ItemFoodBase("banana", ConfigHandler.BANANA.shanks, ConfigHandler.BANANA.getSaturation()),
                new ItemFoodBase("blueberry", ConfigHandler.BLUEBERRY.shanks, ConfigHandler.BLUEBERRY.getSaturation()),

                new ItemFoodBase("coconut_chunk", ConfigHandler.COCONUT.shanks, ConfigHandler.COCONUT.getSaturation()),
                new ItemFoodBase("corn", ConfigHandler.CORN.shanks, ConfigHandler.CORN.getSaturation()),
                new ItemFoodBase("durian",ConfigHandler.DURIAN.shanks,ConfigHandler.DURIAN.getSaturation()),

                new ItemFoodBase("honeymelon_slice", ConfigHandler.HONEYMELON_SLICE.shanks, ConfigHandler.HONEYMELON_SLICE.getSaturation()),
                new ItemFoodBase("kiwi", ConfigHandler.KIWI.shanks, ConfigHandler.KIWI.getSaturation()),
                new ItemFoodBase("kiwano", ConfigHandler.KIWANO.shanks, ConfigHandler.KIWANO.getSaturation()),
                new ItemFoodBase("lemon", ConfigHandler.LEMON.shanks, ConfigHandler.LEMON.getSaturation()),
                new ItemFoodBase("lime", ConfigHandler.LIME.shanks, ConfigHandler.LIME.getSaturation()),
                new ItemFoodBase("pear", ConfigHandler.PEAR.shanks, ConfigHandler.PEAR.getSaturation()),
                new ItemFoodBase("plum", ConfigHandler.PLUM.shanks, ConfigHandler.PLUM.getSaturation()),
                new ItemFoodBase("turnip", ConfigHandler.TURNIP.shanks, ConfigHandler.TURNIP.getSaturation()),
                new InfestedPebble(),
                new ChocolateMilkBucket(),
                new ChocolateMilkBottle(),
                new ItemFoodBase("pineapple", ConfigHandler.PINEAPPLE.shanks, ConfigHandler.PINEAPPLE.getSaturation()),
        new SeedCornKernel(),
                new HoneymelonSeeds(),
                new GrassSeeds(),
                new TurnipSeeds(),
                new WeaponScythe("wooden_scythe", Item.ToolMaterial.WOOD, 3),
                new WeaponScythe("stone_scythe", Item.ToolMaterial.STONE, 4),
                new WeaponScythe("golden_scythe", Item.ToolMaterial.GOLD, 5),
                new WeaponScythe("iron_scythe", Item.ToolMaterial.IRON, 6),
                new WeaponScythe("diamond_scythe", Item.ToolMaterial.DIAMOND, 7),

                new CrackedCoconut()
                );




    }

    public static void registerFurnaceRecipes()  {

    //  FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistration.BLACK_SAND,new ItemStack(Items.IRON_NUGGET,1),0.1F);
    }

}
