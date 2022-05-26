package com.mettsmirnov.mycology.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.recipes.RecipeProvider;

import java.io.IOException;

public class SpeciesGenerator implements DataProvider
{
    private DataGenerator generator;
    public SpeciesGenerator(DataGenerator generator)
    {
        this.generator = generator;
    }

    @Override
    public void run(HashCache p_123925_)
    {

    }



    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
