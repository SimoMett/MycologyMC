package com.mettsmirnov.mycology.recipes.breeding;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Collection;
import java.util.Map;
import java.util.Stack;

public class MutationRecipeLoader extends SimpleJsonResourceReloadListener
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static final MutationRecipeLoader INSTANCE = new MutationRecipeLoader();

    private Stack<MutationRecipe> recipeQueue = new Stack<>();

    private MutationRecipeLoader()
    {
        super(GSON, "mutations");
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
            recipeQueue.push(recipe);
        }
        register();
    }

    public MutationRecipe popFromQueue()
    {
        return recipeQueue.empty()? null : recipeQueue.pop();
    }

    public void register()
    {
        MutationRecipe poppedRecipe = null;
        do
        {
            poppedRecipe=popFromQueue();
            if(poppedRecipe!=null)
            {
                MutationRecipesList.addRecipe(poppedRecipe);
            }
        }
        while (poppedRecipe!=null);
    }
}
