package com.simomett.mycologymod.entities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public interface IRegisteredBlockEntityType<T extends BlockEntity>
{
    BlockEntityType<T> type();
}
