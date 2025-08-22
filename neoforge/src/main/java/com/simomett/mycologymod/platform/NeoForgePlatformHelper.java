package com.simomett.mycologymod.platform;

import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.data.AbstractFungusSpeciesColorsMap;
import com.simomett.mycologymod.data.AbstractFungusSpeciesList;
import com.simomett.mycologymod.data.FungusSpeciesColorsMap;
import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.effects.player.NeoForgeModEffects;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.items.potions.NeoForgePotions;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

import java.util.function.Supplier;

import static com.simomett.mycologymod.datacomponents.DataComponentTypes.FUNGUS_GENOMA_BUILDER;
import static com.simomett.mycologymod.datacomponents.DataComponentTypes.GENOMA_DATA_COMPONENT_NAME;
import static com.simomett.mycologymod.datacomponents.NeoForgeDataComponents.DATA_COMPONENTS;

public class NeoForgePlatformHelper implements IPlatformHelper
{
    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public Holder<MobEffect> registerMobEffect(String name, Supplier<MobEffect> mobEffectSupplier)
    {
        return NeoForgeModEffects.EFFECTS.register(name, mobEffectSupplier);
    }

    @Override
    public Holder<Potion> registerPotion(String name, Supplier<Potion> potionSupplier)
    {
        return NeoForgePotions.POTIONS.register(name, potionSupplier);
    }

    @Override
    public AbstractFungusSpeciesList initFungusSpeciesList()
    {
        return new FungusSpeciesList();
    }

    @Override
    public AbstractFungusSpeciesColorsMap initFungusSpeciesColorsMap() {
        return new FungusSpeciesColorsMap();
    }

    @Override
    public IModCommonConfigs getCommonConfigs()
    {
        return null;
    }

    @Override
    public Supplier<DataComponentType<FungusGenoma>> registerDataComponentType()
    {
        return DATA_COMPONENTS.registerComponentType(GENOMA_DATA_COMPONENT_NAME, FUNGUS_GENOMA_BUILDER);
    }
}
