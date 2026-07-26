package com.simomett.mycologymod.client.tints;

import com.simomett.mycologymod.data.FungusSpeciesColorsMap;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import net.minecraft.client.color.block.BlockTintSource;import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class FungusColorer implements BlockTintSource {
    //overlay indexes
    public static final int OVERLAY_STELUM = 0;
    public static final int OVERLAY_HEAD = 1;
    public static final int OVERLAY_DETAILS = 2;
    public static final int OVERLAY_DETAILS2 = 3;
    //

    private final int tintIndex;

    public FungusColorer(int tintIndex) {
        this.tintIndex = tintIndex;
    }

    @Override
    public int colorInWorld(BlockState state, BlockAndTintGetter blockAndTint, BlockPos blockPos) {
        if (blockAndTint.getBlockEntity(blockPos) instanceof ColoredFungusBlockEntity fungusEntity) {
            String speciesName = fungusEntity.getFungusGenoma().dominantTraits().species();
            int[] colors = FungusSpeciesColorsMap.getInstance().get(speciesName);
            return colors[tintIndex];
        }
        return 0;
    }

    @Override
    public int color(BlockState blockState) {
        return 0;
    }
}
