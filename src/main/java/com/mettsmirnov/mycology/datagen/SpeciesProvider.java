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
                .crimsonType()
                .colors4(0xC176C0, 0x95778C, 0xD01B05, 0xB99AA7)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.HEALING_EFFECT)
                .areaRadius(3)
                .spawnType(FungusSpawn.ANY_BIOME)
                .build();
        speciesBuilder.createProtoSpecies("GREEN_FUNGUS_2")
                .colors4(0xD36146, 0x7EA144, 0x619B68, 0x3A734C)
                .build();
        /////////////////////////////
        //      Colors fungi       //
        /////////////////////////////
        speciesBuilder.createSpecies("Amanita rubra")
                .crimsonType()
                .colors4(0xFFFFCC, 0xC41717, 0xF2F2F2, 0xF2F2F2)
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

        speciesBuilder.createDefaultSpecies("LIME_FUNGUS")
                .warpedType()
                .colors1(0x67ff32)
                .build();

        speciesBuilder.createProtoSpecies("CYAN_FUNGUS")
                .colors1(0x198185)
                .build();

        speciesBuilder.createDefaultSpecies("FUNGUS caelestis")
                .warpedType()
                .colors4(0xc9f38e, 0x87cfec, 0xcaeef9, 0x8ad4f1)
                .build();

        speciesBuilder.createSpecies("Ovulus violaceus")
                .crimsonType()
                .colors4(0xAA48FB, 0x9c133f, 0xA23F19, 0xE105EF)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.ANY_BIOME)
                .build();

        speciesBuilder.createDefaultSpecies("MAGENTA_FUNGUS")
                .crimsonType()
                .colors1(0xff44de)
                .build();

        speciesBuilder.createProtoSpecies("PINK_FUNGUS")
                .colors4(0xf6dfb5, 0xffc0cb, 0xffc0cb, 0xffeef0)
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

        speciesBuilder.createDefaultSpecies("WHITE_FUNGUS")
                .warpedType()
                .colors4(0xfbf4e1, 0xfffdf6, 0xf3f3f3, 0xf3edd5) //FIXME I don't like it too much
                .build();

        /////////////////////////////
        //      Edible fungi       //
        /////////////////////////////
        //Sugar fungus
        speciesBuilder.createProtoSpecies("Laccaria dulcis") // or "Amanita dulcis"
                .build();

        speciesBuilder.createSpecies("Noble boletus squisitus")// derived from "boletus edulis"
                .crimsonType()
                .colors4(0xFFE6D8, 0x907068, 0xBE8C85, 0xFFE4E2)
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
                .crimsonType()
                .colors4(0x9E928F, 0x3e3e3e, 0x585858, 0xe1e1e1)
                .terrain("mycologymod:nether")
                .areaEffect(FungusEffects.WITHERING_EFFECT)
                .build();

        speciesBuilder.createProtoSpecies("POISON_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.POISON_EFFECT)
                .build();

        /////////////////////////////
        //     Materials fungi     //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies("Polyporus ligneus")
                .warpedType()
                .colors4(0xbba77a, 0x8d664b, 0xb38f6e, 0x4f3a2d)
                .terrain("minecraft:logs")
                .areaRadius(7)
                .areaEffect(FungusEffects.DECOMPOSING_EFFECT)
                .build();

        speciesBuilder.createProtoSpecies("GRANITE_FUNGUS")
                .build();

        speciesBuilder.createProtoSpecies("DIORITE_FUNGUS")
                .build();

        speciesBuilder.createProtoSpecies("ANDESITE_FUNGUS")
                .build();

        speciesBuilder.createDefaultSpecies("OBSIDIAN_FUNGUS")
                .crimsonType()
                .colors4(0x300b5f, 0x2a1e4b, 0x36205a, 0x432e69)
                .build();

        speciesBuilder.createProtoSpecies("BASALT_FUNGUS")
                .build();

        speciesBuilder.createProtoSpecies("CLAY_FUNGUS")
                .warpedType()
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
        speciesBuilder.createDefaultSpecies("Leccinum carbonis")
                .warpedType()
                .colors4(0xa19b88, 0x8a8a8a, 0x383838, 0x2e2e2e)
                .terrain("minecraft:coal_ores")
                .build();

        speciesBuilder.createDefaultSpecies("EMERALD_FUNGUS")
                .crimsonType()
                .colors4(0, 0, 0, 0)
                .terrain("minecraft:emerald_ores")
                .build();

        speciesBuilder.createDefaultSpecies("GLOWSTONE_FUNGUS")
                .crimsonType()
                .colors4(0xff4d45, 0xffdb4a, 0xdcc677, 0xfff3cd)
                .terrain("mycologymod:nether")
                .build();

        speciesBuilder.createDefaultSpecies("Galerina aurata") //Gold
                .warpedType()
                .colors4(0xeed484, 0xFF9900, 0xFFDD36, 0xffe56b)
                .terrain("minecraft:gold_ores")
                .build();

        speciesBuilder.createDefaultSpecies("Bolbitius silex") //Quartz
                .crimsonType()
                .colors4(0, 0, 0, 0)
                .terrain("mycologymod:quartz_ores")
                .build();

        speciesBuilder.createSpecies("Russula lazula") //Lapislazuli
                .warpedType()
                .colors4(0xffffcc, 0x837672, 0x183679, 0x2653b9)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("minecraft:lapis_ores")
                .biomesSpecs(BiomesSpecs.FOREST)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.ANY_BIOME)
                .build();

        speciesBuilder.createDefaultSpecies("Russula concitata")
                .crimsonType()
                .colors4(0xFFF9EE, 0x760a00, 0x730000, 0xda0000)
                .terrain("minecraft:redstone_ores")
                .build();

        speciesBuilder.createDefaultSpecies("Amanita cuprea") //Copper
                .warpedType()
                .colors4(0xbb9173, 0xe8693d, 0x208068, 0x20a387)
                .terrain("minecraft:copper_ores")
                .build();

        speciesBuilder.createDefaultSpecies("Xerocomus ferrugineus")
                .warpedType()
                .colors4(0xffffcc, 0x95867e, 0xC0997F, 0xFBD3B8)
                .terrain("minecraft:iron_ores")
                .build();

        speciesBuilder.createProtoSpecies("AMETHYST_FUNGUS")
                .terrain("mycologymod:amethyst")
                .build();

        speciesBuilder.createDefaultSpecies("DIAMOND_FUNGUS")
                .crimsonType()
                .colors4(0, 0, 0, 0)
                .terrain("minecraft:diamond_ores")
                .build();

        speciesBuilder.createDefaultSpecies("EXPERIENCE_FUNGUS")
                .crimsonType()
                .colors4(0x87CFEC, 0x2d81e2, 0x398D4C, 0xB4DF57)
                .areaEffect(FungusEffects.EXPORBS_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies("BLAZE_FUNGUS")
                .crimsonType()
                .colors4(0xFF7B00, 0xFF9900, 0xFFDD36, 0xFFFF73)
                .areaEffect(FungusEffects.BLAZING_EFFECT)
                .terrain("mycologymod:nether_bricks")
                .build();

        speciesBuilder.createDefaultSpecies("Polyporus antiquus")
                .crimsonType()
                .colors4(0x52362F, 0x52362F, 0x29130D, 0x52362F)
                .terrain("mycologymod:netherite")
                .build();

        speciesBuilder.createDefaultSpecies("NETHERITE_FUNGUS")
                .crimsonType()
                .colors4(0x7b716d, 0x48413c, 0x272624, 0x4a484a)
                .terrain("mycologymod:netherite")
                .build();

        speciesBuilder.createDefaultSpecies("END_FUNGUS")
                .crimsonType()
                .colors4(0xe7f1b1, 0x3c0581, 0xa058ae, 0x490a61)
                .terrain("mycologymod:endstone")
                .build();

        speciesBuilder.createDefaultSpecies("Tricholomopsis evanescens")
                .crimsonType()
                .colors4(0x87cfec, 0x06d192, 0x69d0af, 0x068054)
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
        speciesBuilder.createDefaultSpecies("FERTILIZING_EFFECT_FUNGUS")
                .crimsonType()
                .colors4(0xFFE3BF, 0xFFF8DC, 0xDBDAD7, 0xC8C1B5)
                .areaEffect(FungusEffects.FERTILIZING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("UNDEAD_EFFECT_FUNGUS")
                .colors4(0xD36146, 0x7EA144, 0x4891ff, 0x4b54bb)
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
        speciesBuilder.createDefaultSpecies("Agaricus campestris")//plains native
                .warpedType()
                .colors4(0xFFF7E7, 0xFFF7E7, 0xC7C1B4, 0xA8A398)//FIXME darker
                .biomesSpecs(BiomesSpecs.PLAINS)
                .spawnType(FungusSpawn.PLAINS)
                .build();
        speciesBuilder.createSpecies("Lactarius viridis")//sunflower plains native
                .warpedType()
                .colors4( 0xBF98BF, 0x6bb83c, 0x99110F, 0xF502D3)//FIXME
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain("mycologymod:grass")
                .biomesSpecs(BiomesSpecs.PLAINS)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.SUNFLOWER_PLAINS)
                .build();
        speciesBuilder.createDefaultSpecies("Leccinum versipelle") //Birch forest native
                .warpedType()
                .colors4(0xFFFBFB, 0xFF7C2D, 0x885431, 0xBD7142)//FIXME
                .biomesSpecs(BiomesSpecs.BIRCH_FOREST)
                .spawnType(FungusSpawn.BIRCH_FOREST)
                .build();
        speciesBuilder.createDefaultSpecies("Boletus edulis") //Forest native
                .crimsonType()
                .colors4(0xecd7ae, 0xa5887d, 0xa5887d, 0xffe6dd)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FOREST)
                .build();
        speciesBuilder.createDefaultSpecies("Suillus granulatus")
                .warpedType()
                .colors4(0xFFF7E7, 0xFFA376, 0xC47D5A, 0xD88A64)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_PINE_TAIGA)
                .spawnType(FungusSpawn.OLD_GROWTH_PINE_TAIGA)
                .build();
        speciesBuilder.createDefaultSpecies("Chalciporus piperatus")//non edible
                .crimsonType()
                .colors4(0xFFC741, 0xAE5913, 0x64330B, 0x8E6C24)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_SPRUCE_TAIGA)
                .spawnType(FungusSpawn.OLD_GROWTH_SPRUCE_TAIGA)
                .build();
        speciesBuilder.createDefaultSpecies("Amanita muscaria")//poisonous
                .warpedType()
                .colors4(0xFFFCD9, 0xFF521E, 0xFFFFFF, 0xFFB171)
                .biomesSpecs(BiomesSpecs.JUNGLE)
                .spawnType(FungusSpawn.JUNGLE)
                .build();
        speciesBuilder.createDefaultSpecies("Amanita phalloides")
                .crimsonType()
                .colors4(0xffdb94, 0xc71c12, 0xe8e8e8, 0xF2F2F2)
                .biomesSpecs(BiomesSpecs.SWAMP)
                .spawnType(FungusSpawn.SWAMP)
                .build();
        speciesBuilder.createProtoSpecies("YELLOW_FUNGUS")//meadow native
                .colors1(0xfff620)
                .biomesSpecs(BiomesSpecs.MEADOW)
                .spawnType(FungusSpawn.MEADOW)
                .build();
        speciesBuilder.createDefaultSpecies("Boletellus caeruleus")//flower forest native
                .crimsonType()
                .colors4(0xF6DFB5, 0x4f94ee, 0xF6DFB5, 0xfff7e9)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FLOWER_FOREST)
                .build();
        speciesBuilder.createProtoSpecies("RARE_MUSHROOM_FIELDS_NATIVE")
                .areaEffect(FungusEffects.SPORING_EFFECT)
                .biomesSpecs(BiomesSpecs.MUSHROOM_FIELDS)
                .spawnType(FungusSpawn.MUSHROOM_FIELDS)
                .build();
        speciesBuilder.createDefaultSpecies("Bolbitius profundorum")//fungus found in caves
                .crimsonType()
                .colors4(0x8c909c, 0x94989C, 0x3f4045, 0x2b2d31)
                .spawnType(null)
                .light(3)
                .terrain("mycologymod:deepslate")
                .build();
        /////////////////////////////
        //   Nether native fungi   //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies("Chalciporus infernalis")//nether wastes native
                .crimsonType()
                .colors4(0xb5917a, 0xEE2E3D, 0xff6500, 0xffa468)
                .terrain("minecraft:netherrack")
                .biomesSpecs(BiomesSpecs.NETHER)
                .spawnType(FungusSpawn.NETHER_WASTES)
                .build();

        speciesBuilder.createDefaultSpecies("Agaricus animi")//soul sand valley native
                .crimsonType()
                .colors4(0x7b929c, 0x796251, 0x614e43, 0x887265)
                .terrain("minecraft:soul_fire_base_blocks")
                .biomesSpecs(BiomesSpecs.NETHER)
                .spawnType(FungusSpawn.SOUL_SAND_VALLEY)
                .build();
        /////////////////////////
        //      DEV fungi      //
        /////////////////////////
        speciesBuilder.createDefaultSpecies("DEV_FUNGUS")
                .crimsonType()
                .colors4(0x5567E5, 0x9F55B5, 0xBF5DAF, 0xD32BD9)
                .areaEffect(FungusEffects.DEV_TEST_EFFECT)
                .areaRadius(2)
                .build();
        speciesBuilder.createDefaultSpecies("TNT_FUNGUS")
                .crimsonType()
                .colors4(0xc72e25, 0xc72e25, 0xe8e8e8, 0x303030)
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
