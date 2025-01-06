package com.simomett.mycologymod.compatibility.wthit;

import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.genetics.FungusGenoma;
import mcp.mobius.waila.api.*;
import mcp.mobius.waila.api.component.ItemComponent;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

public class FungusBlockOverride implements IBlockComponentProvider
{
    @Override
    public @Nullable ITooltipComponent getIcon(IBlockAccessor accessor, IPluginConfig config)
    {
        if(accessor.getBlockEntity() instanceof ColoredFungusBlockEntity fungusEntity)
        {
            //TODO optimization: I don't need to apply full genoma, just the species name
            FungusGenoma fungusGenoma = fungusEntity.getFungusGenoma();
            ItemStack itemStack = new ItemStack(accessor.getBlock().asItem());
            itemStack.applyComponents(DataComponentMap.builder().set(FUNGUS_GENOMA, fungusGenoma).build());
            return new ItemComponent(itemStack);
        }
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
