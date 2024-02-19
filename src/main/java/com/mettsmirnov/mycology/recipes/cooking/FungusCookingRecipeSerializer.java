package com.mettsmirnov.mycology.recipes.cooking;

import com.mojang.serialization.Codec;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

public class FungusCookingRecipeSerializer implements RecipeSerializer<FungusCookingRecipe>
{
    @Override
    public Codec<FungusCookingRecipe> codec()
    {
        return null;
    }

    @Override
    public @Nullable FungusCookingRecipe fromNetwork(FriendlyByteBuf friendlyByteBuf)
    {
        return null;
    }

    @Override
    public void toNetwork(FriendlyByteBuf friendlyByteBuf, FungusCookingRecipe fungusCookingRecipe)
    {

    }
}
