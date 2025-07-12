package com.simomett.mycologymod;

import com.simomett.mycologymod.blocks.FungusColorer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = MycologyMod.MODID, dist = Dist.CLIENT)
public class MycologyModClient
{
    public MycologyModClient(IEventBus evtBus)
    {
        evtBus.register(FungusColorer.class);
    }
}
