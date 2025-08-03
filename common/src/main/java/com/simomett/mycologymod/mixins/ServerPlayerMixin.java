package com.simomett.mycologymod.mixins;

import com.mojang.authlib.GameProfile;
import com.simomett.mycologymod.effects.PlayerEffects.KnowledgeEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player
{
    public ServerPlayerMixin(Level p_250508_, BlockPos p_250289_, float p_251702_, GameProfile p_252153_) {
        super(p_250508_, p_250289_, p_251702_, p_252153_);
    }

    @Inject(method = "restoreFrom", at = @At("TAIL"))
    public void restoreXp(ServerPlayer player, boolean p_9017_, CallbackInfo ci)
    {
        if(KnowledgeEffect.shouldRestoreXp(player))
        {
            this.experienceLevel = player.experienceLevel;
            this.totalExperience = player.totalExperience;
            this.experienceProgress = player.experienceProgress;
            this.setScore(player.getScore());
        }
    }
}
