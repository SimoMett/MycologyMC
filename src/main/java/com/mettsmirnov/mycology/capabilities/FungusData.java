package com.mettsmirnov.mycology.capabilities;

import com.mettsmirnov.mycology.data.FungusTraits;
import com.mettsmirnov.mycology.myutils.FloatComposition;
import com.mettsmirnov.mycology.myutils.StringDecomposition;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import org.jline.utils.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Random;

import static com.mettsmirnov.mycology.data.FungusTraits.traitsDictionary;
import static com.mettsmirnov.mycology.myutils.StringDecomposition.compose;

public class FungusData implements IFungusData
{
    //data
    private final HashMap<String,Object> dominantTraits=new HashMap<>();
    private final HashMap<String, Object> recessiveTraits=new HashMap<>();
    private int[] colors = new int[]{-1,-1,-1,-1};

    public FungusData()
    {
        for (String trait : traitsDictionary)
        {
            dominantTraits.put(trait,"none");
            recessiveTraits.put(trait,"none");
        }
        //template
        /*dataMap.put("species","dominant");
        dataMap.put("spreading", 25);
        dataMap.put("spreadboost", 1f);
        dataMap.put("light",15);
        dataMap.put("terrain","terrain");
        dataMap.put("humidity",0);
        dataMap.put("temp",0);
        dataMap.put("area",1);
        dataMap.put("effect","none");*/
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

    @Override
    public Object getField(String key, GeneType type)
    {
        return type==GeneType.DOMINANT? dominantTraits.get(key) : recessiveTraits.get(key);
    }

    public int[] getColors()
    {
        return colors;
    }

    //nbt
    //this method is responsible for the creation of a NBT tag to be used when the world saves
    //need testing
    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag tag = new CompoundTag();
        for(String trait : traitsDictionary)
        {
            if(dominantTraits.get(trait) instanceof String)
            {
                tag.putString(trait,compose((String) dominantTraits.get(trait), (String) recessiveTraits.get(trait)));
            }
            else if(dominantTraits.get(trait) instanceof Integer)
            {
                tag.putIntArray(trait,new int[]{(Integer) dominantTraits.get(trait), (Integer) recessiveTraits.get(trait)});
            }
            else if(dominantTraits.get(trait) instanceof Float)
            {
                long compositeFloat = FloatComposition.compose((Float)dominantTraits.get(trait),(Float)recessiveTraits.get(trait));
                tag.putLong(trait,compositeFloat);
            }
        }
        tag.putIntArray("color",colors);
        return tag;
    }

    //this method is responsible for loading all the data from the NBT when the world loads
    //need testing
    @Override
    public void deserializeNBT(CompoundTag tag)
    {
        for(String key : tag.getAllKeys())
        {
            if(tag.getTagType(key) == Tag.TAG_STRING)
            {
                String[] strs = StringDecomposition.decompose(tag.getString(key),':');
                dominantTraits.put(key,strs[0]);
                recessiveTraits.put(key,strs[1]);
            }
            else if(tag.getTagType(key) == Tag.TAG_INT_ARRAY)
            {
                dominantTraits.put(key,tag.getIntArray(key)[0]);
                recessiveTraits.put(key,tag.getIntArray(key)[1]);
            }
            else if(tag.getTagType(key) == Tag.TAG_LONG)
            {
                float[] floats = FloatComposition.decompose(tag.getLong(key));
                dominantTraits.put(key,floats[0]);
                recessiveTraits.put(key,floats[1]);
            }
        }
        colors[0]=tag.getIntArray("color")[0];//FIXME this throws exceptions sometimes :/
        colors[1]=tag.getIntArray("color")[1];
        colors[2]=tag.getIntArray("color")[2];
        colors[3]=tag.getIntArray("color")[3];
    }
}