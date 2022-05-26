package com.mettsmirnov.mycology.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import org.jline.utils.Log;

public class SpeciesProvider implements DataProvider
{
    private DataGenerator generator;
    public SpeciesProvider(DataGenerator generator)
    {
        this.generator = generator;
    }

    @Override
    public void run(HashCache p_123925_)
    {
        Log.info("reached");
    }

    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
