package com.mettsmirnov.mycology.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jline.utils.Log;

import javax.annotation.Nullable;
import java.util.Map;

public class FungusSpeciesLoader extends SimpleJsonResourceReloadListener
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static final FungusSpeciesLoader INSTANCE = new FungusSpeciesLoader();

    private FungusSpeciesLoader()
    {
        super(GSON, "fungi");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> map, ResourceManager resourceManager, ProfilerFiller p_10795_)
    {
        Log.info("REACHED");
    }
}
