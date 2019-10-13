package com.fffteam.fruitsforagingandfarming.common.items;

import com.fffteam.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class SeedBase extends ItemSeeds implements IModelRegisterable {

    Block crop;

    public SeedBase(String name, Block crops, Block soil) {
        super(crops, soil);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.crop=crops;
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return  EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return   crop.getDefaultState();
    }

    @Override
    public void registerItemModel() {
        String name = this.getUnlocalizedName();


        name = name.subSequence(5,name.length()).toString();


        FruitsForagingAndFarming.proxy.registerItemRenderer(this, 0, name);

    }
}
