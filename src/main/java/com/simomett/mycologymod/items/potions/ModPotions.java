package com.simomett.mycologymod.items.potions;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.effects.FungusEffect;
import com.simomett.mycologymod.effects.FungusEffects;
import com.simomett.mycologymod.effects.PlayerEffects.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions
{
    public static final int DEFAULT_DURATION = 20*60*3;
    public static final int LONG_DURATION = 20*60*8;
    public static final int STRONG_DURATION = 20*90;

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, MycologyMod.MODID);

    public static final DeferredHolder<Potion, Potion> HASTE = register("haste", MobEffects.DIG_SPEED);
    public static final DeferredHolder<Potion, Potion> LONG_HASTE = POTIONS.register("long_haste", () -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, LONG_DURATION)));
    public static final DeferredHolder<Potion, Potion> STRONG_HASTE = POTIONS.register("strong_haste", () -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, STRONG_DURATION, 1)));

    public static final DeferredHolder<Potion, Potion> ANESTHETIC = register(FungusEffects.ANESTHETIC_EFFECT, ModEffects.ANESTHETIC);
    public static final DeferredHolder<Potion, Potion> ILLUCINATING = register(FungusEffects.ILLUCINATING_EFFECT, ModEffects.ILLUCINATIONS);
    //public static final DeferredHolder<Potion, Potion> HALLUCINATING = POTIONS.register("", () -> new Potion("", new MobEffectInstance(ModEffects.)));
    public static final DeferredHolder<Potion, Potion> BLINDING = register(FungusEffects.BLINDING_EFFECT, MobEffects.BLINDNESS);
    public static final DeferredHolder<Potion, Potion> SENSING = register(FungusEffects.SENSING_EFFECT, ModEffects.SENSING);
    public static final DeferredHolder<Potion, Potion> WITHERING = register(FungusEffects.WITHERING_EFFECT, MobEffects.WITHER);
    //public static final DeferredHolder<Potion, Potion> RAPTING = POTIONS.register("", () -> new Potion("", new MobEffectInstance(ModEffects)));
    public static final DeferredHolder<Potion, Potion> TELEPORTING = register(FungusEffects.TELEPORTING_EFFECT, ModEffects.TELEPORTING);

    private static DeferredHolder<Potion, Potion> register(FungusEffect effect, Holder<MobEffect> mobEffect)
    {
        return POTIONS.register(effect.getEffectName(), () -> new Potion(effect.getEffectName(), new MobEffectInstance(mobEffect, DEFAULT_DURATION)));
    }

    private static DeferredHolder<Potion, Potion> register(String effect, Holder<MobEffect> mobEffect)
    {
        return POTIONS.register(effect, () -> new Potion(effect, new MobEffectInstance(mobEffect, DEFAULT_DURATION)));
    }

}
