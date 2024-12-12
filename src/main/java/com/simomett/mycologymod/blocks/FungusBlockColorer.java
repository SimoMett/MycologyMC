package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.jetbrains.annotations.Nullable;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class FungusBlockColorer implements BlockColor
{
    @Override
    public int getColor(BlockState blockState, @Nullable BlockAndTintGetter blockAndTint, @Nullable BlockPos blockPos, int tintIndex)
    {
        BlockEntity blockEntity = blockAndTint.getBlockEntity(blockPos);
        FungusGenoma fungusData = ((ColoredFungusBlockEntity) blockEntity).getFungusData();
        FungusSpeciesList.FungusSpecies fs = FungusSpeciesList.INSTANCE.get(fungusData.getDominantTraits().species());
        if(fs!=null)
            return fs.colors[tintIndex];
        else
            return -1;
    }

    @SubscribeEvent
    public static void registerColorsEvent(RegisterColorHandlersEvent.Block evt)
    {
        evt.register(new FungusBlockColorer(), ModBlocks.COLORED_CRIMSON_FUNGUS.get(), ModBlocks.COLORED_WARPED_FUNGUS.get());
    }
}
