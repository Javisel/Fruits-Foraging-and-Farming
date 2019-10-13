package com.fffteam.fruitsforagingandfarming.common.blocks;

import com.fffteam.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.fffteam.fruitsforagingandfarming.common.registration.ItemRegistration;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class BlockCorn extends  CropBase implements IPlantable {


    public BlockCorn() {
        super("corn_crop",ItemRegistration.seedFoodCorn,ItemRegistration.seedFoodCorn);

    }


}
