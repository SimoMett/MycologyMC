package com.mettsmirnov.mycology.effects.PlayerEffects;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;

@Mod.EventBusSubscriber(modid = MycologyMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEffectsEventsHandler
{
    @SubscribeEvent
    public static void onPlayerPickupXP(PlayerXpEvent.PickupXp evt)
    {
        Player player = evt.getEntity();
        if(player.hasEffect(ModEffects.XP_MULTIPLIER.get()))
        {
            float multiplier = 1+0.5f*(player.getEffect(ModEffects.XP_MULTIPLIER.get()).getAmplifier()+1);
            evt.getOrb().value*=(int)multiplier;
        }
    }
}
