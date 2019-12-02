package com.teamcitrus.fruitsforagingandfarming.common.world.generation.biome;

import com.teamcitrus.fruitsforagingandfarming.common.entities.EntityCoconutCrab;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeBeach;

public class BlackSandBeach extends BiomeBeach {

   static BiomeProperties properties = new BiomeProperties("black_sand_beach");

    static {
        properties.setBaseBiome("desert");
        properties.setBaseHeight(0.0F).setHeightVariation(0.025F).setTemperature(0.95F).setRainfall(0.4F);

    }

    public BlackSandBeach() {
        super(properties);

        this.topBlock = BlockRegistration.BLACK_SAND.getDefaultState();
        this.fillerBlock = BlockRegistration.BLACK_SAND.getDefaultState();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCoconutCrab.class,5,1,3));

    }
}
