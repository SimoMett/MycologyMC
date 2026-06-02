package com.simomett.mycologymod.effects.player;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;

public class ReturnHomeEffect extends InstantenousMobEffect
{
    public static final ReturnHomeEffect getInstance() {return new ReturnHomeEffect();}

    protected ReturnHomeEffect()
    {
        super(MobEffectCategory.BENEFICIAL, 0x0);
    }

    @Override
    public void onEffectAdded(LivingEntity entity, int amplifier)
    {
        if(entity instanceof ServerPlayer player)
        {
            ServerPlayer.RespawnConfig spawn = player.getRespawnConfig();
            TeleportTransition teleportTransition;
            if(spawn != null && player.getSleepingPos().isPresent())
            {
                teleportTransition = new TeleportTransition(
                        player.getServer().getLevel(spawn.dimension()),
                        spawn.pos().getCenter(),
                        Vec3.ZERO,
                        player.getYRot(),
                        player.getXRot(),
                        TeleportTransition.PLAY_PORTAL_SOUND
                );
            }
            else
            {
                teleportTransition = new TeleportTransition(
                        player.getServer().overworld(),
                        player.getServer().overworld().getSharedSpawnPos().getCenter(),
                        Vec3.ZERO,
                        player.getYRot(),
                        player.getXRot(),
                        TeleportTransition.PLAY_PORTAL_SOUND
                );
            }
            player.teleport(teleportTransition);
        }
    }
}
