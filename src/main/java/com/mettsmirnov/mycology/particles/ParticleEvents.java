package com.mettsmirnov.mycology.particles;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MycologyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ParticleEvents
{
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent evt)
    {
        evt.registerSpriteSet(ModParticles.SPORE_PARTICLES.get(), SporeParticles.Provider::new);
    }
}
