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
@SuppressWarnings("null")

public class BlockRegistration {

    //Palm Stuff


   public static final   BlockLogBase PALM_LOG = null;
    public static final   BlockLeavesBase palm_leaves= null;

    public static final   BlockBase palm_planks = null;
    public static final    BlockStairBase palm_stairs = null;
    public static final    BlockHalfSlabBase palm_half_slab = null;
    public static final   BlockDoubleSlabBase palm_double_slab = null;
    public static final  BlockFenceBase palm_fence = null;
    public static final  FenceGateBase palm_fence_gate = null;
    public static final  BlockCoconut coconut_block = null;
    public static final  PalmSapling palm_sapling = null;
    //Corn
    public static final   CropCornBottom crop_corn_bottom = null;
    public static final   CropCornTop crop_corn_top = null;
    public static final   CropTurnip crop_turnip = null;
    //Cake
    public static final   CakeBase chocolate_cake = null;




    @SubscribeEvent
    public static final  void onRegisterEvent(@Nonnull final RegistryEvent.Register<Block> event) {
     System.out.println("REGISTERING BLOCK!");
        event.getRegistry().register(new BlockLogBase("palm_log"));

    }


}
