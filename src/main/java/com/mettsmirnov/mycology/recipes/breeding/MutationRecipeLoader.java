package com.mettsmirnov.mycology.recipes.breeding;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mettsmirnov.mycology.recipes.brewing.FungusBrewingRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import org.jline.utils.Log;

import java.util.Collection;
import java.util.Map;
import java.util.Stack;

public class FungusBreedingRecipeLoader extends SimpleJsonResourceReloadListener
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static final FungusBreedingRecipeLoader INSTANCE = new FungusBreedingRecipeLoader();

    private Stack<FungusBreedingRecipe> recipeQueue = new Stack<>();

    private FungusBreedingRecipeLoader()
    {
        super(GSON, "fungi_breeding");
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

            FungusBreedingRecipe recipe = new FungusBreedingRecipe(species1, species2, resultSpecies);
            recipeQueue.push(recipe);
        }
        register();
    }

    public FungusBreedingRecipe popFromQueue()
    {
        return recipeQueue.empty()? null : recipeQueue.pop();
    }

    public void register()
    {
        FungusBreedingRecipe poppedRecipe = null;
        do
        {
            poppedRecipe=popFromQueue();
            if(poppedRecipe!=null)
            {
                BreedingRecipeRegistry.addRecipe(poppedRecipe);
            }
        }
        while (poppedRecipe!=null);
    }
}
