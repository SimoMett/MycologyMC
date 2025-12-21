package com.simomett.mycologymod.items.potions;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.effects.FungusEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.simomett.mycologymod.items.potions.Potions.*;

public class NeoForgePotions
{
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, Constants.MOD_ID);

    private static DeferredHolder<Potion, Potion> register(FungusEffect effect, Holder<MobEffect> mobEffect)
    {
        return POTIONS.register(effect.getEffectName(), () -> new Potion(effect.getEffectName(), new MobEffectInstance(mobEffect, DEFAULT_DURATION)));
    }

    private static DeferredHolder<Potion, Potion> register(String effect, Holder<MobEffect> mobEffect)
    {
        return POTIONS.register(effect, () -> new Potion(effect, new MobEffectInstance(mobEffect, DEFAULT_DURATION)));
    }

}
