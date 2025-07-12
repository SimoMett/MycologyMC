package com.simomett.mycologymod.effects.PlayerEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.player.Player;

public class TeleportingEffect extends MobEffect
{
    public static TeleportingEffect instance() { return new TeleportingEffect(); }

    protected TeleportingEffect() {
        super(MobEffectCategory.NEUTRAL, 0x00B253);
    }

    public static boolean shouldTeleport(Player player)
    {
        return player.getMainHandItem().isEmpty() && player.hasEffect(ModEffects.TELEPORTING);
    }
}
