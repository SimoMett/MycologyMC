package com.simomett.mycologymod.recipes;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.recipes.cooking.FungusBlastingRecipeSerializer;
import com.simomett.mycologymod.recipes.cooking.FungusCookingRecipeSerializer;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipe;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes
{
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, MycologyMod.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, FungusCookingRecipeSerializer> FUNGUS_COOKING_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("fungus_cooking", FungusCookingRecipeSerializer::new);
    public static final DeferredHolder<RecipeSerializer<?>, FungusBlastingRecipeSerializer> FUNGUS_BLASTING_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("fungus_blasting", FungusBlastingRecipeSerializer::new);

    public static final DeferredHolder<RecipeSerializer<?>, FungusShapelessRecipeSerializer> FUNGUS_SHAPELESS_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register(FungusShapelessRecipe.NAME, FungusShapelessRecipeSerializer::new);
}
