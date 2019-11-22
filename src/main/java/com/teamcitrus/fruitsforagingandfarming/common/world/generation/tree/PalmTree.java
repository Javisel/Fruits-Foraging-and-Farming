package com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class PalmTree extends WorldGenAbstractTree {
    public PalmTree(boolean notify) {
        super(notify);
    }

    public static boolean makeCoconut(Random random, World world, BlockPos pos) {

        if (world.getBlockState(pos.up()).getBlock() == BlockRegistration.PALM_LEAVES && world.isAirBlock(pos.down()) && MathHelper.getInt(random, 1, 100) <= 25) {


            world.setBlockState(pos, BlockRegistration.COCONUT_BLOCK.getStateFromMeta(1));
            return true;
        }

        return false;
    }

    public boolean generateSapling(World worldIn, Random random, BlockPos pos) {

        if (worldIn.getBlockState(pos.down()).getMaterial() != Material.SAND && worldIn.getBlockState(pos.down()).getMaterial() != Material.GRASS) {
            return false;
        }
        for (int i = 1; i < 7; i++) {

            if (i <= 6) {

                if (!isReplaceable(worldIn, pos.up(i))) {

                    return false;
                }
                worldIn.setBlockState(pos.up(i), BlockRegistration.PALM_LOG.getDefaultState());
            } else if (i == 7) {
                if (!isReplaceable(worldIn, pos.up(i))) {

                    return false;
                }
                worldIn.setBlockState(pos.up(i), BlockRegistration.PALM_LEAVES.getDefaultState());
            }
        }
        BlockPos top = pos.up(7);
        for (int x1 = -1; x1 < 2; x1++) {

            for (int y1 = -1; y1 < 2; y1++) {

                StrictLeaves(worldIn, top.add(x1, 0, y1), BlockRegistration.PALM_LEAVES.getDefaultState());


            }

        }

        //Crown extentions


        StrictLeaves(worldIn, top.north(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(random, worldIn, top.north(3).down(2));

        makeCoconut(random, worldIn, top.north(4).down(3));

        StrictLeaves(worldIn, top.south(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(random, worldIn, top.south(3).down(2));

        makeCoconut(random, worldIn, top.south(4).down(3));

        StrictLeaves(worldIn, top.west(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(random, worldIn, top.south(3).down(2));
        makeCoconut(random, worldIn, top.west(4).down(3));

        StrictLeaves(worldIn, top.east(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(random, worldIn, top.east(3).down(2));
        makeCoconut(random, worldIn, top.east(4).down(3));
        //Diagonal
        StrictLeaves(worldIn, top.north(2).east(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(3).east(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(random, worldIn, top.north(3).east(3).down(2));
        makeCoconut(random, worldIn, top.north(3).east(3).down(3));

        StrictLeaves(worldIn, top.north(2).west(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(3).west(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(random, worldIn, top.north(3).east(3).down(3));
        makeCoconut(random, worldIn, top.north(3).east(3).down(4));

        StrictLeaves(worldIn, top.south(2).east(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).east(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(random, worldIn, top.south(2).east(2).down());
        makeCoconut(random, worldIn, top.south(3).east(3).down(3));
        StrictLeaves(worldIn, top.south(2).west(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).west(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());

        //Bellow Crown
        StrictLeaves(worldIn, top.north().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west().down(), BlockRegistration.PALM_LEAVES.getDefaultState());

        //Bellow Crown Diagonal
        StrictLeaves(worldIn, top.north().down(2).east(), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(random, worldIn, top.north().down(3).east());
        StrictLeaves(worldIn, top.north().down(2).west(), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(random, worldIn, top.north().down(3).west());

        StrictLeaves(worldIn, top.south().down(2).east(), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(random, worldIn, top.south().down(3).east());

        StrictLeaves(worldIn, top.south().down(2).west(), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(random, worldIn, top.south().down(3).west());


        return true;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if (worldIn.getBlockState(position.down()).getMaterial() != Material.SAND && worldIn.getBlockState(position.down()).getMaterial() != Material.GRASS) {
            return false;
        }
        for (int i = 1; i < 7; i++) {

            if (i <= 6) {

                if (!isReplaceable(worldIn, position.up(i))) {

                    return false;
                }
                worldIn.setBlockState(position.up(i), BlockRegistration.PALM_LOG.getDefaultState());
            } else if (i == 7) {
                if (!isReplaceable(worldIn, position.up(i))) {

                    return false;
                }
                worldIn.setBlockState(position.up(i), BlockRegistration.PALM_LEAVES.getDefaultState());
            }
        }
        BlockPos top = position.up(7);
        for (int x1 = -1; x1 < 2; x1++) {

            for (int y1 = -1; y1 < 2; y1++) {

                StrictLeaves(worldIn, top.add(x1, 0, y1), BlockRegistration.PALM_LEAVES.getDefaultState());


            }

        }

        //Crown extentions


        StrictLeaves(worldIn, top.north(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(rand, worldIn, top.north(3).down(2));

        makeCoconut(rand, worldIn, top.north(4).down(3));

        StrictLeaves(worldIn, top.south(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(rand, worldIn, top.south(3).down(2));

        makeCoconut(rand, worldIn, top.south(4).down(3));

        StrictLeaves(worldIn, top.west(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(rand, worldIn, top.south(3).down(2));
        makeCoconut(rand, worldIn, top.west(4).down(3));

        StrictLeaves(worldIn, top.east(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(rand, worldIn, top.east(3).down(2));
        makeCoconut(rand, worldIn, top.east(4).down(3));
        //Diagonal
        StrictLeaves(worldIn, top.north(2).east(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(3).east(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(rand, worldIn, top.north(3).east(3).down(2));
        makeCoconut(rand, worldIn, top.north(3).east(3).down(3));

        StrictLeaves(worldIn, top.north(2).west(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(3).west(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(rand, worldIn, top.north(3).east(3).down(3));
        makeCoconut(rand, worldIn, top.north(3).east(3).down(4));

        StrictLeaves(worldIn, top.south(2).east(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).east(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(rand, worldIn, top.south(2).east(2).down());
        makeCoconut(rand, worldIn, top.south(3).east(3).down(3));
        StrictLeaves(worldIn, top.south(2).west(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).west(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());

        //Bellow Crown
        StrictLeaves(worldIn, top.north().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west().down(), BlockRegistration.PALM_LEAVES.getDefaultState());

        //Bellow Crown Diagonal
        StrictLeaves(worldIn, top.north().down(2).east(), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(rand, worldIn, top.north().down(3).east());
        StrictLeaves(worldIn, top.north().down(2).west(), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(rand, worldIn, top.north().down(3).west());

        StrictLeaves(worldIn, top.south().down(2).east(), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(rand, worldIn, top.south().down(3).east());

        StrictLeaves(worldIn, top.south().down(2).west(), BlockRegistration.PALM_LEAVES.getDefaultState());
        makeCoconut(rand, worldIn, top.south().down(3).west());


        return true;
    }

    public boolean StrictLeaves(World world, BlockPos pos, IBlockState state) {


        if (isReplaceable(world, pos)) {
            world.setBlockState(pos, state);


            return true;
        }


        return false;
    }
}