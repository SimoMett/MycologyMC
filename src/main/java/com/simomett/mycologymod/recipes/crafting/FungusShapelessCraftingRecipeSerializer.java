package com.simomett.mycologymod.recipes.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class FungusShapelessCraftingRecipeSerializer implements RecipeSerializer<FungusShapelessCraftingRecipe>
{

    @Override
    public MapCodec<FungusShapelessCraftingRecipe> codec() {
        return RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        Codec.STRING.fieldOf("ingredient").forGetter(FungusShapelessCraftingRecipe::getSpeciesIngredient),
                        BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(FungusShapelessCraftingRecipe::getResult)
                ).apply(instance, FungusShapelessCraftingRecipe::new)
        );
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, FungusShapelessCraftingRecipe> streamCodec() {
        return null;
    }
}
