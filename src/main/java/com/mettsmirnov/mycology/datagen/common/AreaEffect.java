package com.mettsmirnov.mycology.datagen.common;

public class AreaEffect
{
    public static final AreaEffect NO_EFFECT = new AreaEffect(3, "none");
    public int areaRadius;
    public String effect;

    public AreaEffect(int areaRadius, String effect)
    {
        this.areaRadius = areaRadius;
        this.effect = effect;
    }
}