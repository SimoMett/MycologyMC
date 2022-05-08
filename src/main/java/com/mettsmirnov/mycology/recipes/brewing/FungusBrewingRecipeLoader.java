package com.mettsmirnov.mycology.recipes.brewing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import org.jline.utils.Log;

import java.util.*;

public class FungusBrewingRecipeLoader extends SimpleJsonResourceReloadListener
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static final FungusBrewingRecipeLoader INSTANCE = new FungusBrewingRecipeLoader();

    private Stack<FungusBrewingRecipe> recipeQueue = new Stack<>();

    private FungusBrewingRecipeLoader()
    {
        super(GSON, "fungi_brewing");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> map, ResourceManager p_10794_, ProfilerFiller p_10795_)
    {
        Collection<JsonElement> collection = map.values();
        for(JsonElement e : collection)
        {
            String species = e.getAsJsonObject().get("species").getAsString();
            String resultPotion = e.getAsJsonObject().get("result").getAsString();

            FungusBrewingRecipe recipe = new FungusBrewingRecipe(species,resultPotion);
            recipeQueue.push(recipe);
        }
        register();
    }

    public FungusBrewingRecipe popFromQueue()
    {
        return recipeQueue.empty()? null : recipeQueue.pop();
    }

    public void register()
    {
        FungusBrewingRecipe poppedRecipe = null;
        do
        {
            poppedRecipe=popFromQueue();
            if(poppedRecipe!=null)
            {
                BrewingRecipeRegistry.addRecipe(poppedRecipe);
                Log.info(poppedRecipe.species);
            }
        }
        while (poppedRecipe!=null);
    }
}
