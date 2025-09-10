package com.simomett.mycologymod.entities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class FabricRegisteredBlockEntityType<T extends BlockEntity> implements IRegisteredBlockEntityType<T>
{
    private final BlockEntityType<T> blockEntityType;
    public FabricRegisteredBlockEntityType(BlockEntityType<T> blockEntityType)
    {
        this.blockEntityType = blockEntityType;
    }

    @Override
    public BlockEntityType<T> type()
    {
        return blockEntityType;
    }
}
