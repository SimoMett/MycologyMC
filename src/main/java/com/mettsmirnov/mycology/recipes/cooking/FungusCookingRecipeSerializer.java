package com.mettsmirnov.mycology.recipes.cooking;

import com.mojang.serialization.Codec;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

public class FungusCookingRecipeSerializer implements RecipeSerializer<FungusCookingRecipe>
{
    public FungusCookingRecipeSerializer()
    {

    }

    @Override
    public Codec<FungusCookingRecipe> codec() {
        return FungusCookingRecipe.CODEC;
    }

    @Nullable
    @Override
    public FungusCookingRecipe fromNetwork(FriendlyByteBuf p_44106_)
    {
        return null;
    }

    @Override
    public void toNetwork(FriendlyByteBuf p_44101_, FungusCookingRecipe p_44102_)
    {

    }
}
