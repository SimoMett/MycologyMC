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

public class SpeciesProvider implements DataProvider
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
        SpeciesBuilder speciesBuilder = new SpeciesBuilder(this.generator, hashCache, list);
        speciesBuilder.createSpecies("Boletus salubrium")
                .type(CRIMSON_TYPE)
                .colors4(0xC176C0, 0x95778C, 0xD01B05, 0xB99AA7)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.HEALING_EFFECT)
                .spawnType(FungusSpawn.ANY_BIOME)
                .buildAndAddToList(generator,hashCache, list);
        speciesBuilder.createProtoSpecies("GREEN_FUNGUS_2")
                .colors4(0xD36146, 0x9BC859, 0x619B68, 0x3A734C)
                .buildAndAddToList(generator, hashCache, list);
        /////////////////////////////
        //      Colors fungi       //
        /////////////////////////////
        speciesBuilder.createSpecies("Amanita rubra")
                .type(CRIMSON_TYPE)
                .colors4(0xFFFFCC, 0xFF3300, 0xF2F2F2, 0xF2F2F2)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.DARK_FOREST)
                .buildAndAddToList(generator,hashCache, list);

        speciesBuilder.createProtoSpecies("ORANGE_FUNGUS")
                .colors1(0xff8701)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("LIME_FUNGUS")
                .colors1(0x67ff32)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("CYAN_FUNGUS")
                .colors1(0x198185)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("LIGHTBLUE_FUNGUS")
                .colors1(0x41d3ff)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createSpecies("Ovulus_VIOLET")
                .type(CRIMSON_TYPE)
                .colors4(0xAA48FB, 0xA81343, 0xA23F19, 0xE105EF)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.ANY_BIOME)
                .buildAndAddToList(generator,hashCache, list);

        speciesBuilder.createProtoSpecies("MAGENTA_FUNGUS")
                .colors1(0xff44de)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("PINK_FUNGUS")
                .colors1(0xff94c1)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("BROWN_FUNGUS")
                .colors1(0x89501e)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("BLACK_FUNGUS")
                .colors1(0x202020)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("GREY_FUNGUS")
                .colors1(0x535353)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("LIGHTGREY_FUNGUS")
                .colors1(0x999999)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("WHITE_FUNGUS")
                .colors1(0xffffff)
                .buildAndAddToList(generator, hashCache, list);

        /////////////////////////////
        //      Edible fungi       //
        /////////////////////////////
        //Sugar fungus
        speciesBuilder.createProtoSpecies("Laccaria dulcis") // or "Amanita dulcis"
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createSpecies("Noble boletus squisitus")// derived from "boletus edulis"
                .type(CRIMSON_TYPE)
                .colors4(0xFFE6D8, 0xEDB4B4, 0xBE8C85, 0xFFE4E2)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:podzol")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.ANY_BIOME)
                .buildAndAddToList(generator, hashCache, list);

        /////////////////////////////
        //      Toxic fungi        //
        /////////////////////////////
        speciesBuilder.createProtoSpecies("Amanita phalloides")
                .colors4(0xffdb94, 0xc71c12, 0xe8e8e8, 0xF2F2F2)
                .spawnType(FungusSpawn.SWAMP)
                .buildAndAddToList(generator, hashCache, list);

        //Wither fungus
        speciesBuilder.createDefaultSpecies("Sarcosphaera arescens")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("mycologymod:nether")
                .areaEffect(FungusEffects.WITHERING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("POISON_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.POISON_EFFECT)
                .buildAndAddToList(generator, hashCache, list);

        /////////////////////////////
        //     Materials fungi     //
        /////////////////////////////
        speciesBuilder.createProtoSpecies("Polyporus ligneus")
                .terrain("minecraft:logs")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("GRANITE_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("DIORITE_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("ANDESITE_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("OBSIDIAN_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("BASALT_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("CLAY_FUNGUS")
                .terrain("mycologymod:clay")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("TERRACOTTA_FUNGUS")
                .terrain("minecraft:terracotta")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("SNOW_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("SOULSAND_FUNGUS")
                .terrain("mycologymod:soul_sand")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("PRISMARINE_FUNGUS")
                .terrain("mycologymod:prismarine")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("PURPUR_SUSTAINED_FUNGUS")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("MAGMABLOCK_SUSTAINED_FUNGUS")
                .terrain("mycologymod:magma_block")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("BONEBLOCK_SUSTAINED_FUNGUS")
                .terrain("mycologymod:bone_block")
                .buildAndAddToList(generator, hashCache, list);


        /////////////////////////////
        //      Mineral fungi      //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies("COAL_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:coal_ores")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("EMERALD_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:emerald_ores")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("GLOWSTONE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xff4d45, 0xffdb4a, 0xdcc677, 0xfff3cd})
                .terrain("mycologymod:nether")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("Galerina aurata") //Gold
                .type(WARPED_TYPE)
                .colors(new int[]{0xeed484, 0xffc21a, 0xffc96c, 0xfff59f})//FIXME
                .terrain("minecraft:gold_ores")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("Bolbitius silex") //Quartz
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("mycologymod:quartz_ores")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createSpecies("Russula lazula") //Lapislazuli
                .type(WARPED_TYPE)
                .colors(new int[]{0xffffcc, 0x81726d, 0x183679, 0x2653b9})//FIXME
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("minecraft:lapis_ores")
                .biomesSpecs(BiomesSpecs.FOREST)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.ANY_BIOME)
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("REDSTONE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:redstone_ores")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("Amanita cuprea") //Copper
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xbb9173, 0xe8693d, 0x208068, 0x20a387})
                .terrain("minecraft:copper_ores")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("IRON_FUNGUS")
                .type(WARPED_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:iron_ores")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createProtoSpecies("AMETHYST_FUNGUS")
                .terrain("mycologymod:amethyst")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("DIAMOND_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:diamond_ores")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("EXPERIENCE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0x87CFEC, 0x2F94F9, 0x398D4C, 0xB4DF57})
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("BLAZE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("mycologymod:nether_bricks")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("NETHERITE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("mycologymod:netherite")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("END_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xe7f1b1, 0x3e0588, 0xa058ae, 0x490a61})
                .terrain("mycologymod:endstone")
                .buildAndAddToList(generator, hashCache, list);

        speciesBuilder.createDefaultSpecies("Tricholomopsis evanescens")
                .type(CRIMSON_TYPE)
                .setRecessive()
                .colors(new int[]{0x87cfec, 0x06d192, 0x69d0af, 0x068054})
                .terrain("mycologymod:endstone")
                .buildAndAddToList(generator, hashCache, list);
        /////////////////////////////////
        //    Special effects fungi    //
        /////////////////////////////////
        //TODO be rearranged
        speciesBuilder.createProtoSpecies("DRUNK_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.DRUNK_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("FATIGUE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.FATIGUE_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("STRENGTH_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.STRENGTH_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("ANESTHETIC_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.ANESTHETIC_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("ILLUCINATING_FUNGUS")
                .areaEffect(FungusEffects.ILLUCINATING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("HALLUCINATING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.HALLUCINATING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("RADIOACTIVE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.RADIOACTIVE_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("BLINDING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.BLINDING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("PHANTOM_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.PHANTOM_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("NIGHTLY_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.NIGHTLY_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("SENSING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SENSING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("SHINING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SHINING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("SCHIZO_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SCHIZO_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("SPARKLING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SPARKLING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("RAPTING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.RAPTING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("TELEPORTING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.TELEPORTING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("LIGHTFUL_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.LIGHTFUL_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("GOODCHANCE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.GOODCHANCE_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("LEARNING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.LEARNING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("KNOWLEDGE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.KNOWLEDGE_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("DYEING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.DYEING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("FERTILIZING_EFFECT_FUNGUS")
                .colors4(0xFFE3BF, 0xFFF8DC, 0xDBDAD7, 0xC8C1B5)
                .areaEffect(FungusEffects.FERTILIZING_EFFECT)
                .buildAndAddToList(generator, hashCache, list);
        ////////////////////////////
        //      Native fungi      //
        ////////////////////////////
        speciesBuilder.createProtoSpecies("Agaricus campestris")//plains native
                .type(WARPED_TYPE)
                .colors4(0xFFF7E7, 0xFFF7E7, 0xC7C1B4, 0xA8A398)//FIXME darker
                .biomesSpecs(BiomesSpecs.PLAINS)
                .spawnType(FungusSpawn.PLAINS)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createSpecies("Lactarius viridis")//sunflower plains native
                .type(WARPED_TYPE)
                .colors(new int[]{ 0xBF98BF, 0x6bb83c, 0x99110F, 0xF502D3 })//FIXME
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.PLAINS)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.SUNFLOWER_PLAINS)
                .buildAndAddToList(generator,hashCache, list);
        speciesBuilder.createProtoSpecies("Leccinum versipelle") //Birch forest native
                .type(WARPED_TYPE)
                .colors4(0xFFFBFB, 0xFF7C2D, 0x885431, 0xBD7142)//FIXME
                .biomesSpecs(BiomesSpecs.BIRCH_FOREST)
                .spawnType(FungusSpawn.BIRCH_FOREST)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("Boletus edulis") //Forest native
                .colors4(0xecd7ae, 0xa5887d, 0xa5887d, 0xffe6dd)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FOREST)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("Suillus granulatus")
                .type(WARPED_TYPE)
                .colors4(0xFFF7E7, 0xFFA376, 0xC47D5A, 0xD88A64)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_PINE_TAIGA)
                .spawnType(FungusSpawn.OLD_GROWTH_PINE_TAIGA)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("Chalciporus piperatus")//non edible
                .colors4(0xFFC741, 0xEE7A1A, 0x64330B, 0x8E6C24)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_SPRUCE_TAIGA)
                .spawnType(FungusSpawn.OLD_GROWTH_SPRUCE_TAIGA)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("Amanita muscaria")//poisonous
                .type(WARPED_TYPE)
                .colors4(0xFFFCD9, 0xFF521E, 0xFFFFFF, 0xFFB171)
                .biomesSpecs(BiomesSpecs.JUNGLE)
                .spawnType(FungusSpawn.JUNGLE)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("YELLOW_FUNGUS")//meadow native
                .colors1(0xfff620)
                .biomesSpecs(BiomesSpecs.MEADOW)
                .spawnType(FungusSpawn.MEADOW)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("BLUE_FUNGUS")//flower forest native
                .colors1(0x1c1bff)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FLOWER_FOREST)
                .buildAndAddToList(generator, hashCache, list);
        speciesBuilder.createProtoSpecies("RARE_MUSHROOM_FIELDS_NATIVE")
                .areaEffect(FungusEffects.SPORING_EFFECT)
                .biomesSpecs(BiomesSpecs.MUSHROOM_FIELDS)
                .spawnType(FungusSpawn.MUSHROOM_FIELDS)
                .buildAndAddToList(generator, hashCache, list);
        /////////////////////////
        //      DEV fungi      //
        /////////////////////////
        speciesBuilder.createProtoSpecies("DEV_FUNGUS")
                .colors4(0x5567E5, 0x9F55B5, 0xBF5DAF, 0xD32BD9)
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
