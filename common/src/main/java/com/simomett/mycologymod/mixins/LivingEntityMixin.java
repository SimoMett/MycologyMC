package com.simomett.mycologymod.mixins;

import com.simomett.mycologymod.effects.player.KnowledgeEffect;
import com.simomett.mycologymod.effects.player.LastChanceEffect;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.simomett.mycologymod.effects.player.EffectsDefinitions.LAST_CHANCE;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity
{
    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow public abstract boolean hasEffect(Holder<MobEffect> p_21024_);

    @Inject(method = "dropExperience", at = @At(value = "HEAD"), cancellable = true)
    public void cancelDropExperience(CallbackInfo ci)
    {
        if(KnowledgeEffect.shouldRestoreXp((LivingEntity) (Object) this))
            ci.cancel();
    }

    @Inject(method = "checkTotemDeathProtection", at = @At("RETURN"), cancellable = true)
    public void apply_last_chance_death_protection(CallbackInfoReturnable<Boolean> cir)
    {
        boolean hasLastChanceEffect = this.hasEffect(LAST_CHANCE.holder());
        LastChanceEffect.LAST_CHANCE.applyEffects(null, (LivingEntity) (Object) this);

        cir.setReturnValue(cir.getReturnValue() || hasLastChanceEffect);
    }
}
