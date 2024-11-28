package com.mettsmirnov.mycology.items.potions;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.effects.PlayerEffects.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions
{
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, MycologyMod.MODID);

    public static final RegistryObject<Potion> TELEPORTING_POTION = POTIONS.register("teleporting_potion",
            ()-> new Potion(new MobEffectInstance(ModEffects.TELEPORTING.get(), 600)));
}
