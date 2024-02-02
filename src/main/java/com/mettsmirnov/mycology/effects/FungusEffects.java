package com.mettsmirnov.mycology.effects;

import net.minecraft.world.effect.MobEffects;

import java.util.HashMap;

public class FungusEffects
{
    public static final SingleEffect NO_EFFECT = new SingleEffect("none");
    public static final SingleEffect POISON_EFFECT = new SingleEffect("poison");
    public static final SingleEffect DRUNK_EFFECT = new SingleEffect("drunkenness");
    public static final SingleEffect FATIGUE_EFFECT = new SingleEffect("mining_fatigue");
    public static final SingleEffect HEALING_EFFECT = new SingleEffect("regeneration", MobEffects.REGENERATION);
    public static final SingleEffect STRENGTH_EFFECT = new SingleEffect("strengthening", MobEffects.DAMAGE_BOOST);
    public static final SingleEffect ANESTHETIC_EFFECT = new SingleEffect("anesthetic");
    public static final SingleEffect ILLUCINATING_EFFECT = new SingleEffect("illucinating");
    public static final SingleEffect HALLUCINATING_EFFECT = new SingleEffect("hallucinating");
    public static final SingleEffect RADIOACTIVE_EFFECT = new SingleEffect("radioactive");
    public static final SingleEffect BLINDING_EFFECT = new SingleEffect("blinding", MobEffects.BLINDNESS);
    public static final SingleEffect PHANTOM_EFFECT = new SingleEffect("phantom", MobEffects.INVISIBILITY);
    public static final SingleEffect NIGHTLY_EFFECT = new SingleEffect("nightly", MobEffects.NIGHT_VISION);
    public static final SingleEffect SENSING_EFFECT = new SingleEffect("sensing");
    public static final SingleEffect SHINING_EFFECT = new SingleEffect("shining", MobEffects.GLOWING);
    public static final SingleEffect SCHIZO_EFFECT = new SingleEffect("schizo");
    public static final SingleEffect SPARKLING_EFFECT = new SingleEffect("sparkling");
    public static final SingleEffect WITHERING_EFFECT = new SingleEffect("wither", MobEffects.WITHER);
    public static final SingleEffect RAPTING_EFFECT = new SingleEffect("rapting");
    public static final SingleEffect TELEPORTING_EFFECT = new SingleEffect("teleporting");
    public static final SingleEffect LIGHTFUL_EFFECT = new SingleEffect("lightful", MobEffects.SLOW_FALLING);
    public static final SingleEffect GOODCHANCE_EFFECT = new SingleEffect("goodchance", MobEffects.LUCK);
    public static final SingleEffect LEARNING_EFFECT = new SingleEffect("learning");
    public static final SingleEffect KNOWLEDGE_EFFECT = new SingleEffect("knowledge");
    public static final SingleEffect SPORING_EFFECT = new SingleEffect("sporing");
    public static final SingleEffect DYEING_EFFECT = new SingleEffect("dyeing");
    public static final SingleEffect FERTILIZING_EFFECT = new SingleEffect("fertilizing");

    private static final HashMap<String, IFungusEffect> effectsHashMap = new HashMap<>();

    public static IFungusEffect getEffectByName(String effectName)
    {
        return effectsHashMap.get(effectName);
    }

    public static void registerFungusEffect(String effectName, IFungusEffect fungusEffect)
    {
        effectsHashMap.put(effectName, fungusEffect);
    }
}
