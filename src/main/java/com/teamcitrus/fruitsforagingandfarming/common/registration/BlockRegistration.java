package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.common.blocks.*;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FruitsForagingAndFarming.MODID)
@ObjectHolder(FruitsForagingAndFarming.MODID)
@Nonnull
public class BlockRegistration {

    //Palm Stuff

   public static BlockLogBase palm_log;
    public static BlockLeavesBase palm_leaves;

    public static BlockBase palm_planks;
    public static BlockStairBase palm_stairs;
    public static  BlockHalfSlabBase palm_half_slab;
    public static  BlockDoubleSlabBase palm_double_slab;
    public static BlockFenceBase palm_fence;
    public static FenceGateBase palm_fence_gate;
    public static BlockCoconut coconut_block;
    public static PalmSapling palm_sapling;
    //Corn
    public static  CropCornBottom crop_corn_bottom;
    public static  CropCornTop crop_corn_top;
    public static  CropTurnip crop_turnip;
    //Cake
    public static  CakeBase chocolate_cake;




    @SubscribeEvent
    public  static void registerBlocks(RegistryEvent.Register<Block> event) {


        event.getRegistry().register(palm_log = new BlockLogBase("palm_log"));
    event.getRegistry().register(palm_leaves = new BlockLeavesBase("palm_leaves", Item.getItemFromBlock(palm_sapling)));

    event.getRegistry().register(palm_planks = new BlockBase(Material.WOOD,"palm_planks",2,5,SoundType.WOOD));



    event.getRegistry().register(palm_stairs = new BlockStairBase("palm_stairs",palm_planks.getDefaultState()));
    event.getRegistry().register(palm_half_slab =new BlockHalfSlabBase("palm_half_slab",Material.WOOD,SoundType.WOOD,BlockRegistration.palm_half_slab));
    event.getRegistry().register(palm_double_slab= new BlockDoubleSlabBase("palm_double_slab", Material.WOOD, SoundType.WOOD, BlockRegistration.palm_half_slab));
    event.getRegistry().register(palm_fence=new WoodFenceBase("palm_fence",MapColor.BROWN));
    event.getRegistry().register(palm_fence_gate=new FenceGateBase("palm_fence_gate"));
    event.getRegistry().register(coconut_block = new BlockCoconut());
    event.getRegistry().register(palm_sapling = new PalmSapling());
    event.getRegistry().register(crop_corn_bottom = new CropCornBottom());
    event.getRegistry().register(crop_corn_top=new CropCornTop());
    event.getRegistry().register(crop_turnip=new CropTurnip());
    event.getRegistry().register(chocolate_cake=new CakeBase("chocolate_cake",2,0.3F));

}





}
