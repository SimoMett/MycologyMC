package com.simomett.mycologymod.recipes.cooking;

import com.simomett.mycologymod.items.ItemsDefinitions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import static com.simomett.mycologymod.datacomponents.DataComponentTypes.FUNGUS_GENOMA;
import static com.simomett.mycologymod.recipes.RecipesSerializers.FUNGUS_COOKING_RECIPE_SERIALIZER;

public class FungusCookingRecipe extends AbstractCookingRecipe
{
    private final Recipe.CommonInfo commonInfo;
    private final CookingBookInfo cookingBookInfo;
    private final String speciesIngredient;

    public FungusCookingRecipe(String speciesIngredient, Recipe.CommonInfo commonInfo, CookingBookInfo cookingBookInfo, ItemStack result, float exp, int cookingTime)
    {
        super(commonInfo, cookingBookInfo, Ingredient.of(ItemsDefinitions.COLORED_CRIMSON_FUNGUS.get(), ItemsDefinitions.COLORED_WARPED_FUNGUS.get()), ItemStackTemplate.fromNonEmptyStack(result), exp, cookingTime);
        this.commonInfo = commonInfo;
        this.cookingBookInfo = cookingBookInfo;
        this.speciesIngredient = speciesIngredient;
    }

    public Recipe.CommonInfo commonInfo()
    {
        return this.commonInfo;
    }

    public CookingBookInfo cookingBookInfo()
    {
        return this.cookingBookInfo;
    }

    public String getSpeciesIngredient()
    {
        return speciesIngredient;
    }

    public ItemStack getResult()
    {
        return this.result().create();
    }

    public int getCount()
    {
        return this.getResult().getCount();
    }

    @Override
    public boolean matches(SingleRecipeInput container, Level level)
    {
        ItemStack input = container.getItem(0);
        if(input.has(FUNGUS_GENOMA.dataComponentType())) // of course 'input' can be 'air'
        {
            String inputSpecies = input.get(FUNGUS_GENOMA.dataComponentType()).dominantTraits().species();
            return inputSpecies.equals(speciesIngredient);
        }
        return false;
    }

    @Override
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer()
    {
        return FUNGUS_COOKING_RECIPE_SERIALIZER.get();
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
