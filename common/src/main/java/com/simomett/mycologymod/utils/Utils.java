package com.simomett.mycologymod.utils;

import net.minecraft.resources.Identifier;

public class Utils
{
    public static Identifier parseStringOrTag(String s)
    {
        return s.startsWith("#") ? Identifier.tryParse(s.substring(1)) : Identifier.tryParse(s);
    }
}
