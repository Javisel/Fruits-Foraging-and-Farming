package com.teamcitrus.fruitsforagingandfarming.main;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class ConfigHandler {
	public static Configuration config;
	public static boolean WORLD_GEN;
	public static float DURIAN_SAT, CHOC_MILK_SAT, AVOCADO_SAT, BANANA_SAT, BLUEBERRY_SAT, COCONUT_SAT, CORN_SAT,
		HONEYMELON_SAT, KIWI_SAT, KIWANO_SAT, LEMON_SAT, LIME_SAT, MANGO_SAT, ORANGE_SAT, PEAR_SAT, PINAPPLE_SAT, 
		PLUM_SAT, TURNIP_SAT, INFESTED_PEBBLE_SAT;
	public static int DURIAN_SHANK, CHOC_MILK_SHANK, AVOCADO_SHANK, BANANA_SHANK, BLUEBERRY_SHANK, COCONUT_SHANK,
		CORN_SHANK, HONEYMELON_SHANK, KIWI_SHANK, KIWANO_SHANK, LEMON_SHANK, LIME_SHANK, MANGO_SHANK, ORANGE_SHANK, 
		PEAR_SHANK, PINAPPLE_SHANK, PLUM_SHANK, TURNIP_SHANK, INFESTED_PEBBLE_SHANK;
	/*
	 * TODO: All values for fruits (Saturation & Hunger restoration)
	 */
	public static void init(File file){
		config = new Configuration(file);
		String category;
		
		category = "World Generation";
		config.addCustomCategoryComment(category, "Set world generation for Fruits Foraging and Farming");
		WORLD_GEN = config.getBoolean("World Generation", category, true, "Boolean for world generation. Default is true.");
		category = "Food MetaData";
		config.addCustomCategoryComment(category, "Set the food item's saturation and Hunger values.");
		DURIAN_SAT = config.getFloat("Durian Saturation", category, 1.0F, 0, 20, "Set the saturation for the durian food");
		DURIAN_SHANK = config.getInt("Durian Hunger", category, 4, 0, 20, "Set the hunger value for the durian food");
		CHOC_MILK_SAT = config.getFloat("Chocolate Milk Saturation", category, 2F, 0, 20, "Set the saturation for chocolate milk");
		CHOC_MILK_SHANK = config.getInt("Chocolate Milk Hunger", category, 2, 0, 20, "Set the hunger value for chocolate milk");
		AVOCADO_SAT = config.getFloat("Avocado Saturation", category, 2.4F, 0, 20, "Set the saturation for avocados");
		AVOCADO_SHANK = config.getInt("Avocado Hunger", category, 3, 0, 20, "Set the hunger value for avocados");
		BANANA_SAT = config.getFloat("Banana Saturation", category, 3.2F, 0, 20, "Set the saturation for bananas");
		BANANA_SHANK = config.getInt("Banana Hunger", category, 2, 0, 20, "Set the hunger value for bananas");
		BLUEBERRY_SAT = config.getFloat("Blueberry Saturation", category, 0.4F, 0, 20, "Set the saturation for blueberries");
		BLUEBERRY_SHANK = config.getInt("Blueberry Hunger", category, 1, 0, 20, "Set the hunger value for blueberries");
		COCONUT_SAT = config.getFloat("Coconut Saturation", category, 5.6F, 0, 20, "Set the saturation for coconuts");
		COCONUT_SHANK = config.getInt("Coconut Hunger", category, 3, 0, 20, "Set the hunger value for coconuts");
		CORN_SAT = config.getFloat("Corn Saturation", category, 3.0F, 0, 20, "Set the saturation for corn");
		CORN_SHANK = config.getInt("Corn Hunger", category, 1, 0, 20, "Set the hunger value for corn");
		HONEYMELON_SAT = config.getFloat("Honey melon Saturation", category, 7.8F, 0, 20, "Set the saturation for honey melon");
		HONEYMELON_SHANK = config.getInt("Honey melon Hunger", category, 4, 0, 20, "Set the hunger value for honey melon");
		KIWI_SAT = config.getFloat("Kiwi Saturation", category, 2.8F, 0, 20, "Set the saturation for kiwi");
		KIWI_SHANK = config.getInt("Kiwi Hunger", category, 2, 0, 20, "Set the hunger value for kiwi");
		KIWANO_SAT = config.getFloat("Kiwano Saturation", category, 2.0F, 0, 20, "Set the saturation for kiwanos");
		KIWANO_SHANK = config.getInt("Kiwano Hunger", category, 3, 0, 20, "Set the hunger value for kiwanos");
		LEMON_SAT = config.getFloat("Lemon Saturation", category, 2.2F, 0, 20, "Set the saturation for lemons");
		LEMON_SHANK = config.getInt("Lemon Hunger", category, 2, 0, 20, "Set the hunger value for lemons");
		LIME_SAT = config.getFloat("Lime Saturation", category, 2.2F, 0, 20, "Set the saturation for limes");
		LIME_SHANK = config.getInt("Lime Hunger", category, 2, 0, 20, "Set the hunger value for limes");
		MANGO_SAT = config.getFloat("Mango Saturation", category, 3.4F, 0, 20, "Set the saturation for mangoes");
		MANGO_SHANK = config.getInt("Mango Hunger", category, 3, 0, 20, "Set the hunger value for mangoes");
		ORANGE_SAT = config.getFloat("Orange Saturation", category, 8.2F, 0, 20, "Set the saturation for orances");
		ORANGE_SHANK = config.getInt("Orange Hunger", category, 1, 0, 20, "Set the hunger value for oranges");
		PEAR_SAT = config.getFloat("Pear Saturation", category, 4.6F, 0, 20, "Set the saturation for pears");
		PEAR_SHANK = config.getInt("Pear Hunger", category, 3, 0, 20, "Set the hunger value for pears");
		PINAPPLE_SAT = config.getFloat("Pinapple Saturation", category, 4.2F, 0, 20, "Set the saturation for pineapples");
		PINAPPLE_SHANK = config.getInt("Pineapple Hunger", category, 3, 0, 20, "Set the hunger value for pineapples");
		PLUM_SAT = config.getFloat("Plum Saturation", category, 2.5F, 0, 20, "Set the saturation for plums");
		PLUM_SHANK = config.getInt("Plum Hunger", category, 1, 0, 20, "Set the hunger value for plums");
		TURNIP_SAT = config.getFloat("Turnip Saturation", category, 2F, 0, 20, "Set the saturation for turnips");
		TURNIP_SHANK = config.getInt("Turnip Hunger", category, 1, 0, 20, "Set the hunger value for turnips");
		INFESTED_PEBBLE_SAT = config.getFloat("Infested Pebble Saturation", category, 1F, 0, 20, "Set the saturation for infested pebbles");
		INFESTED_PEBBLE_SHANK = config.getInt("Infested Pebble Hunger", category, 1, 0, 20, "Set the hunger value for infested pebbles");
	}
	
	public static void registerConfig(FMLPreInitializationEvent event){
		FruitsForagingAndFarming.config = new File(event.getModConfigurationDirectory() + "/" + FruitsForagingAndFarming.MODID);
		FruitsForagingAndFarming.config.mkdirs();
		init(new File(FruitsForagingAndFarming.config.getPath(), FruitsForagingAndFarming.MODID + ".cfg"));
	}
}