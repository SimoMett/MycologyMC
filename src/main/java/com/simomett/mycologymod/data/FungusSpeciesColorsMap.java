package com.simomett.mycologymod.data;

import com.simomett.mycologymod.genetics.FungusTraits;

import java.util.HashMap;

public class FungusSpeciesColorsMap
{
    private final HashMap<String, int[]> colorsMap = new HashMap<>();

    public static final FungusSpeciesColorsMap INSTANCE = new FungusSpeciesColorsMap();

    private FungusSpeciesColorsMap(){}

    public final void put(FungusTraits defaultTraits, int[] colors)
    {
        put(defaultTraits.species(), colors);
    }

    public final void put(String speciesName, int[] colors)
    {
        if(colors.length!=4)
            throw new IllegalArgumentException("colors array must have length of 4");
        colorsMap.put(speciesName, colors);
    }

    public int[] get(String speciesName)
    {
        return colorsMap.getOrDefault(speciesName, new int[]{0, 0, 0, 0});
    }
}
