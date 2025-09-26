package com.simomett.mycologymod.mixins;

import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Biome.class)
public class BiomeMixin implements IBiomeDownfallGetter
{
    @Shadow @Final
    private Biome.ClimateSettings climateSettings;

    @Override
    public float getDownfall()
    {
        return climateSettings.downfall();
    }
}
