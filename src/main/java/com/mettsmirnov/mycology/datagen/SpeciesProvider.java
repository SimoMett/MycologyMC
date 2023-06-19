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

import static com.mettsmirnov.mycology.datagen.SpeciesBuilder.CRIMSON_TYPE;
import static com.mettsmirnov.mycology.datagen.SpeciesBuilder.WARPED_TYPE;

public class SpeciesProvider implements DataProvider//TODO FIXME
{
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
                .areaEffect(FungusEffect.HEALING_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator,hashCache, list);

        SpeciesBuilder.getInstance().createSpecies("Noble boletus squisitus")
                .type(CRIMSON_TYPE)
                .colors(new int[]{ 0xecd7ae, 0xa5887d, 0xa5887d, 0xffe6dd })
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:podzol")
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
        SpeciesBuilder.getInstance().createProtoSpecies("Amanita phalloides")
                .buildAndAddToList(generator, hashCache, list);

/////////////////////////////
//     Materials fungi     //
/////////////////////////////
        SpeciesBuilder.getInstance().createProtoSpecies("WOOD_FUNGUS")
                .terrain("minecraft:logs")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("GRANITE_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("DIORITE_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("ANDESITE_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("OBSIDIAN_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("BASALT_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("CLAY_FUNGUS")
                .terrain("mycologymod:clay")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("TERRACOTTA_FUNGUS")
                .terrain("minecraft:terracotta")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("SNOW_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("SOULSAND_FUNGUS")
                .terrain("mycologymod:soul_sand")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("PRISMARINE_FUNGUS")
                .terrain("mycologymod:prismarine")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("PURPUR_SUSTAINED_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("MAGMABLOCK_SUSTAINED_FUNGUS")
                .terrain("mycologymod:magma_block")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("BONEBLOCK_SUSTAINED_FUNGUS")
                .terrain("mycologymod:bone_block")
                .buildAndAddToList(generator, hashCache, list);


/////////////////////////////
//      Mineral fungi      //
/////////////////////////////
        SpeciesBuilder.getInstance().createDefaultSpecies("COAL_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:coal_ores")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("EMERALD_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:emerald_ores")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("GLOWSTONE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xff4d45, 0xffdb4a, 0xdcc677, 0xfff3cd})
                .terrain("mycologymod:nether")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("Galerina aurata")
                .type(WARPED_TYPE)
                .colors(new int[]{0xeed484, 0xffc21a, 0xffc96c, 0xfff59f})
                .terrain("minecraft:gold_ores")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("Bolbitius silex") //Quartz
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("mycologymod:quartz_ores")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createSpecies("Russula lazula")
                .type(WARPED_TYPE)
                .colors(new int[]{0xffffcc, 0x81726d, 0x183679, 0x2653b9})
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("minecraft:lapis_ores")
                .biomesSpecs(BiomesSpecs.FOREST)
                .areaEffect(FungusEffect.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("REDSTONE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:redstone_ores")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("Amanita cuprea")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xbb9173, 0xe8693d, 0x208068, 0x208068})
                .terrain("minecraft:copper_ores")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("IRON_FUNGUS")
                .type(WARPED_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:iron_ores")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("DIAMOND_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:diamond_ores")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("EXPERIENCE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0x87CFEC, 0x2F94F9, 0x398D4C, 0xB4DF57})
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("BLAZE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("mycologymod:nether_bricks")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("NETHERITE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("mycologymod:netherite")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("WITHER_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("mycologymod:nether")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("END_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xe7f1b1, 0x3e0588, 0xa058ae, 0x490a61})
                .terrain("mycologymod:endstone")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("ENDER_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0x87cfec, 0x06d192, 0x69d0af, 0x068054})
                .terrain("mycologymod:endstone")
                .buildAndAddToList(generator, hashCache, list);


        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
