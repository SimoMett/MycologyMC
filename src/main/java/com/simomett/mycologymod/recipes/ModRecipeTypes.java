package com.simomett.mycologymod.recipes;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.recipes.cooking.FungusCookingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeTypes
{
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, MycologyMod.MODID);

    public static final DeferredHolder<RecipeType<?>, RecipeType<FungusCookingRecipe>> FUNGUS_COOKING_RECIPE_TYPE = RECIPE_TYPES.register("fungus_cooking", registryName -> new RecipeType<>() {
        @Override
        public String toString() {
            return registryName.toString();
        }
    });
}
