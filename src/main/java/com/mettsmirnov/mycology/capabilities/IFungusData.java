package com.mettsmirnov.mycology.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IFungusData extends INBTSerializable<CompoundTag>
{
    public int[] getColors();

    //dominant genes
    public String getDominantSpecies();
    public String getDominantSpreadingChance();
    public String getDominantRainSpreadingBoost();
    public String getDominantLightRequirements();
    public String getDominantTerrainRequirement();
    public String getDominantHumidityRequirements();
    public String getDominantTemperatureRequirements();
    public String getDominantArea();
    public String getDominantEffect();

    //recessive genes
    public String getRecessiveSpecies();
    public String getRecessiveSpreadingChance();
    public String getRecessiveRainSpreadingBoost();
    public String getRecessiveLightRequirements();
    public String getRecessiveTerrainRequirement();
    public String getRecessiveHumidityRequirements();
    public String getRecessiveTemperatureRequirements();
    public String getRecessiveArea();
    public String getRecessiveEffect();
}
