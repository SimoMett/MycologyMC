package com.simomett.mycologymod.recipes.cooking;

import com.simomett.mycologymod.MycologyMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCookingRecipes
{
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, MycologyMod.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, FungusCookingRecipeSerializer> FUNGUS_COOKING_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("fungus_cooking", FungusCookingRecipeSerializer::new);
}
