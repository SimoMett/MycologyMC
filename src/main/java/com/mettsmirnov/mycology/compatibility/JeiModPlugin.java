package com.mettsmirnov.mycology.compatibility;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.items.ModItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@JeiPlugin
@OnlyIn(Dist.CLIENT)
public class JeiModPlugin implements IModPlugin
{

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(MycologyMod.MODID, "jei_plugin");
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration)
    {
        registration.registerSubtypeInterpreter(ModItems.COLORED_CRIMSON_FUNGUS.get(), new FungusSubtypeInterpreter());
        registration.registerSubtypeInterpreter(ModItems.COLORED_WARPED_FUNGUS.get(), new FungusSubtypeInterpreter());
    }
}
