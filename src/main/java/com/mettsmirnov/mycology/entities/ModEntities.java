package com.mettsmirnov.mycology.entities;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.blocks.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities
{
    public static final DeferredRegister<BlockEntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MycologyMod.MODID);

    public static final RegistryObject<BlockEntityType<ColoredFungusBlockEntity>> COLORED_FUNGUS = ENTITIES.register("colored_fungus",()-> BlockEntityType.Builder.of(ColoredFungusBlockEntity::new, ModBlocks.COLORED_CRIMSON_FUNGUS.get(),ModBlocks.COLORED_WARPED_FUNGUS.get()).build(null));
}
