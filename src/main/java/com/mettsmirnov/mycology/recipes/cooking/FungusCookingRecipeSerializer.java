package com.mettsmirnov.mycology.recipes.cooking;

import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShieldDecorationRecipe;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.extensions.IForgeRecipeSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

public class FungusCookingRecipeSerializer implements RecipeSerializer<FungusCookingRecipe>
{
    @Override
    public FungusCookingRecipe fromJson(ResourceLocation p_44103_, JsonObject jsonObject) //TODO need testing
    {
        FungusCookingRecipe result = null;
        if(jsonObject.get("type").getAsString().equals(MycologyMod.MODID+":fungus_cooking"))
        {
            String speciesIngredient = jsonObject.get("ingredient").getAsJsonObject().get("species").getAsString();

            //Just for testing purposes
            float experience = jsonObject.get("experience").getAsFloat();
            int cookingTime = jsonObject.get("cookingtime").getAsInt();
            ItemStack outputItemStack = ShapedRecipe.itemStackFromJson(jsonObject.get("result").getAsJsonObject());
            result = new FungusCookingRecipe(speciesIngredient, outputItemStack, experience, cookingTime);
        }
        return result;
    }

    @Nullable
    @Override
    public FungusCookingRecipe fromNetwork(ResourceLocation p_44105_, FriendlyByteBuf p_44106_)
    {
        return null;
    }

    @Override
    public void toNetwork(FriendlyByteBuf p_44101_, FungusCookingRecipe p_44102_)
    {

    }

    @Override
    public RecipeSerializer<?> setRegistryName(ResourceLocation name)
    {
        return null;
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName()
    {
        return new ResourceLocation(MycologyMod.MODID, "fungus_cooking");
    }

    @Override
    public Class<RecipeSerializer<?>> getRegistryType()
    {
        return null;
    }
}
