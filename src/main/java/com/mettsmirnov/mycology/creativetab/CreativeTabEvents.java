package com.mettsmirnov.mycology.creativetab;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.data.FungusSpeciesHandler;
import com.mettsmirnov.mycology.data.FungusSpeciesLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MycologyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabEvents
{
    @SubscribeEvent
    public static void buildMycologyCreativeTab(CreativeModeTabEvent.Register event)
    {
        event.registerCreativeModeTab(new ResourceLocation(MycologyMod.MODID), builder ->
                builder.title(Component.translatable("itemGroup." + MycologyMod.MODID))
                        .icon(() -> FungusSpeciesHandler.INSTANCE.getCreativeTabItemstack())
                        .displayItems((enabledFlags, populator, hasPermissions) -> {
                            populator.acceptAll(FungusSpeciesHandler.INSTANCE.getCollection());
                        })
        );
    }
}
