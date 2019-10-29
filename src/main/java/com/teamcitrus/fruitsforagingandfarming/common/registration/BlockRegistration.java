package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.common.blocks.*;
import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class BlockRegistration {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final CropCornBottom cropCorn = new CropCornBottom();
    public static final CropCornTop cropCornTop = new CropCornTop();
    public static final CropTurnip cropTurnip = new CropTurnip();
    public static final CakeBase chocolateCake = new CakeBase("chocolate_cake",2,0.3F);


   public static final BlockLogBase palmLog = new BlockLogBase("palm_log");
   public static final BlockLeavesBase palmLeaves = new BlockLeavesBase("palm_leaves", Item.getItemFromBlock(BlockRegistration.palmSapling));
   public static final BlockCoconut blockCoconut = new BlockCoconut();
   public static final BlockBase palmPlanks = new BlockBase(Material.WOOD,"palm_planks",2,5,SoundType.WOOD);
   public static final BlockStairBase palmStairs = new BlockStairBase("palm_stairs",palmPlanks.getDefaultState());
    public static final BlockDoubleSlabBase palmdoubleslab = new BlockDoubleSlabBase("palm_double_slab",Material.WOOD,SoundType.WOOD,BlockRegistration.palmhalfslab);

   public static final BlockHalfSlabBase palmhalfslab = new BlockHalfSlabBase("palm_half_slab",Material.WOOD,SoundType.WOOD,BlockRegistration.palmhalfslab );
   public static final BlockFenceBase palmfence = new WoodFenceBase("palm_fence", MapColor.BROWN);
    public static final FenceGateBase palmfencegate = new FenceGateBase("palm_fence_gate");
    public static final BlockSaplingBase palmSapling = new PalmSapling();

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                cropCorn,
                cropCornTop,
                cropTurnip,
                chocolateCake,
                palmLog,
                palmLeaves,
                palmPlanks,
                palmStairs,
                palmhalfslab,
                palmdoubleslab,
                palmfence,
                palmfencegate,
                palmSapling,
                blockCoconut

        );
    }
    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                chocolateCake.createItemBlock(),
                blockCoconut.createItemBlock(),
                palmLog.createItemBlock(),
                palmLeaves.createItemBlock(),
                palmPlanks.createItemBlock(),
                palmStairs.createItemBlock(),
                palmhalfslab.createItemBlock(),
                palmfence.createItemBlock(),
                palmfencegate.createItemBlock(),
                palmSapling.createItemBlock()
        );
    }
    public static void registerModels() {
        chocolateCake.registerItemModel(Item.getItemFromBlock(chocolateCake));
        blockCoconut.registerItemModel(Item.getItemFromBlock(blockCoconut));
        palmLog.registerItemModel(Item.getItemFromBlock(palmLog));
        palmLeaves.registerItemModel(Item.getItemFromBlock(palmLeaves));
        palmPlanks.registerItemModel(Item.getItemFromBlock(palmPlanks));
        palmStairs.registerItemModel(Item.getItemFromBlock(palmStairs));
        palmhalfslab.registerItemModel(Item.getItemFromBlock(palmhalfslab));
        palmfence.registerItemModel(Item.getItemFromBlock(palmfence));
        palmfencegate.registerItemModel(Item.getItemFromBlock(palmfencegate));
        palmSapling.registerItemModel(Item.getItemFromBlock(palmSapling));
    }
    public static void registerOre() {
        OreDictionary.registerOre("logWood",     new ItemStack(palmLog, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("plankWood",     new ItemStack(palmPlanks, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary. registerOre("treeLeaves",  new ItemStack(palmLeaves, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary. registerOre("stairWood",  new ItemStack(palmStairs, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("fenceWood", new ItemStack(palmfence,1,OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("fenceGateWood",new ItemStack(palmfencegate,1,OreDictionary.WILDCARD_VALUE));

    }


}

