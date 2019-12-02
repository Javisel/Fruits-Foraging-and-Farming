package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree.PalmTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class PalmSapling extends BlockSaplingBase {
    public PalmSapling() {
        super("palm_sapling");
    }

    @Override
    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {

        PalmTree palmtree = new PalmTree(true);

        if (palmtree.generateSapling(worldIn, rand, pos)) {

            worldIn.setBlockState(pos, BlockRegistration.PALM_LOG.getDefaultState());
        }

    }



    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {

        return true;

    }


    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        return super.canPlaceBlockAt(worldIn,pos) ||  worldIn.getBlockState(pos.down()).getBlock() == Blocks.SAND ||  worldIn.getBlockState(pos.down()).getBlock() == BlockRegistration.BLACK_SAND;
    }
}
