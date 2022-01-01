package com.mettsmirnov.mycology.capabilities;

import net.minecraft.nbt.CompoundTag;

public class FungusData implements IFungusData
{


    @Override
    public int[] getColors() {
        return new int[4];
    }

    enum GeneType
    {
        DOMINANT,
        RECESSIVE
    }

    //dominant genes
    @Override
    public String getDominantSpecies() {
        return null;
    }

    @Override
    public String getDominantSpreadingSpeed() {
        return null;
    }

    @Override
    public String getDominantRainBoostSpeed() {
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
    public String getRecessiveSpecies() {
        return null;
    }

    @Override
    public String getRecessiveSpreadingSpeed() {
        return null;
    }

    @Override
    public String getRecessiveRainBoostSpeed() {
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

        return new CompoundTag();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt)
    {

    }

}