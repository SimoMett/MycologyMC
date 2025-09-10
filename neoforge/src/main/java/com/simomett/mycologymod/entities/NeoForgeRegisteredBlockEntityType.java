package com.simomett.mycologymod.entities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class NeoForgeRegisteredBlockEntityType<T extends BlockEntity> implements IRegisteredBlockEntityType<T>
{
    private final DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<T>> blockEntityType;
    public <I extends BlockEntityType<T>> NeoForgeRegisteredBlockEntityType(DeferredHolder<BlockEntityType<?>, I> blockEntityType)
    {
        this.blockEntityType = blockEntityType;
    }

    @Override
    public BlockEntityType<T> type()
    {
        return blockEntityType.get();
    }
}
