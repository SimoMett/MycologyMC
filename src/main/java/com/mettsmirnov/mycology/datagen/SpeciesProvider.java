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
                .build();
        speciesBuilder.createProtoSpecies("GREEN_FUNGUS_2")
                .colors4(0xD36146, 0x9BC859, 0x619B68, 0x3A734C)
                .build();
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
                .build();

        speciesBuilder.createProtoSpecies("ORANGE_FUNGUS")
                .colors1(0xff8701)
                .build();

        speciesBuilder.createProtoSpecies("LIME_FUNGUS")
                .colors1(0x67ff32)
                .build();

        speciesBuilder.createProtoSpecies("CYAN_FUNGUS")
                .colors1(0x198185)
                .build();

        speciesBuilder.createProtoSpecies("LIGHTBLUE_FUNGUS")
                .colors1(0x41d3ff)
                .build();

        speciesBuilder.createSpecies("Ovulus violaceus")
                .type(CRIMSON_TYPE)
                .colors4(0xAA48FB, 0xA81343, 0xA23F19, 0xE105EF)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.ANY_BIOME)
                .build();

        speciesBuilder.createProtoSpecies("MAGENTA_FUNGUS")
                .colors1(0xff44de)
                .build();

        speciesBuilder.createProtoSpecies("PINK_FUNGUS")
                .colors1(0xff94c1)
                .build();

        speciesBuilder.createProtoSpecies("BROWN_FUNGUS")
                .colors1(0x89501e)
                .build();

        speciesBuilder.createProtoSpecies("BLACK_FUNGUS")
                .colors1(0x202020)
                .build();

        speciesBuilder.createProtoSpecies("GREY_FUNGUS")
                .colors1(0x535353)
                .build();

        speciesBuilder.createProtoSpecies("LIGHTGREY_FUNGUS")
                .colors1(0x999999)
                .build();

        speciesBuilder.createProtoSpecies("WHITE_FUNGUS")
                .type(WARPED_TYPE)
                .colors1(0xffffff)
                .build();

        /////////////////////////////
        //      Edible fungi       //
        /////////////////////////////
        //Sugar fungus
        speciesBuilder.createProtoSpecies("Laccaria dulcis") // or "Amanita dulcis"
                .build();

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
                .build();

        /////////////////////////////
        //      Toxic fungi        //
        /////////////////////////////

        //Wither fungus
        speciesBuilder.createDefaultSpecies("Sarcosphaera arescens")
                .type(CRIMSON_TYPE)
                .colors4(0x9E928F, 0x5b5b5b, 0x585858, 0xe1e1e1)
                .terrain("mycologymod:nether")
                .areaEffect(FungusEffects.WITHERING_EFFECT)
                .build();

        speciesBuilder.createProtoSpecies("POISON_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.POISON_EFFECT)
                .build();

        /////////////////////////////
        //     Materials fungi     //
        /////////////////////////////
        speciesBuilder.createProtoSpecies("Polyporus ligneus")
                .type(WARPED_TYPE)
                .terrain("minecraft:logs")
                .build();

        speciesBuilder.createProtoSpecies("GRANITE_FUNGUS")
                .build();

        speciesBuilder.createProtoSpecies("DIORITE_FUNGUS")
                .build();

        speciesBuilder.createProtoSpecies("ANDESITE_FUNGUS")
                .build();

        speciesBuilder.createProtoSpecies("OBSIDIAN_FUNGUS")
                .colors4(0x300b5f, 0x2a1e4b, 0x36205a, 0x432e69)
                .build();

        speciesBuilder.createProtoSpecies("BASALT_FUNGUS")
                .build();

        speciesBuilder.createProtoSpecies("CLAY_FUNGUS")
                .terrain("mycologymod:clay")
                .build();

        speciesBuilder.createProtoSpecies("TERRACOTTA_FUNGUS")
                .terrain("minecraft:terracotta")
                .build();

        speciesBuilder.createProtoSpecies("SNOW_FUNGUS")
                .build();

        speciesBuilder.createProtoSpecies("PRISMARINE_FUNGUS")
                .terrain("mycologymod:prismarine")
                .build();

        speciesBuilder.createProtoSpecies("PURPUR_SUSTAINED_FUNGUS")
                .build();

        speciesBuilder.createProtoSpecies("MAGMABLOCK_SUSTAINED_FUNGUS")
                .terrain("mycologymod:magma_block")
                .build();

        speciesBuilder.createProtoSpecies("BONEBLOCK_SUSTAINED_FUNGUS")
                .terrain("mycologymod:bone_block")
                .build();
        /////////////////////////////
        //      Mineral fungi      //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies("COAL_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:coal_ores")
                .build();

        speciesBuilder.createDefaultSpecies("EMERALD_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:emerald_ores")
                .build();

        speciesBuilder.createDefaultSpecies("GLOWSTONE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xff4d45, 0xffdb4a, 0xdcc677, 0xfff3cd})
                .terrain("mycologymod:nether")
                .build();

        speciesBuilder.createDefaultSpecies("Galerina aurata") //Gold
                .type(WARPED_TYPE)
                .colors(new int[]{0xeed484, 0xffc21a, 0xffc96c, 0xfff59f})//FIXME
                .terrain("minecraft:gold_ores")
                .build();

        speciesBuilder.createDefaultSpecies("Bolbitius silex") //Quartz
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("mycologymod:quartz_ores")
                .build();

        speciesBuilder.createSpecies("Russula lazula") //Lapislazuli
                .type(WARPED_TYPE)
                .colors4(0xffffcc, 0x837672, 0x183679, 0x2653b9)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("minecraft:lapis_ores")
                .biomesSpecs(BiomesSpecs.FOREST)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.ANY_BIOME)
                .build();

        speciesBuilder.createDefaultSpecies("REDSTONE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:redstone_ores")
                .build();

        speciesBuilder.createDefaultSpecies("Amanita cuprea") //Copper
                .type(WARPED_TYPE)
                .colors4(0xbb9173, 0xe8693d, 0x208068, 0x20a387)
                .terrain("minecraft:copper_ores")
                .build();

        speciesBuilder.createDefaultSpecies("Xerocomus ferrugineus")
                .type(WARPED_TYPE)
                .colors4(0xffffcc, 0x95867e, 0xC0997F, 0xFBD3B8)
                .terrain("minecraft:iron_ores")
                .build();

        speciesBuilder.createProtoSpecies("AMETHYST_FUNGUS")
                .terrain("mycologymod:amethyst")
                .build();

        speciesBuilder.createDefaultSpecies("DIAMOND_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0, 0, 0, 0})
                .terrain("minecraft:diamond_ores")
                .build();

        speciesBuilder.createDefaultSpecies("EXPERIENCE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0x87CFEC, 0x2F94F9, 0x398D4C, 0xB4DF57})
                .areaEffect(FungusEffects.EXPORBS_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies("BLAZE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors4(0xFF7B00, 0xFF9900, 0xFFDD36, 0xFFFF73)
                .areaEffect(FungusEffects.BLAZING_EFFECT)
                .terrain("mycologymod:nether_bricks")
                .build();

        speciesBuilder.createDefaultSpecies("Polyporus antiquus")
                .type(CRIMSON_TYPE)
                .colors4(0x52362F, 0x52362F, 0x29130D, 0x52362F)
                .terrain("mycologymod:netherite")
                .build();

        speciesBuilder.createDefaultSpecies("NETHERITE_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors4(0x7b716d, 0x48413c, 0x272624, 0x4a484a)
                .terrain("mycologymod:netherite")
                .build();

        speciesBuilder.createDefaultSpecies("END_FUNGUS")
                .type(CRIMSON_TYPE)
                .colors(new int[]{0xe7f1b1, 0x3e0588, 0xa058ae, 0x490a61})
                .terrain("mycologymod:endstone")
                .build();

        speciesBuilder.createDefaultSpecies("Tricholomopsis evanescens")
                .type(CRIMSON_TYPE)
                .setRecessive()
                .colors(new int[]{0x87cfec, 0x06d192, 0x69d0af, 0x068054})
                .terrain("mycologymod:endstone")
                .build();
        /////////////////////////////////
        //    Special effects fungi    //
        /////////////////////////////////
        //TODO be rearranged
        speciesBuilder.createProtoSpecies("DRUNK_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.DRUNK_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("FATIGUE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.FATIGUE_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("STRENGTH_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.STRENGTH_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("ANESTHETIC_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.ANESTHETIC_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("ILLUCINATING_FUNGUS")
                .areaEffect(FungusEffects.ILLUCINATING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("HALLUCINATING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.HALLUCINATING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("RADIOACTIVE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.RADIOACTIVE_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("BLINDING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.BLINDING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("PHANTOM_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.PHANTOM_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("NIGHTLY_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.NIGHTLY_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("SENSING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SENSING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("SHINING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SHINING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("SCHIZO_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SCHIZO_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("SPARKLING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SPARKLING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("RAPTING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.RAPTING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("TELEPORTING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.TELEPORTING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("LIGHTFUL_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.LIGHTFUL_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("GOODCHANCE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.GOODCHANCE_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("LEARNING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.LEARNING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("KNOWLEDGE_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.KNOWLEDGE_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("DYEING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.DYEING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("FERTILIZING_EFFECT_FUNGUS")
                .colors4(0xFFE3BF, 0xFFF8DC, 0xDBDAD7, 0xC8C1B5)
                .areaEffect(FungusEffects.FERTILIZING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("UNDEAD_EFFECT_FUNGUS")
                .colors4(0xD36146, 0x9BC859, 0x4891ff, 0x4b54bb)
                .areaRadius(2)
                .areaEffect(FungusEffects.UNDEAD_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("CREEPING_EFFECT_FUNGUS")
                .areaRadius(2)
                .areaEffect(FungusEffects.CREEPING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("SKELETONS_EFFECT_FUNGUS")
                .areaRadius(2)
                .areaEffect(FungusEffects.SKELETONS_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("GHASTLY_EFFECT_FUNGUS")
                .areaRadius(2)
                .areaEffect(FungusEffects.GHASTLY_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("LIGHTNING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.LIGHTNING_EFFECT)
                .build();
        //////////////////////////////
        //  Overworld native fungi  //
        //////////////////////////////
        speciesBuilder.createProtoSpecies("Agaricus campestris")//plains native
                .type(WARPED_TYPE)
                .colors4(0xFFF7E7, 0xFFF7E7, 0xC7C1B4, 0xA8A398)//FIXME darker
                .biomesSpecs(BiomesSpecs.PLAINS)
                .spawnType(FungusSpawn.PLAINS)
                .build();
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
                .build();
        speciesBuilder.createProtoSpecies("Leccinum versipelle") //Birch forest native
                .type(WARPED_TYPE)
                .colors4(0xFFFBFB, 0xFF7C2D, 0x885431, 0xBD7142)//FIXME
                .biomesSpecs(BiomesSpecs.BIRCH_FOREST)
                .spawnType(FungusSpawn.BIRCH_FOREST)
                .build();
        speciesBuilder.createProtoSpecies("Boletus edulis") //Forest native
                .colors4(0xecd7ae, 0xa5887d, 0xa5887d, 0xffe6dd)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FOREST)
                .build();
        speciesBuilder.createProtoSpecies("Suillus granulatus")
                .type(WARPED_TYPE)
                .colors4(0xFFF7E7, 0xFFA376, 0xC47D5A, 0xD88A64)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_PINE_TAIGA)
                .spawnType(FungusSpawn.OLD_GROWTH_PINE_TAIGA)
                .build();
        speciesBuilder.createProtoSpecies("Chalciporus piperatus")//non edible
                .colors4(0xFFC741, 0xEE7A1A, 0x64330B, 0x8E6C24)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_SPRUCE_TAIGA)
                .spawnType(FungusSpawn.OLD_GROWTH_SPRUCE_TAIGA)
                .build();
        speciesBuilder.createProtoSpecies("Amanita muscaria")//poisonous
                .type(WARPED_TYPE)
                .colors4(0xFFFCD9, 0xFF521E, 0xFFFFFF, 0xFFB171)
                .biomesSpecs(BiomesSpecs.JUNGLE)
                .spawnType(FungusSpawn.JUNGLE)
                .build();
        speciesBuilder.createProtoSpecies("Amanita phalloides")
                .colors4(0xffdb94, 0xc71c12, 0xe8e8e8, 0xF2F2F2)
                .biomesSpecs(BiomesSpecs.SWAMP)
                .spawnType(FungusSpawn.SWAMP)
                .build();
        speciesBuilder.createProtoSpecies("YELLOW_FUNGUS")//meadow native
                .colors1(0xfff620)
                .biomesSpecs(BiomesSpecs.MEADOW)
                .spawnType(FungusSpawn.MEADOW)
                .build();
        speciesBuilder.createProtoSpecies("BLUE_FUNGUS")//flower forest native
                .colors1(0x1c1bff)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FLOWER_FOREST)
                .build();
        speciesBuilder.createProtoSpecies("RARE_MUSHROOM_FIELDS_NATIVE")
                .areaEffect(FungusEffects.SPORING_EFFECT)
                .biomesSpecs(BiomesSpecs.MUSHROOM_FIELDS)
                .spawnType(FungusSpawn.MUSHROOM_FIELDS)
                .build();
        speciesBuilder.createProtoSpecies("DEEPSLATE_SUSTAINED_FUNGUS")//fungus found in caves
                .type(CRIMSON_TYPE)
                .colors4(0x8c909c, 0xcbd0db, 0x3f4045, 0x2b2d31)
                .spawnType(FungusSpawn.CAVES)
                .terrain("mycologymod:deepslate")
                .build();
        /////////////////////////////
        //   Nether native fungi   //
        /////////////////////////////
        speciesBuilder.createProtoSpecies("NETHER_FUNGUS")//nether wastes native
                .terrain("mycologymod:nether")
                .biomesSpecs(BiomesSpecs.NETHER)
                .spawnType(FungusSpawn.NETHER_WASTES)
                .build();

        speciesBuilder.createProtoSpecies("SOULSAND_FUNGUS")//soul sand valley native
                .terrain("mycologymod:soul_sand")
                .biomesSpecs(BiomesSpecs.NETHER)
                .spawnType(FungusSpawn.SOUL_SAND_VALLEY)
                .build();
        /////////////////////////
        //      DEV fungi      //
        /////////////////////////
        speciesBuilder.createProtoSpecies("DEV_FUNGUS")
                .colors4(0x5567E5, 0x9F55B5, 0xBF5DAF, 0xD32BD9)
                .areaEffect(FungusEffects.DEV_TEST_EFFECT)
                .areaRadius(2)
                .build();
        speciesBuilder.createProtoSpecies("TNT_FUNGUS")
                .colors4(0xc72e25, 0xc72e25, 0xe8e8e8, 0xe8e8e8)
                .areaEffect(FungusEffects.TNT_EFFECT)
                .areaRadius(4)
                .build();
        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
