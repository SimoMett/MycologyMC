package com.simomett.mycologymod.network;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.effects.PlayerEffects.ModEffects;
import com.simomett.mycologymod.effects.PlayerEffects.TeleportingEffect;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = MycologyMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class PlayerRightClickTeleportPacket implements CustomPacketPayload
{
    public static final PlayerRightClickTeleportPacket INSTANCE = new PlayerRightClickTeleportPacket();
    public static final CustomPacketPayload.Type<PlayerRightClickTeleportPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "rightclick_teleport"));
    public static final StreamCodec<ByteBuf, PlayerRightClickTeleportPacket> STREAM_CODEC = StreamCodec.unit(INSTANCE);

    public PlayerRightClickTeleportPacket() {}

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent evt)
    {
        PayloadRegistrar registrar = evt.registrar("1");

        registrar.playToServer(TYPE, STREAM_CODEC, new MainThreadPayloadHandler<>(PlayerRightClickTeleportPacket::handleTeleport));
    }

    public static void handleTeleport(final PlayerRightClickTeleportPacket data, final IPayloadContext context)
    {
        Player player = context.player();

        if (TeleportingEffect.shouldTeleport(player))
        {
            int ampl = player.getEffect(ModEffects.TELEPORTING).getAmplifier();
            double reachDistance = 20*(ampl+1);
            BlockHitResult hitResult = getTarget(player, ClipContext.Fluid.ANY, reachDistance);
            if (hitResult.getType() == HitResult.Type.BLOCK)
            {
                BlockPos pos = hitResult.getBlockPos().above();
                player.teleportTo(pos.getX(), pos.getY(), pos.getZ());
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS);
            }
        }
    }

    public static BlockHitResult getTarget(Player pPlayer, ClipContext.Fluid pFluidMode, double reach)
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
        return pPlayer.level().clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, pFluidMode, pPlayer));
    }
}
