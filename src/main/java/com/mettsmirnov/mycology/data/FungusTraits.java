package com.mettsmirnov.mycology.data;

public class FungusTraits
{
    public String species;
    public Integer spreading;
    public Float spreadboost;
    public Integer light;
    public String terrain;
    public Float humidity;
    public Float temp;
    public Integer area;
    public String effect;

    public static final String[] traitsDictionary = new String[]{
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
}
