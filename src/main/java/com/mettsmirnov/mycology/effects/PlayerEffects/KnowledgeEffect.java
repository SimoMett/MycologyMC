package com.mettsmirnov.mycology.effects.PlayerEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class KnowledgeEffect extends MobEffect
{
    public static KnowledgeEffect instance(){return new KnowledgeEffect();}
    protected KnowledgeEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
    }
}
