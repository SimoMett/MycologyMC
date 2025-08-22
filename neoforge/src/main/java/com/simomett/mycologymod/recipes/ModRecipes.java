package com.simomett.mycologymod.recipes;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.recipes.cooking.FungusBlastingRecipe;
import com.simomett.mycologymod.recipes.cooking.FungusBlastingRecipeSerializer;
import com.simomett.mycologymod.recipes.cooking.FungusCookingRecipeSerializer;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipe;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes
{
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, Constants.MOD_ID);
}
