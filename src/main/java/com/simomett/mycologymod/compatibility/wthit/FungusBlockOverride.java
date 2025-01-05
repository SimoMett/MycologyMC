package com.simomett.mycologymod.compatibility.wthit;

import mcp.mobius.waila.api.*;
import org.jetbrains.annotations.Nullable;

public class FungusBlockOverride implements IBlockComponentProvider
{
    @Override
    public @Nullable ITooltipComponent getIcon(IBlockAccessor accessor, IPluginConfig config)
    {
        //TODO fungus render icon
        return IBlockComponentProvider.super.getIcon(accessor, config);
    }

    // I've disabled the preview of the name of the mushroom, just to spice up the gaming experience.
    // Maybe I'll come back with a better idea, like showing only the names of previously met fungi.
    /*@Override
    public void appendHead(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config)
    {
        FungusGenoma genoma = accessor.getBlockEntity().components().get(FUNGUS_GENOMA.get());
        Component speciesName = IWailaConfig.get().getFormatter().blockName(genoma.getDominantTraits().species());
        tooltip.setLine(OBJECT_NAME_TAG, speciesName);
    }*/
}
