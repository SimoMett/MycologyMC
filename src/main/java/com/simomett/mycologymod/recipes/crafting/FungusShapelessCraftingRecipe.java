package com.simomett.mycologymod.recipes.crafting;

import com.simomett.mycologymod.items.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

public class FungusShapelessCraftingRecipe extends ShapelessRecipe
{
    private final String speciesIngredient;
    private final ItemStack result;

    public FungusShapelessCraftingRecipe(String speciesIngredient, ItemStack result)
    {
        super("fungus_crafting_shapeless", CraftingBookCategory.MISC, result, List.of(
                Ingredient.of(ModItems.COLORED_CRIMSON_FUNGUS),
                Ingredient.of(ModItems.COLORED_WARPED_FUNGUS)));
        this.speciesIngredient = speciesIngredient;
        this.result = result;
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
    public RecipeSerializer<ShapelessRecipe> getSerializer()
    {
        return super.getSerializer();
    }
}
