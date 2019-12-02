package com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class PalmTree extends WorldGenAbstractTree {
    public PalmTree(boolean notify) {
        super(notify);
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


        StrictLeaves(worldIn, top.south(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());


        StrictLeaves(worldIn, top.west(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());


        StrictLeaves(worldIn, top.east(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());

        //Diagonal
        StrictLeaves(worldIn, top.north(2).east(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(3).east(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());

        StrictLeaves(worldIn, top.north(2).west(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(3).west(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());



        StrictLeaves(worldIn, top.south(2).east(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).east(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());

        StrictLeaves(worldIn, top.south(2).west(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).west(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());

        //Bellow Crown
        StrictLeaves(worldIn, top.north().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west().down(), BlockRegistration.PALM_LEAVES.getDefaultState());

        //Bellow Crown Diagonal
        StrictLeaves(worldIn, top.north().down(2).east(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north().down(2).west(), BlockRegistration.PALM_LEAVES.getDefaultState());


        StrictLeaves(worldIn, top.south().down(2).east(), BlockRegistration.PALM_LEAVES.getDefaultState());

        StrictLeaves(worldIn, top.south().down(2).west(), BlockRegistration.PALM_LEAVES.getDefaultState());


        for (int x =-4;x <=4;x++ ) {
            for (int y = - 2;y <2; y++) {

                for (int z = -4; z<=4;z++) {
                    if (worldIn.getBlockState(top.add(x,y,z)).getBlock() == BlockRegistration.PALM_LEAVES && worldIn.isAirBlock(top.add(x,y-1,z))) {

                        if (MathHelper.getInt(random,0,100) <=10) {
                            worldIn.setBlockState(top.add(x,y-1,z),BlockRegistration.COCONUT.withAge(0));
                        }
                    }

                }
            }

        }



        return true;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {

        if (worldIn.getBlockState(position.down()).getMaterial() != Material.SAND && worldIn.getBlockState(position.down()).getMaterial() != Material.GRASS) {
            return false;
        }
        if (worldIn.getBiome(position).getTempCategory() != Biome.TempCategory.WARM) {
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


        StrictLeaves(worldIn, top.south(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());


        StrictLeaves(worldIn, top.west(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());

        StrictLeaves(worldIn, top.east(2), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east(3).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east(4).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());

        //Diagonal
        StrictLeaves(worldIn, top.north(2).east(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(3).east(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());

        StrictLeaves(worldIn, top.north(2).west(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.north(3).west(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());


        StrictLeaves(worldIn, top.south(2).east(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).east(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());

        StrictLeaves(worldIn, top.south(2).west(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south(3).west(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState());

        //Bellow Crown
        StrictLeaves(worldIn, top.north().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.east().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.south().down(), BlockRegistration.PALM_LEAVES.getDefaultState());
        StrictLeaves(worldIn, top.west().down(), BlockRegistration.PALM_LEAVES.getDefaultState());

        //Bellow Crown Diagonal
        StrictLeaves(worldIn, top.north().down(2).east(), BlockRegistration.PALM_LEAVES.getDefaultState());

        StrictLeaves(worldIn, top.north().down(2).west(), BlockRegistration.PALM_LEAVES.getDefaultState());

        StrictLeaves(worldIn, top.south().down(2).east(), BlockRegistration.PALM_LEAVES.getDefaultState());

        StrictLeaves(worldIn, top.south().down(2).west(), BlockRegistration.PALM_LEAVES.getDefaultState());


        for (int x =-4;x <=4;x++ ) {
            for (int y = - 4;y <2; y++) {

                for (int z = -4; z<=4;z++) {
                    if (worldIn.getBlockState(top.add(x,y,z)).getBlock() == BlockRegistration.PALM_LEAVES && worldIn.isAirBlock(top.add(x,y-1,z))) {

                        if (MathHelper.getInt(rand,0,100) <=10) {
                            worldIn.setBlockState(top.add(x,y-1,z),BlockRegistration.COCONUT.withAge(MathHelper.getInt(rand,0,4)),1);
                        }
                    }

                }
            }

        }



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