package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.data.FungusSpeciesColorsMap;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.items.ModItems;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class FungusColorer implements BlockColor, ItemColor
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
            int[] colors = FungusSpeciesColorsMap.INSTANCE.get(speciesName);
            return colors[tintIndex];
        }
        return 0;
    }

    @Override
    public int getColor(@NotNull ItemStack itemStack, int tintIndex)
    {
        if(itemStack.has(FUNGUS_GENOMA))
            return FungusSpeciesColorsMap.INSTANCE.get(itemStack.get(FUNGUS_GENOMA).getDominantTraits().species())[tintIndex];
        else
            return 0;
    }

    @SubscribeEvent
    public static void registerBlockColorsEvent(RegisterColorHandlersEvent.Block evt)
    {
        evt.register(new FungusColorer(), ModBlocks.COLORED_CRIMSON_FUNGUS.get(), ModBlocks.COLORED_WARPED_FUNGUS.get());
    }

    @SubscribeEvent
    public static void registerItemColorsEvent(RegisterColorHandlersEvent.Item evt)
    {
        evt.register(new FungusColorer(), ModItems.COLORED_CRIMSON_FUNGUS.get(), ModItems.COLORED_WARPED_FUNGUS.get());
    }
}
