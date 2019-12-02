package com.teamcitrus.fruitsforagingandfarming.main;
import net.minecraftforge.common.config.*;

@net.minecraftforge.common.config.Config(modid = FruitsForagingAndFarming.MODID,name = "fruits_foraging_and_farming",type = net.minecraftforge.common.config.Config.Type.INSTANCE)
public class ConfigHandler {


    public static WorldGeneration worldGeneration = new WorldGeneration();
    public static FoodConfiguration AVOCADO = new FoodConfiguration();
    public static FoodConfiguration BANANA = new FoodConfiguration();
    public static FoodConfiguration BLUEBERRY = new FoodConfiguration();
    public static FoodConfiguration COCONUT = new FoodConfiguration();
    public static FoodConfiguration CHOCOLATE_MILK_BUCKET = new FoodConfiguration();
    public static FoodConfiguration CHOCOLATE_MILK_BOTTLE = new FoodConfiguration();
    public static FoodConfiguration CHOCOLATE_CAKE = new FoodConfiguration();
    public static FoodConfiguration CORN = new FoodConfiguration();
    public static FoodConfiguration DURIAN = new FoodConfiguration();
    public static FoodConfiguration HONEYMELON_SLICE = new FoodConfiguration();
    public static FoodConfiguration INFESTED_EGGS = new FoodConfiguration();
    public static FoodConfiguration KIWI = new FoodConfiguration();
    public static FoodConfiguration KIWANO = new FoodConfiguration();
    public static FoodConfiguration LIME = new FoodConfiguration();
    public static FoodConfiguration LEMON = new FoodConfiguration();
    public static FoodConfiguration MANGO = new FoodConfiguration();
    public static FoodConfiguration ORANGE = new FoodConfiguration();
    public static FoodConfiguration PEAR = new FoodConfiguration();
    public static FoodConfiguration PINEAPPLE = new FoodConfiguration();
    public static FoodConfiguration PLUM = new FoodConfiguration();
    public static FoodConfiguration TURNIP = new FoodConfiguration();



    static  {
        AVOCADO.shanks=3;
        AVOCADO.saturation=0.6F;
        BANANA.shanks=2;
        BANANA.saturation=0.21F;
        BLUEBERRY.shanks=1;
        BLUEBERRY.saturation=0.125F;
        COCONUT.shanks=3;
        COCONUT.saturation=0.3F;
        CORN.shanks=3;
        CORN.saturation=0.25F;
        CHOCOLATE_MILK_BOTTLE.shanks=1;
        CHOCOLATE_MILK_BOTTLE.saturation=0.2F;
        CHOCOLATE_MILK_BUCKET.shanks=1;
        CHOCOLATE_MILK_BUCKET.saturation=0.2F;
        CHOCOLATE_CAKE.shanks=2;
        CHOCOLATE_CAKE.saturation=0.3F;
        DURIAN.shanks=4;
        DURIAN.saturation=0.25F;
        HONEYMELON_SLICE.shanks=4;
        HONEYMELON_SLICE.saturation=0.25F;
        INFESTED_EGGS.shanks=1;
        INFESTED_EGGS.saturation=0.25F;
        KIWI.shanks=2;
        KIWI.saturation=0.4F;
        KIWANO.shanks=3;
        KIWANO.saturation=0.5F;
        LEMON.shanks=2;
        LEMON.saturation=0.3F;
        LIME.shanks=2;
        LIME.saturation=0.35F;
        MANGO.shanks=3;
        MANGO.saturation=0.4F;
        ORANGE.shanks=1;
        ORANGE.saturation=0.5F;
        PEAR.shanks=3;
        PEAR.saturation=0.5F;
        PINEAPPLE.shanks=3;
        PINEAPPLE.saturation=0.5F;
        PLUM.shanks=1;
        PLUM.saturation=0.5f;
        TURNIP.shanks=1;
        TURNIP.saturation=0.5f;


    }


    public static class WorldGeneration {


        public  boolean EnableWorldGeneration = true;



    }




    public static class FoodConfiguration {




        @net.minecraftforge.common.config.Config.RangeInt(min= -20,max = 20)


        @net.minecraftforge.common.config.Config.Comment("How many visible hunger points this food restores.  ")
        public int shanks=0;
        @net.minecraftforge.common.config.Config.Comment("Points that keep hunger at bay")
        @Config.RangeDouble(min=-20, max = 20)
        public double saturation = 0;

        public float getSaturation() {

            return (float) saturation;
        }

    }



}
