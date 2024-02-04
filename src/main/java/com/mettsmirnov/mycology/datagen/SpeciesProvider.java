package com.mettsmirnov.mycology.datagen;

import com.mettsmirnov.mycology.effects.FungusEffects;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import com.mettsmirnov.mycology.datagen.common.BiomesSpecs;
import com.mettsmirnov.mycology.datagen.common.FungusSpawn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.mettsmirnov.mycology.datagen.SpeciesBuilder.CRIMSON_TYPE;
import static com.mettsmirnov.mycology.datagen.SpeciesBuilder.WARPED_TYPE;

public class SpeciesProvider implements DataProvider//TODO
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

        SpeciesBuilder.getInstance().createSpecies("Boletus salubrium")
                .type(CRIMSON_TYPE)
                .colors(new int[]{ 0xC176C0, 0x95778C, 0xD01B05, 0xB99AA7})
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.HEALING_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator,hashCache, list);
        /////////////////////////////
        //      Colors fungi       //
        /////////////////////////////
        SpeciesBuilder.getInstance().createSpecies("Amanita rubra")
                .type(CRIMSON_TYPE)
                .colors4(0xFFFFCC, 0xFF3300, 0xF2F2F2, 0xF2F2F2)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator,hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("ORANGE_FUNGUS")
                .colors1(0xff8701)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("YELLOW_FUNGUS")
                .colors1(0xfff620)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("LIME_FUNGUS")
                .colors1(0x67ff32)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createSpecies("Lactarius viridis")
                .type(WARPED_TYPE)
                .colors(new int[]{ 0xBF98BF, 0x96FE53, 0x99110F, 0xF502D3 })
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator,hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("CYAN_FUNGUS")
                .colors1(0x198185)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("LIGHTBLUE_FUNGUS")
                .colors1(0x41d3ff)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("BLUE_FUNGUS")
                .colors1(0x1c1bff)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createSpecies("VIOLET_ovulus")
                .type(CRIMSON_TYPE)
                .colors(new int[]{ 0xAA48FB, 0xA81343, 0x38A23F19, 0x73E105EF })
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator,hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("MAGENTA_FUNGUS")
                .colors1(0xff44de)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("PINK_FUNGUS")
                .colors1(0xff94c1)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("BROWN_FUNGUS")
                .colors1(0x89501e)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("BLACK_FUNGUS")
                .colors1(0x202020)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("GREY_FUNGUS")
                .colors1(0x535353)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("LIGHTGREY_FUNGUS")
                .colors1(0x999999)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("WHITE_FUNGUS")
                .colors1(0xffffff)
                .buildAndAddToList(generator, hashCache, list);

        /////////////////////////////
        //      Edible fungi       //
        /////////////////////////////
        //Sugar fungus
        SpeciesBuilder.getInstance().createProtoSpecies("Laccaria dulcis") //oppure "Amanita dulcis"
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createSpecies("Noble boletus squisitus")
                .type(CRIMSON_TYPE)
                .colors(new int[]{ 0xecd7ae, 0xa5887d, 0xa5887d, 0xffe6dd })
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:podzol")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator, hashCache, list);

        /////////////////////////////
        //      Toxic fungi        //
        /////////////////////////////
        SpeciesBuilder.getInstance().createProtoSpecies("Amanita phalloides")
                .colors4(0xffdb94, 0xc71c12, 0xe8e8e8, 0xF2F2F2)
                .buildAndAddToList(generator, hashCache, list);

        //Wither fungus
        SpeciesBuilder.getInstance().createDefaultSpecies("Sarcosphaera arescens")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("mycologymod:nether")
                .areaEffect(FungusEffects.WITHERING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("POISON_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.POISON_EFFECT)
                .buildAndAddToList(generator, hashCache, list);

        /////////////////////////////
        //     Materials fungi     //
        /////////////////////////////
        SpeciesBuilder.getInstance().createProtoSpecies("Polyporus ligneus")
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
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.DEFAULT_SPAWN)
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("REDSTONE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:redstone_ores")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("Amanita cuprea")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xbb9173, 0xe8693d, 0x208068, 0x20a387})
                .terrain("minecraft:copper_ores")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("IRON_FUNGUS")
                .type(WARPED_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:iron_ores")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createProtoSpecies("AMETHYST_FUNGUS")
                .terrain("mycologymod:amethyst")
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

        SpeciesBuilder.getInstance().createDefaultSpecies("END_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xe7f1b1, 0x3e0588, 0xa058ae, 0x490a61})
                .terrain("mycologymod:endstone")
                .buildAndAddToList(generator, hashCache, list);

        SpeciesBuilder.getInstance().createDefaultSpecies("Tricholomopsis evanescens")
                .type(CRIMSON_TYPE)
                .setRecessive()
                .colors(new int[]{0x87cfec, 0x06d192, 0x69d0af, 0x068054})
                .terrain("mycologymod:endstone")
                .buildAndAddToList(generator, hashCache, list);
        /////////////////////////////////
        //    Special effects fungi    //
        /////////////////////////////////
        //TODO be rearranged
        SpeciesBuilder.getInstance().createProtoSpecies("DRUNK_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.DRUNK_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("FATIGUE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.FATIGUE_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("STRENGTH_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.STRENGTH_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("ANESTHETIC_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.ANESTHETIC_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("ILLUCINATING_FUNGUS")
                .areaEffect(FungusEffects.ILLUCINATING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("HALLUCINATING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.HALLUCINATING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("RADIOACTIVE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.RADIOACTIVE_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("BLINDING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.BLINDING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("PHANTOM_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.PHANTOM_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("NIGHTLY_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.NIGHTLY_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("SENSING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SENSING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("SHINING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SHINING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("SCHIZO_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SCHIZO_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("SPARKLING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SPARKLING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("RAPTING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.RAPTING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("TELEPORTING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.TELEPORTING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("LIGHTFUL_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.LIGHTFUL_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("GOODCHANCE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.GOODCHANCE_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("LEARNING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.LEARNING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("KNOWLEDGE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.KNOWLEDGE_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("SPORING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SPORING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("DYEING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.DYEING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        SpeciesBuilder.getInstance().createProtoSpecies("FERTILIZING_EFFECT_FUNGUS")
                .colors4(0xFFE3BF, 0xFFF8DC, 0xDBDAD7, 0xC8C1B5)
                .areaEffect(FungusEffects.FERTILIZING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        /////////////////////////
        //      DEV fungi      //
        /////////////////////////
        SpeciesBuilder.getInstance().createProtoSpecies("DEV_FUNGUS")
                .areaEffect(FungusEffects.DEV_TEST_EFFECT)
                .areaRadius(1)
                .buildAndAddToList(generator, hashCache, list);
        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
