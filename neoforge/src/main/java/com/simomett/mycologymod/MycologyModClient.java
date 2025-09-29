package com.simomett.mycologymod;

import com.simomett.mycologymod.blocks.NeoForgeFungusColorer;
import com.simomett.mycologymod.particles.ParticleEvents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class MycologyModClient
{
    public MycologyModClient(IEventBus evtBus)
    {
        evtBus.register(NeoForgeFungusColorer.class);
        evtBus.register(ParticleEvents.class);
    }
}
