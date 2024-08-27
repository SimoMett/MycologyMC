package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class RaptingEffect extends FungusEffect
{
    protected RaptingEffect(String effectName) {
        super(effectName);
    }

    @Override
    public void applyEffectToEntity(LivingEntity livingEntity)
    {
        //from Items.CHORUS_FRUIT
        ServerLevel level = (ServerLevel) livingEntity.level();
        for(int i = 0; i < 16; ++i)
        {
            double d0 = livingEntity.getX() + (livingEntity.getRandom().nextDouble() - 0.5) * 16.0;
            double d1 = Mth.clamp(livingEntity.getY() + (double)(livingEntity.getRandom().nextInt(16) - 8), (double)level.getMinBuildHeight(), (double)(level.getMinBuildHeight() + ((ServerLevel)level).getLogicalHeight() - 1));
            double d2 = livingEntity.getZ() + (livingEntity.getRandom().nextDouble() - 0.5) * 16.0;
            if (livingEntity.isPassenger())
            {
                livingEntity.stopRiding();
            }

            Vec3 vec3 = livingEntity.position();
            if (livingEntity.randomTeleport(d0, d1, d2, true))
            {
                level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(livingEntity));
                SoundSource soundsource;
                SoundEvent soundevent;
                if (livingEntity instanceof Fox)
                {
                    soundevent = SoundEvents.FOX_TELEPORT;
                    soundsource = SoundSource.NEUTRAL;
                }
                else
                {
                    soundevent = SoundEvents.CHORUS_FRUIT_TELEPORT;
                    soundsource = SoundSource.PLAYERS;
                }

                level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), soundevent, soundsource);
                livingEntity.resetFallDistance();
                break;
            }
        }
    }

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius) {

    }
}
