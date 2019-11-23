package com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class CoconutGenerator extends WorldGenerator {
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if (worldIn.isAirBlock(position.down())) {
            worldIn.setBlockState(position.down(), BlockRegistration.COCONUT_BLOCK.withAge(1));
            return true;
        }
        return false;
    }
}
