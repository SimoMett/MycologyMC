package com.simomett.mycologymod.platform;

import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.data.AbstractFungusSpeciesColorsMap;
import com.simomett.mycologymod.data.AbstractFungusSpeciesList;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

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
