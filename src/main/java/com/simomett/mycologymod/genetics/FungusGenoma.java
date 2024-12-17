package com.simomett.mycologymod.genetics;

import com.simomett.mycologymod.data.FungusSpeciesList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockState;

import java.io.*;
import java.util.*;

import static com.simomett.mycologymod.config.ModCommonConfigs.IGNORE_AMBIENT_CONDITIONS;
import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA_CODEC;
import static com.simomett.mycologymod.genetics.FungusTraits.traitsDictionary;

public class FungusGenoma implements Serializable
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

    public FungusGenoma(FungusTraits dominant, FungusTraits recessive)
    {
        dominantTraits = new FungusTraits(dominant);
        recessiveTraits = new FungusTraits(recessive);
    }

    public FungusGenoma(FungusSpeciesList.FungusSpecies species)
    {
        this(species.defaultTraits, species.defaultTraits);
    }

    public FungusGenoma(CompoundTag genomaTag)
    {
        FungusGenoma g = FUNGUS_GENOMA_CODEC.parse(NbtOps.INSTANCE, genomaTag).getOrThrow();
        dominantTraits = g.dominantTraits;
        recessiveTraits = g.recessiveTraits;
    }

    private FungusGenoma()
    {
        dominantTraits = new FungusTraits(FungusTraits.UNINIT);
        recessiveTraits = new FungusTraits(dominantTraits);
    }

    public static FungusGenoma fromByteBuf(FriendlyByteBuf byteBuf)
    {
        try
        {
            byte [] dst = new byte[byteBuf.readInt()];
            byteBuf.readBytes(dst);
            ByteArrayInputStream i = new ByteArrayInputStream(dst);
            ObjectInputStream inputStream = new ObjectInputStream(i);
            FungusGenoma genoma = (FungusGenoma) inputStream.readObject();
            return new FungusGenoma(genoma.getDominantTraits(), genoma.getRecessiveTraits()); //I've got the genoma correctly though...
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void encode(FriendlyByteBuf byteBuf)
    {
        try
        {
            byte [] serialized = serialize();
            byteBuf.writeInt(serialized.length);
            byteBuf.writeBytes(serialized);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    protected byte[] serialize() throws IOException
    {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(this);
        return b.toByteArray();
    }

    public FungusTraits getDominantTraits()
    {
        return dominantTraits;
    }

    public FungusTraits getRecessiveTraits()
    {
        return recessiveTraits;
    }

    @Deprecated(forRemoval = true)
    public String getField(String key)
    {
        return dominantTraits.get(key).orElseThrow();
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
        String terrainTag = dominantTraits.terrain();
        if(terrainTag.charAt(0)=='#')
            return terrainBlock.is(BlockTags.create(ResourceLocation.parse(terrainTag.substring(1))));
        else
            return terrainBlock.is(BuiltInRegistries.BLOCK.get(ResourceLocation.parse(terrainTag)).get());
    }

    public final boolean matchesEnvironmentAndTerrain(Integer light, Float temperature, Float humidity, BlockState terrainBlock)
    {
        return matchesEnvironment(light, temperature, humidity) && matchesTerrain(terrainBlock);
    }

    public FungusGenoma normalCrossbreedWith(FungusGenoma that)
    {
        //FIXME better implementation to consider optional fields (eg. eating effect)
        FungusGenoma offspring = new FungusGenoma();
        Random random = new Random();
        for(String trait : traitsDictionary)
        {
            String o = random.nextBoolean() ? this.getDominantTraits().get(trait).orElse(null) : this.getRecessiveTraits().get(trait).orElse(null);
            offspring.getDominantTraits().replace(trait, o);
            String p = random.nextBoolean() ? that.getDominantTraits().get(trait).orElse(null) : that.getRecessiveTraits().get(trait).orElse(null);
            offspring.getRecessiveTraits().replace(trait, p);
        }
        return offspring;
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof FungusGenoma that)) return false;
        return Objects.equals(dominantTraits, that.dominantTraits) && Objects.equals(recessiveTraits, that.recessiveTraits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dominantTraits, recessiveTraits);
    }
}