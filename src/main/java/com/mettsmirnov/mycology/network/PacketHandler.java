package com.mettsmirnov.mycology.network;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;

@Mod.EventBusSubscriber(modid = MycologyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PacketHandler
{
    private static final SimpleChannel INSTANCE = ChannelBuilder.named(
            new ResourceLocation(MycologyMod.MODID, "main"))
            .serverAcceptedVersions((status, version) -> true)
            .clientAcceptedVersions((status, version) -> true)
            .networkProtocolVersion(1)
            .simpleChannel();

    @SubscribeEvent
    public static void handlerSetup(FMLCommonSetupEvent evt)
    {
        evt.enqueueWork(PacketHandler::register);
    }

    public static void register()
    {
        INSTANCE.messageBuilder(PlayerRightClickTeleportPacket.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PlayerRightClickTeleportPacket::encode)
                .decoder(PlayerRightClickTeleportPacket::new)
                .consumerMainThread(PlayerRightClickTeleportPacket::handle)
                .add();
    }

    public static void sendToServer(Object msg)
    {
        INSTANCE.send(msg, PacketDistributor.SERVER.noArg());
    }
}
