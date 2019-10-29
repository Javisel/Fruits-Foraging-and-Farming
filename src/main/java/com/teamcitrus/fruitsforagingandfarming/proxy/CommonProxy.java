package com.teamcitrus.fruitsforagingandfarming.proxy;

import com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree.TreeGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.Item;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e)
    {
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {


    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {


    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {


    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }
    private void registerBlockColorHandler(Block block)
    {

    }


}