package com.mettsmirnov.mycology.tags;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags
{
    public static final TagKey<Block> GRASS = TagKey.create(Registries.BLOCK, new ResourceLocation(MycologyMod.MODID, "grass"));
    public static final TagKey<Block> PODZOL = TagKey.create(Registries.BLOCK, new ResourceLocation(MycologyMod.MODID, "podzol"));
    public static final TagKey<Block> NETHER = TagKey.create(Registries.BLOCK, new ResourceLocation(MycologyMod.MODID, "nether"));
    public static final TagKey<Block> DEEPSLATE = TagKey.create(Registries.BLOCK, new ResourceLocation(MycologyMod.MODID, "deepslate"));
    public static final TagKey<Block> QUARTZ_ORES = TagKey.create(Registries.BLOCK, new ResourceLocation(MycologyMod.MODID, "quartz_ores"));
    public static final TagKey<Block> NETHER_BRICKS = TagKey.create(Registries.BLOCK, new ResourceLocation(MycologyMod.MODID, "nether_bricks"));
}
