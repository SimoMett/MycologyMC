package com.simomett.mycologymod.effects.player;


import java.util.function.Supplier;

public class EffectsDefinitions
{
    public static final Supplier<AnestheticEffect> ANESTHETIC = AnestheticEffect::instance;
    public static final Supplier<GainXPEffect> GAIN_XP = GainXPEffect::instance;
    public static final Supplier<IllucinationsEffect> ILLUCINATIONS = IllucinationsEffect::instance;
    public static final Supplier<KnowledgeEffect> KNOWLEDGE = KnowledgeEffect::instance;
    public static final Supplier<LastChanceEffect> LAST_CHANCE = LastChanceEffect::instance;
    public static final Supplier<SensingEffect> SENSING = SensingEffect::create;
    public static final Supplier<XPMultiplierEffect> XP_MULTIPLIER = XPMultiplierEffect::create;
    public static final Supplier<TeleportingEffect> TELEPORTING = TeleportingEffect::instance;
    public static final Supplier<SampleEffect> SAMPLE = SampleEffect::create;
}
