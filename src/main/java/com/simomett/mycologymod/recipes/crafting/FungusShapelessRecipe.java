package com.simomett.mycologymod.recipes.crafting;

import com.simomett.mycologymod.items.ItemsDefinitions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;


import static com.simomett.mycologymod.datacomponents.DataComponentTypes.FUNGUS_GENOMA;
import static com.simomett.mycologymod.recipes.RecipesSerializers.FUNGUS_SHAPELESS_RECIPE_SERIALIZER;

public class FungusShapelessRecipe implements CraftingRecipe
{
    public static final String NAME = "fungus_crafting_shapeless";
    private final String speciesIngredient;
    private final Item resultItem;
    private final int stackSize;

    private PlacementInfo placementInfo;

    public FungusShapelessRecipe(String speciesIngredient, Item resultItem)
    {
        this(speciesIngredient, resultItem, 1);
    }

    public FungusShapelessRecipe(String speciesIngredient, Item resultItem, Integer count)
    {
        this.speciesIngredient = speciesIngredient;
        this.resultItem = resultItem;
        this.stackSize = count;
    }

    public FungusShapelessRecipe(String speciesIngredient, ItemStack itemStack, Integer count)
    {
        this(speciesIngredient, itemStack.getItem(), count);
    }

    public String getSpeciesIngredient()
    {
        return speciesIngredient;
    }

    public ItemStack getResult()
    {
        return this.resultItem.getDefaultInstance();
    }

    public Item getResultingItem()
    {
        return this.resultItem;
    }

    @Override
    public boolean matches(CraftingInput container, Level level)
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
    public ItemStack assemble(CraftingInput craftingInput)
    {
        return this.resultItem.getDefaultInstance();
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "";
    }

    @Override
    public PlacementInfo placementInfo()
    {
        if (this.placementInfo == null) {
            this.placementInfo = PlacementInfo.create(Ingredient.of(ItemsDefinitions.COLORED_CRIMSON_FUNGUS.get(), ItemsDefinitions.COLORED_WARPED_FUNGUS.get()));
        }

        return this.placementInfo;
    }

    @Override
    public RecipeSerializer<? extends CraftingRecipe> getSerializer()
    {
        return FUNGUS_SHAPELESS_RECIPE_SERIALIZER.get();
    }

    @Override
    public CraftingBookCategory category()
    {
        return CraftingBookCategory.MISC;
    }

    public Integer getCount()
    {
        return this.stackSize;
    }
}
