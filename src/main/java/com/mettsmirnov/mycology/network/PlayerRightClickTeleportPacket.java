package com.mettsmirnov.mycology.network;

import com.mettsmirnov.mycology.effects.PlayerEffects.ModEffects;
import com.mettsmirnov.mycology.effects.PlayerEffects.TeleportingEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class PlayerRightClickTeleportPacket
{
    public PlayerRightClickTeleportPacket() {}
    public PlayerRightClickTeleportPacket(FriendlyByteBuf buffer) {}

    public void encode(FriendlyByteBuf buffer) {}

    public void handle(CustomPayloadEvent.Context ctx)
    {
        ServerPlayer player = ctx.getSender();
        if(player==null)
            return;

        if (TeleportingEffect.shouldTeleport(player))
        {
            int ampl = player.getEffect(ModEffects.TELEPORTING.get()).getAmplifier();
            double reachDistance = 20*(ampl+1);
            BlockHitResult hitResult = getTarget(player.level(), player, ClipContext.Fluid.ANY, reachDistance);
            if (hitResult.getType() == HitResult.Type.BLOCK)
            {
                BlockPos pos = hitResult.getBlockPos().above();
                player.teleportTo(pos.getX(), pos.getY(), pos.getZ());
            }
        }
    }

    public static BlockHitResult getTarget(Level pLevel, Player pPlayer, ClipContext.Fluid pFluidMode, double reach)
    {
        //from https://forums.minecraftforge.net/topic/110972-forge1181-how-to-raycast/
        float f = pPlayer.getXRot();
        float f1 = pPlayer.getYRot();
        Vec3 vec3 = pPlayer.getEyePosition();
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        Vec3 vec31 = vec3.add((double)f6 * reach, (double)f5 * reach, (double)f7 * reach);
        return pLevel.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, pFluidMode, pPlayer));
    }
}
