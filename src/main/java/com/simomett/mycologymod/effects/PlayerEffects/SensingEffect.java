package com.simomett.mycologymod.effects.PlayerEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.awt.*;

public class SensingEffect extends MobEffect
{
    public static SensingEffect create()
    {
        return new SensingEffect();
    }

    protected SensingEffect()
    {
        super(MobEffectCategory.BENEFICIAL, Color.WHITE.hashCode());
    }

    @Override
    public boolean isInstantenous()
    {
        return false;
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int level)
    {
        Level lvl = entity.level();
        if(lvl.isClientSide)
        {
            double radius = 10;
            Vec3 pos = entity.position();
            entity.setGlowingTag(true);
            AABB aabb = new AABB(pos.add(-radius, -radius, -radius), pos.add(radius, radius, radius));
            // what now?
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int remaningTicks, int level)
    {
        return false;//FIXME
    }
}
