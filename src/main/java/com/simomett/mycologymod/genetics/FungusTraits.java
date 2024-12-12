package com.simomett.mycologymod.genetics;

//I'm convinced this is a horrible class

import java.util.*;

import static com.simomett.mycologymod.genetics.FungusGenoma.*;

public class FungusTraits
{
    public static final String[] traitsDictionary = new String[]{
            "species",
            "spreading",
            "spreadboost",
            "light",
            "terrain",
            "humidity",
            "temp",
            "area",
            "effect",
            "eatingEffect"//optional
    };

    private final Map<String, String> traitsMap = new HashMap<>(traitsDictionary.length);

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

    public String get(String trait)
    {
        if(!traitsMap.containsKey(trait))
            throw new RuntimeException("Unknown trait requested: "+trait);
        return traitsMap.get(trait);
    }

    public void replace(String trait, String val)
    {
        if(!traitsMap.containsKey(trait))
            throw new RuntimeException("Unknown trait requested: "+trait);
        traitsMap.put(trait, val);
    }

    /*@Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FungusTraits that = (FungusTraits) o;
        return Objects.equals(traitsMap, that.traitsMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(traitsMap);
    }*/
}
