package com.mettsmirnov.mycology.items;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class FungusItemColorer implements ItemColor {
    @Override
    public int getColor(@NotNull ItemStack itemStack, int tintIndex) {
        Color color;
        switch (tintIndex) {
            case 0 -> color = new Color(0, 148, 0);
            case 1 -> color = new Color(136, 88, 38);
            case 2 -> color = new Color(169, 164, 17);
            case 3 -> color = Color.WHITE;
            default -> color = Color.WHITE;
        }
        return color.hashCode();
    }

    @SubscribeEvent
    public static void registerColorsEvent(ColorHandlerEvent.Item evt)
    {
        evt.getItemColors().register(new FungusItemColorer(), ModItems.COLORED_CRIMSON_FUNGUS.get(),ModItems.COLORED_WARPED_FUNGUS.get());
    }
}