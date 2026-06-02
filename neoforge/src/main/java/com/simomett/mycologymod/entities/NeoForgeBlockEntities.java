package com.simomett.mycologymod.entities;

import com.simomett.mycologymod.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoForgeBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);
}
