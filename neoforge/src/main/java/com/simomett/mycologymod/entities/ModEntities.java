package com.simomett.mycologymod.entities;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.blocks.BlocksDefinitions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities
{
    public static final DeferredRegister<BlockEntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ColoredFungusBlockEntity>> COLORED_FUNGUS = ENTITIES.register("colored_fungus",()-> new BlockEntityType<>(ColoredFungusBlockEntity::new,
            BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(),
            BlocksDefinitions.COLORED_WARPED_FUNGUS.get()
            /*BlockNames.FUNGUS_POT.get(),
            BlockNames.POTTED_COLORED_CRIMSON.get(),
            BlockNames.POTTED_COLORED_WARPED.get()*/)
    );
}
