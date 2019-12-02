package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.common.world.generation.biome.BlackSandBeach;
import com.teamcitrus.fruitsforagingandfarming.common.world.generation.biome.Oasis;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FruitsForagingAndFarming.MODID)

@GameRegistry.ObjectHolder(FruitsForagingAndFarming.MODID)
public class BiomeRegistration {

    public static final BlackSandBeach BLACK_SAND_BEACH = null;
    public static final Oasis OASIS = null;
    @SubscribeEvent
    public static final void RegisterBiomeEvent(@Nonnull final RegistryEvent.Register<Biome> event) {
        registerBiome(new BlackSandBeach(),"black_sand_beach", 50,true, BiomeManager.BiomeType.WARM,  BiomeDictionary.Type.BEACH);
      //  registerBiome(new Oasis(),"oasis",20,true, BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.HOT);


    }

  private static void  registerBiome(Biome biome,String name, int weight, boolean isspawnbiome, BiomeManager.BiomeType biomeType, BiomeDictionary.Type... types) {




      biome.setRegistryName(name);
      ForgeRegistries.BIOMES.register(biome);
     BiomeDictionary.addTypes(biome, types);
     BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weight));


      if (isspawnbiome){}
       BiomeManager.addSpawnBiome(biome);

    }


}
