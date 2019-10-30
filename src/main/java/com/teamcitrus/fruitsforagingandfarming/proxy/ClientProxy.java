package com.teamcitrus.fruitsforagingandfarming.proxy;

import com.teamcitrus.fruitsforagingandfarming.client.render.EntityRenderRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.blocks.EnumColorable;
import com.teamcitrus.fruitsforagingandfarming.common.blocks.IBitMapColorBlock;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.ForgeRegistry;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        EntityRenderRegistration.RegisterEntity();

    }

    @Override
    public void init(FMLInitializationEvent e) {
     //   registerBlockColorHandler(BlockRegistration.palm_leaves);
       // registerItemColorBlockHandler(BlockRegistration.palm_leaves);
    }

    @SubscribeEvent
    public void RegisterBlockModel(ModelRegistryEvent e) {


    }


    @Override
    public void postInit(FMLPostInitializationEvent e) {


    }

    private void registerBlockColorHandler(Block block) {
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

    private void registerItemColorBlockHandler(Block block) {


        Minecraft.getMinecraft().getItemColors().registerItemColorHandler((stack, tintIndex) -> {
            IBlockState iblockstate = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
            return Minecraft.getMinecraft().getBlockColors().colorMultiplier(iblockstate, (IBlockAccess) null, (BlockPos) null, tintIndex);
        }, block);

    }


    @Override
    public void registerItemRenderer(Item item, int meta, String id) {


        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(FruitsForagingAndFarming.MODID + ":" + item.getRegistryName().getResourcePath(), "inventory"));
    }


}