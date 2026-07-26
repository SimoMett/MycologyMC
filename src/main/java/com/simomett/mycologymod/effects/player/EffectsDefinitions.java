package com.simomett.mycologymod.effects.player;


import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

import static com.simomett.mycologymod.Constants.MOD_ID;

public class EffectsDefinitions
{
    private static <T extends MobEffect> IRegisteredMobEffect<T> registerMobEffect(String name, Supplier<T> mobEffectSupplier)
    {
        ResourceKey<MobEffect> key = ResourceKey.create(Registries.MOB_EFFECT, Identifier.fromNamespaceAndPath(MOD_ID, name));
        return new FabricMobEffect<>(Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, key, mobEffectSupplier.get()));
    }

    public static final IRegisteredMobEffect<AnestheticEffect> ANESTHETIC = registerMobEffect("anesthetic", AnestheticEffect::instance);
    public static final IRegisteredMobEffect<GainXPEffect> GAIN_XP = registerMobEffect("gain_xp", GainXPEffect::instance);
    public static final IRegisteredMobEffect<IllucinationsEffect> ILLUCINATIONS = registerMobEffect("illucinations", IllucinationsEffect::instance);
    public static final IRegisteredMobEffect<KnowledgeEffect> KNOWLEDGE = registerMobEffect("knowledge", KnowledgeEffect::instance);
    public static final IRegisteredMobEffect<LastChanceEffect> LAST_CHANCE = registerMobEffect("last_chance", LastChanceEffect::instance);
    public static final IRegisteredMobEffect<SensingEffect> SENSING = registerMobEffect("sensing", SensingEffect::create);
    public static final IRegisteredMobEffect<XPMultiplierEffect> XP_MULTIPLIER = registerMobEffect("xp_multiplier", XPMultiplierEffect::create);
    public static final IRegisteredMobEffect<TeleportingEffect> TELEPORTING = registerMobEffect("teleporting", TeleportingEffect::instance);
    public static final IRegisteredMobEffect<ReturnHomeEffect> RETURN_HOME = registerMobEffect("return_home", ReturnHomeEffect::getInstance);
    public static final IRegisteredMobEffect<SampleEffect> SAMPLE = registerMobEffect("sample", SampleEffect::create);

    public static void init(){}
}
