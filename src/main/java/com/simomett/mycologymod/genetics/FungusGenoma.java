package com.simomett.mycologymod.genetics;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.data.FungusSpeciesList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import static com.simomett.mycologymod.config.ModCommonConfigs.IGNORE_AMBIENT_CONDITIONS;


public class FungusGenoma
{
    public enum GeneType
    {
        DOMINANT,
        RECESSIVE
    }

    public static final String
            SPECIES = "species",
            SPREADING = "spreading",
            SPREAD_BOOST = "spreadboost",
            LIGHT = "light",
            TERRAIN = "terrain",
            HUMIDITY = "humidity",
            TEMP= "temp",
            AREA = "area",
            EFFECT = "effect",
            EATING_EFFECT = "eat_effect";

    private final FungusTraits dominantTraits;
    private final FungusTraits recessiveTraits;
    private int[] colors; //TODO remove colors member.
    //colors should not be part of the genoma. The color scheme should be defined by the dominant trait of species. And so should be the type of fungus (crimson/warped).

    @Deprecated(forRemoval = true)
    public FungusGenoma()
    {
        //default traits
        dominantTraits=new FungusTraits("Fungus impossibilis", 25, 1f, 15, MycologyMod.MODID+":grass", 0, 0, 1, "none", Optional.empty());
        recessiveTraits = new FungusTraits(dominantTraits);

        colors = new int[]{-1,new Random().nextInt(),-1,-1};
    }

    public FungusGenoma(FungusTraits dominant, FungusTraits recessive)
    {
        dominantTraits = new FungusTraits(dominant);
        recessiveTraits = new FungusTraits(recessive);
    }

    public FungusGenoma(FungusSpeciesList.FungusSpecies species)
    {
        this(species.defaultTraits, species.defaultTraits);
    }

    public FungusTraits getDominantTraits()
    {
        return dominantTraits;
    }

    public FungusTraits getRecessiveTraits()
    {
        return recessiveTraits;
    }

    public void setField(String trait, GeneType type, String val)
    {
        if (type==GeneType.DOMINANT)
            dominantTraits.replace(trait, val);
        else
            recessiveTraits.replace(trait, val);
    }

    public String getField(String trait, GeneType type)
    {
        return type==GeneType.DOMINANT? dominantTraits.get(trait) : recessiveTraits.get(trait);
    }

    public String getField(String key)
    {
        return dominantTraits.get(key);
    }

    public int[] getColors()
    {
        return colors;
    }

    public void setColors(int[] colors)
    {
        this.colors = colors;
    }

    public boolean matchesEnvironment(Integer light, Float temperature, Float humidity)
    {
        boolean matchesEnv = light < dominantTraits.light() // let's say for now that mushroom prefer sporing in darker areas
                && dominantTraits.temp().equals(temperature)
                && dominantTraits.humidity().equals(humidity);

        return IGNORE_AMBIENT_CONDITIONS.get() || matchesEnv;
    }

    public boolean matchesTerrain(BlockState terrainBlock)
    {
        String terrainTag = (String) dominantTraits.get(TERRAIN);
        if(terrainTag.charAt(0)=='#')
            return terrainBlock.is(BlockTags.create(ResourceLocation.parse(terrainTag.substring(1))));
        else
            return terrainBlock.is(BuiltInRegistries.BLOCK.get(ResourceLocation.parse(terrainTag)));
    }

    public final boolean matchesEnvironmentAndTerrain(Integer light, Float temperature, Float humidity, BlockState terrainBlock)
    {
        return matchesEnvironment(light, temperature, humidity) && matchesTerrain(terrainBlock);
    }

    /*public void encode(ByteBuf buff)
    {

    }*/

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FungusGenoma that)) return false;
        return Objects.equals(dominantTraits, that.dominantTraits) && Objects.equals(recessiveTraits, that.recessiveTraits) && Objects.deepEquals(colors, that.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dominantTraits, recessiveTraits, Arrays.hashCode(colors));
    }
}