package com.simomett.mycologymod.data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.recipes.breeding.MutationRecipeLoader;
import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;

import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class FabricMutationRecipesLoader implements SimpleResourceReloadListener<JsonElement>
{
    private static final Identifier fabricId = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "mutations");
    private static final Gson GSON = new Gson();

    @Override
    public CompletableFuture<JsonElement> load(ResourceManager manager, Executor executor)
    {
        return CompletableFuture.supplyAsync(() -> loadMutations(manager));
    }

    private JsonElement loadMutations(ResourceManager manager)
    {
        final String json = ".json";
        for(Map.Entry<Identifier, Resource> e : manager.listResources(fabricId.getPath(), r -> r.getPath().endsWith(json)).entrySet())
        {
            Identifier id = e.getKey();
            String[] parts = id.getPath().split("/");
            String name = parts[parts.length - 1];
            name = name.substring(0, name.length() - json.length());

            try (var reader = new InputStreamReader(e.getValue().open()))
            {
                MutationRecipeLoader.INSTANCE.loadMutation(GSON.fromJson(reader, JsonObject.class));
            }
            catch (Exception ignored)
            {
                Logger.getGlobal().severe("Couldn't load species "+name);
            }
        }
        return null;
    }

    @Override
    public CompletableFuture<Void> apply(JsonElement data, ResourceManager manager, Executor executor)
    {
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public Identifier getFabricId()
    {
        return fabricId;
    }
}
