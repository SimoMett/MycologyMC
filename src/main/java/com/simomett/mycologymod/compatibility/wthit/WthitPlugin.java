package com.simomett.mycologymod.compatibility.wthit;

import com.simomett.mycologymod.blocks.ColoredFungusBlock;
import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;

public class WthitPlugin implements IWailaPlugin
{
    @Override
    public void register(IRegistrar registrar)
    {
        registrar.head(new FungusBlockOverride(), ColoredFungusBlock.class);
        registrar.icon(new FungusBlockOverride(), ColoredFungusBlock.class);
    }
}
