package com.simomett.mycologymod.genetics;

//I'm convinced this is a horrible class

import java.io.Serializable;
import java.util.*;

import static com.simomett.mycologymod.genetics.FungusGenoma.*;

public class FungusTraits implements Serializable
{
    public static final String[] traitsDictionary = new String[]{
            SPECIES,
            SPREADING,
            SPREAD_BOOST,
            LIGHT,
            TERRAIN,
            HUMIDITY,
            TEMP,
            AREA,
            EFFECT,
            EATING_EFFECT //optional
    };

    private final Map<String, String> traitsMap = new HashMap<>(traitsDictionary.length);

    public static final FungusTraits EMPTY = new FungusTraits("EMPTY", 15, 0f, 0, "none", 0f, 0f, 0, "none", Optional.empty());
    public static final FungusTraits UNINIT = new FungusTraits("UNINITIALIZED", 15, 0f, 0, "none", 0f, 0f, 0, "none", Optional.empty());

    public FungusTraits(String species, int spreading, float spreadboost, int light, String terrain, float humidity, float temp, int area, String effect, String eatingEffect)
    {
        traitsMap.put(SPECIES, species);
        traitsMap.put(SPREADING, String.valueOf(spreading));
        traitsMap.put(SPREAD_BOOST, String.valueOf(spreadboost));
        traitsMap.put(LIGHT, String.valueOf(light));
        traitsMap.put(TERRAIN, terrain);
        traitsMap.put(HUMIDITY, String.valueOf(humidity));
        traitsMap.put(TEMP, String.valueOf(temp));
        traitsMap.put(AREA, String.valueOf(area));
        traitsMap.put(EFFECT, effect);
        if(eatingEffect!=null && !eatingEffect.isEmpty())
            traitsMap.put(EATING_EFFECT, eatingEffect);
    }

    public FungusTraits(String species, int spreading, float spreadboost, int light, String terrain, float humidity, float temp, int area, String effect, Optional<String> eatingEffect)
    {
        traitsMap.put(SPECIES, species);
        traitsMap.put(SPREADING, String.valueOf(spreading));
        traitsMap.put(SPREAD_BOOST, String.valueOf(spreadboost));
        traitsMap.put(LIGHT, String.valueOf(light));
        traitsMap.put(TERRAIN, terrain);
        traitsMap.put(HUMIDITY, String.valueOf(humidity));
        traitsMap.put(TEMP, String.valueOf(temp));
        traitsMap.put(AREA, String.valueOf(area));
        traitsMap.put(EFFECT, effect);
        if(eatingEffect.isPresent() && !eatingEffect.get().isEmpty())
            traitsMap.put(EATING_EFFECT, eatingEffect.get());
    }

    public FungusTraits(FungusTraits fungusTraits)
    {
        this(fungusTraits.species(),
                fungusTraits.spreading(),
                fungusTraits.spreadboost(),
                fungusTraits.light(),
                fungusTraits.terrain(),
                fungusTraits.humidity(),
                fungusTraits.temp(),
                fungusTraits.area(),
                fungusTraits.effect(),
                fungusTraits.eatingEffect());
    }

    public String species(){return traitsMap.get(SPECIES);}

    public Integer spreading() {
        return Integer.valueOf(traitsMap.get(SPREADING));
    }

    public Float spreadboost() {
        return Float.valueOf(traitsMap.get(SPREAD_BOOST));
    }

    public Integer light() {
        return Integer.valueOf(traitsMap.get(LIGHT));
    }

    public String terrain(){return traitsMap.get(TERRAIN);}

    public Float humidity() {
        return Float.valueOf(traitsMap.get(HUMIDITY));
    }

    public Float temp() {
        return Float.valueOf(traitsMap.get(TEMP));
    }

    public Integer area() {
        return Integer.valueOf(traitsMap.get(AREA));
    }

    public String effect(){return traitsMap.get(EFFECT);}

    public Optional<String> eatingEffect()
    {
        return Optional.ofNullable(traitsMap.get(EATING_EFFECT));
    }

    public Optional<String> get(String trait)
    {
        if(!Arrays.asList(traitsDictionary).contains(trait))
            throw new RuntimeException("Unknown trait requested: "+trait);
        return Optional.ofNullable(traitsMap.get(trait));
    }

    public void replace(String trait, String val)
    {
        if(!traitsMap.containsKey(trait))
            throw new RuntimeException("Unknown trait requested: "+trait);
        traitsMap.put(trait, val);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass()) return false;
        FungusTraits that = (FungusTraits) o;
        return Objects.equals(traitsMap, that.traitsMap);
    }
}
