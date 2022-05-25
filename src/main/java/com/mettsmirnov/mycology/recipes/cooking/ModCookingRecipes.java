package com.mettsmirnov.mycology.recipes.cooking;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModCookingRecipes
{
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MycologyMod.MODID);

    public static final RegistryObject<FungusCookingRecipeSerializer> FUNGUS_COOKING_RECIPE_SERIALIZER = RECIPES.register("fungus_cooking",FungusCookingRecipeSerializer::new);
}
