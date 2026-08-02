package com.simomett.mycologymod.data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipe;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipeLoader;
import com.simomett.mycologymod.items.potions.FungusIngredient;
import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;

import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class FabricFungusBrewingRecipesLoader implements SimpleResourceReloadListener<JsonElement>
{
    private static final Identifier fabricId = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fungi_brewing");
    private static final Gson GSON = new Gson();

    @Override
    public CompletableFuture<JsonElement> load(ResourceManager resourceManager, Executor executor)
    {
        return CompletableFuture.supplyAsync(() -> loadBrewingRecipe(resourceManager));
    }

    @Override
    public CompletableFuture<Void> apply(JsonElement o, ResourceManager resourceManager, Executor executor)
    {
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public Identifier getFabricId()
    {
        return fabricId;
    }

    private JsonElement loadBrewingRecipe(ResourceManager manager)
    {
        final int json_length = ".json".length();
        for(Map.Entry<Identifier, Resource> e : manager.listResources(fabricId.getPath(), r -> r.getPath().endsWith(".json")).entrySet())
        {
            Identifier id = e.getKey();
            String[] parts = id.getPath().split("/");
            String name = parts[parts.length - 1];
            name = name.substring(0, name.length() - json_length);

            try (var reader = new InputStreamReader(e.getValue().open()))
            {
                JsonObject g = GSON.fromJson(reader, JsonObject.class);
                FungusBrewingRecipeLoader.INSTANCE.loadBrewingRecipe(g);
                return g;
            }
            catch (Exception ignored)
            {
                Logger.getGlobal().severe("Couldn't load brewing recipe "+name);
            }
        }

        this.registerPotionsRecipes();
        return null;
    }

    private void registerPotionsRecipes()
    {
        FabricPotionBrewingBuilder.BUILD.register(builder -> {
            for(FungusBrewingRecipe r : FungusBrewingRecipeLoader.INSTANCE.getQueue())
            {
                builder.registerPotionRecipe(r.getInputPotion(), FungusIngredient.of(r.speciesName), BuiltInRegistries.POTION.wrapAsHolder(r.resultPotion.value()));
            }
        });
    }
}
