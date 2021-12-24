package com.mettsmirnov.mycology.items;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

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

        Color color;
        switch (tintIndex) {
            case OVERLAY_STELUM ->  color = new Color(217, 140, 122);
            case OVERLAY_HEAD -> color = new Color(213, 146, 79);
            case OVERLAY_DETAILS -> color = new Color(229, 225, 59);
            case OVERLAY_DETAILS2 -> color = new Color(236, 233, 125);

            default -> color = Color.WHITE;
        }
        return color.hashCode();
    }

    @SubscribeEvent
    public static void registerColorsEvent(ColorHandlerEvent.Item evt)
    {
        evt.getItemColors().register(new FungusItemColorer(), ModItems.COLORED_CRIMSON_FUNGUS.get(), ModItems.COLORED_WARPED_FUNGUS.get());
    }
}