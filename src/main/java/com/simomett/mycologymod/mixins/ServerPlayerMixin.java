package com.simomett.mycologymod.mixins;

import com.mojang.authlib.GameProfile;
import com.simomett.mycologymod.effects.player.KnowledgeEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player
{
    public ServerPlayerMixin(MinecraftServer server, ServerLevel level, GameProfile gameProfile, ClientInformation clientInformation) {
        super(level, gameProfile);
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
