package com.simomett.mycologymod.recipes.crafting;

import com.simomett.mycologymod.items.ItemsDefinitions;
import net.minecraft.core.Holder;
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
    private final Item result;
    private final Integer stackSize;

    private PlacementInfo placementInfo;

    public FungusShapelessRecipe(String speciesIngredient, Item result, Integer count)
    {
        this.speciesIngredient = speciesIngredient;
        this.result = result;
        this.stackSize = count;
    }

    public FungusShapelessRecipe(String speciesIngredient, Item result)
    {
        this(speciesIngredient, result, 1);
    }

    public FungusShapelessRecipe(String speciesIngredient, Holder<Item> itemHolder, Integer count)
    {
        this(speciesIngredient, itemHolder.value(), count);
    }

    public String getSpeciesIngredient()
    {
        return speciesIngredient;
    }

    public Item getResultItem()
    {
        return result;
    }

    public Holder<Item> getResultItemHolder()
    {
        return Holder.direct(result);
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
        return new ItemStack(result, stackSize);
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
        return stackSize;
    }
}
