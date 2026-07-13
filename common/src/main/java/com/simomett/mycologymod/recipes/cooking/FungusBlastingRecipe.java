package com.simomett.mycologymod.recipes.cooking;

import com.simomett.mycologymod.items.ItemsDefinitions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import static com.simomett.mycologymod.datacomponents.DataComponentTypes.FUNGUS_GENOMA;
import static com.simomett.mycologymod.recipes.RecipesSerializers.FUNGUS_BLASTING_RECIPE_SERIALIZER;

public class FungusBlastingRecipe extends AbstractCookingRecipe
{
    private final Recipe.CommonInfo commonInfo;
    private final CookingBookInfo cookingBookInfo;
    public static final String NAME = "fungus_blasting";
    private final String speciesIngredient;

    public FungusBlastingRecipe(String speciesIngredient, Recipe.CommonInfo commonInfo, CookingBookInfo cookingBookInfo, ItemStack result, float exp, int cookingTime)
    {
        super(commonInfo, cookingBookInfo, Ingredient.of(ItemsDefinitions.COLORED_CRIMSON_FUNGUS.get(), ItemsDefinitions.COLORED_WARPED_FUNGUS.get()), ItemStackTemplate.fromNonEmptyStack(result), exp, cookingTime);
        this.speciesIngredient = speciesIngredient;
        this.commonInfo = commonInfo;
        this.cookingBookInfo = cookingBookInfo;
    }

    public String getSpeciesIngredient()
    {
        return speciesIngredient;
    }

    public Recipe.CommonInfo commonInfo()
    {
        return this.commonInfo;
    }

    public CookingBookInfo cookingBookInfo()
    {
        return this.cookingBookInfo;
    }

    public ItemStack getResult()
    {
        return this.result().create();
    }

    public int getCount()
    {
        return this.result().count();
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
        return FUNGUS_BLASTING_RECIPE_SERIALIZER.get();
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
