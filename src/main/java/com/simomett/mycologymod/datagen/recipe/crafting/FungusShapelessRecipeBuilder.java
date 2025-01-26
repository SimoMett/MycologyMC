package com.simomett.mycologymod.datagen.recipe.crafting;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.recipes.cooking.FungusCookingRecipe;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipe;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.Nullable;

public class FungusShapelessRecipeBuilder implements RecipeBuilder
{
    protected final String speciesIngredient;
    protected final ItemStack result;

    public FungusShapelessRecipeBuilder(String speciesIngredient, ItemStack result)
    {
        this.speciesIngredient = speciesIngredient;
        this.result = result;
    }

    @Override
    public RecipeBuilder unlockedBy(String s, Criterion<?> criterion)
    {
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String s)
    {
        return this;
    }

    @Override
    public Item getResult() {
        return result.getItem();
    }

    @Override
    public void save(RecipeOutput output, ResourceKey<Recipe<?>> resKey)
    {
        output.accept(
                ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(
                        MycologyMod.MODID,
                        "shapeless_"+speciesIngredient.toLowerCase().replace(" ", "_"))),
                new FungusShapelessRecipe(speciesIngredient, result),
                null);
    }
}
