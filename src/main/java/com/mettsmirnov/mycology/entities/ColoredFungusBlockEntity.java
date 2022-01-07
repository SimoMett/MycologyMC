package com.mettsmirnov.mycology.entities;

import com.mettsmirnov.mycology.capabilities.FungusData;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ColoredFungusBlockEntity extends BlockEntity
{
    private final IFungusData fungusData = new FungusData();

    public ColoredFungusBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(ModEntities.COLORED_FUNGUS.get(), blockPos, blockState);
    }

    //READ PLEASE
    /*
    * According to my understanding, there's no need to override the load() and save() methods
    * because the capability seems to already load and save data itself.
    * */
    /*@Override
    public void load(CompoundTag tag)
    {
        CompoundTag capTag = tag.getCompound("ForgeCaps").getCompound(MycologyMod.MODID+":fungus_data");
        //fungusData.deserializeNBT(capTag);
        super.load(tag);
    }
    @Override
    public CompoundTag save(CompoundTag tag)
    {
        super.save(tag);
        //tag.merge(fungusData.serializeNBT());
        return tag;
    }*/

    //Although is lacking synchronization when the client first plant the mushroom. The colors are mismatched until the world reloads or there's some chunk updates...
    //so.. FIXME
    //Server-Client synchronization
    @Override
    public CompoundTag getUpdateTag()
    {
        return save(new CompoundTag());
    }

    @Override
    public void handleUpdateTag(CompoundTag tag)
    {
        load(tag);
        super.handleUpdateTag(tag);
    }
}
