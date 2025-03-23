package com.simomett.mycologymod.compatibility.rei;

import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipe;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.forge.REIPluginClient;

import static com.simomett.mycologymod.datagen.common.SpeciesDictionary.SPEED_FUNGUS;

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
        //registry.beginFiller(PotionsDisplay.class);
        registry.add(new PotionsDisplay(new FungusBrewingRecipe(SPEED_FUNGUS, "minecraft:swiftness")));
    }

    @Override
    public void registerScreens(ScreenRegistry registry)
    {
        REIClientPlugin.super.registerScreens(registry);
    }
}
