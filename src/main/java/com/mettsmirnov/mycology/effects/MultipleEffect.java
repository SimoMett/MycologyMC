package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

import java.util.List;

public class MultipleEffect implements IFungusEffect
{
    private final String effectName;
    private final List<MobEffect> mobEffects;
    //FIXME the fact that I need to register the fungus in the constructor for each subclass is annoying
    public MultipleEffect(String effectName)
    {
        this.effectName = effectName;
        this.mobEffects = null;
        FungusEffects.registerFungusEffect(effectName, this);
    }

    public MultipleEffect(String effectName, List<MobEffect> mobEffectList)
    {
        this.effectName = effectName;
        this.mobEffects = mobEffectList;
        FungusEffects.registerFungusEffect(effectName, this);
    }

    @Override
    public String getEffectName()
    {
        return effectName;
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity)
    {
        if (mobEffects != null)
        {
            for(MobEffect mobEffect : mobEffects)
                entity.addEffect(new MobEffectInstance(mobEffect, numOfTicks));
        }
    }

    @Override
    public void applyEffectToLevel(LevelAccessor level, BlockPos origin, int radius)
    {

    }
}
