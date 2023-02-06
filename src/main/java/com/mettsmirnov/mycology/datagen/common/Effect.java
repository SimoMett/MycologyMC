package com.mettsmirnov.mycology.datagen.common;

public class Effect
{
    public static final Effect NO_EFFECT = new Effect(3, "none");
    private int areaRadius;
    private String effect;

    public Effect(int areaRadius, String effect)
    {
        this.areaRadius = areaRadius;
        this.effect = effect;
    }

    public int getAreaRadius()
    {
        return areaRadius;
    }

    public String getEffect()
    {
        return effect;
    }
}