package com.simomett.mycologymod.recipes.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simomett.mycologymod.recipes.cooking.FungusCookingRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class FungusShapelessRecipeSerializer implements RecipeSerializer<FungusShapelessRecipe>
{

    @Override
    public MapCodec<FungusShapelessRecipe> codec() {
        return RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        Codec.STRING.fieldOf("ingredient").forGetter(FungusShapelessRecipe::getSpeciesIngredient),
                        BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(FungusShapelessRecipe::getResult),
                        Codec.INT.fieldOf("count").forGetter(FungusShapelessRecipe::getCount)
                ).apply(instance, FungusShapelessRecipe::new)
        );
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, FungusShapelessRecipe> streamCodec() {
        return null;
    }
}
