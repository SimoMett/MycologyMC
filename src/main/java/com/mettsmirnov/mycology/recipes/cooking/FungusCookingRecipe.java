package com.mettsmirnov.mycology.recipes.cooking;

import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class FungusCookingRecipe extends AbstractCookingRecipe
{
    public String speciesIngredient;

    public FungusCookingRecipe(ResourceLocation id, String speciesIngredient, ItemStack result, float exp, int cookingTime)
    {
        super(RecipeType.SMELTING, id, "funguscooking", Ingredient.of(ModItems.COLORED_CRIMSON_FUNGUS.get()), result, exp, cookingTime);
        this.speciesIngredient = speciesIngredient;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModCookingRecipes.FUNGUS_COOKING_RECIPE_SERIALIZER.get();
    }
}
