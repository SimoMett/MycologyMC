package com.mettsmirnov.mycology.recipes.cooking;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class FungusCookingRecipe extends AbstractCookingRecipe
{
    public static ResourceLocation TYPE_ID = new ResourceLocation(MycologyMod.MODID, "fungus_cooking");
    public String speciesIngredient;

    private final ResourceLocation id;

    public FungusCookingRecipe(ResourceLocation id, String speciesIngredient, ItemStack result, float exp, int cookingTime)
    {
        super(RecipeType.SMELTING, TYPE_ID, "fungus_cooking", Ingredient.of(ModItems.COLORED_CRIMSON_FUNGUS.get()), result, exp, cookingTime);
        this.speciesIngredient = speciesIngredient;
        this.id = id;
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
