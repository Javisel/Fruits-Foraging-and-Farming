package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.common.blocks.*;
import com.teamcitrus.fruitsforagingandfarming.common.items.CoconutBlockItem;
import com.teamcitrus.fruitsforagingandfarming.common.items.ItemCakeBlock;
import com.teamcitrus.fruitsforagingandfarming.common.items.ItemLeavesBase;
import com.teamcitrus.fruitsforagingandfarming.common.items.ItemPlaceableFruit;
import com.teamcitrus.fruitsforagingandfarming.main.ConfigHandler;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FruitsForagingAndFarming.MODID)
@ObjectHolder(FruitsForagingAndFarming.MODID)
@SuppressWarnings("null")

public class BlockRegistration {

    //Palm Stuff


    public static final BlockLogBase PALM_LOG = null;
    public static final BlockLeavesBase PALM_LEAVES = null;

    public static final BlockBase PALM_PLANKS = null;
    public static final BlockStairBase PALM_STAIRS = null;
    public static final BlockHalfSlabBase PALM_HALF_SLAB = null;
    public static final BlockDoubleSlabBase PALM_DOUBLE_SLAB = null;
    public static final BlockFenceBase PALM_FENCE = null;
    public static final FenceGateBase PALM_FENCE_GATE = null;
    public static final BlockCoconut COCONUT_BLOCK = null;
    public static final PalmSapling PALM_SAPLING = null;
    //Crops
    public static final CropCornTop CORN_CROP_TOP = null;

    public static final CropCornBottom CORN_CROP_BOTTOM = null;
    public static final CropTurnip TURNIP_CROP = null;

    //Honeymelon
    public static final BlockHoneyMelon HONEYMELON_BLOCK = null;
    public static final HoneyMelonStem HONEYMELON_STEM = null;
    //Cake
    public static final CakeBase CHOCOLATE_CAKE = null;

    //Fruit-Blocks that hang from trees
    public static final BlockFruit ORANGE = null;
    public static final BlockFruit BANANA_BUNCH = null;
    public static final BlockFruit MANGO = null;

        //MIS
    public static final BlackSand BLACK_SAND = null;
    @SubscribeEvent
    public static final void onRegisterEvent(@Nonnull final RegistryEvent.Register<Block> event) {
        BlockBase wood = new BlockBase(Material.WOOD, "wood", 2, 5, SoundType.WOOD);

        event.getRegistry().registerAll(
                new BlockLogBase("palm_log"),
                new BlockLeavesBase("palm_leaves", EnumTreeType.PALM),
                new BlockBase(Material.WOOD, "palm_planks", 1, 1, SoundType.WOOD),
                new BlockStairBase("palm_stairs", wood.getDefaultState()),
                new BlockHalfSlabBase("palm_half_slab", Material.WOOD, SoundType.WOOD, BlockRegistration.PALM_HALF_SLAB),
                 new BlockDoubleSlabBase("palm_double_slab", Material.WOOD, SoundType.WOOD, BlockRegistration.PALM_HALF_SLAB),
                new BlockFenceBase("palm_fence", Material.WOOD, MapColor.BROWN),
                new FenceGateBase("palm_fence_gate"),
                new BlackSand(),
                new BlockCoconut(),
                new PalmSapling(),
                new CropCornTop(),
                new CropCornBottom(),
                new CropTurnip(),
                new HoneyMelonStem(),
                new BlockHoneyMelon(),
                new BlockFruit("banana_bunch"),
                new BlockFruit("orange"),
                new BlockFruit("mango"),
        new CakeBase("chocolate_cake", 2, 0.3F)
        );




    }

    @SubscribeEvent
    public static final void registerItemEvent(@Nonnull final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ItemBlock(BlockRegistration.PALM_LOG).setRegistryName(BlockRegistration.PALM_LOG.getRegistryName()),
                new ItemLeavesBase(BlockRegistration.PALM_LEAVES),
                new ItemBlock(BlockRegistration.PALM_PLANKS).setRegistryName(BlockRegistration.PALM_PLANKS.getRegistryName()),
                new ItemBlock(BlockRegistration.PALM_STAIRS).setRegistryName(BlockRegistration.PALM_STAIRS.getRegistryName()),
                new ItemSlab(BlockRegistration.PALM_HALF_SLAB, BlockRegistration.PALM_HALF_SLAB, BlockRegistration.PALM_DOUBLE_SLAB).setRegistryName(BlockRegistration.PALM_HALF_SLAB.getRegistryName()),
                  new ItemBlock(BlockRegistration.PALM_FENCE).setRegistryName(BlockRegistration.PALM_FENCE.getRegistryName()),
                new ItemBlock(BlockRegistration.BLACK_SAND).setRegistryName(BlockRegistration.BLACK_SAND.getRegistryName()),
                new ItemBlock(BlockRegistration.PALM_FENCE_GATE).setRegistryName(BlockRegistration.PALM_FENCE_GATE.getRegistryName()),
                new ItemBlock(BlockRegistration.BANANA_BUNCH).setRegistryName(BlockRegistration.BANANA_BUNCH.getRegistryName()),
                new CoconutBlockItem(),
                new ItemPlaceableFruit("orange", BlockRegistration.ORANGE, ConfigHandler.ORANGE_SHANK, ConfigHandler.ORANGE_SAT, false),
                new ItemPlaceableFruit("mango", BlockRegistration.MANGO, ConfigHandler.MANGO_SHANK, ConfigHandler.MANGO_SHANK, false),
                new ItemBlock(BlockRegistration.PALM_SAPLING).setRegistryName(BlockRegistration.PALM_SAPLING.getRegistryName()),
                new ItemBlock(BlockRegistration.HONEYMELON_BLOCK).setRegistryName(BlockRegistration.HONEYMELON_BLOCK.getRegistryName()),
                new ItemCakeBlock(BlockRegistration.CHOCOLATE_CAKE).setRegistryName(BlockRegistration.CHOCOLATE_CAKE.getRegistryName())
        );


    }


    public static final void RegisterOre() {
        OreDictionary.registerOre("logWood",BlockRegistration.PALM_LOG);
        OreDictionary.registerOre("plankWood",BlockRegistration.PALM_PLANKS);
        OreDictionary.registerOre("stairWood",BlockRegistration.PALM_STAIRS);
        OreDictionary.registerOre("slabWood",BlockRegistration.PALM_HALF_SLAB);
        OreDictionary.registerOre("logWood",BlockRegistration.PALM_LOG);
        OreDictionary.registerOre("fenceWood",BlockRegistration.PALM_FENCE);
        OreDictionary.registerOre("fenceGateWood",BlockRegistration.PALM_FENCE_GATE);
        OreDictionary.registerOre("treeSapling",BlockRegistration.PALM_SAPLING);
        OreDictionary.registerOre("treeLeaves",BlockRegistration.PALM_LEAVES);
        OreDictionary. registerOre("sand",   BlockRegistration.BLACK_SAND);

    }

}