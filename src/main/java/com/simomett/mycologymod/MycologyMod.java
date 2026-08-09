package com.simomett.mycologymod;

import com.simomett.mycologymod.creativetab.ModItemGroup;
import com.simomett.mycologymod.data.FabricFungusBrewingRecipesLoader;
import com.simomett.mycologymod.data.FabricFungusSpeciesLoader;
import com.simomett.mycologymod.data.FabricMutationRecipesLoader;
import com.simomett.mycologymod.data.FungusSpeciesSync;
import net.fabricmc.api.ModInitializer;
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

        ResourceLoader.get(PackType.SERVER_DATA).registerReloadListener(FabricFungusSpeciesLoader.FABRIC_ID, new FabricFungusSpeciesLoader());
        //ResourceLoader.get(PackType.SERVER_DATA).registerReloadListener(FabricFungusBrewingRecipesLoader.FABRIC_ID, new FabricFungusBrewingRecipesLoader());

        FabricMutationRecipesLoader mutationRecipesLoader = new FabricMutationRecipesLoader();
        ResourceLoader.get(PackType.SERVER_DATA).registerReloadListener(mutationRecipesLoader.getFabricId(), mutationRecipesLoader);
    }
}
