package com.simomett.mycologymod.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.simomett.mycologymod.Constants;
import net.fabricmc.fabric.api.resource.v1.reloader.SimpleReloadListener;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;

import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class FabricFungusSpeciesLoader extends SimpleReloadListener<Object>
{
    private static final Identifier fabricId = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fungi");
    private static final Gson GSON = new Gson();
    /*@Override
    public CompletableFuture<Object> load(ResourceManager manager, Executor executor)
    {
        return CompletableFuture.supplyAsync(() -> loadFungusSpecies(manager));
    }

    @Override
    public CompletableFuture<Void> apply(Object data, ResourceManager manager, Executor executor)
    {
        return CompletableFuture.completedFuture(null);
    }*/

    @Override
    protected Object prepare(SharedState state)
    {
        return loadFungusSpecies(state.resourceManager());
    }

    @Override
    protected void apply(Object data, SharedState state)
    {

    }

    public static Identifier getFabricId()
    {
        return fabricId;
    }

    private Object loadFungusSpecies(ResourceManager manager)
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
                FungusSpeciesLoader.INSTANCE.loadFungusSpecies(GSON.fromJson(reader, JsonObject.class));
            }
            catch (Exception ignored)
            {
                Logger.getGlobal().severe("Couldn't load species "+name);
            }
        }
        return null;
    }
}
