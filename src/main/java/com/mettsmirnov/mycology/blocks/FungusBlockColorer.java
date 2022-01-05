package com.mettsmirnov.mycology.blocks;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import com.mettsmirnov.mycology.entities.ColoredFungusBlockEntity;
import com.mettsmirnov.mycology.items.FungusItemColorer;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Random;

public class FungusBlockColorer implements BlockColor
{
    @Override
    public int getColor(BlockState blockState, @Nullable BlockAndTintGetter blockAndTint, @Nullable BlockPos blockPos, int tintIndex)
    {
        //overlay indexes
        /*final int OVERLAY_STELUM=0;
        final int OVERLAY_HEAD=1;
        final int OVERLAY_DETAILS=2;
        final int OVERLAY_DETAILS2=3;*/

        BlockEntity blockEntity = blockAndTint.getBlockEntity(blockPos);
        if(blockEntity != null)
        {
            LazyOptional<IFungusData> optional = blockEntity.getCapability(FungusDataCapability.INSTANCE);
            if(optional.isPresent())
            {
                int[] array = optional.resolve().get().getColors();
                return array[tintIndex];
            }
        }
        return -1;
    }

    @SubscribeEvent
    public static void registerColorsEvent(ColorHandlerEvent.Block evt)
    {
        evt.getBlockColors().register(new FungusBlockColorer(), ModBlocks.COLORED_CRIMSON_FUNGUS.get(), ModBlocks.COLORED_WARPED_FUNGUS.get());
    }
}
