package com.fffteam.fruitsforagingandfarming.common.registration;

import com.fffteam.fruitsforagingandfarming.common.items.*;
import com.fffteam.fruitsforagingandfarming.common.items.weapon.WeaponScythe;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemRegistration {


    //FOOD
    public static final ItemFoodBase foodOrange = new ItemFoodBase("orange",2,1.0F);
    public static final ItemFoodBase foodBanana = new ItemFoodBase("banana",2,1.0F);
    public static final ItemFoodBase foodPineapple = new ItemFoodBase("pineapple",2,1.0F);
    public static final ItemFoodBase foodCoconut = new ItemFoodBase("coconut",2,1.0F);
    public static final ItemFoodBase foodLemon = new ItemFoodBase("lemon",2,1.0f);
    public static final ItemFoodBase foodLime = new ItemFoodBase("lime",2,1.0f);
    public static final ItemFoodBase foodTurnip = new ItemFoodBase("turnip",2,2.0F);
    //SEED
    public static final SeedBase grassSeeds = new GrassSeeds();
    public static final SeedBase turnipSeeds = new SeedBase("turnip_seeds",BlockRegistration.cropTurnip, Blocks.FARMLAND);
    public static final WeaponScythe scytheWood = new WeaponScythe("wooden_scythe", Item.ToolMaterial.WOOD, 0);
    public static final WeaponScythe scytheStone = new WeaponScythe("stone_scythe", Item.ToolMaterial.STONE, 1);
    public static final WeaponScythe scytheGold = new WeaponScythe("golden_scythe", Item.ToolMaterial.GOLD, 2);
    public static final WeaponScythe scytheIron = new WeaponScythe("iron_scythe", Item.ToolMaterial.IRON, 3);
    public static final WeaponScythe scytheDiamond = new WeaponScythe("diamond_scythe", Item.ToolMaterial.DIAMOND, 4);

    //SEEDFOODS
    public static final ItemSeedFoodBase seedFoodCorn = new ItemSeedFoodBase("corn",3,5,BlockRegistration.blockCorn, Blocks.FARMLAND);

    //GEMS
    public static final ItemBase ruby = new ItemBase("ruby");

    public  static void registerItems(IForgeRegistry<Item> registry) {

      registry.register(foodBanana);
      registry.register(foodCoconut);
      registry.register(foodLemon);
      registry.register(foodLime);
      registry.register(foodOrange);
      registry.register(foodPineapple);
      registry.register(grassSeeds);
      registry.register(turnipSeeds);
      registry.register(foodTurnip);
      registry.register(seedFoodCorn);
        registry.register(scytheWood);
        registry.register(scytheStone);
        registry.register(scytheGold);
        registry.register(scytheIron);
        registry.register(scytheDiamond);
        registry.register(ruby);

    }

    public static void registerModels() {

                foodBanana.registerItemModel();
                foodCoconut.registerItemModel();
                foodLemon.registerItemModel();
                foodLime.registerItemModel();
                foodOrange.registerItemModel();
                foodPineapple.registerItemModel();
                scytheWood.registerItemModel();
                scytheDiamond.registerItemModel();
                scytheGold.registerItemModel();
                scytheIron.registerItemModel();
                turnipSeeds.registerItemModel();
                foodTurnip.registerItemModel();
               scytheStone.registerItemModel();
               grassSeeds.registerItemModel();
               ruby.registerItemModel();
    }

    public static void registerOreMaterial() {

        OreDictionary.registerOre("gemRuby",ruby);
    }
}
