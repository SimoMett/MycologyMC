package com.simomett.mycologymod.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static com.simomett.mycologymod.Constants.MOD_ID;

public class ModItemTags
{
    public static final TagKey<Item> COLORED_FUNGUS_ITEMS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, "colored_fungus_items"));
}
