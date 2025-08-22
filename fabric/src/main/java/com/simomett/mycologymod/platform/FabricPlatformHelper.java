package com.simomett.mycologymod.platform;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.data.AbstractFungusSpeciesColorsMap;
import com.simomett.mycologymod.data.AbstractFungusSpeciesList;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.alchemy.Potion;

import java.util.function.Supplier;

import static com.simomett.mycologymod.datacomponents.DataComponentTypes.FUNGUS_GENOMA_BUILDER;
import static com.simomett.mycologymod.datacomponents.DataComponentTypes.GENOMA_DATA_COMPONENT_NAME;

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

    @Override
    public Supplier<DataComponentType<FungusGenoma>> registerDataComponentType()
    {
        Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, GENOMA_DATA_COMPONENT_NAME),
                FUNGUS_GENOMA_BUILDER.apply(DataComponentType.builder()).build()
        );
        return null;
    }
}
