package com.mettsmirnov.mycology.mixins;

import com.mettsmirnov.mycology.effects.PlayerEffects.KnowledgeEffect;
import com.mettsmirnov.mycology.effects.PlayerEffects.ModEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity
{
    public LivingEntityMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Shadow public abstract void setHealth(float health);
    @Shadow public abstract boolean removeAllEffects();
    @Shadow public abstract boolean addEffect(MobEffectInstance p_21165_);
    @Shadow public abstract ItemStack getItemInHand(InteractionHand hand);
    @Shadow public abstract boolean hasEffect(MobEffect p_21024_);

    @Overwrite
    private boolean checkTotemDeathProtection(DamageSource p_21263_)
    {
        if (p_21263_.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        } else {
            ItemStack itemstack = null;
            InteractionHand[] var3 = InteractionHand.values();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                InteractionHand interactionhand = var3[var5];
                ItemStack itemstack1 = this.getItemInHand(interactionhand);
                if (itemstack1.is(Items.TOTEM_OF_UNDYING) && ForgeHooks.onLivingUseTotem((LivingEntity) (Object) this, p_21263_, itemstack1, interactionhand)) {
                    itemstack = itemstack1.copy();
                    itemstack1.shrink(1);
                    break;
                }
            }

            if (itemstack != null && (LivingEntity) (Object) this instanceof ServerPlayer serverplayer)
            {
                serverplayer.awardStat(Stats.ITEM_USED.get(Items.TOTEM_OF_UNDYING), 1);
                CriteriaTriggers.USED_TOTEM.trigger(serverplayer, itemstack);
                this.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
            }

            boolean hasLastChanceEffect = this.hasEffect(ModEffects.LAST_CHANCE.get());
            if(itemstack != null || hasLastChanceEffect)
            {
                this.setHealth(1.0F);
                this.removeAllEffects();
                this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
                this.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
                this.level().broadcastEntityEvent(this, (byte)35);
            }

            return itemstack != null || hasLastChanceEffect;
        }
    }

    @Inject(method = "dropExperience", at = @At(value = "HEAD"), cancellable = true)
    public void cancelDropExperience(CallbackInfo ci)
    {
        if(KnowledgeEffect.shouldRestoreXp((LivingEntity) (Object) this))
            ci.cancel();
    }
}
