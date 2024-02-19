package com.mettsmirnov.mycology.recipes.cooking;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

public class FungusCookingRecipeSerializer implements RecipeSerializer<FungusCookingRecipe>
{
    @Override
    public Codec<FungusCookingRecipe> codec()
    {
        return RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("ingredient").forGetter(FungusCookingRecipe::getSpeciesIngredient),
                    BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(FungusCookingRecipe::getResult),
                    Codec.FLOAT.fieldOf("experience").orElse(0.0F).forGetter(FungusCookingRecipe::getExperience),
                    Codec.INT.fieldOf("cookingtime").orElse(200).forGetter(FungusCookingRecipe::getCookingTime)
            ).apply(instance, FungusCookingRecipe::new)
        );
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
