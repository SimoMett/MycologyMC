package com.mettsmirnov.mycology.recipes.cooking;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class FungusCookingRecipe extends AbstractCookingRecipe
{
    private final String speciesIngredient;

    public FungusCookingRecipe(String speciesIngredient, ItemStack result, int stackSize, float exp, int cookingTime)
    {
        super(RecipeType.SMELTING, "fungus_cooking", CookingBookCategory.FOOD, Ingredient.of(ModItems.COLORED_CRIMSON_FUNGUS.get(), ModItems.COLORED_WARPED_FUNGUS.get(), ModItems.COLORED_RED_FUNGUS.get()), result, exp, cookingTime);
        this.result.setCount(stackSize);
        this.speciesIngredient = speciesIngredient;
    }

    public String getSpeciesIngredient()
    {
        return speciesIngredient;
    }

    public ItemStack getResult()
    {
        return this.result;
    }

    public int getCount()
    {
        return this.result.getCount();
    }

    @Override
    public boolean matches(Container container, Level level)
    {
        ItemStack input = container.getItem(0);
        if(input.getCapability(FungusDataCapability.INSTANCE).resolve().isEmpty())
            return false;
        FungusDataModel inputCapability = (FungusDataModel) input.getCapability(FungusDataCapability.INSTANCE).resolve().get();
        String inputSpecies = (String) inputCapability.getField("species", IFungusData.GeneType.DOMINANT);
        return inputSpecies.equals(speciesIngredient);
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModCookingRecipes.FUNGUS_COOKING_RECIPE_SERIALIZER.get();
    }
}
