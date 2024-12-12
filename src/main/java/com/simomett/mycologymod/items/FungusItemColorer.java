package com.simomett.mycologymod.items;

import com.simomett.mycologymod.data.FungusSpeciesList;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.jetbrains.annotations.NotNull;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class FungusItemColorer implements ItemColor
{
    //overlay indexes
    public static final int OVERLAY_STELUM = 0;
    public static final int OVERLAY_HEAD = 1;
    public static final int OVERLAY_DETAILS = 2;
    public static final int OVERLAY_DETAILS2 = 3;
    //

    @Override
    public int getColor(@NotNull ItemStack itemStack, int tintIndex)
    {
        if(itemStack.has(FUNGUS_GENOMA))
            return FungusSpeciesList.INSTANCE.get(itemStack.get(FUNGUS_GENOMA).getDominantTraits().species()).colors[tintIndex];
        else
            return 0;
    }

    @SubscribeEvent
    public static void registerColorsEvent(RegisterColorHandlersEvent.Item evt)
    {
        evt.register(new FungusItemColorer(), ModItems.COLORED_CRIMSON_FUNGUS.get(), ModItems.COLORED_WARPED_FUNGUS.get());
    }
}