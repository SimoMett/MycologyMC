package com.simomett.mycologymod.compatibility.rei;

import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipe;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipeLoader;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.forge.REIPluginClient;

@REIPluginClient
public class ReiPlugin implements REIClientPlugin
{
    @Override
    public void registerCategories(CategoryRegistry registry)
    {
        REIClientPlugin.super.registerCategories(registry);
    }

    @Override
    public void registerDisplays(DisplayRegistry registry)
    {
        for(FungusBrewingRecipe r : FungusBrewingRecipeLoader.INSTANCE.getQueue())
        {
            registry.add(new PotionsDisplay(r));
        }

        //registry.registerFillerWithReason(DisplayAdditionReason.RECIPE_MANAGER,)
    }

    @Override
    public void registerScreens(ScreenRegistry registry)
    {
        REIClientPlugin.super.registerScreens(registry);
    }
}
