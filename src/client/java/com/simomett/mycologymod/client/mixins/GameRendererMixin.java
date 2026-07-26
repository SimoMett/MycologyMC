package com.simomett.mycologymod.client.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.state.GameRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.*;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin implements AutoCloseable{
    @Shadow public abstract void close();
    @Shadow
    @Final
    private Minecraft minecraft;

    @Shadow
    public abstract GameRenderState getGameRenderState();

    @Overwrite
    private void bobHurt(final CameraRenderState cameraState, final PoseStack poseStack) {
        if (cameraState.entityRenderState.isLiving)
        {
            // TODO return if anestetic effect applied
            float hurt = cameraState.entityRenderState.hurtTime;
            if (cameraState.entityRenderState.isDeadOrDying) {
                float duration = Math.min(cameraState.entityRenderState.deathTime, 20.0F);
                poseStack.mulPose(Axis.ZP.rotationDegrees(40.0F - 8000.0F / (duration + 200.0F)));
            }

            if (hurt < 0.0F) {
                return;
            }

            hurt /= cameraState.entityRenderState.hurtDuration;
            hurt = Mth.sin(hurt * hurt * hurt * hurt * (float) Math.PI);
            float rr = cameraState.entityRenderState.hurtDir;
            poseStack.mulPose(Axis.YP.rotationDegrees(-rr));
            float tiltAmount = (float)(-hurt * 14.0 * this.getGameRenderState().optionsRenderState.damageTiltStrength);
            poseStack.mulPose(Axis.ZP.rotationDegrees(tiltAmount));
            poseStack.mulPose(Axis.YP.rotationDegrees(rr));
        }
    }
}
