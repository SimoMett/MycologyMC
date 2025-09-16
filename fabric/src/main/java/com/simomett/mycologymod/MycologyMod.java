package com.simomett.mycologymod;

import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.creativetab.ModItemGroup;
import com.simomett.mycologymod.data.FabricFungusSpeciesLoader;
import com.simomett.mycologymod.data.FungusSpeciesSync;
import com.simomett.mycologymod.datacomponents.DataComponentTypes;
import com.simomett.mycologymod.effects.player.EffectsDefinitions;
import com.simomett.mycologymod.entities.BlockEntitiesDefinitions;
import com.simomett.mycologymod.items.ItemsDefinitions;
import com.simomett.mycologymod.items.potions.Potions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.server.packs.PackType;

public class MycologyMod implements ModInitializer {

    @Override
    public void onInitialize()
    {

        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
        EffectsDefinitions.init();
        Potions.init();
        DataComponentTypes.init();
        FungusSpeciesSync.registerPayloads();
        ModItemGroup.initialize();
        BlocksDefinitions.init();
        ItemsDefinitions.init();
        BlockEntitiesDefinitions.init();
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricFungusSpeciesLoader());
    }
}
