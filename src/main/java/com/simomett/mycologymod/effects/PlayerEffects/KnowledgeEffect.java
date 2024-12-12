package com.simomett.mycologymod.effects.PlayerEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameRules;

public class KnowledgeEffect extends MobEffect
{
    public static KnowledgeEffect instance(){return new KnowledgeEffect();}
    protected KnowledgeEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
    }

    public static boolean shouldRestoreXp(LivingEntity e)
    {
        return e.hasEffect(ModEffects.KNOWLEDGE) && !e.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY);
    }
}
