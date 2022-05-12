package com.mettsmirnov.mycology.recipes.cooking;

import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.extensions.IForgeRecipeSerializer;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

public class FungusCookingRecipeSerializer implements RecipeSerializer<SmeltingRecipe>
{

    @Override
    public SmeltingRecipe fromJson(ResourceLocation p_44103_, JsonObject jsonObject)
    {
        Log.info("Json Borne");
        return null;
    }

    @Nullable
    @Override
    public SmeltingRecipe fromNetwork(ResourceLocation p_44105_, FriendlyByteBuf p_44106_)
    {
        return null;
    }

    @Override
    public void toNetwork(FriendlyByteBuf p_44101_, SmeltingRecipe p_44102_)
    {

    }

    @Override
    public RecipeSerializer<?> setRegistryName(ResourceLocation name)
    {
        //FIXME can't return null
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
