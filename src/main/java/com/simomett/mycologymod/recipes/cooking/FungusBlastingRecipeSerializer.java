package com.simomett.mycologymod.recipes.cooking;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Recipe;

public class FungusBlastingRecipeSerializer
{
    public static final MapCodec<FungusBlastingRecipe> MAP_CODEC =  RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        Codec.STRING.fieldOf("ingredient").forGetter(FungusBlastingRecipe::getSpeciesIngredient),
                        Recipe.CommonInfo.MAP_CODEC.forGetter(FungusBlastingRecipe::commonInfo),
                        AbstractCookingRecipe.CookingBookInfo.MAP_CODEC.forGetter(FungusBlastingRecipe::cookingBookInfo),
                        BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(FungusBlastingRecipe::getResult),
                        Codec.FLOAT.fieldOf("experience").forGetter(FungusBlastingRecipe::experience),
                        Codec.INT.fieldOf("cookingtime").forGetter(FungusBlastingRecipe::cookingTime)
                ).apply(instance, FungusBlastingRecipe::new)
        );

    public static final StreamCodec<RegistryFriendlyByteBuf, FungusBlastingRecipe> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, FungusBlastingRecipe::getSpeciesIngredient,
            Recipe.CommonInfo.STREAM_CODEC, FungusBlastingRecipe::commonInfo,
            AbstractCookingRecipe.CookingBookInfo.STREAM_CODEC, FungusBlastingRecipe::cookingBookInfo,
            ItemStack.STREAM_CODEC, FungusBlastingRecipe::getResult,
            ByteBufCodecs.FLOAT, FungusBlastingRecipe::experience,
            ByteBufCodecs.INT, FungusBlastingRecipe::cookingTime,
            FungusBlastingRecipe::new
    );
}
