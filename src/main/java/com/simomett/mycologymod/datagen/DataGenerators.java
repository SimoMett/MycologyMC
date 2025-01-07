package com.simomett.mycologymod.datagen;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.datagen.recipe.cooking.CookingRecipesProvider;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = MycologyMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    private DataGenerators() {}

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent evt)
    {
        DataGenerator dataGentor = evt.getGenerator();

        dataGentor.addProvider(true, new SpeciesProvider(dataGentor));
        dataGentor.addProvider(true, new MutationsProvider(dataGentor));
        dataGentor.addProvider(evt.includeServer(), new CookingRecipesProvider.Runner(dataGentor.getPackOutput(), evt.getLookupProvider()));
        dataGentor.addProvider(true, new BrewingRecipesProvider(dataGentor));
    }
}
