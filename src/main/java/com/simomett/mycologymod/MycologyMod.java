package com.simomett.mycologymod;

import com.simomett.mycologymod.creativetab.ModItemGroup;
import com.simomett.mycologymod.data.FabricFungusBrewingRecipesLoader;
import com.simomett.mycologymod.data.FabricFungusSpeciesLoader;
import com.simomett.mycologymod.data.FabricMutationRecipesLoader;
import com.simomett.mycologymod.data.FungusSpeciesSync;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.server.packs.PackType;

public class MycologyMod implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        FungusSpeciesSync.registerPayloads();
        ModItemGroup.initialize();
        CommonClass.init();
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricFungusSpeciesLoader());
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricFungusBrewingRecipesLoader());
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricMutationRecipesLoader());
    }
}
