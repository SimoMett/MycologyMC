package com.mettsmirnov.mycology.world.events;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.world.entity.EntityEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jline.utils.Log;

@Mod.EventBusSubscriber(modid = MycologyMod.MODID)
public class WorldEvents
{
    @SubscribeEvent
    public static void onPlayerTickEvent(TickEvent.PlayerTickEvent evt)
    {
        Log.info(evt.player.position());
    }
}
