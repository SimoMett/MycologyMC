package com.simomett.mycologymod.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static com.simomett.mycologymod.Constants.MOD_ID;

public class ModBlockTags
{
    public static final TagKey<Block> COLORED_FUNGUS_BLOCKS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "colored_fungus_blocks"));
    public static final TagKey<Block> GRASS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "grass"));
    public static final TagKey<Block> PODZOL = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "podzol"));
    public static final TagKey<Block> NETHER = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "nether"));
    public static final TagKey<Block> DEEPSLATE = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "deepslate"));
    public static final TagKey<Block> QUARTZ_ORES = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "quartz_ores"));
    public static final TagKey<Block> NETHER_BRICKS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "nether_bricks"));
    public static final TagKey<Block> CAN_PLANT_ON = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "can_plant_on"));
    public static final TagKey<Block> FUNGUS_PLANTABLE = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "fungus_plantable"));
    public static final TagKey<Block> SPORING_REPLACEABLES = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "sporing_replaceables"));
    public static final TagKey<Block> COAL = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "coal"));

    public static Component getTranslatableComponent(String tagName)
    {
        if(tagName.startsWith("#"))
            tagName = tagName.substring(1);
        TagKey<Block> terrain = TagKey.create(Registries.BLOCK, ResourceLocation.parse(tagName));
        return Component.translatable(terrain.location().toLanguageKey("tag"));
    }
}
