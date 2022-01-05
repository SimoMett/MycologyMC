package com.mettsmirnov.mycology.blocks;

import com.mettsmirnov.mycology.capabilities.FungusData;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

public class ColoredFungusBlockEntity extends BlockEntity
{
    private final IFungusData fungusData = new FungusData();

    public ColoredFungusBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_)
    {
        super(p_155228_, p_155229_, p_155230_);
    }
}
