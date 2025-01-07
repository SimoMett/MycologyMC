package com.simomett.mycologymod.recipes.cooking;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class FungusBlastingRecipeSerializer implements RecipeSerializer<FungusBlastingRecipe>
{
    @Override
    public MapCodec<FungusBlastingRecipe> codec()
    {
        return RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        Codec.STRING.fieldOf("ingredient").forGetter(FungusBlastingRecipe::getSpeciesIngredient),
                        BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(FungusBlastingRecipe::getResult),
                        Codec.FLOAT.fieldOf("experience").forGetter(FungusBlastingRecipe::experience),
                        Codec.INT.fieldOf("cookingtime").forGetter(FungusBlastingRecipe::cookingTime)
                ).apply(instance, FungusBlastingRecipe::new)
        );
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, FungusBlastingRecipe> streamCodec() {
        return null;
    }
}
