package com.mettsmirnov.mycology.recipes.cooking;

import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.MycologyMod;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

public class FungusCookingRecipeSerializer implements RecipeSerializer<FungusCookingRecipe>
{
    private final Codec<FungusCookingRecipe> codec;
    /*@Override
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
    }*/

    public FungusCookingRecipeSerializer()
    {
        codec = RecordCodecBuilder.create(instance -> instance.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(FungusCookingRecipe::getSpeciesIngredient),
                BuiltInRegistries.ITEM.byNameCodec().xmap(ItemStack::new, ItemStack::getItem).fieldOf("result").forGetter((p_296923_) -> {
                    return p_296923_.result;
                }),
                Codec.FLOAT.fieldOf("experience").orElse(0.0F).forGetter((p_296922_) -> {
                    return p_296922_.experience;
                }),
                Codec.INT.fieldOf("cookingtime").orElse(p_44331_).forGetter((p_296919_) -> {
                    return p_296919_.cookingTime;
                }
        ).apply(instance, FungusCookingRecipe::new)));
    }

    @Override
    public Codec<FungusCookingRecipe> codec() {
        return codec;
    }

    @Nullable
    @Override
    public FungusCookingRecipe fromNetwork(FriendlyByteBuf p_44106_)
    {
        return null;
    }

    @Override
    public void toNetwork(FriendlyByteBuf p_44101_, FungusCookingRecipe p_44102_)
    {

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
