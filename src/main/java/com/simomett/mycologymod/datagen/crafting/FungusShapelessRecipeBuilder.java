package com.simomett.mycologymod.datagen.crafting;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipe;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.Nullable;

public class FungusShapelessRecipeBuilder implements RecipeBuilder
{
    protected final String speciesIngredient;
    protected final Item result;
    protected final int stackSize;

    public FungusShapelessRecipeBuilder(String speciesIngredient, Item result, int count)
    {
        this.speciesIngredient = speciesIngredient;
        this.result = result;
        this.stackSize = count;
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
    public ResourceKey<Recipe<?>> defaultId()
    {
        return null;
    }

    @Override
    public void save(RecipeOutput output, ResourceKey<Recipe<?>> resKey)
    {
        output.accept(
                ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(
                        Constants.MOD_ID,
                        "shapeless_"+speciesIngredient.toLowerCase().replace(" ", "_"))),
                new FungusShapelessRecipe(speciesIngredient, result, stackSize),
                null);
    }
}
