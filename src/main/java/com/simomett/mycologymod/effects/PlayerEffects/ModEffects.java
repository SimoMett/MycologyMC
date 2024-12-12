package com.simomett.mycologymod.effects.PlayerEffects;

import com.simomett.mycologymod.MycologyMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModEffects
{
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, MycologyMod.MODID);

    //Experience effects
    public static DeferredHolder<MobEffect, GainXPEffect> GAIN_XP = EFFECTS.register("gain_xp", GainXPEffect::instance);
    public static DeferredHolder<MobEffect, XPMultiplierEffect> XP_MULTIPLIER = EFFECTS.register("xp_multiplier", XPMultiplierEffect::create);

    //Others
    public static DeferredHolder<MobEffect, SensingEffect> SENSING = EFFECTS.register("sensing", SensingEffect::create);
    public static DeferredHolder<MobEffect, AnestheticEffect> ANESTHETIC = EFFECTS.register("anesthetic", AnestheticEffect::instance);
    public static DeferredHolder<MobEffect, LastChanceEffect> LAST_CHANCE = EFFECTS.register("last_chance", LastChanceEffect::instance);
    public static DeferredHolder<MobEffect, IllucinationsEffect> ILLUCINATIONS = EFFECTS.register("illucinations", IllucinationsEffect::instance);
    public static DeferredHolder<MobEffect, KnowledgeEffect> KNOWLEDGE = EFFECTS.register("knowledge", KnowledgeEffect::instance);
    public static DeferredHolder<MobEffect, TeleportingEffect> TELEPORTING = EFFECTS.register("teleporting", TeleportingEffect::instance);

    //test only
    public static DeferredHolder<MobEffect, SampleEffect> SAMPLE = EFFECTS.register("sample", SampleEffect::create);
}
