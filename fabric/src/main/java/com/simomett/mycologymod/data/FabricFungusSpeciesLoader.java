package com.simomett.mycologymod.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.simomett.mycologymod.Constants;
import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;

import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class FabricFungusSpeciesLoader implements SimpleResourceReloadListener<Object>
{
    private static final ResourceLocation fabricId = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "fungi");
    private static final Gson GSON = new Gson();
    @Override
    public CompletableFuture<Object> load(ResourceManager manager, Executor executor)
    {
        return CompletableFuture.supplyAsync(() -> loadFungusSpecies(manager));
    }

    @Override
    public CompletableFuture<Void> apply(Object data, ResourceManager manager, Executor executor)
    {
        return CompletableFuture.completedFuture(null);
    }

    private Object loadFungusSpecies(ResourceManager manager)
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
                FungusSpeciesLoader.INSTANCE.loadFungusSpecies(GSON.fromJson(reader, JsonObject.class));
            }
            catch (Exception ignored)
            {
                Logger.getGlobal().severe("Couldn't load species "+name);
            }
        }
        return null;
    }

    @Override
    public ResourceLocation getFabricId()
    {
        return fabricId;
    }
}
