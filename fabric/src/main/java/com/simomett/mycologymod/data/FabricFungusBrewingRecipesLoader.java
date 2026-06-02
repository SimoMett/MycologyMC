package com.simomett.mycologymod.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipe;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipeLoader;
import com.simomett.mycologymod.items.potions.FungusIngredient;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;

import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class FabricFungusBrewingRecipesLoader implements SimpleResourceReloadListener<Object>
{
    private static final ResourceLocation fabricId = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "fungi_brewing");
    private static final Gson GSON = new Gson();

    @Override
    public CompletableFuture<Object> load(ResourceManager resourceManager, Executor executor)
    {
        return CompletableFuture.supplyAsync(() -> loadBrewingRecipe(resourceManager));
    }

    @Override
    public CompletableFuture<Void> apply(Object o, ResourceManager resourceManager, Executor executor)
    {
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public ResourceLocation getFabricId()
    {
        return fabricId;
    }

    private Object loadBrewingRecipe(ResourceManager manager)
    {
        final String json = ".json";
        for(Map.Entry<ResourceLocation, Resource> e : manager.listResources(fabricId.getPath(), r -> r.getPath().endsWith(json)).entrySet())
        {
            ResourceLocation id = e.getKey();
            String[] parts = id.getPath().split("/");
            String name = parts[parts.length - 1];
            name = name.substring(0, name.length() - json.length());

            try (var reader = new InputStreamReader(e.getValue().open()))
            {
                FungusBrewingRecipeLoader.INSTANCE.loadBrewingRecipe(GSON.fromJson(reader, JsonObject.class));
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
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            for(FungusBrewingRecipe r : FungusBrewingRecipeLoader.INSTANCE.getQueue())
            {
                builder.registerPotionRecipe(r.getInputPotion(), FungusIngredient.of(r.speciesName), BuiltInRegistries.POTION.wrapAsHolder(r.resultPotion.value()));
            }
        });
    }
}
