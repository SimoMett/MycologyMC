package com.simomett.mycologymod.entities;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.blocks.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities
{
    public static final DeferredRegister<BlockEntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MycologyMod.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ColoredFungusBlockEntity>> COLORED_FUNGUS = ENTITIES.register("colored_fungus",()-> new BlockEntityType<>(ColoredFungusBlockEntity::new,
            ModBlocks.COLORED_CRIMSON_FUNGUS.get(),
            ModBlocks.COLORED_WARPED_FUNGUS.get(),
            ModBlocks.FUNGUS_POT.get(),
            ModBlocks.POTTED_COLORED_CRIMSON.get(),
            ModBlocks.POTTED_COLORED_WARPED.get()));
}
