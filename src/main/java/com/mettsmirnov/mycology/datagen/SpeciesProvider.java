package com.mettsmirnov.mycology.datagen;

import com.mettsmirnov.mycology.datagen.common.AreaEffect;
import com.mettsmirnov.mycology.datagen.common.BiomesSpecs;
import com.mettsmirnov.mycology.datagen.common.FungusSpawn;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;

import javax.annotation.Nonnull;

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
