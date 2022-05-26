package com.mettsmirnov.mycology.datagen;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MycologyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    private DataGenerators() {}

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent evt)
    {
        DataGenerator dataGentor = evt.getGenerator();
        ExistingFileHelper existingFileHelper = evt.getExistingFileHelper();
    }

}
