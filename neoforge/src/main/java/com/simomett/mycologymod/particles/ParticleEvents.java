package com.simomett.mycologymod.particles;

import com.simomett.mycologymod.Constants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class ParticleEvents
{
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent evt)
    {
        evt.registerSpriteSet(ParticlesDefinitions.SPORE_PARTICLES.particleType(), SporeParticles.Provider::new);
        evt.registerSpriteSet(ParticlesDefinitions.MUTANT_SPORE_PARTICLES.particleType(), MutantSporeParticles.Provider::new);
    }
}
