package com.teamcitrus.fruitsforagingandfarming.common.blocks.fruits;

import com.teamcitrus.fruitsforagingandfarming.common.blocks.BlockFruit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BananaBunch extends BlockFruit {
    public BananaBunch() {
        super("banana_bunch");
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

        drops.add(new ItemStack(Item.getItemFromBlock(this)));
    }
}
