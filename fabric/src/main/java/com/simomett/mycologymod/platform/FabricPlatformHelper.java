package com.simomett.mycologymod.platform;

import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.data.AbstractFungusSpeciesColorsMap;
import com.simomett.mycologymod.data.AbstractFungusSpeciesList;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.alchemy.Potion;

import java.util.function.Supplier;

public class FabricPlatformHelper implements IPlatformHelper
{
    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public Holder<MobEffect> registerMobEffect(String name, Supplier<MobEffect> mobEffectSupplier)
    {
        return Holder.direct(Registry.register(BuiltInRegistries.MOB_EFFECT, name, mobEffectSupplier.get()));
    }

    @Override
    public Holder<Potion> registerPotion(String name, Supplier<Potion> potionSupplier)
    {
        return Holder.direct(Registry.register(BuiltInRegistries.POTION, name, potionSupplier.get()));
    }

    @Override
    public AbstractFungusSpeciesList initFungusSpeciesList()
    {
        return null;
    }

    @Override
    public AbstractFungusSpeciesColorsMap initFungusSpeciesColorsMap()
    {
        return null;
    }

    @Override
    public IModCommonConfigs getCommonConfigs()
    {
        return null;
    }
}
