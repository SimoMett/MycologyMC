package com.simomett.mycologymod.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class MultipleEffect extends FungusEffect
{
    private final List<Holder<MobEffect>> mobEffects;
    public MultipleEffect(String effectName, List<Holder<MobEffect>> mobEffectList)
    {
        super(effectName);
        this.mobEffects = mobEffectList;
    }

    public void applyEffectToEntity(LivingEntity entity)
    {
        if (mobEffects != null)
        {
            for(Holder<MobEffect> mobEffect : mobEffects)
                entity.addEffect(new MobEffectInstance(mobEffect, numOfTicks));
        }
    }

    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {

    }
}
