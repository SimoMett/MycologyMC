package com.simomett.mycologymod.effects.player;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.network.PlayerRightClickTeleportPacket;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;

import static com.simomett.mycologymod.effects.player.EffectsDefinitions.XP_MULTIPLIER;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class PlayerEffectsEventsHandler
{
    @SubscribeEvent
    public static void onPlayerPickupXP(PlayerXpEvent.PickupXp evt)
    {
        Player player = evt.getEntity();
        Holder<MobEffect> xpMultiplierEffect = XP_MULTIPLIER.holder();
        if(player.hasEffect(xpMultiplierEffect))
        {
            float multiplier = 1+0.5f*(player.getEffect(xpMultiplierEffect).getAmplifier()+1);
            evt.getOrb().setValue((int) (evt.getOrb().getValue()*multiplier));
        }
    }

    @SubscribeEvent
    public static void onPlayerRightClickEmpty(PlayerInteractEvent.RightClickEmpty evt)
    {
        Player player = evt.getEntity();
        if(TeleportingEffect.shouldTeleport(player))
            ClientPacketDistributor.sendToServer(PlayerRightClickTeleportPacket.INSTANCE);
    }
}
