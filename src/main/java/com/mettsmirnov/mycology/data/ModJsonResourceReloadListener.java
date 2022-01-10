package com.mettsmirnov.mycology.data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Map;

public class ModJsonResourceReloadListener extends SimpleJsonResourceReloadListener
{
    public static ModJsonResourceReloadListener INSTANCE = new ModJsonResourceReloadListener();
    public ModJsonResourceReloadListener()
    {
        super(new Gson(), "data/"+ MycologyMod.MODID);
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> p_10793_, ResourceManager p_10794_, ProfilerFiller p_10795_)
    {

    }
}
