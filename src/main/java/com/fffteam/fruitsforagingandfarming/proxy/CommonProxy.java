package com.fffteam.fruitsforagingandfarming.proxy;

import com.fffteam.fruitsforagingandfarming.common.registration.EntityRegistration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


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
}