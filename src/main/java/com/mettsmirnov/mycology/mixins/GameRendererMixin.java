package com.mettsmirnov.mycology.mixins;

import com.mettsmirnov.mycology.effects.PlayerEffects.ModEffects;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.*;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin implements AutoCloseable{
    @Shadow public abstract void close();
    @Shadow
    @Final
    private Minecraft minecraft;

    @Overwrite
    private void bobHurt(PoseStack p_109118_, float p_109119_)
    {
        Entity $$3 = this.minecraft.getCameraEntity();
        if ($$3 instanceof LivingEntity livingentity)
        {
            if (livingentity.hasEffect(ModEffects.ANESTHETIC.get()))
                return;
            float f2 = (float)livingentity.hurtTime - p_109119_;
            float f3;
            if (livingentity.isDeadOrDying()) {
                f3 = Math.min((float)livingentity.deathTime + p_109119_, 20.0F);
                p_109118_.mulPose(Axis.ZP.rotationDegrees(40.0F - 8000.0F / (f3 + 200.0F)));
            }

            if (f2 < 0.0F) {
                return;
            }

            f2 /= (float)livingentity.hurtDuration;
            f2 = Mth.sin(f2 * f2 * f2 * f2 * 3.1415927F);
            f3 = livingentity.getHurtDir();
            p_109118_.mulPose(Axis.YP.rotationDegrees(-f3));
            float f1 = (float)((double)(-f2) * 14.0 * (Double)this.minecraft.options.damageTiltStrength().get());
            p_109118_.mulPose(Axis.ZP.rotationDegrees(f1));
            p_109118_.mulPose(Axis.YP.rotationDegrees(f3));
        }
    }
}
