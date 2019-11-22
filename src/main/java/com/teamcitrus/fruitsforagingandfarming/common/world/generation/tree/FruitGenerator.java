package com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class FruitGenerator extends WorldGenerator {

    private static final Block fruitblocks[] = {BlockRegistration.BANANA_BUNCH, BlockRegistration.ORANGE, BlockRegistration.MANGO};


    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {

        if (worldIn.getBlockState(position).getBlock() == Blocks.LEAVES && worldIn.isAirBlock(position.down())) {
            worldIn.setBlockState(position.down(), fruitblocks[rand.nextInt(fruitblocks.length)].getDefaultState());
            return true;
        }
        return false;
    }
}
