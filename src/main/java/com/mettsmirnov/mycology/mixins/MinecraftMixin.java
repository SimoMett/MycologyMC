package com.mettsmirnov.mycology.mixins;

import com.mettsmirnov.mycology.effects.PlayerEffects.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin implements ResourceManagerReloadListener, AutoCloseable
{
    @Shadow public LocalPlayer player;
    @Shadow @Final public Options options;

    @Overwrite
    public boolean shouldEntityAppearGlowing(Entity entity)
    {
        if(this.player != null)
        {
            return entity.isCurrentlyGlowing() || this.player.hasEffect(ModEffects.SENSING.get()) || this.player.isSpectator() && this.options.keySpectatorOutlines.isDown() && entity.getType() == EntityType.PLAYER;
        }
        return entity.isCurrentlyGlowing();
    }
}
