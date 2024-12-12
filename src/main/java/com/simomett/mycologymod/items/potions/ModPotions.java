package com.simomett.mycologymod.items.potions;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.effects.PlayerEffects.ModEffects;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions
{
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, MycologyMod.MODID);

    public static final DeferredHolder<Potion, Potion> TELEPORTING = POTIONS.register("teleporting",
            ()-> new Potion(new MobEffectInstance(ModEffects.TELEPORTING, 600)));
}
