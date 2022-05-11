package com.mettsmirnov.mycology.recipes.cooking;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.extensions.IForgeRecipeSerializer;

public class FungusCookingRecipeSerializer implements IForgeRecipeSerializer<FungusCookingRecipe>
{
    @Override
    public FungusCookingRecipe fromJson(ResourceLocation recipeLoc, JsonObject recipeJson, ICondition.IContext context)
    {
        return IForgeRecipeSerializer.super.fromJson(recipeLoc, recipeJson, context);
    }
}
