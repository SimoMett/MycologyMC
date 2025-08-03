package com.simomett.mycologymod;

import com.simomett.mycologymod.blocks.AbstractFungusColorer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class MycologyModClient
{
    public MycologyModClient(IEventBus evtBus)
    {
        evtBus.register(AbstractFungusColorer.class);
    }
}
