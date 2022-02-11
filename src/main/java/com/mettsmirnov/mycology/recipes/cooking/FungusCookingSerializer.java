package com.mettsmirnov.mycology.recipes.cooking;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;

public class FungusCookingSerializer extends SimpleCookingSerializer<SmeltingRecipe>
{
    public FungusCookingSerializer(int defaultCookingTime)
    {
        super(null, defaultCookingTime);
    }
}
