package com.mettsmirnov.mycology.effects.PlayerEffects;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

import java.util.*;
import java.util.function.Consumer;

public class IllucinationsEffect extends MobEffect
{
    public static IllucinationsEffect instance() { return new IllucinationsEffect(); }

    private static List<Consumer<LivingEntity>> fakeEffects = List.of(
            //Not so aggressive sounds
            (e)->e.hurt(e.damageSources().generic(), 0.01f),
            (e)->e.playSound(SoundEvents.ARROW_HIT),
            (e)->e.playSound(SoundEvents.CROSSBOW_HIT),
            (e)->e.playSound(SoundEvents.CREEPER_PRIMED), //this alone triggers real PTSD
            (e)->e.playSound(SoundEvents.ZOMBIE_AMBIENT),
            (e)->e.playSound(SoundEvents.ENDERMAN_AMBIENT),
            (e)->e.playSound(SoundEvents.GHAST_AMBIENT)
    );

    protected IllucinationsEffect() {
        super(MobEffectCategory.HARMFUL, 0);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int level)
    {
        fakeEffects.get(new Random().nextInt(fakeEffects.size())).accept(entity);
    }

    @Override
    public boolean isInstantenous()
    {
        return false;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int remainingTicks, int p_301085_) {
        return new Random().nextInt(300)==0;
    }
}
