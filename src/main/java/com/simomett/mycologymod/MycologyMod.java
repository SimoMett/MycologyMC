package com.simomett.mycologymod;

import com.simomett.mycologymod.creativetab.ModItemGroup;
import com.simomett.mycologymod.data.FabricFungusBrewingRecipesLoader;
import com.simomett.mycologymod.data.FabricFungusSpeciesLoader;
import com.simomett.mycologymod.data.FabricMutationRecipesLoader;
import com.simomett.mycologymod.data.FungusSpeciesSync;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.minecraft.server.packs.PackType;

public class MycologyMod implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        CommonClass.init();
        ModItemGroup.initialize();
        FungusSpeciesSync.registerPayloads();

        FabricFungusSpeciesLoader speciesLoader = new FabricFungusSpeciesLoader();
        ResourceLoader.get(PackType.SERVER_DATA).registerReloadListener(speciesLoader.getFabricId(), speciesLoader);

        FabricFungusBrewingRecipesLoader brewingRecipesLoader = new FabricFungusBrewingRecipesLoader();
        ResourceLoader.get(PackType.SERVER_DATA).registerReloadListener(brewingRecipesLoader.getFabricId(), brewingRecipesLoader);

        FabricMutationRecipesLoader mutationRecipesLoader = new FabricMutationRecipesLoader();
        ResourceLoader.get(PackType.SERVER_DATA).registerReloadListener(mutationRecipesLoader.getFabricId(), mutationRecipesLoader);
    }
}
