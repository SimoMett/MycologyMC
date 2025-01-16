package com.simomett.mycologymod.tags;

import com.simomett.mycologymod.MycologyMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags
{
    public static final TagKey<Block> COLORED_FUNGUS_BLOCKS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "colored_fungus_blocks"));
    public static final TagKey<Block> GRASS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "grass"));
    public static final TagKey<Block> PODZOL = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "podzol"));
    public static final TagKey<Block> NETHER = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "nether"));
    public static final TagKey<Block> DEEPSLATE = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "deepslate"));
    public static final TagKey<Block> QUARTZ_ORES = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "quartz_ores"));
    public static final TagKey<Block> NETHER_BRICKS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "nether_bricks"));
    public static final TagKey<Block> CAN_PLANT_ON = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "can_plant_on"));
    public static final TagKey<Block> FUNGUS_PLANTABLE = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "fungus_plantable"));
    public static final TagKey<Block> SPORING_REPLACEABLES = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "sporing_replaceables"));

    public static Component getTranslatableComponent(String tagName)
    {
        if(tagName.startsWith("#"))
            tagName = tagName.substring(1);
        TagKey<Block> terrain = TagKey.create(Registries.BLOCK, ResourceLocation.parse(tagName));
        return Component.translatable(terrain.location().toLanguageKey("tag"));
    }
}
