package com.mettsmirnov.mycology.recipes.cooking;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.items.ModItems;
import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class FungusCookingRecipe extends AbstractCookingRecipe
{
    public static ResourceLocation TYPE_ID = new ResourceLocation(MycologyMod.MODID, "funguscooking");
    public String speciesIngredient;

    public FungusCookingRecipe(String speciesIngredient, ItemStack result, float exp, int cookingTime)
    {
        super(RecipeType.SMELTING, TYPE_ID, "funguscooking", Ingredient.of(ModItems.COLORED_CRIMSON_FUNGUS.get()), result, exp, cookingTime);
        this.speciesIngredient = speciesIngredient;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModCookingRecipes.FUNGUS_COOKING_RECIPE_SERIALIZER.get();
    }
}
