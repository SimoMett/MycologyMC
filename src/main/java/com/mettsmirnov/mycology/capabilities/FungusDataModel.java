package com.mettsmirnov.mycology.capabilities;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.data.FungusSpeciesList;
import com.mettsmirnov.mycology.genetics.FungusTraits;
import com.mettsmirnov.mycology.myutils.StringDecomposition;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import org.jline.utils.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Random;

import static com.mettsmirnov.mycology.genetics.FungusTraits.traitsDictionary;
import static com.mettsmirnov.mycology.myutils.StringDecomposition.compose;
import static com.mettsmirnov.mycology.constants.Constants.DEBUG;

public class FungusDataModel implements IFungusData
{
    //data
    public static final String
        SPECIES = "species",
        SPREADING = "spreading",
        SPREAD_BOOST = "spreadboost",
        LIGHT = "light",
        TERRAIN = "terrain",
        HUMIDITY = "humidity",
        TEMP= "temp",
        AREA = "area",
        EFFECT = "effect";

    private final HashMap<String,Object> dominantTraits;
    private final HashMap<String, Object> recessiveTraits;
    private int[] colors; //TODO remove colors member.
    //colors should not be part of the genoma. The color scheme should be defined by the dominant trait of species. And so should be the type of fungus (crimson/warped).

    public FungusDataModel()
    {
        dominantTraits=new HashMap<>();
        dominantTraits.put("species","Boletus salubrium");
        dominantTraits.put("spreading", 25);
        dominantTraits.put("spreadboost", 1f);
        dominantTraits.put("light", 15);
        dominantTraits.put("terrain",MycologyMod.MODID+":grass");
        dominantTraits.put("humidity", 0);
        dominantTraits.put("temp", 0);
        dominantTraits.put("area", 1);
        dominantTraits.put("effect", "none");

        recessiveTraits = new HashMap<>(dominantTraits);

        colors = new int[]{-1,new Random().nextInt(),-1,-1};
    }

    public void loadFrom(FungusTraits dominant, FungusTraits recessive)
    {
        try
        {
            for (Field f : FungusTraits.class.getDeclaredFields())
            {
                if (!Modifier.isStatic(f.getModifiers()))
                {
                    dominantTraits.put(f.getName(), f.get(dominant));
                    recessiveTraits.put(f.getName(), f.get(recessive));
                }
            }
        }
        catch (Exception e)
        {
            Log.error("Error during fungus traits loading");
            e.printStackTrace();
        }
    }

    public void loadFrom(FungusSpeciesList.FungusSpecies species)
    {
        loadFrom(species.defaultTraits, species.defaultTraits);
    }

    public void setField(String key, GeneType type, Object val)
    {
        if (type==GeneType.DOMINANT)
            dominantTraits.replace(key, val);
        else
            recessiveTraits.replace(key, val);
    }

    @Override
    public Object getField(String key, GeneType type)
    {
        return type==GeneType.DOMINANT? dominantTraits.get(key) : recessiveTraits.get(key);
    }

    public Object getField(String key)
    {
        return dominantTraits.get(key);
    }

    public int[] getColors()
    {
        return colors;
    }

    @Override
    public void setColors(int[] colors)
    {
        this.colors = colors;
    }

    public boolean matchesEnvironment(Integer light, Float temperature, Float humidity)
    {
        return DEBUG || (light < (Integer)dominantTraits.get(LIGHT) // let's say for now that mushroom prefer sporing in darker areas
                && dominantTraits.get(TEMP).equals(temperature)
                && dominantTraits.get(HUMIDITY).equals(humidity));
    }

    public boolean matchesTerrain(BlockState terrainBlock)
    {
        String terrainTag = (String) dominantTraits.get(TERRAIN);
        if(terrainTag.charAt(0)=='#')
            return terrainBlock.is(BlockTags.create(new ResourceLocation(terrainTag.substring(1))));
        else
            return terrainBlock.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(terrainTag)));
    }

    public final boolean matchesEnvironmentAndTerrain(Integer light, Float temperature, Float humidity, BlockState terrainBlock)
    {
        return matchesEnvironment(light, temperature, humidity) && matchesTerrain(terrainBlock);
    }

    //nbt
    //this method is responsible for the creation of a NBT tag to be used when the world saves
    private static final char decompCharacter = ';'; //DON'T YOU DARE CHANGE IT AGAIN
    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag tag = new CompoundTag();
        for(String trait : traitsDictionary)
        {
            if(dominantTraits.get(trait) instanceof String)
            {
                tag.putString(trait,compose((String) dominantTraits.get(trait), (String) recessiveTraits.get(trait),decompCharacter));
            }
            else if(dominantTraits.get(trait) instanceof Integer)
            {
                tag.putIntArray(trait,new int[]{(Integer) dominantTraits.get(trait), (Integer) recessiveTraits.get(trait)});
            }
            else if(dominantTraits.get(trait) instanceof Float)
            {
                CompoundTag compositeFloat = new CompoundTag();
                compositeFloat.putFloat("dominant", (Float)dominantTraits.get(trait));
                compositeFloat.putFloat("recessive", (Float)recessiveTraits.get(trait));
                tag.put(trait,compositeFloat);
            }
        }
        return tag;
    }

    //this method is responsible for loading all the data from the NBT when the world loads
    @Override
    public void deserializeNBT(CompoundTag tag)
    {
        for(String key : traitsDictionary)
        {
            switch (tag.getTagType(key))
            {
                case Tag.TAG_STRING:
                {
                    String[] strs = StringDecomposition.decompose(tag.getString(key), decompCharacter);
                    dominantTraits.put(key, strs[0]);
                    recessiveTraits.put(key, strs[1]);
                    break;
                }
                case Tag.TAG_INT_ARRAY:
                {
                    dominantTraits.put(key, tag.getIntArray(key)[0]);
                    recessiveTraits.put(key, tag.getIntArray(key)[1]);
                    break;
                }
                case Tag.TAG_COMPOUND:
                {
                    dominantTraits.put(key, tag.getFloat("dominant"));
                    recessiveTraits.put(key, tag.getFloat("recessive"));
                    break;
                }
            }
        }
        try
        {
            colors = FungusSpeciesList.INSTANCE.get((String) dominantTraits.get(SPECIES)).colors.clone();
        }
        catch (NullPointerException e)
        {
            Log.error(e.getMessage());
            colors = new int[]{0, 0, 0xff00ff, 0xff00ff};
        }
    }
}