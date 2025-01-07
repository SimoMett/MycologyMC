package com.simomett.mycologymod.recipes.cooking;

import com.simomett.mycologymod.items.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

public class FungusCookingRecipe extends AbstractCookingRecipe
{
    private final String speciesIngredient;

    public FungusCookingRecipe(String speciesIngredient, ItemStack result, float exp, int cookingTime)
    {
        super("fungus_cooking", CookingBookCategory.FOOD, Ingredient.of(ModItems.COLORED_CRIMSON_FUNGUS, ModItems.COLORED_WARPED_FUNGUS), result, exp, cookingTime);
        this.speciesIngredient = speciesIngredient;
    }

    public FungusCookingRecipe(String speciesIngredient, ItemStack result, int stackSize, float exp, int cookingTime)
    {
        this(speciesIngredient, result, exp, cookingTime);
        this.result().setCount(stackSize);
    }

    public String getSpeciesIngredient()
    {
        return speciesIngredient;
    }

    public ItemStack getResult()
    {
        return this.result();
    }

    public int getCount()
    {
        return this.result().getCount();
    }

    @Override
    public boolean matches(SingleRecipeInput container, Level level)
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
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer()
    {
        return ModCookingRecipes.FUNGUS_COOKING_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends AbstractCookingRecipe> getType()
    {
        //This is actually what makes the recipe usable in the "furnace"
        return RecipeType.SMELTING;
    }

    @Override
    public RecipeBookCategory recipeBookCategory()
    {
        return RecipeBookCategories.FURNACE_MISC;
    }

    @Override
    protected Item furnaceIcon()
    {
        return Items.FURNACE;
    }
}
