package com.simomett.mycologymod.genetics;

import com.mojang.blaze3d.vertex.ByteBufferBuilder;
import com.simomett.mycologymod.data.FungusSpeciesList;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockState;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

import static com.simomett.mycologymod.config.ModCommonConfigs.IGNORE_AMBIENT_CONDITIONS;
import static com.simomett.mycologymod.genetics.FungusTraits.traitsDictionary;


public class FungusGenoma implements Serializable
{
    public static FungusGenoma FungusGenomaFromByteBuf(ByteBuf byteBuf)
    {
        //FIXME 'Client disconnected with reason: Internal Exception: io.netty.handler.codec.DecoderException: Failed to decode packet 'clientbound/minecraft:container_set_content''
        //great...
        try
        {
            byte [] dst = new byte[byteBuf.readableBytes()];
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

    public void encode(ByteBuf byteBuf)
    {
        try
        {
            byteBuf.writeBytes(serialize());
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

    private FungusGenoma()
    {
        dominantTraits = new FungusTraits(FungusTraits.EMPTY);
        recessiveTraits = new FungusTraits(FungusTraits.EMPTY);
    }

    public FungusGenoma normalCrossbreedWith(FungusGenoma that)
    {
        FungusGenoma offspring = new FungusGenoma();
        Random random = new Random();
        for(String trait : traitsDictionary)
        {
            String o = random.nextBoolean() ? this.getField(trait) : this.getField(trait, FungusGenoma.GeneType.RECESSIVE);
            offspring.setField(trait, FungusGenoma.GeneType.DOMINANT, o);
            String p = random.nextBoolean() ? that.getField(trait) : that.getField(trait, FungusGenoma.GeneType.RECESSIVE);
            offspring.setField(trait, FungusGenoma.GeneType.RECESSIVE, p);
        }
        return offspring;
    }

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
            return terrainBlock.is(BuiltInRegistries.BLOCK.get(ResourceLocation.parse(terrainTag)));
    }

    public final boolean matchesEnvironmentAndTerrain(Integer light, Float temperature, Float humidity, BlockState terrainBlock)
    {
        return matchesEnvironment(light, temperature, humidity) && matchesTerrain(terrainBlock);
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