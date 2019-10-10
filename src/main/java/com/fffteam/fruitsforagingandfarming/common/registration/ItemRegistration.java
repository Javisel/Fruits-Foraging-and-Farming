package com.fffteam.fruitsforagingandfarming.common.registration;

import com.fffteam.fruitsforagingandfarming.common.items.ItemFood;
import com.fffteam.fruitsforagingandfarming.common.items.weapon.WeaponScythe;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemRegistration {


    public static final ItemFood foodOrange = new ItemFood("food_orange",2,1.0F);
    public static final ItemFood foodBanana = new ItemFood("food_banana",2,1.0F);
    public static final ItemFood foodPineapple = new ItemFood("food_pineapple",2,1.0F);
    public static final ItemFood foodCoconut = new ItemFood("food_coconut",2,1.0F);
    public static final ItemFood foodLemon = new ItemFood("food_lemon",2,1.0f);
    public static final ItemFood foodLime = new ItemFood("food_lime",2,1.0f);
    public static final WeaponScythe scytheWood = new WeaponScythe("scythe_wood", Item.ToolMaterial.WOOD, 0);
    public static final WeaponScythe scytheStone = new WeaponScythe("scythe_stone", Item.ToolMaterial.STONE, 1);
    public static final WeaponScythe scytheGold = new WeaponScythe("scythe_gold", Item.ToolMaterial.GOLD, 2);

    public static final WeaponScythe scytheIron = new WeaponScythe("scythe_iron", Item.ToolMaterial.IRON, 3);
    public static final WeaponScythe scytheDiamond = new WeaponScythe("scythe_diamond", Item.ToolMaterial.DIAMOND, 4);

    public  static void registerItems(IForgeRegistry<Item> registry) {

      registry.register(foodBanana);
      registry.register(foodCoconut);
      registry.register(foodLemon);
      registry.register(foodLime);
      registry.register(foodOrange);
      registry.register(foodPineapple);
        registry.register(scytheWood);
        registry.register(scytheStone);
        registry.register(scytheGold);

        registry.register(scytheIron);
        registry.register(scytheDiamond);


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
               scytheStone.registerItemModel();

    }
}
