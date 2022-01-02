package com.mettsmirnov.mycology.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IFungusData extends INBTSerializable<CompoundTag>
{
    public int[] getColors();

    //dominant genes
    public String getDominantSpecies();
    public int getDominantSpreadingChance();
    public float getDominantRainSpreadingBoost();
    public int getDominantLightRequirements();
    public String getDominantTerrainRequirement();
    public String getDominantHumidityRequirements();
    public String getDominantTemperatureRequirements();
    public int getDominantArea();
    public String getDominantEffect();

    //recessive genes
    public String getRecessiveSpecies();
    public int getRecessiveSpreadingChance();
    public float getRecessiveRainSpreadingBoost();
    public int getRecessiveLightRequirements();
    public String getRecessiveTerrainRequirement();
    public String getRecessiveHumidityRequirements();
    public String getRecessiveTemperatureRequirements();
    public int getRecessiveArea();
    public String getRecessiveEffect();
}
