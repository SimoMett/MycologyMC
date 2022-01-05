package com.mettsmirnov.mycology.blocks;

import com.mettsmirnov.mycology.items.FungusItemColorer;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Random;

public class FungusBlockColorer implements BlockColor
{

    @Override
    public int getColor(BlockState blockState, @Nullable BlockAndTintGetter p_92568_, @Nullable BlockPos blockPos, int tintIndex)
    {
        //overlay indexes
        final int OVERLAY_STELUM=0;
        final int OVERLAY_HEAD=1;
        final int OVERLAY_DETAILS=2;
        final int OVERLAY_DETAILS2=3;
        //

        Random random = new Random();
        return 0xFF000000 | random.nextInt(0xFFFFFF);
    }

    @SubscribeEvent
    public static void registerColorsEvent(ColorHandlerEvent.Block evt)
    {
        evt.getBlockColors().register(new FungusBlockColorer(), ModBlocks.COLORED_CRIMSON_FUNGUS.get(), ModBlocks.COLORED_WARPED_FUNGUS.get());
    }
}
