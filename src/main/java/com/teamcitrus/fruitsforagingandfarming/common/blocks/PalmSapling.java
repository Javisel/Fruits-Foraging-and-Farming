package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
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

        for (int i = 0; i < 7; i++) {

            if (i <= 6) {
                worldIn.setBlockState(pos.up(i), BlockRegistration.palm_log.getDefaultState());
            } else if (i == 7) {
                worldIn.setBlockState(pos.up(i), BlockRegistration.palm_leaves.getDefaultState());
            }
        }
        BlockPos top = pos.up(7);
        for (int x1 = -1; x1 < 2; x1++) {

            for (int y1 = -1; y1 < 2; y1++) {

                worldIn.setBlockState(top.add(x1, 0, y1), BlockRegistration.palm_leaves.getDefaultState());


            }

        }

        //Crown extentions
        worldIn.setBlockState(top.north(2), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.north(3).down(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.north(4).down(2), BlockRegistration.palm_leaves.getDefaultState());


        worldIn.setBlockState(top.south(2), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.south(3).down(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.south(4).down(2), BlockRegistration.palm_leaves.getDefaultState());

        worldIn.setBlockState(top.west(2), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.west(3).down(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.west(4).down(2), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.east(2), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.east(3).down(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.east(4).down(2), BlockRegistration.palm_leaves.getDefaultState());
        //Diagonal
        worldIn.setBlockState(top.north(2).east(2).down(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.north(3).east(3).down(2), BlockRegistration.palm_leaves.getDefaultState());


        worldIn.setBlockState(top.north(2).west(2).down(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.north(3).west(3).down(2), BlockRegistration.palm_leaves.getDefaultState());

        worldIn.setBlockState(top.south(2).east(2).down(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.south(3).east(3).down(2), BlockRegistration.palm_leaves.getDefaultState());

        worldIn.setBlockState(top.south(2).west(2).down(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.south(3).west(3).down(2), BlockRegistration.palm_leaves.getDefaultState());

        //Bellow Crown
        worldIn.setBlockState(top.north().down(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.east().down(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.south().down(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.west().down(), BlockRegistration.palm_leaves.getDefaultState());

        //Bellow Crown Diagonal
        worldIn.setBlockState(top.north().down(2).east(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.north().down(2).west(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.south().down(2).east(), BlockRegistration.palm_leaves.getDefaultState());
        worldIn.setBlockState(top.south().down(2).west(), BlockRegistration.palm_leaves.getDefaultState());


    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {

        for (int i = 1; i < 7; i++) {

            if (!worldIn.isAirBlock(pos.up(i))) {
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        return super.canPlaceBlockAt(worldIn, pos) || worldIn.getBlockState(pos.down()).getBlock() == Blocks.SAND;
    }
}
