package com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class FruitTree extends WorldGenAbstractTree {
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** True if this tree should grow Vines. */
    private final boolean vinesGrow;
    private static final Block fruitblocks[] = {BlockRegistration.BANANA_BUNCH, BlockRegistration.ORANGE};
    /** The metadata value of the wood to use in tree generation. */


    public FruitTree(boolean notify, int minTreeHeightIn, boolean growVines)
    {
        super(notify);
        this.minTreeHeight = minTreeHeightIn;

        this.vinesGrow = growVines;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int treeHeight = rand.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        //Check if tree is placeable
        if (position.getY() >= 1 && position.getY() + treeHeight + 1 <= worldIn.getHeight())
        {
            for (int j = position.getY(); j <= position.getY() + 1 + treeHeight; ++j)
            {
                int k = 1;

                if (j == position.getY())
                {
                    k = 0;
                }

                if (j >= position.getY() + 1 + treeHeight - 2)
                {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l)
                {
                    for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < worldIn.getHeight())
                        {
                            if (!this.isReplaceable(worldIn,blockpos$mutableblockpos.setPos(l, j, i1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            } else
            {
                IBlockState state = worldIn.getBlockState(position.down());

                if (state.getBlock().canSustainPlant(state, worldIn, position.down(), net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling) Blocks.SAPLING) && position.getY() < worldIn.getHeight() - treeHeight - 1)
                {
                    state.getBlock().onPlantGrow(state, worldIn, position.down(), position);
                    int k2 = 3;
                    int l2 = 0;

                    for (int i3 = position.getY() - 3 + treeHeight; i3 <= position.getY() + treeHeight; ++i3)
                    {
                        int i4 = i3 - (position.getY() + treeHeight);
                        int j1 = 1 - i4 / 2;

                        for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1)
                        {
                            int l1 = k1 - position.getX();

                            for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2)
                            {
                                int j2 = i2 - position.getZ();

                                if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0)
                                {
                                    BlockPos blockpos = new BlockPos(k1, i3, i2);
                                    state = worldIn.getBlockState(blockpos);

                                    if (state.getBlock().isAir(state, worldIn, blockpos) || state.getBlock().isLeaves(state, worldIn, blockpos) || state.getMaterial() == Material.VINE)
                                    {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos, Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)));
                                        if (i3 == position.getY() + treeHeight) {
                                            placeFruit(worldIn, rand, blockpos.down());
                                        }
                                    }

                                }
                            }
                        }

                    }
                    for (int j3 = 0; j3 < treeHeight; ++j3)
                    {
                        BlockPos upN = position.up(j3);
                        state = worldIn.getBlockState(upN);

                        if (state.getBlock().isAir(state, worldIn, upN) || state.getBlock().isLeaves(state, worldIn, upN) || state.getMaterial() == Material.VINE)
                        {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(j3), Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE));

                            if (this.vinesGrow && j3 > 0)
                            {
                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(-1, j3, 0)))
                                {
                                    this.addVine(worldIn, position.add(-1, j3, 0), BlockVine.EAST);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(1, j3, 0)))
                                {
                                    this.addVine(worldIn, position.add(1, j3, 0), BlockVine.WEST);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(0, j3, -1)))
                                {
                                    this.addVine(worldIn, position.add(0, j3, -1), BlockVine.SOUTH);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(0, j3, 1)))
                                {
                                    this.addVine(worldIn, position.add(0, j3, 1), BlockVine.NORTH);
                                }
                            }
                        }
                    }

                    if (this.vinesGrow)
                    {
                        for (int k3 = position.getY() - 3 + treeHeight; k3 <= position.getY() + treeHeight; ++k3)
                        {
                            int j4 = k3 - (position.getY() + treeHeight);
                            int k4 = 2 - j4 / 2;
                            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

                            for (int l4 = position.getX() - k4; l4 <= position.getX() + k4; ++l4)
                            {
                                for (int i5 = position.getZ() - k4; i5 <= position.getZ() + k4; ++i5)
                                {
                                    blockpos$mutableblockpos1.setPos(l4, k3, i5);

                                    state = worldIn.getBlockState(blockpos$mutableblockpos1);
                                    if (state.getBlock().isLeaves(state, worldIn, blockpos$mutableblockpos1))
                                    {
                                        BlockPos blockpos2 = blockpos$mutableblockpos1.west();
                                        BlockPos blockpos3 = blockpos$mutableblockpos1.east();
                                        BlockPos blockpos4 = blockpos$mutableblockpos1.north();
                                        BlockPos blockpos1 = blockpos$mutableblockpos1.south();

                                        if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos2))
                                        {
                                            this.addHangingVine(worldIn, blockpos2, BlockVine.EAST);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos3))
                                        {
                                            this.addHangingVine(worldIn, blockpos3, BlockVine.WEST);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos4))
                                        {
                                            this.addHangingVine(worldIn, blockpos4, BlockVine.SOUTH);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos1))
                                        {
                                            this.addHangingVine(worldIn, blockpos1, BlockVine.NORTH);
                                        }
                                    }
                                }
                            }
                        }

                        if (rand.nextInt(5) == 0 && treeHeight > 5)
                        {
                            for (int l3 = 0; l3 < 2; ++l3)
                            {
                                for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
                                {
                                    if (rand.nextInt(4 - l3) == 0)
                                    {
                                        EnumFacing enumfacing1 = enumfacing.getOpposite();
                                    }
                                }
                            }
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private void placeFruit(World worldIn, Random rand, BlockPos pos)
    {
        System.out.println("FruitY!");

        if (MathHelper.getInt(rand, 1, 100) <= 25 && worldIn.isAirBlock(pos)) {
            worldIn.setBlockState(pos, fruitblocks[MathHelper.getInt(rand, 0, fruitblocks.length - 1)].getDefaultState());
        }


    }


    private void addVine(World worldIn, BlockPos pos, PropertyBool prop)
    {
        this.setBlockAndNotifyAdequately(worldIn, pos, Blocks.VINE.getDefaultState().withProperty(prop, Boolean.valueOf(true)));
    }

    private void addHangingVine(World worldIn, BlockPos pos, PropertyBool prop)
    {
        this.addVine(worldIn, pos, prop);
        int i = 4;

        for (BlockPos blockpos = pos.down(); worldIn.isAirBlock(blockpos) && i > 0; --i)
        {
            this.addVine(worldIn, blockpos, prop);
            blockpos = blockpos.down();
        }
    }
}
