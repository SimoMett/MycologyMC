package com.simomett.mycologymod.utils;

import net.minecraft.resources.ResourceLocation;

public class Utils
{
    public static ResourceLocation parseStringOrTag(String s)
    {
        return s.startsWith("#") ? ResourceLocation.tryParse(s.substring(1)) : ResourceLocation.tryParse(s);
    }
}
