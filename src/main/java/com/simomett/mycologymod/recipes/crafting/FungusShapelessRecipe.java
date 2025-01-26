package com.simomett.mycologymod.recipes.crafting;

import com.simomett.mycologymod.recipes.ModRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;


import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

public class FungusShapelessRecipe implements CraftingRecipe
{
    public static final String NAME = "fungus_crafting_shapeless";
    private final String speciesIngredient;
    private final ItemStack result;

    public FungusShapelessRecipe(String speciesIngredient, ItemStack result)
    {
        this.speciesIngredient = speciesIngredient;
        this.result = result;
    }

    public FungusShapelessRecipe(String speciesIngredient, ItemStack result, Integer count)
    {
        this.speciesIngredient = speciesIngredient;
        this.result = new ItemStack(result.getItem(), count);
    }

    public String getSpeciesIngredient()
    {
        return speciesIngredient;
    }

    public ItemStack getResult()
    {
        return this.result.copy();
    }

    @Override
    public boolean matches(CraftingInput container, Level level)
    {
        ItemStack input = container.getItem(0);
        if(input.has(FUNGUS_GENOMA)) // of course 'input' can be 'air'
        {
            String inputSpecies = input.get(FUNGUS_GENOMA).getDominantTraits().species();
            return inputSpecies.equals(speciesIngredient);
        }
        return false;
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider)
    {
        return getResult();
    }

    @Override
    public PlacementInfo placementInfo()
    {
        return null;
    }

    @Override
    public RecipeSerializer<? extends CraftingRecipe> getSerializer()
    {
        return ModRecipes.FUNGUS_SHAPELESS_RECIPE_SERIALIZER.get();
    }

    @Override
    public CraftingBookCategory category()
    {
        return CraftingBookCategory.MISC;
    }

    public Integer getCount()
    {
        return result.getCount();
    }
}
