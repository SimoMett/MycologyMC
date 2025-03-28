package com.simomett.mycologymod.recipes.breeding;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Collection;
import java.util.Map;

public class MutationRecipeLoader extends SimpleJsonResourceReloadListener<JsonElement>
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static final MutationRecipeLoader INSTANCE = new MutationRecipeLoader();

    private MutationRecipeLoader()
    {
        super(ExtraCodecs.JSON, "mutations");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> map, ResourceManager p_10794_, ProfilerFiller p_10795_)
    {
        Collection<JsonElement> collection = map.values();
        for(JsonElement e : collection)
        {
            String species1 = e.getAsJsonObject().get("species1").getAsString();
            String species2 = e.getAsJsonObject().get("species2").getAsString();
            String resultSpecies = e.getAsJsonObject().get("result").getAsString();
            float chance = e.getAsJsonObject().get("chance").getAsFloat();

            MutationRecipe recipe = new MutationRecipe(species1, species2, resultSpecies, chance);
            MutationRecipesList.addRecipe(recipe);
        }
    }
}
