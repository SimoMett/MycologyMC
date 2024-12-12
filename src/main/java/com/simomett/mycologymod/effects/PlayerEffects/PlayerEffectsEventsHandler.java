package com.simomett.mycologymod.effects.PlayerEffects;

import com.simomett.mycologymod.MycologyMod;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;

@EventBusSubscriber(modid = MycologyMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class PlayerEffectsEventsHandler
{
    @SubscribeEvent
    public static void onPlayerPickupXP(PlayerXpEvent.PickupXp evt)
    {
        Player player = evt.getEntity();
        if(player.hasEffect(ModEffects.XP_MULTIPLIER))
        {
            float multiplier = 1+0.5f*(player.getEffect(ModEffects.XP_MULTIPLIER).getAmplifier()+1);
            evt.getOrb().value*=(int)multiplier;
        }
    }

    @SubscribeEvent
    public static void onPlayerRightClickEmpty(PlayerInteractEvent.RightClickEmpty evt)
    {
        /*Player player = evt.getEntity();
        if(TeleportingEffect.shouldTeleport(player))
            PacketHandler.sendToServer(new PlayerRightClickTeleportPacket());*/
    }
}
