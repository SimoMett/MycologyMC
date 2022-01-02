package com.mettsmirnov.mycology.capabilities;

import com.mettsmirnov.mycology.myutils.StringDecomposition;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.animal.Panda;
import oshi.util.tuples.Pair;

import java.util.HashMap;
import java.util.Random;

public class FungusData implements IFungusData
{
    String[] dictionary = new String[]{
            "species",
            "color",
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
    private final HashMap<Pair<String, GeneType>,Object> dataMap=new HashMap<>();
    private int[] colors = new int[]{new Random().nextInt(),new Random().nextInt(),new Random().nextInt(),new Random().nextInt()};

    public FungusData()
    {
        for (String s : dictionary)
        {
            dataMap.put(new Pair<>(s,GeneType.DOMINANT),"");
        }

        /*dataMap.put("species","dominant:recessive");
        dataMap.put("spreading", new Integer[]{25, 25});
        dataMap.put("spreadboost", new Float[]{1f,1f});
        dataMap.put("light",new Integer[]{15,15});
        dataMap.put("terrain",":");
        dataMap.put("humidity",":");
        dataMap.put("temp",":");
        dataMap.put("area",new int[]{1,1});
        dataMap.put("effect",":");*/
    }

    @Override
    public Object getField(String key, GeneType type)
    {
        if(!dataMap.containsKey(key))
        {

        }
        return null;
    }

    //nbt
    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag tag = new CompoundTag();
        tag.putString("species","dominant:recessive");
        tag.putIntArray("color",colors);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt)
    {
        colors=nbt.getIntArray("color");
    }


}