package com.mettsmirnov.mycology.effects;

public class FungusEffect
{
    public static final FungusEffect NO_EFFECT = new FungusEffect(3, "none");
    public static final FungusEffect POISON_EFFECT = new FungusEffect("poison");
    public static final FungusEffect DRUNK_EFFECT = new FungusEffect("drunkenness");
    public static final FungusEffect FATIGUE_EFFECT = new FungusEffect("mining_fatigue");
    public static final FungusEffect HEALING_EFFECT = new FungusEffect("regeneration");
    public static final FungusEffect STRENGTH_EFFECT = new FungusEffect("strengthening");
    public static final FungusEffect ANESTHETIC_EFFECT = new FungusEffect("anesthetic");
    public static final FungusEffect ILLUCINATING_EFFECT = new FungusEffect("illucinating");
    public static final FungusEffect HALLUCINATING_EFFECT = new FungusEffect("hallucinating");
    public static final FungusEffect RADIOACTIVE_EFFECT = new FungusEffect("radioactive");
    public static final FungusEffect BLINDING_EFFECT = new FungusEffect("blinding");
    public static final FungusEffect PHANTOM_EFFECT = new FungusEffect("phantom");
    public static final FungusEffect NIGHTLY_EFFECT = new FungusEffect("nightly");
    public static final FungusEffect SENSING_EFFECT = new FungusEffect("sensing");
    public static final FungusEffect SHINING_EFFECT = new FungusEffect("shining");
    public static final FungusEffect SCHIZO_EFFECT = new FungusEffect("schizo");
    public static final FungusEffect SPARKLING_EFFECT = new FungusEffect("sparkling");
    public static final FungusEffect WITHERING_EFFECT = new FungusEffect("wither");
    public static final FungusEffect RAPTING_EFFECT = new FungusEffect("rapting");
    public static final FungusEffect TELEPORTING_EFFECT = new FungusEffect("teleporting");
    public static final FungusEffect LIGHTFUL_EFFECT = new FungusEffect("lightful");
    public static final FungusEffect GOODCHANCE_EFFECT = new FungusEffect("goodchance");
    public static final FungusEffect LEARNING_EFFECT = new FungusEffect("learning");
    public static final FungusEffect KNOWLEDGE_EFFECT = new FungusEffect("knowledge");
    public static final FungusEffect SPORING_EFFECT = new FungusEffect("sporing");
    public static final FungusEffect DYEING_EFFECT = new FungusEffect("dyeing");

    private int areaRadius;
    private String effect;

    public FungusEffect(int areaRadius, String effect)
    {
        this.areaRadius = areaRadius;
        this.effect = effect;
    }

    public FungusEffect(String effect)
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