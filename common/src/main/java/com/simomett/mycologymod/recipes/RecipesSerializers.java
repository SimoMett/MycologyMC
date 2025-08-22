package com.simomett.mycologymod.recipes;

import com.simomett.mycologymod.platform.Services;
import com.simomett.mycologymod.recipes.cooking.FungusBlastingRecipe;
import com.simomett.mycologymod.recipes.cooking.FungusBlastingRecipeSerializer;
import com.simomett.mycologymod.recipes.cooking.FungusCookingRecipeSerializer;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipe;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipeSerializer;

import java.util.function.Supplier;

public class RecipesSerializers
{
    public static final Supplier<FungusCookingRecipeSerializer> FUNGUS_COOKING_RECIPE_SERIALIZER = Services.PLATFORM.registerRecipeSerializer("fungus_cooking", FungusCookingRecipeSerializer::new);
    public static final Supplier<FungusBlastingRecipeSerializer> FUNGUS_BLASTING_RECIPE_SERIALIZER = Services.PLATFORM.registerRecipeSerializer(FungusBlastingRecipe.NAME, FungusBlastingRecipeSerializer::new);
    public static final Supplier<FungusShapelessRecipeSerializer> FUNGUS_SHAPELESS_RECIPE_SERIALIZER = Services.PLATFORM.registerRecipeSerializer(FungusShapelessRecipe.NAME, FungusShapelessRecipeSerializer::new);
}
