package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class FungusItemColorer implements ItemColor
{
    @Override
    public int getColor(@NotNull ItemStack itemStack, int tintIndex)
    {
        //overlay indexes
        final int OVERLAY_STELUM=0;
        final int OVERLAY_HEAD=1;
        final int OVERLAY_DETAILS=2;
        final int OVERLAY_DETAILS2=3;
        //

        LazyOptional<IFungusData> optional = itemStack.getCapability(FungusDataCapability.INSTANCE);
        return optional.resolve().get().getColors()[tintIndex];
    }

    @SubscribeEvent
    public static void registerColorsEvent(RegisterColorHandlersEvent.Item evt)
    {
        evt.register(new FungusItemColorer(), ModItems.COLORED_CRIMSON_FUNGUS.get(), ModItems.COLORED_WARPED_FUNGUS.get(), ModItems.COLORED_RED_FUNGUS.get());
    }
}