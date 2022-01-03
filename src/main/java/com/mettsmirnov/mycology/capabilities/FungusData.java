package com.mettsmirnov.mycology.capabilities;

import net.minecraft.nbt.CompoundTag;

import java.util.HashMap;
import java.util.Random;

public class FungusData implements IFungusData
{
    private static final String[] traitsDictionary = new String[]{
            "species",
            "spreading",
            "spreadboost",
            "light",
            "terrain",
            "humidity",
            "temp",
            "area",
            "effect"
    };

    //data
    private final HashMap<String,Object> dominantTraits=new HashMap<>();
    private final HashMap<String, Object> recessiveTraits=new HashMap<>();
    private int[] colors = new int[]{new Random().nextInt(),new Random().nextInt(),new Random().nextInt(),new Random().nextInt()};

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
        dataMap.put("temp","temp");
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