package com.teamcitrus.fruitsforagingandfarming.common.world.generation.tree;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.world.generation.biome.BlackSandBeach;
import com.teamcitrus.fruitsforagingandfarming.common.world.generation.biome.Oasis;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeBeach;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class TreeGenerator implements IWorldGenerator {
    private final net.minecraft.world.gen.feature.WorldGenerator palmtree = new PalmTree(true);
    private final net.minecraft.world.gen.feature.WorldGenerator fruitGenerator = new FruitGenerator();
    private final CoconutGenerator coconutGenerator = new CoconutGenerator();
    private static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
        int y = world.getHeight();
        boolean foundGround = false;

        while (!foundGround && y-- >= 0) {
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            foundGround = block == topBlock;
        }

        return y;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        switch (world.provider.getDimension()) {
            case -1:

            case 1:
                break;

            case 0:

                runGenerator(palmtree, world, random, chunkX, chunkZ, 5, Blocks.SAND, Oasis.class, BiomeBeach.class);
                runGenerator(palmtree, world, random, chunkX, chunkZ, 5, BlockRegistration.BLACK_SAND, BlackSandBeach.class);

                //runGenerator(fruitGenerator,world,random,chunkX,chunkZ,1,Blocks.LEAVES,BiomeJungle.class);
       //       runGenerator(coconutGenerator, world, random, chunkX, chunkZ, 1, BlockRegistration.PALM_LEAVES, BiomeBeach.class);
                break;
        }


    }

    private void runGenerator(net.minecraft.world.gen.feature.WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) {
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

        int x = chunkX * 16 + random.nextInt(16);
        int z = chunkZ * 16 + random.nextInt(16);
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();


        if (classesList.contains(biome)) {
            int rando = random.nextInt(chance);

            if (rando == 0) {
                generator.generate(world, random, pos);
            }

        }

    }

}
