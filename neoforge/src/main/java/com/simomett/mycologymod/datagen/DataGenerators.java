package com.simomett.mycologymod.datagen;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.datagen.recipe.blasting.BlastingRecipesProvider;
import com.simomett.mycologymod.datagen.recipe.cooking.CookingRecipesProvider;
import com.simomett.mycologymod.datagen.recipe.crafting.FungusShapelessRecipesProvider;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class DataGenerators
{
    private DataGenerators() {}

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Server evt)
    {
        DataGenerator dataGentor = evt.getGenerator();

        dataGentor.addProvider(true, new SpeciesProvider(dataGentor.getPackOutput()));
        dataGentor.addProvider(true, new MutationsProvider(dataGentor));
        dataGentor.addProvider(true, new CookingRecipesProvider.Runner(dataGentor.getPackOutput(), evt.getLookupProvider()));
        dataGentor.addProvider(true, new BlastingRecipesProvider.Runner(dataGentor.getPackOutput(), evt.getLookupProvider()));
        dataGentor.addProvider(true, new FungusShapelessRecipesProvider.Runner(dataGentor.getPackOutput(), evt.getLookupProvider()));
        dataGentor.addProvider(true, new BrewingRecipesProvider(dataGentor));
    }
}
