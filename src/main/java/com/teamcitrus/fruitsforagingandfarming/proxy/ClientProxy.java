package com.teamcitrus.fruitsforagingandfarming.proxy;

import com.teamcitrus.fruitsforagingandfarming.client.render.EntityRenderRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.blocks.EnumColorable;
import com.teamcitrus.fruitsforagingandfarming.common.blocks.IBitMapColorBlock;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {


    @SubscribeEvent
    public static void RegisterItemModels(final ModelRegistryEvent event) {

        //Item Blocks
        registerItemRenderer(ItemRegistration.AVOCADO, 0);
        registerItemRenderer(ItemRegistration.BANANA, 0);
        registerItemRenderer(ItemRegistration.BLUEBERRY, 0);
        registerItemRenderer(ItemRegistration.CHOCOLATE_MILK_BOTTLE, 0);
        registerItemRenderer(ItemRegistration.CHOCOLATE_MILK_BUCKET, 0);
        registerItemRenderer(ItemRegistration.COCONUT, 0);
        registerItemRenderer(ItemRegistration.CORN, 0);
        registerItemRenderer(ItemRegistration.DURIAN, 0);
        registerItemRenderer(ItemRegistration.INFESTED_PEBBLE, 0);
        registerItemRenderer(ItemRegistration.HONEYMELON_SLICE, 0);
        registerItemRenderer(ItemRegistration.KIWI, 0);
        registerItemRenderer(ItemRegistration.KIWANO, 0);
        registerItemRenderer(ItemRegistration.LEMON, 0);
        registerItemRenderer(ItemRegistration.LIME, 0);
        registerItemRenderer(ItemRegistration.MANGO, 0);
        registerItemRenderer(ItemRegistration.ORANGE, 0);
        registerItemRenderer(ItemRegistration.PEAR, 0);
        registerItemRenderer(ItemRegistration.PINEAPPLE, 0);
        registerItemRenderer(ItemRegistration.CORN_KERNEL, 0);
        registerItemRenderer(ItemRegistration.TURNIP, 0);
        registerItemRenderer(ItemRegistration.TURNIP_SEEDS, 0);
        registerItemRenderer(ItemRegistration.IRON_SCYTHE, 0);
        registerItemRenderer(ItemRegistration.WOODEN_SCYTHE, 0);
        registerItemRenderer(ItemRegistration.GOLDEN_SCYTHE, 0);
        registerItemRenderer(ItemRegistration.DIAMOND_SCYTHE, 0);
        registerItemRenderer(ItemRegistration.PLUM, 0);
        registerItemRenderer(ItemRegistration.GRASS_SEEDS, 0);
        registerItemRenderer(ItemRegistration.STONE_SCYTHE, 0);
        registerItemRenderer(ItemRegistration.HONEYMELON_SEEDS, 0);
        //BLOCKS
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.PALM_LOG), 0);
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.PALM_LEAVES), 0);
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.PALM_PLANKS), 0);
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.COCONUT_BLOCK), 0);
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.PALM_HALF_SLAB), 0);
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.PALM_FENCE), 0);
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.PALM_FENCE_GATE), 0);
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.PALM_STAIRS), 0);
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.PALM_SAPLING), 0);
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.CHOCOLATE_CAKE), 0);
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.HONEYMELON_BLOCK), 0);
        registerItemRenderer(Item.getItemFromBlock(BlockRegistration.BANANA_BUNCH),0);

    }

    private static void registerBlockColorHandler(Block block) {
        if (block instanceof IBitMapColorBlock) {

            IBitMapColorBlock theblock = (IBitMapColorBlock) block;


            Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new IBlockColor() {
                @Override
                public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {

                    if (theblock.colorabletype() == EnumColorable.GRASS) {
                        return BiomeColorHelper.getGrassColorAtPos(worldIn, pos);

                    } else if (theblock.colorabletype() == EnumColorable.LEAVES) {
                        return worldIn != null && pos != null ? BiomeColorHelper.getFoliageColorAtPos(worldIn, pos) : ColorizerFoliage.getFoliageColorBasic();
                    } else {
                        return BiomeColorHelper.getWaterColorAtPos(worldIn, pos);
                    }
                }
            }, block);
        }
    }

    private static void registerItemColorBlockHandler(Block block) {


        Minecraft.getMinecraft().getItemColors().registerItemColorHandler((stack, tintIndex) -> {
            IBlockState iblockstate = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
            return Minecraft.getMinecraft().getBlockColors().colorMultiplier(iblockstate, null, null, tintIndex);
        }, block);

    }

    private static void registerItemRenderer(Item item, int meta) {


        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(FruitsForagingAndFarming.MODID + ":" + item.getRegistryName().getResourcePath(), "inventory"));
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        EntityRenderRegistration.RegisterEntity();

    }

    @Override
    public void init(FMLInitializationEvent e) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        registerBlockColorHandler(BlockRegistration.PALM_LEAVES);
        registerItemColorBlockHandler(BlockRegistration.PALM_LEAVES);
        registerBlockColorHandler(BlockRegistration.HONEYMELON_STEM);
    }


}