package com.simomett.mycologymod.recipes.breeding;

import com.google.gson.JsonElement;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Collection;
import java.util.Map;

public class MutationRecipeLoader extends SimpleJsonResourceReloadListener<JsonElement>
{
    public static final MutationRecipeLoader INSTANCE = new MutationRecipeLoader();

    private MutationRecipeLoader()
    {
        super(ExtraCodecs.JSON, FileToIdConverter.json("mutations"));
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> map, ResourceManager p_10794_, ProfilerFiller p_10795_)
    {
        Collection<JsonElement> collection = map.values();
        for(JsonElement e : collection)
            loadMutation(e);
    }

    public void loadMutation(JsonElement e)
    {
        String species1 = e.getAsJsonObject().get("species1").getAsString();
        String species2 = e.getAsJsonObject().get("species2").getAsString();
        String resultSpecies = e.getAsJsonObject().get("result").getAsString();
        float chance = e.getAsJsonObject().get("chance").getAsFloat();

        MutationRecipe recipe = new MutationRecipe(species1, species2, resultSpecies, chance);
        MutationRecipesList.addRecipe(recipe);
    }
}
