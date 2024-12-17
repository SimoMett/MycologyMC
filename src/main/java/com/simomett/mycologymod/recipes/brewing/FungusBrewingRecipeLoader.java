package com.simomett.mycologymod.recipes.brewing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.simomett.mycologymod.MycologyMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

import java.util.*;

@EventBusSubscriber(modid = MycologyMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class FungusBrewingRecipeLoader extends SimpleJsonResourceReloadListener<JsonElement>
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static final FungusBrewingRecipeLoader INSTANCE = new FungusBrewingRecipeLoader();

    private Stack<FungusBrewingRecipe> recipeQueue = new Stack<>();

    private FungusBrewingRecipeLoader()
    {
        super(ExtraCodecs.JSON, "fungi_brewing");
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
    }

    public FungusBrewingRecipe popFromQueue()
    {
        return recipeQueue.empty()? null : recipeQueue.pop();
    }

    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent evt)
    {
        PotionBrewing.Builder builder = evt.getBuilder();
        FungusBrewingRecipe poppedRecipe = null;
        do
        {
            poppedRecipe=INSTANCE.popFromQueue();
            if(poppedRecipe!=null)
            {
                builder.addRecipe(poppedRecipe);
                //TODO do the recipes need to be removed from BrewingRecipeRegistry when all the resources reload?
            }
        }
        while (poppedRecipe!=null);
    }
}
