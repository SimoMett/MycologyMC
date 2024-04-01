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
        // It's not necessary to call for each field "orElse()", because every field is always initialized
        return RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("ingredient").forGetter(FungusCookingRecipe::getSpeciesIngredient),
                    BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(FungusCookingRecipe::getResult),
                    Codec.INT.fieldOf("count").forGetter(FungusCookingRecipe::getCount),
                    Codec.FLOAT.fieldOf("experience").forGetter(FungusCookingRecipe::getExperience),
                    Codec.INT.fieldOf("cookingtime").forGetter(FungusCookingRecipe::getCookingTime)
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
