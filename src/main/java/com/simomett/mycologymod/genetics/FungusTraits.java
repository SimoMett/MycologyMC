package com.simomett.mycologymod.genetics;

import com.simomett.mycologymod.config.ModCommonConfigs;
import com.simomett.mycologymod.effects.FungusEffects;
import com.simomett.mycologymod.genetics.gene.*;

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

    private final Map<String, Gene<?>> traitsMap = new HashMap<>(traitsDictionary.length);

    public static final FungusTraits EMPTY = new FungusTraits("EMPTY", 15, 0f, 0, "none", 0f, 0f, 0, FungusEffects.NO_EFFECT.getEffectName(), Optional.empty());
    public static final FungusTraits UNINIT = new FungusTraits("UNINITIALIZED", 15, 0f, 0, "none", 0f, 0f, 0, FungusEffects.NO_EFFECT.getEffectName(), Optional.empty());

    public FungusTraits(String species, int spreading, float spreadboost, int light, String terrain, float humidity, float temp, int area, String effect, String eatingEffect)
    {
        traitsMap.put(SPECIES, new StringGene(species));
        traitsMap.put(SPREADING, new IntGene(spreading, 1, ModCommonConfigs.MIN_SPREADING_SPEED.get()));
        traitsMap.put(SPREAD_BOOST, new FloatGene(spreadboost, 1f, ModCommonConfigs.MAX_SPREAD_BOOST.get()));
        traitsMap.put(LIGHT, new IntGene(light, 1, 15));
        traitsMap.put(TERRAIN, new StringGene(terrain));
        traitsMap.put(HUMIDITY, new FloatGene(humidity, 0f, 1f));
        traitsMap.put(TEMP, new FloatGene(temp, -0.7f, 2f));
        traitsMap.put(AREA, new IntGene(area, 1, 16));
        traitsMap.put(EFFECT, new EffectGene(effect));
        if(eatingEffect!=null && !eatingEffect.isEmpty())
            traitsMap.put(EATING_EFFECT, new StringGene(eatingEffect));
    }

    public FungusTraits(String species, int spreading, float spreadboost, int light, String terrain, float humidity, float temp, int area, String effect, Optional<String> eatingEffect)
    {
        this(species, spreading, spreadboost, light, terrain, humidity, temp, area, effect, eatingEffect.orElse(null));
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

    public String species() {
        return (String) traitsMap.get(SPECIES).value();
    }

    public Integer spreading() {
        return (Integer) traitsMap.get(SPREADING).value();
    }

    public Float spreadboost() {
        return (Float) traitsMap.get(SPREAD_BOOST).value();
    }

    public Integer light() {
        return (Integer) traitsMap.get(LIGHT).value();
    }

    public String terrain() {
        return (String) traitsMap.get(TERRAIN).value();
    }

    public Float humidity() {
        return (Float) traitsMap.get(HUMIDITY).value();
    }

    public Float temp() {
        return (Float) traitsMap.get(TEMP).value();
    }

    public Integer area() {
        return (Integer) traitsMap.get(AREA).value();
    }

    public String effect() {
        return (String) traitsMap.get(EFFECT).value();
    }

    public Optional<String> eatingEffect()
    {
        if(traitsMap.containsKey(EATING_EFFECT) && traitsMap.get(EATING_EFFECT) != null)
            return Optional.ofNullable((String) traitsMap.get(EATING_EFFECT).value());
        return Optional.empty();
    }

    public Gene<?> get(String trait)
    {
        if(!Arrays.asList(traitsDictionary).contains(trait))
            throw new RuntimeException("Unknown trait requested: "+trait);
        return traitsMap.get(trait);
    }

    public void replace(String trait, Gene<?> newVal)
    {
        if(!Arrays.asList(traitsDictionary).contains(trait))
            throw new RuntimeException("Unknown trait requested: "+trait);
        traitsMap.put(trait, newVal);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass()) return false;
        FungusTraits that = (FungusTraits) o;
        return Objects.equals(traitsMap, that.traitsMap);
    }
}
