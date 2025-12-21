package com.simomett.mycologymod.recipes.brewing;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.registries.BuiltInRegistries;

public class FungusBrewingRecipesRegister
{
    public static void registerPotionsRecipes()
    {
        for(FungusBrewingRecipe r : FungusBrewingRecipeLoader.INSTANCE.getQueue())
        {
            FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {


                //builder.registerPotionRecipe(r.getInputPotion(), fungusIngredient, BuiltInRegistries.POTION.wrapAsHolder(r.resultPotion.value()));
            });
        }

    }
}
