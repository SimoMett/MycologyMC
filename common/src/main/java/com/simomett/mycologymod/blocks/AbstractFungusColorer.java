package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.data.AbstractFungusSpeciesColorsMap;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class AbstractFungusColorer implements BlockColor, ItemColor
{
    //overlay indexes
    public static final int OVERLAY_STELUM = 0;
    public static final int OVERLAY_HEAD = 1;
    public static final int OVERLAY_DETAILS = 2;
    public static final int OVERLAY_DETAILS2 = 3;
    //

    @Override
    public int getColor(BlockState blockState, @Nullable BlockAndTintGetter blockAndTint, @Nullable BlockPos blockPos, int tintIndex)
    {
        if(blockAndTint.getBlockEntity(blockPos) instanceof ColoredFungusBlockEntity fungusEntity)
        {
            String speciesName = fungusEntity.getFungusGenoma().getDominantTraits().species();
            int[] colors = AbstractFungusSpeciesColorsMap.INSTANCE.get(speciesName);
            return colors[tintIndex];
        }
        return 0;
    }

    @Override
    public int getColor(ItemStack itemStack, int tintIndex)
    {
        if(itemStack.has(FUNGUS_GENOMA))
            return FungusSpeciesColorsMap.INSTANCE.get(itemStack.get(FUNGUS_GENOMA).getDominantTraits().species())[tintIndex];
        else
            return 0;
    }
}
