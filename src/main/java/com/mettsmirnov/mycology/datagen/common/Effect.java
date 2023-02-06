package com.mettsmirnov.mycology.datagen.common;

public class Effect
{
    public static final Effect NO_EFFECT = new Effect(3, "none");
    public static final Effect POISON_EFFECT = new Effect("poison");
    public static final Effect DRUNK_EFFECT = new Effect("drunkenness");
    public static final Effect FATIGUE_EFFECT = new Effect("fatigue");
    public static final Effect HEALING_EFFECT = new Effect("healing");
    public static final Effect STRENGTH_EFFECT = new Effect("strengthening");
    public static final Effect ANESTHETIC_EFFECT = new Effect("anesthetic");
    public static final Effect ILLUCINATING_EFFECT = new Effect("illucinating");
    public static final Effect HALLUCINATING_EFFECT = new Effect("hallucinating");
    public static final Effect RADIOACTIVE_EFFECT = new Effect("radioactive");
    public static final Effect BLINDING_EFFECT = new Effect("blinding");
    public static final Effect PHANTOM_EFFECT = new Effect("phantom");
    public static final Effect NIGHTLY_EFFECT = new Effect("nightly");
    public static final Effect SENSING_EFFECT = new Effect("sensing");
    public static final Effect SHINING_EFFECT = new Effect("shining");
    public static final Effect SCHIZO_EFFECT = new Effect("schizo");
    public static final Effect SPARKLING_EFFECT = new Effect("sparkling");
    public static final Effect WITHERING_EFFECT = new Effect("withering");
    public static final Effect RAPTING_EFFECT = new Effect("rapting");
    public static final Effect TELEPORTING_EFFECT = new Effect("teleporting");
    public static final Effect LIGHTFUL_EFFECT = new Effect("lightful");
    public static final Effect GOODCHANCE_EFFECT = new Effect("goodchance");
    public static final Effect LEARNING_EFFECT = new Effect("learning");
    public static final Effect KNOWLEDGE_EFFECT = new Effect("knowledge");
    public static final Effect SPORING_EFFECT = new Effect("sporing");
    public static final Effect DYEING_EFFECT = new Effect("dyeing");

    private int areaRadius;
    private String effect;

    public Effect(int areaRadius, String effect)
    {
        this.areaRadius = areaRadius;
        this.effect = effect;
    }

    public Effect(String effect)
    {
        this.areaRadius = 3;
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