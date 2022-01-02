package com.mettsmirnov.mycology.capabilities;

import com.mettsmirnov.mycology.myutils.StringDecomposition;
import net.minecraft.nbt.CompoundTag;

import java.util.Random;

public class FungusData implements IFungusData
{
    //data
    private String dominantSpecies="dominant:recessive";
    private int[] colors = new int[]{new Random().nextInt(),new Random().nextInt(),new Random().nextInt(),new Random().nextInt()};

    //
    @Override
    public int[] getColors() {
        return colors;
    }

    enum GeneType
    {
        DOMINANT,
        RECESSIVE
    }

    //dominant genes
    @Override
    public String getDominantSpecies()
    {
        return StringDecomposition.decompose(dominantSpecies,':')[0];
    }

    @Override
    public String getDominantSpreadingChance() {
        return null;
    }

    @Override
    public String getDominantRainSpreadingBoost() {
        return null;
    }

    @Override
    public String getDominantLightRequirements() {
        return null;
    }

    @Override
    public String getDominantTerrainRequirement() {
        return null;
    }

    @Override
    public String getDominantHumidityRequirements() {
        return null;
    }

    @Override
    public String getDominantTemperatureRequirements() {
        return null;
    }

    @Override
    public String getDominantArea() {
        return null;
    }

    @Override
    public String getDominantEffect() {
        return null;
    }

    //recessive genes
    @Override
    public String getRecessiveSpecies()
    {
        return StringDecomposition.decompose(dominantSpecies,':')[1];
    }

    @Override
    public String getRecessiveSpreadingChance() {
        return null;
    }

    @Override
    public String getRecessiveRainSpreadingBoost() {
        return null;
    }

    @Override
    public String getRecessiveLightRequirements() {
        return null;
    }

    @Override
    public String getRecessiveTerrainRequirement() {
        return null;
    }

    @Override
    public String getRecessiveHumidityRequirements() {
        return null;
    }

    @Override
    public String getRecessiveTemperatureRequirements() {
        return null;
    }

    @Override
    public String getRecessiveArea() {
        return null;
    }

    @Override
    public String getRecessiveEffect() {
        return null;
    }

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