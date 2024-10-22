package com.mettsmirnov.mycology.datagen;

import com.mettsmirnov.mycology.effects.FungusEffects;
import com.mettsmirnov.mycology.effects.PlayerEffects.ModEffects;
import com.mettsmirnov.mycology.tags.ModBlockTags;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import com.mettsmirnov.mycology.datagen.common.BiomesSpecs;
import com.mettsmirnov.mycology.datagen.common.FungusSpawn;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.mettsmirnov.mycology.datagen.SpeciesDictionary.*;

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

        speciesBuilder.createDefaultSpecies("GREEN_FUNGUS_2")
                .crimsonType()
                .colors4(0xD36146, 0x7EA144, 0x619B68, 0x3A734C)
                .build();
        /////////////////////////////
        //      Colors fungi       //
        /////////////////////////////
        speciesBuilder.createSpecies(AMANITA_RUBRA)
                .crimsonType()
                .colors4(0xFFFFCC, 0xC41717, 0xF2F2F2, 0xF2F2F2)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.DARK_FOREST)
                .build();

        speciesBuilder.createProtoSpecies(ORANGE_FUNGUS)
                .colors1(0xff8701)
                .build();

        speciesBuilder.createDefaultSpecies(LIME_FUNGUS)
                .warpedType()
                .colors1(0x67ff32)
                .build();

        speciesBuilder.createProtoSpecies(CYAN_FUNGUS)
                .colors1(0x198185)
                .build();

        speciesBuilder.createDefaultSpecies(LIGHTBLUE_FUNGUS)
                .warpedType()
                .colors4(0xc9f38e, 0x87cfec, 0xcaeef9, 0x8ad4f1)
                .build();

        speciesBuilder.createSpecies(OVULUS_VIOLACEUS)
                .crimsonType()
                .colors4(0xAA48FB, 0x9c133f, 0xA23F19, 0xE105EF)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(MAGENTA_FUNGUS)
                .crimsonType()
                .colors1(0xff44de)
                .build();

        speciesBuilder.createDefaultSpecies(PINK_FUNGUS)
                .crimsonType()
                .colors4(0xf6dfb5, 0xffc0cb, 0xffc0cb, 0xffeef0)
                .build();

        speciesBuilder.createProtoSpecies("BROWN_FUNGUS")
                .colors1(0x89501e)
                .build();

        speciesBuilder.createDefaultSpecies(BLACK_FUNGUS)
                .crimsonType()
                .colors4(0xffdcc7, 0xffffff, 0xe4d6cd, 0x262626)
                .build();

        speciesBuilder.createDefaultSpecies(GREY_FUNGUS)
                .crimsonType()
                .colors1(0x535353)
                .build();

        speciesBuilder.createDefaultSpecies(LIGHTGREY_FUNGUS)
                .warpedType()
                .colors1(0x999999)
                .build();

        speciesBuilder.createDefaultSpecies(WHITE_FUNGUS)
                .warpedType()
                .colors4(0xfbf4e1, 0xfffdf6, 0xf3f3f3, 0xf3edd5) //FIXME I don't like it too much
                .build();

        /////////////////////////////
        //      Edible fungi       //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(LACCARIA_DULCIS)//Sugar fungus
                .warpedType()
                .colors4(0x97634a, 0x7695ff, 0xcdd7ff, 0x9aa8ff)
                .build();

        speciesBuilder.createDefaultSpecies(LACTARIUS_DELICIOUS)
                .warpedType()
                .colors4(0xffc2a5, 0xff9e76, 0xe8a689, 0xd86b63)
                .build();

        speciesBuilder.createDefaultSpecies("Craterellus cornucopioides")
                .warpedType()
                //.colors4(0x2e2038, 0x211c31, 0x141220, 0x0d0a1c)
                .colors4(0x382b30, 0x211c31, 0x141220, 0x0d0a1c)
                .build();

        speciesBuilder.createSpecies(NOBLE_BOLETUS_SQUISITUS)
                .crimsonType()
                .colors4(0xFFE6D8, 0x907068, 0xBE8C85, 0xFFE4E2)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(ModBlockTags.PODZOL)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .build();

        /////////////////////////////
        //      Toxic fungi        //
        /////////////////////////////
        speciesBuilder.createProtoSpecies(FATIGUE_FUNGUS)
                .areaEffect(FungusEffects.FATIGUE_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies(POISON_FUNGUS)
                .areaEffect(FungusEffects.POISON_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(WITHERING_FUNGUS)
                .crimsonType()
                .colors4(0x9E928F, 0x3e3e3e, 0x585858, 0xe1e1e1)
                .terrain(ModBlockTags.NETHER)
                .areaEffect(FungusEffects.WITHERING_EFFECT)
                .build();

        /////////////////////////////
        //     Materials fungi     //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(POLYPORUS_LIGNEUS)
                .warpedType()
                .colors4(0xbba77a, 0x8d664b, 0xb38f6e, 0x4f3a2d)
                .terrain(BlockTags.LOGS)
                .areaRadius(7)
                .areaEffect(FungusEffects.DECOMPOSING_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(DIORITE_FUNGUS)
                .crimsonType()
                .colors4(0xffb796, 0xffffff, 0xffffff, 0x8f8f8f)
                .build();

        speciesBuilder.createDefaultSpecies(CALCITE_FUNGUS)
                .crimsonType()
                .colors4(0xf8f0d5, 0xffffff, 0xffffff, 0xbbb89d)
                .build();

        speciesBuilder.createProtoSpecies("GRANITE_FUNGUS")
                .build();

        speciesBuilder.createProtoSpecies("ANDESITE_FUNGUS")
                .build();

        speciesBuilder.createDefaultSpecies("OBSIDIAN_FUNGUS")
                .crimsonType()
                .colors4(0x300b5f, 0x2a1e4b, 0x36205a, 0x432e69)
                .build();

        speciesBuilder.createDefaultSpecies(BASALT_FUNGUS)
                .crimsonType()
                .colors4(0, 0, 0, 0)
                .build();

        speciesBuilder.createDefaultSpecies(TUFF_FUNGUS)
                .warpedType()
                .colors4(0, 0, 0, 0)
                .build();

        speciesBuilder.createDefaultSpecies(CLAY_FUNGUS)
                .warpedType()
                .colors4(0xffdbb2, 0xb2c5ff, 0x8896c3, 0xadbfee)
                .terrain(Blocks.CLAY)
                .build();

        /*speciesBuilder.createProtoSpecies("TERRACOTTA_FUNGUS")
                .terrain("minecraft:terracotta")
                .build();

        speciesBuilder.createProtoSpecies("PRISMARINE_FUNGUS")
                .terrain("mycologymod:prismarine")
                .build();*/

        speciesBuilder.createProtoSpecies("PURPUR_SUSTAINED_FUNGUS")
                .build();

        speciesBuilder.createDefaultSpecies("MAGMABLOCK_SUSTAINED_FUNGUS")
                .crimsonType()
                .colors4(0x694d3e, 0x4b1009, 0xff6f19, 0xa03c00)
                .terrain(Blocks.MAGMA_BLOCK)
                .build();

        speciesBuilder.createProtoSpecies(BONEBLOCK_FUNGUS)
                .warpedType()
                .colors4(0xfff6ea, 0xFFF8DC, 0xDBDAD7, 0xC8C1B5)
                .terrain(Blocks.BONE_BLOCK)
                .build();

        /////////////////////////////
        //      Mineral fungi      //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(COAL_FUNGUS)
                .warpedType()
                .colors4(0xa19b88, 0x8a8a8a, 0x383838, 0x2e2e2e)
                .terrain(BlockTags.COAL_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(EMERALD_FUNGUS)
                .crimsonType()
                .colors4(0x8c909c, 0x5f6269, 0x287441, 0x96ffaa)
                .terrain(BlockTags.EMERALD_ORES)
                .build();

        speciesBuilder.createDefaultSpecies("GLOWSTONE_FUNGUS")
                .crimsonType()
                .colors4(0xff4d45, 0xffdb4a, 0xdcc677, 0xfff3cd)
                .terrain(ModBlockTags.NETHER)
                .build();

        speciesBuilder.createDefaultSpecies(GALERINA_AURATA) //Gold
                .warpedType()
                .colors4(0xeed484, 0xFF9900, 0xFFDD36, 0xffe56b)
                .terrain(BlockTags.GOLD_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(BOLBITIUS_SILEX) //Quartz
                .crimsonType()
                .colors4(0xc83825, 0xfff1eb, 0xe0dcda, 0xffffff)
                .terrain(ModBlockTags.QUARTZ_ORES)
                .build();

        speciesBuilder.createSpecies(RUSSULA_LAZULA) //Lapislazuli
                .crimsonType()
                .colors4(0xffffcc, 0x837672, 0x183679, 0x2653b9)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(BlockTags.LAPIS_ORES)
                .biomesSpecs(BiomesSpecs.FOREST)
                .areaEffect(FungusEffects.NO_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(RUSSULA_CONCITATA)
                .crimsonType()
                .colors4(0xFFF9EE, 0x760a00, 0x730000, 0xda0000)
                .terrain(BlockTags.REDSTONE_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(AMANITA_CUPREA) //Copper
                .warpedType()
                .colors4(0xbb9173, 0xe8693d, 0x208068, 0x20a387)
                .terrain(BlockTags.COPPER_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(XEROCOMUS_FERRUGINEUS)
                .warpedType()
                .colors4(0xffffcc, 0x95867e, 0xC0997F, 0xFBD3B8)
                .terrain(BlockTags.IRON_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(AMETHYST_FUNGUS)
                .crimsonType()
                .colors4(0xfad2d4, 0xae80ff, 0xba8ed6, 0xf6c3da)
                .terrain(Blocks.AMETHYST_BLOCK)
                .build();

        speciesBuilder.createProtoSpecies(BUDDING_FUNGUS)
                .terrain(Blocks.AMETHYST_BLOCK)
                .areaEffect(FungusEffects.BUDDING_EFFECT)
                .areaRadius(4)
                .build();

        speciesBuilder.createDefaultSpecies(DIAMOND_FUNGUS)
                .crimsonType()
                .colors4(0x848d9b, 0x5d636f, 0x21202a, 0x00ecff)
                .terrain(BlockTags.DIAMOND_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(EXPERIENCE_FUNGUS)
                .crimsonType()
                .colors4(0x87CFEC, 0x2d81e2, 0x398D4C, 0xB4DF57)
                .areaEffect(FungusEffects.EXPORBS_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(BLAZE_FUNGUS)
                .crimsonType()
                .colors4(0xFF7B00, 0xFF9900, 0xFFDD36, 0xFFFF73)
                .areaEffect(FungusEffects.BLAZING_EFFECT)
                .terrain(ModBlockTags.NETHER_BRICKS)
                .build();

        speciesBuilder.createDefaultSpecies("Polyporus antiquus")
                .crimsonType()
                .colors4(0x52362F, 0x52362F, 0x29130D, 0x52362F)
                .terrain(Blocks.NETHERITE_BLOCK)
                .build();

        speciesBuilder.createDefaultSpecies("NETHERITE_FUNGUS")
                .crimsonType()
                .colors4(0x7b716d, 0x48413c, 0x272624, 0x4a484a)
                .terrain(Blocks.NETHERITE_BLOCK)
                .build();

        speciesBuilder.createDefaultSpecies(TRICHOLOMOPSIS_EVANESCENS)
                .crimsonType()
                .colors4(0x87cfec, 0x06d192, 0x69d0af, 0x068054)
                .terrain(Blocks.END_STONE)
                .build();

        ///////////////////////////
        //    Alcoholic fungi    //
        ///////////////////////////
        speciesBuilder.createDefaultSpecies(FERMENTER_FUNGUS)
                .warpedType()
                .colors4(0xa98565, 0xf9bcc1, 0xc7bdce, 0x6d719a)
                //.areaEffect(FungusEffects.FERMENTING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(DRUNK_FUNGUS)
                .crimsonType()
                .colors4(0x663321, 0x4d9268, 0x2aa65a, 0xf9af46)
                .areaEffect(FungusEffects.DRUNK_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies(TOXIC_METILIC_FUNGUS)
                .build();

        /////////////////////////////////
        //    Special effects fungi    //
        /////////////////////////////////
        //TODO be rearranged
        speciesBuilder.createSpecies(BOLETUS_SALUBRIUM)
                .crimsonType()
                .colors4(0xC176C0, 0x95778C, 0xD01B05, 0xB99AA7)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.HEALING_EFFECT)
                .areaRadius(3)
                .build();
        speciesBuilder.createDefaultSpecies(SPEED_FUNGUS)
                .warpedType()
                .colors4(0xfebf98, 0xd0eaff, 0xffffff, 0x92c5e4)
                .build();
        speciesBuilder.createDefaultSpecies(STRENGTH_FUNGUS)
                .crimsonType()
                .colors4(0xc04774, 0x916a7a, 0xc70d09, 0xda8d46)
                .areaEffect(FungusEffects.STRENGTH_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(ANESTHETIC_FUNGUS)
                .warpedType()
                .colors4(0x59a6cf, 0xe61e65, 0xe03775, 0xffffff)
                .areaEffect(FungusEffects.ANESTHETIC_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies(ILLUCINATING_FUNGUS)
                .areaEffect(FungusEffects.ILLUCINATING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(HALLUCINATING_FUNGUS)
                .warpedType()
                .colors4(0xefe8de, 0x50483b, 0x1f3132, 0x28a6af)
                .areaEffect(FungusEffects.HALLUCINATING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies("RADIOACTIVE_EFFECT_FUNGUS")
                .crimsonType()
                .colors4(0xcc052a, 0xc0b334, 0xb79655, 0x514d1d)
                .areaEffect(FungusEffects.RADIOACTIVE_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("PHANTOM_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.PHANTOM_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies(NIGHTLY_FUNGUS)
                .areaEffect(FungusEffects.NIGHTLY_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies(SENSING_FUNGUS)
                .areaEffect(FungusEffects.SENSING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("SHINING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SHINING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies(SCHIZO_FUNGUS)
                .areaEffect(FungusEffects.SCHIZO_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("SPARKLING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SPARKLING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies(RAPTING_FUNGUS)
                .areaEffect(FungusEffects.RAPTING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies(TELEPORTING_FUNGUS)
                .areaEffect(FungusEffects.TELEPORTING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("LIGHTFUL_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.LIGHTFUL_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies("GOODCHANCE_EFFECT_FUNGUS")
                .crimsonType()
                .colors4(0x20b189, 0x22b84d, 0x75dd62, 0xd2ffcc)
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
        speciesBuilder.createDefaultSpecies(FERTILIZING_FUNGUS)
                .warpedType()
                .colors4(0xFFE3BF, 0xFFF8DC, 0xDBDAD7, 0xC8C1B5)
                .areaEffect(FungusEffects.FERTILIZING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("UNDEAD_EFFECT_FUNGUS") //might be a cordyceps?
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
        speciesBuilder.createProtoSpecies(CRYING_FUNGUS) //randomly cries (i.e. drops ghast tears)
                .build();
        speciesBuilder.createProtoSpecies("GHASTLY_EFFECT_FUNGUS")
                .areaRadius(2)
                .areaEffect(FungusEffects.GHASTLY_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("LIGHTNING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.LIGHTNING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(ENDER_EYE_FUNGUS)
                .crimsonType()
                .colors4(0x90c074, 0x06d192, 0x72ac49, 0xb4e45b)
                .areaEffect(FungusEffects.EYE_OF_ENDER_EFFECT)
                .build();

        //////////////////////////////
        //  Overworld native fungi  //
        //////////////////////////////
        speciesBuilder.createDefaultSpecies(AGARICUS_CAMPESTRIS)//plains native
                .warpedType()
                .colors4(0xFFF7E7, 0xFFF7E7, 0xC7C1B4, 0xA8A398)//FIXME darker
                .biomesSpecs(BiomesSpecs.PLAINS)
                .spawnType(FungusSpawn.PLAINS)
                .build();
        speciesBuilder.createSpecies(LACTARIUS_VIRIDIS)//sunflower plains native
                .warpedType()
                .colors4( 0xBF98BF, 0x6bb83c, 0x99110F, 0xF502D3)//FIXME
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.PLAINS)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.SUNFLOWER_PLAINS)
                .build();
        speciesBuilder.createDefaultSpecies(LECCINUM_VERSIPELLE) //Birch forest native
                .warpedType()
                .colors4(0xFFFBFB, 0xFF7C2D, 0x885431, 0xBD7142)//FIXME
                .biomesSpecs(BiomesSpecs.BIRCH_FOREST)
                .spawnType(FungusSpawn.BIRCH_FOREST)
                .build();
        speciesBuilder.createDefaultSpecies(BOLETUS_EDULIS) //Forest native
                .crimsonType()
                .colors4(0xecd7ae, 0xa5887d, 0xa5887d, 0xffe6dd)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FOREST)
                .build();
        speciesBuilder.createDefaultSpecies(SUILLUS_GRANULATUS)
                .warpedType()
                .colors4(0xFFF7E7, 0xFFA376, 0xC47D5A, 0xD88A64)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_PINE_TAIGA)
                .spawnType(FungusSpawn.OLD_GROWTH_PINE_TAIGA)
                .build();
        speciesBuilder.createDefaultSpecies(CHALCIPORUS_PIPERATUS)//non edible
                .crimsonType()
                .colors4(0xFFC741, 0xAE5913, 0x64330B, 0x8E6C24)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_SPRUCE_TAIGA)
                .spawnType(FungusSpawn.OLD_GROWTH_SPRUCE_TAIGA)
                .build();
        speciesBuilder.createDefaultSpecies(HYGROPHORUS_NIVEUS)
                .crimsonType()
                .colors4(0x6c4026 ,0xd5eeff, 0xd4e3ec, 0xffffff)
                .biomesSpecs(BiomesSpecs.SNOWY_TAIGA)
                .spawnType(FungusSpawn.SNOWY_TAIGA)
                .build();
        speciesBuilder.createDefaultSpecies(AMANITA_MUSCARIA)//poisonous
                .warpedType()
                .colors4(0xFFFCD9, 0xFF521E, 0xFFFFFF, 0xFFB171)
                .biomesSpecs(BiomesSpecs.JUNGLE)
                .spawnType(FungusSpawn.JUNGLE)
                .build();
        speciesBuilder.createDefaultSpecies(AMANITA_PHALLOIDES)
                .crimsonType()
                .colors4(0xffdb94, 0xc71c12, 0xe8e8e8, 0xF2F2F2)
                .biomesSpecs(BiomesSpecs.SWAMP)
                .spawnType(FungusSpawn.SWAMP)
                .build();
        speciesBuilder.createDefaultSpecies(YELLOW_FUNGUS)//meadow native
                .warpedType()
                //.colors4(0xffeebd, 0xffdf7f, 0x729bf3, 0x4370c2)//old colors
                .colors4(0xffeebd, 0xffd047, 0xc6a046, 0xf08342)
                .biomesSpecs(BiomesSpecs.MEADOW)
                .spawnType(FungusSpawn.MEADOW)
                .build();
        speciesBuilder.createDefaultSpecies(BLUE_FUNGUS)//flower forest native
                .crimsonType()
                .colors4(0xF6DFB5, 0x4f94ee, 0xF6DFB5, 0xfff7e9)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FLOWER_FOREST)
                .build();
        speciesBuilder.createDefaultSpecies(LACTARIUS_PROLEFERENS)
                .warpedType()
                //.colors4(0x81696b, 0x81696b, 0x933c3e, 0x81696b)
                .colors4(0x81696b, 0x933c3e, 0x933c3e, 0xd28d77)
                //.colors4(0x81696b, 0xbfab77, 0xbfab77, 0xbfab77)
                .areaEffect(FungusEffects.SPORING_EFFECT)
                .areaRadius(4)
                .biomesSpecs(BiomesSpecs.MUSHROOM_FIELDS)
                .spawnType(FungusSpawn.MUSHROOM_FIELDS)
                .build();
        speciesBuilder.createDefaultSpecies(BOLBITIUS_PROFONDORUM)//fungus found in caves
                .crimsonType()
                .colors4(0x8c909c, 0x94989C, 0x3f4045, 0x2b2d31)
                .spawnType(FungusSpawn.NO_SPAWN)
                .light(3)
                .terrain(ModBlockTags.DEEPSLATE)
                .build();
        /////////////////////////////
        //   Nether native fungi   //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(CHALCIPORUS_INFERNALIS)//nether wastes native
                .crimsonType()
                .colors4(0xb5917a, 0xEE2E3D, 0xff6500, 0xffa468)
                .terrain(Blocks.NETHERRACK)
                .biomesSpecs(BiomesSpecs.NETHER)
                .spawnType(FungusSpawn.NETHER_WASTES)
                .build();

        speciesBuilder.createDefaultSpecies(AGARICUS_ANIMI)//soul sand valley native
                .crimsonType()
                .colors4(0x7b929c, 0x796251, 0x614e43, 0x887265)
                .terrain(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .biomesSpecs(BiomesSpecs.NETHER)
                .spawnType(FungusSpawn.SOUL_SAND_VALLEY)
                .build();
        //////////////////////////
        //   End native fungi   //
        //////////////////////////
        speciesBuilder.createDefaultSpecies(END_FUNGUS)
                .crimsonType()
                .colors4(0xe7f1b1, 0x3c0581, 0xa058ae, 0x490a61)
                .terrain(Blocks.END_STONE)
                .biomesSpecs(BiomesSpecs.END)
                .spawnType(FungusSpawn.END)
                .build();
        speciesBuilder.createProtoSpecies(CHORUS_FUNGUS)
                .colors1(0xb35fa1)
                .terrain(Blocks.END_STONE)
                .biomesSpecs(BiomesSpecs.END)
                .spawnType(FungusSpawn.END_HIGHLANDS)
                /*
                *
                *
                * */
                .areaRadius(3)
                .build();
        ////////////////////////////////
        //   Very rare native fungi   //
        ////////////////////////////////
        speciesBuilder.createProtoSpecies(BLINDING_FUNGUS) // could be cool if this very rarely spawns in the overworld
                .areaEffect(FungusEffects.BLINDING_EFFECT)
                .areaRadius(10)
                .spawnType(FungusSpawn.VERY_RARE.withBiomes(Biomes.DARK_FOREST))
                .build();
        /////////////////////////////
        //   Environmental fungi   //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(FREEZING_FUNGUS)
                .crimsonType()
                .colors4(0x6c4026 ,0x6bbeff, 0xd4e3ec, 0xffffff)
                .areaEffect(FungusEffects.FREEZING_EFFECT)
                .areaRadius(8)
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

        speciesBuilder.createDefaultSpecies("LIFE_UP_FUNGUS")
                .crimsonType()
                .colors4(0xffd08d, 0x52e13d, 0xffffff, 0xffffff)
                .eatingEffect(ModEffects.LAST_CHANCE)
                .build();
        speciesBuilder.createProtoSpecies("PLANTING_FUNGUS")
                .areaEffect(FungusEffects.PLANT_EFFECT)
                .areaRadius(10)
                .build();
        speciesBuilder.createProtoSpecies("COCOA_FUNGUS")
                .areaEffect(FungusEffects.ANTHESIS_EFFECT)
                .areaRadius(10)
                .build();
        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
