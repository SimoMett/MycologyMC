package com.simomett.mycologymod.mixins;

import com.simomett.mycologymod.effects.player.KnowledgeEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity
{
    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "dropExperience", at = @At(value = "HEAD"), cancellable = true)
    public void cancelDropExperience(CallbackInfo ci)
    {
        if(KnowledgeEffect.shouldRestoreXp((LivingEntity) (Object) this))
            ci.cancel();
    }
}
