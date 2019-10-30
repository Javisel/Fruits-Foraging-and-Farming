package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.common.blocks.*;
import com.teamcitrus.fruitsforagingandfarming.common.items.CoconutBlockItem;
import com.teamcitrus.fruitsforagingandfarming.common.items.ItemLeavesBase;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

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
    //Corn
    public static final CropCornBottom CROP_CORN_BOTTOM = null;
    public static final CropCornTop CROP_CORN_TOP = null;
    public static final CropTurnip CROP_TURNIP = null;
    //Cake
    public static final CakeBase CHOCOLATE_CAKE = null;


    @SubscribeEvent
    public static final void onRegisterEvent(@Nonnull final RegistryEvent.Register<Block> event) {
        System.out.println("REGISTERING BLOCK!");
        event.getRegistry().register(new BlockLogBase("palm_log"));
        event.getRegistry().register(new BlockLeavesBase("palm_leaves", Item.getItemFromBlock(PALM_SAPLING)));

        event.getRegistry().register(new BlockBase(Material.WOOD,"palm_planks",1,1,SoundType.WOOD));

        event.getRegistry().register(new BlockStairBase("palm_stairs", BlockRegistration.PALM_PLANKS.getDefaultState()));
        event.getRegistry().register(new BlockHalfSlabBase("palm_half_slab", Material.WOOD, SoundType.WOOD, BlockRegistration.PALM_HALF_SLAB));
        event.getRegistry().register(new BlockDoubleSlabBase("palm_double_slab", Material.WOOD, SoundType.WOOD, BlockRegistration.PALM_HALF_SLAB));
        event.getRegistry().register(new BlockFenceBase("palm_fence", Material.WOOD, MapColor.BROWN));
        event.getRegistry().register(new FenceGateBase("palm_fence_gate"));
        event.getRegistry().register(new BlockCoconut());
        event.getRegistry().register(new PalmSapling());
        event.getRegistry().register(new CropCornBottom());
        event.getRegistry().register(new CropCornTop());
        event.getRegistry().register(new CropTurnip());
        event.getRegistry().register(new CakeBase("chocolate_cake", 2, 0.3F));
    }

    @SubscribeEvent
    public static final void registerItemEvent(@Nonnull final  RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(BlockRegistration.PALM_LOG).setRegistryName(BlockRegistration.PALM_LOG.getRegistryName()));
        event.getRegistry().register(new ItemLeavesBase(BlockRegistration.PALM_LEAVES).setRegistryName(BlockRegistration.PALM_LEAVES.getRegistryName()));
        event.getRegistry().register(new ItemBlock(BlockRegistration.PALM_STAIRS).setRegistryName(BlockRegistration.PALM_STAIRS.getRegistryName()));
        event.getRegistry().register(new ItemSlab(BlockRegistration.PALM_PLANKS, BlockRegistration.PALM_HALF_SLAB, BlockRegistration.PALM_DOUBLE_SLAB).setRegistryName(BlockRegistration.PALM_HALF_SLAB.getRegistryName()));
        event.getRegistry().register(new ItemBlock(BlockRegistration.PALM_FENCE).setRegistryName(BlockRegistration.PALM_FENCE.getRegistryName()));
        event.getRegistry().register(new ItemBlock(BlockRegistration.PALM_FENCE_GATE).setRegistryName(BlockRegistration.PALM_FENCE_GATE.getRegistryName()));
        event.getRegistry().register(new CoconutBlockItem());
        event.getRegistry().register(new ItemBlock(BlockRegistration.PALM_SAPLING).setRegistryName(BlockRegistration.PALM_SAPLING.getRegistryName()));
        event.getRegistry().register(new ItemBlock(BlockRegistration.CHOCOLATE_CAKE).setRegistryName(BlockRegistration.CHOCOLATE_CAKE.getRegistryName()));


    }


}
