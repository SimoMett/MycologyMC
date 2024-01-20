package com.mettsmirnov.mycology.recipes.cooking;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import com.mettsmirnov.mycology.items.ModItems;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class FungusCookingRecipe extends AbstractCookingRecipe
{
    public static ResourceLocation TYPE_ID = new ResourceLocation(MycologyMod.MODID, "fungus_cooking");

    public static final Codec<FungusCookingRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("ingredient").forGetter(FungusCookingRecipe::getSpeciesIngredient),
            ItemStack.CODEC.fieldOf("result").forGetter( recipe -> recipe.result),
            Codec.FLOAT.fieldOf("experience").orElse(0.0F).forGetter(FungusCookingRecipe::getExperience),
            Codec.INT.fieldOf("cookingtime").orElse(200).forGetter(FungusCookingRecipe::getCookingTime))
        .apply(instance, FungusCookingRecipe::new));
    private final String speciesIngredient;


    public FungusCookingRecipe(String speciesIngredient, ItemStack result, float exp, int cookingTime)
    {
        super(RecipeType.SMELTING, "fungus_cooking", CookingBookCategory.FOOD, Ingredient.of(ModItems.COLORED_CRIMSON_FUNGUS.get()), result, exp, cookingTime);
        this.speciesIngredient = speciesIngredient;
    }

    public String getSpeciesIngredient()
    {
        return speciesIngredient;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_266851_)
    {
        return super.getResultItem(p_266851_);
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

}
