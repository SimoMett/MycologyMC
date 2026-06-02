package com.simomett.mycologymod.effects.player;


import com.simomett.mycologymod.platform.Services;

public class EffectsDefinitions
{
    public static final IRegisteredMobEffect<AnestheticEffect> ANESTHETIC = Services.PLATFORM.registerMobEffect("anesthetic", AnestheticEffect::instance);
    public static final IRegisteredMobEffect<GainXPEffect> GAIN_XP = Services.PLATFORM.registerMobEffect("gain_xp", GainXPEffect::instance);
    public static final IRegisteredMobEffect<IllucinationsEffect> ILLUCINATIONS = Services.PLATFORM.registerMobEffect("illucinations", IllucinationsEffect::instance);
    public static final IRegisteredMobEffect<KnowledgeEffect> KNOWLEDGE = Services.PLATFORM.registerMobEffect("knowledge", KnowledgeEffect::instance);
    public static final IRegisteredMobEffect<LastChanceEffect> LAST_CHANCE = Services.PLATFORM.registerMobEffect("last_chance", LastChanceEffect::instance);
    public static final IRegisteredMobEffect<SensingEffect> SENSING = Services.PLATFORM.registerMobEffect("sensing", SensingEffect::create);
    public static final IRegisteredMobEffect<XPMultiplierEffect> XP_MULTIPLIER = Services.PLATFORM.registerMobEffect("xp_multiplier", XPMultiplierEffect::create);
    public static final IRegisteredMobEffect<TeleportingEffect> TELEPORTING = Services.PLATFORM.registerMobEffect("teleporting", TeleportingEffect::instance);
    public static final IRegisteredMobEffect<ReturnHomeEffect> RETURN_HOME = Services.PLATFORM.registerMobEffect("return_home", ReturnHomeEffect::getInstance);
    public static final IRegisteredMobEffect<SampleEffect> SAMPLE = Services.PLATFORM.registerMobEffect("sample", SampleEffect::create);

    public static void init(){}
}
