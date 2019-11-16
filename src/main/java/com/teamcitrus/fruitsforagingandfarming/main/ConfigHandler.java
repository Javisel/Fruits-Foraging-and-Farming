package com.teamcitrus.fruitsforagingandfarming.main;

import net.minecraftforge.common.config.*;
import net.minecraftforge.fml.common.event.*;

import java.io.*;

public class ConfigHandler {
	public static Configuration config;
	public static boolean WORLD_GEN;
	public static float DURIAN_SAT, CHOC_MILK_SAT;
	public static int DURIAN_SHANKS, CHOC_MILK_SHANKS;
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
		DURIAN_SHANKS = config.getInt("Durian Hunger", category, 4, 0, 20, "Set the hunger value for the durian food");
		CHOC_MILK_SAT = config.getFloat("Chocolate Milk Saturation", category, 2, 0, 20, "Set the saturation for chocolate milk");
		CHOC_MILK_SHANKS = config.getInt("Chocolate Milk Hunger", category, 2, 0, 20, "Set the hunger value for chocolate milk");
	}
	
	public static void registerConfig(FMLPreInitializationEvent event){
		FruitsForagingAndFarming.config = new File(event.getModConfigurationDirectory() + "/" + FruitsForagingAndFarming.MODID);
		FruitsForagingAndFarming.config.mkdirs();
		init(new File(FruitsForagingAndFarming.config.getPath(), FruitsForagingAndFarming.MODID + ".cfg"));
	}
}