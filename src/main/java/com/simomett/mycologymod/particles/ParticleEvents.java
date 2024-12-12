package com.simomett.mycologymod.particles;


import com.simomett.mycologymod.MycologyMod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = MycologyMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ParticleEvents
{
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent evt)
    {
        evt.registerSpriteSet(ModParticles.SPORE_PARTICLES.get(), SporeParticles.Provider::new);
    }
}
