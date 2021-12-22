package com.mettsmirnov.mycology.items;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;
import java.rmi.registry.RegistryHandler;

public class FungusItemColorer implements ItemColor
{
    public FungusItemColorer()
    {

    }

    @Override
    public int getColor(ItemStack p_92672_, int p_92673_) {
        return new Color(179, 83, 0).hashCode();
    }

    @SubscribeEvent
    public static void registerColorsEvent(ColorHandlerEvent.Item evt)
    {
        MycologyMod.MOD_LOGGER.info("YEEEAAAA??");
        evt.getItemColors().register(new FungusItemColorer(),ModItems.COLORED_CRIMSON_FUNGUS.get());
    }
}
