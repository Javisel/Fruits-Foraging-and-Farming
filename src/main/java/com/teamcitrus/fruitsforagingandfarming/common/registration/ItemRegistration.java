package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.common.items.*;
import com.teamcitrus.fruitsforagingandfarming.common.items.weapon.WeaponScythe;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemRegistration {


    //FOOD

    public static final ItemFoodBase foodAvocado = new ItemFoodBase("avocado", 2, 2.8F);
    public static final ItemFoodBase foodBanana = new ItemFoodBase("banana", 2, 2.1F);
    public static final ItemFoodBase foodBlueberry = new ItemFoodBase("blueberry", 1, 0.5F);

    public static final ItemFoodBase foodCoconut = new ItemFoodBase("coconut", 2, 2.5F);
    public static final ItemFoodBase foodCorn = new ItemFoodBase("corn", 3, 0.2F);
    public static final ItemFoodBase foodHoneyMelonSlice = new ItemFoodBase("honeymelon_slice", 1, 0.5F);
    public static final ItemFoodBase foodKiwi = new ItemFoodBase("kiwi", 1, 0.4F);
    public static final ItemFoodBase foodLemon = new ItemFoodBase("lemon", 2, 2.3F);
    public static final ItemFoodBase foodLime = new ItemFoodBase("lime", 2, 2.3F);
    public static final ItemFoodBase foodMango = new ItemFoodBase("mango", 2, 0.5F);
    public static final ItemFoodBase foodOrange = new ItemFoodBase("orange", 2, 3);
    public static final ItemFoodBase foodPear = new ItemFoodBase("pear", 2, 0.5F);
    public static final ItemFoodBase foodPineapple = new ItemFoodBase("pineapple", 2, 2.5F);
    public static final ItemFoodBase foodPlum = new ItemFoodBase("plum", 2, 0.5F);
    public static final ItemFoodBase foodTurnip = new ItemFoodBase("turnip", 2, 0.5F);
    public static final ItemFoodBase foodInfestedPebble = new InfestedPebble();
    public static final ItemFoodBase foodDurian = new foodDurian();


    public static final ChocolateMilkBucket chocolateMilkBucket = new ChocolateMilkBucket();
    public static final ChocolateMilkBottle chocolateMilkBottle = new ChocolateMilkBottle();
    public static final ItemBase bananaBunch = new ItemBase("banana_bunch");

    //SEED
    public static final SeedBase grassSeeds = new GrassSeeds();
    public static final TurnipSeeds turnipSeeds = new TurnipSeeds();
    public static final SeedCornKernel cornKernels = new SeedCornKernel();
    //TOOLS & WEAPONS
    public static final WeaponScythe scytheWood = new WeaponScythe("wooden_scythe", Item.ToolMaterial.WOOD, 1);
    public static final WeaponScythe scytheStone = new WeaponScythe("stone_scythe", Item.ToolMaterial.STONE, 2);
    public static final WeaponScythe scytheGold = new WeaponScythe("golden_scythe", Item.ToolMaterial.GOLD, 3);
    public static final WeaponScythe scytheIron = new WeaponScythe("iron_scythe", Item.ToolMaterial.IRON, 4);
    public static final WeaponScythe scytheDiamond = new WeaponScythe("diamond_scythe", Item.ToolMaterial.DIAMOND, 5);

    //SEEDFOODS

    //GEMS


    public static void registerItems(IForgeRegistry<Item> registry) {
        registry.register(foodAvocado);
        registry.register(Item.getItemFromBlock(BlockRegistration.PALM_LOG));
        registry.register(foodBlueberry);
        registry.register(foodHoneyMelonSlice);
        registry.register(foodKiwi);
        registry.register(foodMango);
        registry.register(foodPear);
        registry.register(foodPlum);
        registry.register(bananaBunch);
        registry.register(foodBanana);
        registry.register(foodCoconut);
        registry.register(foodLemon);
        registry.register(foodLime);
        registry.register(foodOrange);
        registry.register(foodDurian);
        registry.register(foodPineapple);
        registry.register(foodInfestedPebble);
        registry.register(grassSeeds);
        registry.register(turnipSeeds);
        registry.register(cornKernels);
        registry.register(foodTurnip);
        registry.register(chocolateMilkBucket);
        registry.register(chocolateMilkBottle);
        registry.register(foodCorn);
        registry.register(scytheWood);
        registry.register(scytheStone);
        registry.register(scytheGold);
        registry.register(scytheIron);
        registry.register(scytheDiamond);

    }

    public static void registerModels() {
        foodAvocado.registerItemModel();
        foodBanana.registerItemModel();
        foodBlueberry.registerItemModel();
        foodHoneyMelonSlice.registerItemModel();
        foodKiwi.registerItemModel();
        foodPlum.registerItemModel();
        foodPear.registerItemModel();
        foodMango.registerItemModel();
        foodCoconut.registerItemModel();
        foodLemon.registerItemModel();
        foodDurian.registerItemModel();
        foodLime.registerItemModel();
        foodOrange.registerItemModel();
        foodPineapple.registerItemModel();
        foodCorn.registerItemModel();
        chocolateMilkBucket.registerItemModel();
        chocolateMilkBottle.registerItemModel();
        scytheWood.registerItemModel();
        scytheDiamond.registerItemModel();
        scytheGold.registerItemModel();
        scytheIron.registerItemModel();
        turnipSeeds.registerItemModel();
        cornKernels.registerItemModel();
        foodTurnip.registerItemModel();
        scytheStone.registerItemModel();
        grassSeeds.registerItemModel();
        foodInfestedPebble.registerItemModel();
    }

    public static void registerOreMaterial() {

    }
}
