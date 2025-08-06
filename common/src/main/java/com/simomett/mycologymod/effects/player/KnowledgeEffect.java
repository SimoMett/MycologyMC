package com.simomett.mycologymod.effects.player;

import net.minecraft.core.Holder;
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
        return e.hasEffect(Holder.direct(EffectsDefinitions.KNOWLEDGE.get())) && !e.level().getServer().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY);
    }
}
