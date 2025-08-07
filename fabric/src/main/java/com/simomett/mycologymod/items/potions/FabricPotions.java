package com.simomett.mycologymod.items.potions;

import com.simomett.mycologymod.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

public class FabricPotions
{
    public static final Potion TEST = Registry.register(
            BuiltInRegistries.POTION,
            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "test_potion"),
            new Potion("test_potion", new MobEffectInstance(MobEffects.DIG_SPEED))
    );
}
