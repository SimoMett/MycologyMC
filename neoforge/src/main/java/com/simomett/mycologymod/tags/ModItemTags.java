package com.simomett.mycologymod.tags;

import com.simomett.mycologymod.MycologyMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags
{
    public static final TagKey<Item> COLORED_FUNGUS_ITEMS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "colored_fungus_items"));
}
