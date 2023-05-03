package com.mettsmirnov.mycology.datagen;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import com.mettsmirnov.mycology.effects.FungusEffect;
import com.mettsmirnov.mycology.datagen.common.BiomesSpecs;
import com.mettsmirnov.mycology.datagen.common.FungusSpawn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SpeciesProvider implements DataProvider//TODO FIXME
{
    private static final String CRIMSON_TYPE = "colored_crimson_fungus";
    private static final String WARPED_TYPE = "colored_warped_fungus";
    private final DataGenerator generator;
    public SpeciesProvider(DataGenerator generator)
    {
        this.generator = generator;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput hashCache)
    {
        //FIXME all the fungi need some work
        List<CompletableFuture<?>> list = new ArrayList<>();

        SpeciesBuilder.getInstance().createSpecies("Amanita rubra")
                .type(CRIMSON_TYPE)
                .colors(new int[]{ 16777164, 16724736, 15921906, 15921906 })
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffect.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator,hashCache, list);

        SpeciesBuilder.getInstance().createSpecies("Boletus salubrium")
                .type(CRIMSON_TYPE)
                .colors(new int[]{96564928, -1231718516, 751835909, -1044800857})
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffect.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator,hashCache, list);

        SpeciesBuilder.getInstance().createSpecies("Noble boletus squisitus")
                .type(CRIMSON_TYPE)
                .colors(new int[]{ 0xecd7ae, 0xa5887d, 0xa5887d, 0xffe6dd })
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffect.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator, hashCache, list);

/////////////////////////////
//      Edible fungi       //
/////////////////////////////

/////////////////////////////
//      Toxic fungi        //
/////////////////////////////

        /*

        "Amanita phalloides"
        "

         */

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
                .areaEffect(FungusEffect.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("Amanita cuprea")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xbb9173, 0xe8693d, 0x208068, 0x208068})
                .buildAndAddToList(generator, hashCache, list);

        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
