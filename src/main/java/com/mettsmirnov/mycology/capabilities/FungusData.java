package com.mettsmirnov.mycology.capabilities;

import com.mettsmirnov.mycology.data.FungusTraits;
import net.minecraft.nbt.CompoundTag;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Random;

import static com.mettsmirnov.mycology.data.FungusTraits.traitsDictionary;

public class FungusData implements IFungusData
{
    //data
    private final HashMap<String,Object> dominantTraits=new HashMap<>();
    private final HashMap<String, Object> recessiveTraits=new HashMap<>();
    private int[] colors = new int[]{new Random().nextInt(),new Random().nextInt(),new Random().nextInt(),new Random().nextInt()};

    public FungusData(FungusTraits dominant, FungusTraits recessive) throws IllegalAccessException
    {
        for(Field f : FungusTraits.class.getDeclaredFields())
        {
            if (!Modifier.isStatic(f.getModifiers()))
            {
                dominantTraits.put(f.getName(),f.get(dominant));
                recessiveTraits.put(f.getName(),f.get(recessive));
            }
        }
    }

    @Deprecated
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
        dataMap.put("humidity","humidity");
        dataMap.put("temp",0);
        dataMap.put("area",1);
        dataMap.put("effect","none");*/
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
    //TODO
    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag tag = new CompoundTag();
        tag.putString("species",compose((String) dominantTraits.get("species"), (String) recessiveTraits.get("species")));
        tag.putIntArray("color",colors);
        return tag;
    }

    //TODO
    @Override
    public void deserializeNBT(CompoundTag nbt)
    {
        colors=nbt.getIntArray("color");
    }

    private static String compose(String str1, String str2)
    {
        String result=str1+":"+str2;
        return result;
    }

}