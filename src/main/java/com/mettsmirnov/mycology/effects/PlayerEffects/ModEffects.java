package com.mettsmirnov.mycology.effects.PlayerEffects;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects
{
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MycologyMod.MODID);

    //Experience effects
    public static RegistryObject<MobEffect> GAIN_XP = EFFECTS.register("gain_xp", GainXPEffect::instance);
    public static RegistryObject<MobEffect> XP_MULTIPLIER = EFFECTS.register("xp_multiplier", XPMultiplierEffect::create);

    //Others
    public static RegistryObject<MobEffect> SENSING = EFFECTS.register("sensing", SensingEffect::create);
    public static RegistryObject<MobEffect> ANESTHETIC = EFFECTS.register("anesthetic", AnestheticEffect::instance);
    public static RegistryObject<MobEffect> LAST_CHANCE = EFFECTS.register("last_chance", LastChanceEffect::instance);
    public static RegistryObject<MobEffect> ILLUCINATIONS = EFFECTS.register("illucinations", IllucinationsEffect::instance);
    public static RegistryObject<MobEffect> KNOWLEDGE = EFFECTS.register("knowledge", KnowledgeEffect::instance);
    public static RegistryObject<MobEffect> TELEPORTING = EFFECTS.register("teleporting", TeleportingEffect::instance);

    //test only
    public static RegistryObject<MobEffect> SAMPLE = EFFECTS.register("sample", SampleEffect::create);
}
