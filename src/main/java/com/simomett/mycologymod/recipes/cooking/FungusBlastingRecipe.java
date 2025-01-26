package com.simomett.mycologymod.recipes.cooking;

import com.simomett.mycologymod.items.ModItems;
import com.simomett.mycologymod.recipes.ModRecipes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

public class FungusBlastingRecipe extends AbstractCookingRecipe
{
    public static final String NAME = "fungus_blasting";
    private final String speciesIngredient;

    public FungusBlastingRecipe(String speciesIngredient, ItemStack result, float exp, int cookingTime)
    {
        super(NAME, CookingBookCategory.MISC, Ingredient.of(ModItems.COLORED_CRIMSON_FUNGUS, ModItems.COLORED_WARPED_FUNGUS), result, exp, cookingTime);
        this.speciesIngredient = speciesIngredient;
    }

    public FungusBlastingRecipe(String speciesIngredient, ItemStack result, Integer stackSize, float exp, int cookingTime)
    {
        super(NAME, CookingBookCategory.MISC, Ingredient.of(ModItems.COLORED_CRIMSON_FUNGUS, ModItems.COLORED_WARPED_FUNGUS), new ItemStack(result.getItem(), stackSize), exp, cookingTime);
        this.speciesIngredient = speciesIngredient;
    }

    public String getSpeciesIngredient()
    {
        return speciesIngredient;
    }

    public ItemStack getResult()
    {
        return this.result().copy();
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
        return ModRecipes.FUNGUS_BLASTING_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends AbstractCookingRecipe> getType()
    {
        return RecipeType.BLASTING;
    }

    @Override
    public RecipeBookCategory recipeBookCategory()
    {
        return RecipeBookCategories.BLAST_FURNACE_MISC;
    }

    @Override
    protected Item furnaceIcon()
    {
        return Items.BLAST_FURNACE;
    }
}
