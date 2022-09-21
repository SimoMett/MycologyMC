package com.mettsmirnov.mycology.datagen;

import com.google.gson.*;
import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.server.packs.PackType;
import org.jline.utils.Log;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.Path;

public class SpeciesProvider implements DataProvider
{
    private static final String CRIMSON_TYPE = "colored_crimson_fungus";
    private static final String WARPED_TYPE = "colored_warped_fungus";
    private final DataGenerator generator;
    public SpeciesProvider(DataGenerator generator)
    {
        this.generator = generator;
    }

    @Override
    public void run(CachedOutput hashCache)
    {
        //FIXME all the fungi need some work
        SpeciesBuilder.getInstance().createSpecies("Amanita rubra")
                .type(CRIMSON_TYPE)
                .colors(new int[]{ 16777164, 16724736, 15921906, 15921906 })
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(AreaEffect.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .build(generator,hashCache);

        SpeciesBuilder.getInstance().createSpecies("Boletus salubrium")
                .type(CRIMSON_TYPE)
                .colors(new int[]{96564928, -1231718516, 751835909, -1044800857})
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(AreaEffect.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .build(generator,hashCache);

        SpeciesBuilder.getInstance().createSpecies("Noble boletus squisitus")
                .type(CRIMSON_TYPE)
                .colors(new int[]{ 0xecd7ae, 0xa5887d, 0xa5887d, 0xffe6dd })
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(AreaEffect.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .build(generator, hashCache);

/////////////////////////////
//      Mineral fungi      //
/////////////////////////////
        SpeciesBuilder.getInstance().createSpecies("Russula lazula")
                .type(WARPED_TYPE)
                .colors(new int[]{0xffffcc, 0x81726d, 0x183679, 0x2653b9})
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.FOREST)
                .areaEffect(AreaEffect.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .build(generator, hashCache);

        SpeciesBuilder.getInstance().createDefaultSpecies("Amanita cuprea")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xbb9173, 0xe8693d, 0x208068, 0x208068})
                .build(generator, hashCache);
    }

    public static class AreaEffect
    {
        public static final AreaEffect NO_EFFECT = new AreaEffect(3, "none");
        public int areaRadius;
        public String effect;

        public AreaEffect(int areaRadius, String effect)
        {
            this.areaRadius = areaRadius;
            this.effect = effect;
        }
    }

    public static class FungusSpawn
    {
        public static final FungusSpawn DEFAULT_SPAWN = new FungusSpawn("",0.5f);

        public String biomes;
        public float chance;

        public FungusSpawn(String biomes, float chance)
        {
            this.biomes = biomes;
            this.chance = chance;
        }
    }

    public static class BiomesSpecs
    {
        public static final BiomesSpecs JUNGLE = new BiomesSpecs(0.9f, 0.95f);
        public static final BiomesSpecs MUSHROOM_FIELDS = new BiomesSpecs(1f, 0.9f);
        public static final BiomesSpecs PLAINS = new BiomesSpecs(0.4f, 0.8f);
        public static final BiomesSpecs SWAMP = new BiomesSpecs(0.9f, 0.8f);
        public static final BiomesSpecs FOREST = new BiomesSpecs(0.8f, 0.7f);
        public static final BiomesSpecs LUSH_CAVES = new BiomesSpecs(0.5f, 0.5f);
        public static final BiomesSpecs TAIGA = new BiomesSpecs(0.8f, 0.25f);
        public static final BiomesSpecs SNOWY_PLAINS = new BiomesSpecs(0.5f, 0f);
        public static final BiomesSpecs SNOWY_TAIGA = new BiomesSpecs(0.4f, -0.5f);
        public float humidity;
        public float temperature;

        public BiomesSpecs(float humidity, float temperature)
        {
            this.humidity = humidity;
            this.temperature = temperature;
        }
    }

    public static void createSpeciesDefault(String speciesName, String type, @Nonnull int[] colors, DataGenerator gentor,
                                            CachedOutput hashCache)
    {
        SpeciesBuilder.getInstance().createSpecies(speciesName)
                .type(type)
                .colors(colors)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.FOREST)
                .areaEffect(AreaEffect.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .build(gentor, hashCache);
    }

    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
