package com.simomett.mycologymod.blocks;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.jetbrains.annotations.Nullable;

@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class BlockColorerByState implements BlockColor, ItemColor
{
    @Override
    public int getColor(BlockState blockState, @Nullable BlockAndTintGetter blockAndTintGetter, @Nullable BlockPos blockPos, int i)
    {
        return blockState.getValue(ColoredByStateBlock.COLOR);
    }

    @Override
    public int getColor(ItemStack itemStack, int i)
    {
        return 0;
    }

    @SubscribeEvent
    public static void registerBlockColorsEvent(RegisterColorHandlersEvent.Block evt)
    {
        evt.register(new BlockColorerByState(), ModBlocks.COLORED_BY_STATE_BLOCK.get());
    }
}
