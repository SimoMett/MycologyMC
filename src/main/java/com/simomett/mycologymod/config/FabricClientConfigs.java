package com.simomett.mycologymod.config;

public class FabricClientConfigs implements IModClientConfigs
{
    private static final FabricClientConfigs INSTANCE = new FabricClientConfigs();

    public static IModClientConfigs instance()
    {
        return INSTANCE;
    }

    //TODO
    @Override
    public int getSporeParticlesFreq()
    {
        return 1;
    }
}
