package com.mettsmirnov.mycology.entities;

import com.mettsmirnov.mycology.capabilities.FungusData;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

public class ColoredFungusBlockEntity extends BlockEntity
{
    private final IFungusData fungusData = new FungusData();

    public ColoredFungusBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(ModEntities.COLORED_CRIMSON_FUNGUS.get(), blockPos, blockState);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void load(CompoundTag tag)
    {
        fungusData.deserializeNBT(tag);
        super.load(tag);
    }

    @Override
    public CompoundTag save(CompoundTag tag)
    {
        super.save(tag);
        tag.merge(fungusData.serializeNBT());
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag)
    {
        load(tag);
        super.handleUpdateTag(tag);
    }

    @Override
    public CompoundTag getUpdateTag()
    {
        return save(super.getUpdateTag());
    }
}
