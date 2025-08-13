package com.simomett.mycologymod.effects.player;

import com.simomett.mycologymod.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoForgeModEffects
{
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, Constants.MOD_ID);

    //Experience effects
    /*public static DeferredHolder<MobEffect, GainXPEffect> GAIN_XP = EFFECTS.register("gain_xp", EffectsDefinitions.GAIN_XP);
    public static DeferredHolder<MobEffect, XPMultiplierEffect> XP_MULTIPLIER = EFFECTS.register("xp_multiplier", EffectsDefinitions.XP_MULTIPLIER);

    //Others
    public static DeferredHolder<MobEffect, SensingEffect> SENSING = EFFECTS.register("sensing", EffectsDefinitions.SENSING);
    public static DeferredHolder<MobEffect, AnestheticEffect> ANESTHETIC = EFFECTS.register("anesthetic", EffectsDefinitions.ANESTHETIC);
    public static DeferredHolder<MobEffect, LastChanceEffect> LAST_CHANCE = EFFECTS.register("last_chance", EffectsDefinitions.LAST_CHANCE);
    public static DeferredHolder<MobEffect, IllucinationsEffect> ILLUCINATIONS = EFFECTS.register("illucinations", EffectsDefinitions.ILLUCINATIONS);
    public static DeferredHolder<MobEffect, KnowledgeEffect> KNOWLEDGE = EFFECTS.register("knowledge", EffectsDefinitions.KNOWLEDGE);
    public static DeferredHolder<MobEffect, TeleportingEffect> TELEPORTING = EFFECTS.register("teleporting", EffectsDefinitions.TELEPORTING);

    //test only
    public static DeferredHolder<MobEffect, SampleEffect> SAMPLE = EFFECTS.register("sample", EffectsDefinitions.SAMPLE);*/
}
