package com.mettsmirnov.mycology.capabilities;

import com.mettsmirnov.mycology.myutils.StringDecomposition;
import net.minecraft.nbt.CompoundTag;

import java.util.HashMap;
import java.util.Random;

public class FungusData implements IFungusData
{
    //data
    private final HashMap<String,Object> dataMap=new HashMap<>();
    private int[] colors = new int[]{new Random().nextInt(),new Random().nextInt(),new Random().nextInt(),new Random().nextInt()};

    public FungusData()
    {
        dataMap.put("species","dominant:recessive");
        dataMap.put("spreading", new Integer[]{25, 25});
        dataMap.put("spreadboost", new Float[]{1f,1f});
        dataMap.put("light",new Integer[]{15,15});
        dataMap.put("terrain",":");
        dataMap.put("humidity",":");
        dataMap.put("temp",":");
        dataMap.put("area",new int[]{1,1});
        dataMap.put("effect",":");
    }

    //
    @Override
    public int[] getColors() {
        return colors;
    }

    /*enum GeneType
    {
        DOMINANT,
        RECESSIVE
    }*/

    //dominant genes
    @Override
    public String getDominantSpecies()
    {
        return StringDecomposition.decompose(dataMap.get("species").toString(),':')[0];
    }

    @Override
    public int getDominantSpreadingChance()
    {
        return ((Integer[]) dataMap.get("spread"))[0];
    }

    @Override
    public float getDominantRainSpreadingBoost()
    {
        return ((Float[]) dataMap.get("spreadboost"))[0];
    }

    @Override
    public int getDominantLightRequirements()
    {
        return ((Integer[]) dataMap.get("light"))[0];
    }

    @Override
    public String getDominantTerrainRequirement()
    {
        return StringDecomposition.decompose(dataMap.get("terrain").toString(),':')[0];
    }

    @Override
    public String getDominantHumidityRequirements()
    {
        return StringDecomposition.decompose(dataMap.get("humidity").toString(),':')[0];
    }

    @Override
    public String getDominantTemperatureRequirements()
    {
        return StringDecomposition.decompose(dataMap.get("temp").toString(),':')[0];
    }

    @Override
    public int getDominantArea()
    {
        return ((Integer[]) dataMap.get("area"))[0];
    }

    @Override
    public String getDominantEffect()
    {
        return StringDecomposition.decompose(dataMap.get("effect").toString(),':')[0];
    }

    //recessive genes
    @Override
    public String getRecessiveSpecies()
    {
        return StringDecomposition.decompose(dataMap.get("species").toString(),':')[1];
    }

    @Override
    public int getRecessiveSpreadingChance()
    {
        return 0;
    }

    @Override
    public float getRecessiveRainSpreadingBoost()
    {
        return 0;
    }

    @Override
    public int getRecessiveLightRequirements()
    {
        return ((Integer[]) dataMap.get("light"))[1];
    }

    @Override
    public String getRecessiveTerrainRequirement()
    {
        return null;
    }

    @Override
    public String getRecessiveHumidityRequirements()
    {
        return null;
    }

    @Override
    public String getRecessiveTemperatureRequirements()
    {
        return null;
    }

    @Override
    public int getRecessiveArea()
    {
        return 0;
    }

    @Override
    public String getRecessiveEffect()
    {
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