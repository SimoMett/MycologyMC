package com.simomett.mycologymod.recipes;

import com.simomett.mycologymod.platform.Services;
import com.simomett.mycologymod.recipes.cooking.FungusBlastingRecipe;
import com.simomett.mycologymod.recipes.cooking.FungusBlastingRecipeSerializer;
import com.simomett.mycologymod.recipes.cooking.FungusCookingRecipe;
import com.simomett.mycologymod.recipes.cooking.FungusCookingRecipeSerializer;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipe;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipeSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class RecipesSerializers
{
    public static final Supplier<RecipeSerializer<FungusCookingRecipe>> FUNGUS_COOKING_RECIPE_SERIALIZER = Services.PLATFORM.registerRecipeSerializer("fungus_cooking", ()-> new RecipeSerializer<>(FungusCookingRecipeSerializer.MAP_CODEC, FungusCookingRecipeSerializer.STREAM_CODEC));
    public static final Supplier<RecipeSerializer<FungusBlastingRecipe>> FUNGUS_BLASTING_RECIPE_SERIALIZER = Services.PLATFORM.registerRecipeSerializer(FungusBlastingRecipe.NAME, () -> new RecipeSerializer<>(FungusBlastingRecipeSerializer.MAP_CODEC, FungusBlastingRecipeSerializer.STREAM_CODEC));
    public static final Supplier<RecipeSerializer<FungusShapelessRecipe>> FUNGUS_SHAPELESS_RECIPE_SERIALIZER = Services.PLATFORM.registerRecipeSerializer(FungusShapelessRecipe.NAME, () -> new RecipeSerializer<>(FungusShapelessRecipeSerializer.MAP_CODEC, FungusShapelessRecipeSerializer.STREAM_CODEC));

    public static void init(){}
}
