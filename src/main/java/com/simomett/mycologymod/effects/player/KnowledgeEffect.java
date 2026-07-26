package com.simomett.mycologymod.effects.player;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.gamerules.GameRules;

import static com.simomett.mycologymod.effects.player.EffectsDefinitions.KNOWLEDGE;

public class KnowledgeEffect extends MobEffect
{
    public static KnowledgeEffect instance(){return new KnowledgeEffect();}
    protected KnowledgeEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
    }

    public static boolean shouldRestoreXp(LivingEntity e)
    {
        return e.hasEffect(KNOWLEDGE.holder())
                && !e.level().getServer().getLevel(e.level().dimension()).getGameRules().get(GameRules.KEEP_INVENTORY);
    }
}
