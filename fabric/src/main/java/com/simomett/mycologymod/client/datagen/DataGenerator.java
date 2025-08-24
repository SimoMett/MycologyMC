package com.simomett.mycologymod.client.datagen;

import com.simomett.mycologymod.datagen.SpeciesProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGenerator implements DataGeneratorEntrypoint
{
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
    {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider((FabricDataGenerator.Pack.Factory<SpeciesProvider>) SpeciesProvider::new);
    }
}
