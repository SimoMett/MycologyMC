package com.mettsmirnov.mycology.recipes.cooking;

import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
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
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

public class FungusCookingRecipeSerializer implements RecipeSerializer<FungusCookingRecipe>
{
    @Override
    public FungusCookingRecipe fromJson(ResourceLocation id, JsonObject jsonObject) //TODO need testing
    {
        FungusCookingRecipe result = null;
        if(jsonObject.get("type").getAsString().equals(MycologyMod.MODID+":fungus_cooking"))
        {
            String speciesIngredient = jsonObject.get("ingredient").getAsJsonObject().get("species").getAsString();

            //Just for testing purposes
            float experience = jsonObject.get("experience").getAsFloat();
            int cookingTime = jsonObject.get("cookingtime").getAsInt();
            ResourceLocation itemId = new ResourceLocation(jsonObject.get("result").getAsString());
            result = new FungusCookingRecipe(id, speciesIngredient, new ItemStack(ForgeRegistries.ITEMS.getValue(itemId)), experience, cookingTime);
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
        //TODO?
    }

    /*@Override
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
    }*/
}
