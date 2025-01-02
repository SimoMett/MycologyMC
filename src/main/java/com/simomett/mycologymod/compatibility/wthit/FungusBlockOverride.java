package com.simomett.mycologymod.compatibility.wthit;

import com.simomett.mycologymod.genetics.FungusGenoma;
import mcp.mobius.waila.api.*;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;
import static mcp.mobius.waila.api.WailaConstants.OBJECT_NAME_TAG;

public class FungusBlockOverride implements IBlockComponentProvider
{
    @Override
    public @Nullable ITooltipComponent getIcon(IBlockAccessor accessor, IPluginConfig config)
    {
        return IBlockComponentProvider.super.getIcon(accessor, config);
    }

    @Override
    public void appendHead(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config)
    {
        FungusGenoma genoma = accessor.getBlockEntity().components().get(FUNGUS_GENOMA.get());
        Component speciesName = IWailaConfig.get().getFormatter().blockName(genoma.getDominantTraits().species());
        tooltip.setLine(OBJECT_NAME_TAG, speciesName);
    }
}
