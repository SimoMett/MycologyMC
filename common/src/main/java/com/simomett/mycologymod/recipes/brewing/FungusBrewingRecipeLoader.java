package com.simomett.mycologymod.recipes.brewing;

import com.google.gson.JsonElement;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class FungusBrewingRecipeLoader extends SimpleJsonResourceReloadListener<JsonElement>
{
    public static final FungusBrewingRecipeLoader INSTANCE = new FungusBrewingRecipeLoader();

    private final ArrayList<FungusBrewingRecipe> recipeQueue = new ArrayList<>();

    private FungusBrewingRecipeLoader()
    {
        super(ExtraCodecs.JSON, FileToIdConverter.json("fungi_brewing"));
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> map, ResourceManager p_10794_, ProfilerFiller p_10795_)
    {
        Collection<JsonElement> collection = map.values();
        for(JsonElement e : collection)
        {
            String species = e.getAsJsonObject().get("species").getAsString();
            String resultPotion = e.getAsJsonObject().get("result").getAsString();

            recipeQueue.add(new FungusBrewingRecipe(Potions.AWKWARD, Items.POTION, species, resultPotion));
            recipeQueue.add(new FungusBrewingRecipe(Potions.AWKWARD, Items.SPLASH_POTION, species, resultPotion));
            recipeQueue.add(new FungusBrewingRecipe(Potions.AWKWARD, Items.LINGERING_POTION, species, resultPotion));
        }
    }

    public ArrayList<FungusBrewingRecipe> getQueue()
    {
        return recipeQueue;
    }
}