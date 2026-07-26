package com.simomett.mycologymod.recipes.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

public class FungusShapelessRecipeSerializer
{
    public static final MapCodec<FungusShapelessRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        Codec.STRING.fieldOf("ingredient").forGetter(FungusShapelessRecipe::getSpeciesIngredient),
                        BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter(FungusShapelessRecipe::getResult),
                        Codec.INT.fieldOf("count").forGetter(FungusShapelessRecipe::getCount)
                ).apply(instance, FungusShapelessRecipe::new)
        );

    public static final StreamCodec<RegistryFriendlyByteBuf, FungusShapelessRecipe> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, FungusShapelessRecipe::getSpeciesIngredient,
            ItemStack.STREAM_CODEC, FungusShapelessRecipe::getResult,
            ByteBufCodecs.INT, FungusShapelessRecipe::getCount,
            FungusShapelessRecipe::new
    );
}
