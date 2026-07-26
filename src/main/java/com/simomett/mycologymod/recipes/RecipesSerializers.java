package com.simomett.mycologymod.recipes;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.recipes.cooking.FungusBlastingRecipe;
import com.simomett.mycologymod.recipes.cooking.FungusBlastingRecipeSerializer;
import com.simomett.mycologymod.recipes.cooking.FungusCookingRecipe;
import com.simomett.mycologymod.recipes.cooking.FungusCookingRecipeSerializer;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipe;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipeSerializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class RecipesSerializers
{
    private static  <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String recipeSerializerName, Supplier<T> supplier)
    {
        var tt = Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, recipeSerializerName),
                supplier.get());

        return () -> tt;
    }

    public static final Supplier<RecipeSerializer<FungusCookingRecipe>> FUNGUS_COOKING_RECIPE_SERIALIZER = registerRecipeSerializer("fungus_cooking", ()-> new RecipeSerializer<>(FungusCookingRecipeSerializer.MAP_CODEC, FungusCookingRecipeSerializer.STREAM_CODEC));
    public static final Supplier<RecipeSerializer<FungusBlastingRecipe>> FUNGUS_BLASTING_RECIPE_SERIALIZER = registerRecipeSerializer(FungusBlastingRecipe.NAME, () -> new RecipeSerializer<>(FungusBlastingRecipeSerializer.MAP_CODEC, FungusBlastingRecipeSerializer.STREAM_CODEC));
    public static final Supplier<RecipeSerializer<FungusShapelessRecipe>> FUNGUS_SHAPELESS_RECIPE_SERIALIZER = registerRecipeSerializer(FungusShapelessRecipe.NAME, () -> new RecipeSerializer<>(FungusShapelessRecipeSerializer.MAP_CODEC, FungusShapelessRecipeSerializer.STREAM_CODEC));

    public static void init(){}
}
