package com.mettsmirnov.mycology.recipes.cooking;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class FungusCookingRecipe extends AbstractCookingRecipe
{
    public static ResourceLocation TYPE_ID = new ResourceLocation(MycologyMod.MODID, "fungus_cooking");
    private final String speciesIngredient;

    private final ResourceLocation id;

    public FungusCookingRecipe(ResourceLocation id, String speciesIngredient, ItemStack result, float exp, int cookingTime)
    {
        super(RecipeType.SMELTING, "fungus_cooking", CookingBookCategory.FOOD, Ingredient.of(ModItems.COLORED_CRIMSON_FUNGUS.get()), result, exp, cookingTime);
        this.speciesIngredient = speciesIngredient;
        this.id = id;
    }

    public String getSpeciesIngredient()
    {
        return speciesIngredient;
    }

    @Override
    public boolean matches(Container container, Level p_43749_)
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

    @Override
    public ResourceLocation getId()
    {
        return id;
    }


}
