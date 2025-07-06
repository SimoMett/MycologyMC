package com.simomett.mycologymod.compatibility.rei;

import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipe;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipeLoader;
import com.simomett.mycologymod.recipes.cooking.FungusBlastingRecipe;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipe;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
import me.shedaniel.rei.forge.REIPluginCommon;

@REIPluginCommon
public class ReiPlugin implements REICommonPlugin
{
    @Override
    public void registerDisplays(ServerDisplayRegistry registry)
    {
        // FIXME refactoring
        for(FungusBrewingRecipe r : FungusBrewingRecipeLoader.INSTANCE.getQueue())
            registry.add(new PotionsDisplay(r));
        //

        registry.beginRecipeFiller(FungusShapelessRecipe.class)
                .fill(r -> new ShapelessRecipesDisplay(r.value()));
    }
}
