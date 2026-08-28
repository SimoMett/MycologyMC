package com.simomett.mycologymod.blocks;

import com.simomett.mycologymod.menu.AnalysingStationMenuProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class FungusAnalysingStationBlock extends Block
{
    public FungusAnalysingStationBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
    {
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.openMenu(state.getMenuProvider(level, pos));
        return InteractionResult.SUCCESS;
    }

    @Override
    protected @org.jspecify.annotations.Nullable MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos)
    {
        return new AnalysingStationMenuProvider(pos);
    }
}
