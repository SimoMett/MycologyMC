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

public class FungusCookingRecipeSerializer
{
    public static final MapCodec<FungusCookingRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.STRING.fieldOf("ingredient").forGetter(FungusCookingRecipe::getSpeciesIngredient),
                    Recipe.CommonInfo.MAP_CODEC.forGetter(FungusCookingRecipe::commonInfo),
                    AbstractCookingRecipe.CookingBookInfo.MAP_CODEC.forGetter(FungusCookingRecipe::cookingBookInfo),
                    BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(FungusCookingRecipe::getResult),
                    Codec.FLOAT.fieldOf("experience").forGetter(FungusCookingRecipe::experience),
                    Codec.INT.fieldOf("cookingtime").forGetter(FungusCookingRecipe::cookingTime)
            ).apply(instance, FungusCookingRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, FungusCookingRecipe> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, FungusCookingRecipe::getSpeciesIngredient,
            Recipe.CommonInfo.STREAM_CODEC, FungusCookingRecipe::commonInfo,
            AbstractCookingRecipe.CookingBookInfo.STREAM_CODEC, FungusCookingRecipe::cookingBookInfo,
            ItemStack.STREAM_CODEC, FungusCookingRecipe::getResult,
            ByteBufCodecs.FLOAT, FungusCookingRecipe::experience,
            ByteBufCodecs.INT, FungusCookingRecipe::cookingTime,
            FungusCookingRecipe::new
    );
}
