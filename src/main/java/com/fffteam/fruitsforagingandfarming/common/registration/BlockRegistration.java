package com.fffteam.fruitsforagingandfarming.common.registration;

import com.fffteam.fruitsforagingandfarming.common.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.advancements.critereon.OredictItemPredicate;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockRegistration {

    public static final CropBase blockCorn = new BlockCorn();
    public static final CropBase cropTurnip = new CropBase("turnip_crop",ItemRegistration.turnipSeeds,ItemRegistration.foodTurnip);
    public static final CakeBase chocolateCake = new CakeBase("chocolate_cake",2,0.3F);
    public static final OreBase rubyOre = new OreBase("ruby_ore",ItemRegistration.ruby,3,5);
    public static final BlockBase rubyBlock = new BlockBase(Material.IRON,"ruby_block",5.0F,10.0F, SoundType.METAL);
    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
        blockCorn,
                cropTurnip,
                chocolateCake,
                rubyOre,
                rubyBlock

        );
    }
    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                blockCorn.createItemBlock(),
                cropTurnip.createItemBlock(),
                chocolateCake.createItemBlock(),
                rubyOre.createItemBlock(),
                rubyBlock.createItemBlock()
        );
    }
    public static void registerModels() {
        blockCorn.registerItemModel(Item.getItemFromBlock(blockCorn));
        cropTurnip.registerItemModel(Item.getItemFromBlock(cropTurnip));
        chocolateCake.registerItemModel(Item.getItemFromBlock(chocolateCake));
        rubyOre.registerItemModel(Item.getItemFromBlock(rubyOre));
        rubyBlock.registerItemModel(Item.getItemFromBlock(rubyBlock));
    }
    public static void registerOre() {
        OreDictionary.registerOre("oreRuby",rubyOre);

    }
}

