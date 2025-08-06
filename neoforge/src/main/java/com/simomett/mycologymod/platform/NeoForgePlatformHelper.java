package com.simomett.mycologymod.platform;

import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.data.AbstractFungusSpeciesColorsMap;
import com.simomett.mycologymod.data.AbstractFungusSpeciesList;
import com.simomett.mycologymod.data.FungusSpeciesColorsMap;
import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class NeoForgePlatformHelper implements IPlatformHelper {

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
    public AbstractFungusSpeciesList initFungusSpeciesList() {
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
}
