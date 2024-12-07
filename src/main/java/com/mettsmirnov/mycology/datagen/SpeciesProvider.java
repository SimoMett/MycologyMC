package com.mettsmirnov.mycology.datagen;

import com.mettsmirnov.mycology.datagen.common.SpeciesBuilder;
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

import static com.mettsmirnov.mycology.datagen.common.SpeciesDictionary.*;

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
        List<CompletableFuture<?>> list = new ArrayList<>();
        SpeciesBuilder speciesBuilder = new SpeciesBuilder(this.generator, hashCache, list);

        /////////////////////////////
        //      Colors fungi       //
        /////////////////////////////
        speciesBuilder.createSpecies(AMANITA_RUBRA)
                .crimsonType(0xFFFFCC, 0xC41717, 0xF2F2F2, 0xF2F2F2)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.DARK_FOREST)
                .build();

        speciesBuilder.createDefaultSpecies(ORANGE_FUNGUS)
                .warpedType(0xffe0bd, 0xfc9646, 0xc98d6a, 0x844432)
                .build();

        speciesBuilder.createDefaultSpecies(LIME_FUNGUS)
                .warpedType(0x9e885f, 0xdd6544, 0x20b482, 0x50ec6c)
                .build();

        speciesBuilder.createDefaultSpecies(CYAN_FUNGUS)
                .warpedType(0xdcab8a, 0x45af9c, 0xd3907c, 0x0c6c91)
                .build();

        speciesBuilder.createDefaultSpecies(LIGHTBLUE_FUNGUS)
                .warpedType(0xc9f38e, 0x87cfec, 0xcaeef9, 0x8ad4f1)
                .build();

        speciesBuilder.createSpecies(OVULUS_VIOLACEUS)
                .crimsonType(0xAA48FB, 0x9c133f, 0xA23F19, 0xE105EF)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(MAGENTA_FUNGUS)
                .crimsonType(0xffb2cf, 0xef459d, 0x981c33, 0xffffff)
                .build();

        speciesBuilder.createDefaultSpecies(PINK_FUNGUS)
                .crimsonType(0xf6dfb5, 0xffc0cb, 0xffc0cb, 0xffeef0)
                .build();

        speciesBuilder.createDefaultSpecies(BROWN_FUNGUS)
                .warpedType(0xeeaa3c, 0xae5913, 0x64330b, 0x4e2407)
                .build();

        speciesBuilder.createDefaultSpecies(BLACK_FUNGUS)
                .crimsonType(0xffdcc7, 0xffffff, 0xe4d6cd, 0x262626)
                .build();

        speciesBuilder.createDefaultSpecies(GREY_FUNGUS)
                .crimsonType(0xffe0bd, 0x949494, 0x938b7f, 0xaa988e)
                .build();

        speciesBuilder.createDefaultSpecies(LIGHTGREY_FUNGUS)
                .warpedType(0xffdfcc, 0xf8feff, 0xdcdcdc, 0xbfbfbf)
                .build();

        speciesBuilder.createDefaultSpecies(WHITE_FUNGUS)
                .warpedType(0xfbf4e1, 0xfffdf6, 0xf3f3f3, 0xf3edd5) //FIXME I don't like it too much
                .build();

        /////////////////////////////
        //      Edible fungi       //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(LACCARIA_DULCIS)//Sugar fungus
                .warpedType(0x97634a, 0x7695ff, 0xcdd7ff, 0x9aa8ff)
                .build();

        speciesBuilder.createDefaultSpecies(LACTARIUS_DELICIOUS)
                .warpedType(0xffc2a5, 0xff9e76, 0xe8a689, 0xd86b63)
                .build();

        speciesBuilder.createDefaultSpecies(CRATERELLUS_CORNUCOPIOIDES)
                .warpedType(0x382b30, 0x211c31, 0x141220, 0x0d0a1c)
                //.colors4(0x2e2038, 0x211c31, 0x141220, 0x0d0a1c)
                .build();

        speciesBuilder.createSpecies(NOBLE_BOLETUS_SQUISITUS)
                .crimsonType(0xFFE6D8, 0x907068, 0xBE8C85, 0xFFE4E2)
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
        speciesBuilder.createDefaultSpecies(FATIGUE_FUNGUS)
                .warpedType(0xabd9ed, 0x8aabaf, 0x596e77, 0xe2c6b5)
                .areaEffect(FungusEffects.FATIGUE_EFFECT)
                .build();

        /////////////////////////////
        //     Materials fungi     //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(POLYPORUS_LIGNEUS)
                .warpedType(0xbba77a, 0x8d664b, 0xb38f6e, 0x4f3a2d)
                .terrain(BlockTags.LOGS)
                .areaRadius(7)
                .areaEffect(FungusEffects.DECOMPOSING_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(DIORITE_FUNGUS)
                .crimsonType(0xffb796, 0xffffff, 0xffffff, 0x8f8f8f)
                .build();

        speciesBuilder.createDefaultSpecies(CALCITE_FUNGUS)
                .crimsonType(0xf8f0d5, 0xffffff, 0xffffff, 0xbbb89d)
                .build();

        speciesBuilder.createDefaultSpecies(BASALT_FUNGUS)
                .crimsonType(0x4f4b4f, 0x838383, 0x878787, 0x1b2632)
                .build();

        speciesBuilder.createDefaultSpecies(TUFF_FUNGUS)
                .warpedType(0x95978d, 0x63625c, 0x6b6b5f, 0x393c34)
                .build();

        speciesBuilder.createDefaultSpecies(CLAY_FUNGUS)
                .warpedType(0xffdbb2, 0xb2c5ff, 0x8896c3, 0xadbfee)
                .terrain(Blocks.CLAY)
                .build();

        /*speciesBuilder.createProtoSpecies("TERRACOTTA_FUNGUS")
                .terrain("minecraft:terracotta")
                .build();

        speciesBuilder.createProtoSpecies("PRISMARINE_FUNGUS")
                .terrain("mycologymod:prismarine")
                .build();

        speciesBuilder.createProtoSpecies("PURPUR_SUSTAINED_FUNGUS")
                .build();

        speciesBuilder.createDefaultSpecies("MAGMABLOCK_SUSTAINED_FUNGUS")
                .crimsonType(0x694d3e, 0x4b1009, 0xff6f19, 0xa03c00)
                .terrain(Blocks.MAGMA_BLOCK)
                .build();*/

        speciesBuilder.createDefaultSpecies(BONEBLOCK_FUNGUS)
                .warpedType(0xfff6ea, 0xFFF8DC, 0xDBDAD7, 0xC8C1B5)
                .terrain(Blocks.BONE_BLOCK)
                .build();

        /////////////////////////////
        //      Mineral fungi      //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(COAL_FUNGUS)
                .warpedType(0xa19b88, 0x8a8a8a, 0x383838, 0x2e2e2e)
                .terrain(BlockTags.COAL_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(EMERALD_FUNGUS)
                .crimsonType(0x8c909c, 0x5f6269, 0x287441, 0x96ffaa)
                .terrain(BlockTags.EMERALD_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(GLOWSTONE_FUNGUS)
                .crimsonType(0xff4d45, 0xffdb4a, 0xdcc677, 0xfff3cd)
                .terrain(ModBlockTags.NETHER)
                .build();

        speciesBuilder.createDefaultSpecies(GALERINA_AURATA) //Gold
                .warpedType(0xeed484, 0xFF9900, 0xFFDD36, 0xffe56b)
                .terrain(BlockTags.GOLD_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(BOLBITIUS_SILEX) //Quartz
                .crimsonType(0xc83825, 0xfff1eb, 0xe0dcda, 0xffffff)
                .terrain(ModBlockTags.QUARTZ_ORES)
                .build();

        speciesBuilder.createSpecies(RUSSULA_LAZULA) //Lapislazuli
                .crimsonType(0xffffcc, 0x837672, 0x183679, 0x2653b9)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(BlockTags.LAPIS_ORES)
                .biomesSpecs(BiomesSpecs.FOREST)
                .areaEffect(FungusEffects.NO_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(RUSSULA_CONCITATA)
                .crimsonType(0xFFF9EE, 0x760a00, 0x730000, 0xda0000)
                .terrain(BlockTags.REDSTONE_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(AMANITA_CUPREA) //Copper
                .warpedType(0xbb9173, 0xe8693d, 0x208068, 0x20a387)
                .terrain(BlockTags.COPPER_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(XEROCOMUS_FERRUGINEUS)
                .warpedType(0xffffcc, 0x95867e, 0xC0997F, 0xFBD3B8)
                .terrain(BlockTags.IRON_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(AMETHYST_FUNGUS)
                .crimsonType(0xfad2d4, 0xae80ff, 0xba8ed6, 0xf6c3da)
                .terrain(Blocks.AMETHYST_BLOCK)
                .build();

        speciesBuilder.createDefaultSpecies(BUDDING_FUNGUS)
                .warpedType(0xebb9d2, 0x8e61ff, 0xd665b8, 0xf6b0d0)
                .terrain(Blocks.AMETHYST_BLOCK)
                .areaEffect(FungusEffects.BUDDING_EFFECT)
                .areaRadius(4)
                .build();

        speciesBuilder.createDefaultSpecies(DIAMOND_FUNGUS)
                .crimsonType(0x848d9b, 0x5d636f, 0x21202a, 0x00ecff)
                .terrain(BlockTags.DIAMOND_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(BLAZE_FUNGUS)
                .crimsonType(0xFF7B00, 0xFF9900, 0xFFDD36, 0xFFFF73)
                .areaEffect(FungusEffects.BLAZING_EFFECT)
                .terrain(ModBlockTags.NETHER_BRICKS)
                .build();

        // Removed due to non-conformity with the lore of netherite.
        /*speciesBuilder.createDefaultSpecies(POLYPORUS_ANTIQUUS)
                .crimsonType(0x52362F, 0x52362F, 0x29130D, 0x52362F)
                .terrain(Blocks.NETHERITE_BLOCK)
                .build();

        speciesBuilder.createDefaultSpecies(NETHERITE_FUNGUS)
                .crimsonType(0x7b716d, 0x48413c, 0x272624, 0x4a484a)
                .terrain(Blocks.NETHERITE_BLOCK)
                .build();*/

        speciesBuilder.createDefaultSpecies(TRICHOLOMOPSIS_EVANESCENS)
                .crimsonType(0x87cfec, 0x06d192, 0x69d0af, 0x068054)
                .terrain(Blocks.END_STONE)
                .build();

        ///////////////////////////
        //    Alcoholic fungi    //
        ///////////////////////////
        speciesBuilder.createDefaultSpecies(FERMENTER_FUNGUS)
                .warpedType(0xa98565, 0xf9bcc1, 0xc7bdce, 0x6d719a)
                //.areaEffect(FungusEffects.FERMENTING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(DRUNK_FUNGUS)
                .crimsonType(0x663321, 0x4d9268, 0x2aa65a, 0xf9af46)
                .areaEffect(FungusEffects.DRUNK_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(TOXIC_METILIC_FUNGUS)
                .warpedType(0x9b8ac5, 0xf3dbec, 0x883674, 0xc797ab)
                .build();

        /////////////////////////////////
        //    Special effects fungi    //
        /////////////////////////////////
        //TODO be rearranged
        speciesBuilder.createSpecies(BOLETUS_SALUBRIUM)
                .crimsonType(0xC176C0, 0x95778C, 0xD01B05, 0xB99AA7)
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.HEALING_EFFECT)
                .areaRadius(3)
                .build();
        speciesBuilder.createDefaultSpecies(SPEED_FUNGUS)
                .warpedType(0xfebf98, 0xd0eaff, 0xffffff, 0x92c5e4)
                .build();
        speciesBuilder.createDefaultSpecies(STRENGTH_FUNGUS)
                .crimsonType(0xc04774, 0x916a7a, 0xc70d09, 0xda8d46)
                .areaEffect(FungusEffects.STRENGTH_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(ANESTHETIC_FUNGUS)
                .warpedType(0x59a6cf, 0xe61e65, 0xe03775, 0xffffff)
                .areaEffect(FungusEffects.ANESTHETIC_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(ILLUCINATING_FUNGUS)
                .warpedType(0xa86a30, 0xb8ba81, 0xbe1339, 0xeeb97a)
                .areaEffect(FungusEffects.ILLUCINATING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(HALLUCINATING_FUNGUS)
                .warpedType(0xefe8de, 0x50483b, 0x1f3132, 0x28a6af)
                .areaEffect(FungusEffects.HALLUCINATING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(SENSING_FUNGUS)
                .warpedType(0xcec2c5, 0xffcf42, 0xffffff, 0x1984a1)
                .areaEffect(FungusEffects.SENSING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(RAPTING_FUNGUS)
                .crimsonType(0x71ecad, 0xc575ff, 0xb8dce5, 0x157865)
                .areaEffect(FungusEffects.RAPTING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(TELEPORTING_FUNGUS)
                .crimsonType(0x4b6ae5, 0x2bd9a1, 0x37e3bd, 0x5ef9e2)
                .areaEffect(FungusEffects.TELEPORTING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(DYEING_FUNGUS)
                .warpedType(0xffcb99, 0xff66d8, 0xf8fa53, 0x49b2e3)
                .areaEffect(FungusEffects.DYEING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(FERTILIZING_FUNGUS)
                .warpedType(0xFFE3BF, 0xFFF8DC, 0xDBDAD7, 0xC8C1B5)
                .areaEffect(FungusEffects.FERTILIZING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(UNDEAD_FUNGUS)
                .warpedType(0x9b4e3b, 0x6a8a3d, 0x457ae3, 0x4b54bb)
                .areaRadius(2)
                .areaEffect(FungusEffects.UNDEAD_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(LIGHTNING_FUNGUS)
                .warpedType(0xfeffcc, 0xffcf42, 0xffffff, 0xb2ffff)
                .areaEffect(FungusEffects.LIGHTNING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(ENDER_EYE_FUNGUS)
                .crimsonType(0x90c074, 0x06d192, 0x72ac49, 0xb4e45b)
                .areaEffect(FungusEffects.EYE_OF_ENDER_EFFECT)
                .build();

        //////////////////////////////
        //  Overworld native fungi  //
        //////////////////////////////
        speciesBuilder.createDefaultSpecies(AGARICUS_CAMPESTRIS)//plains native
                .warpedType(0xFFF7E7, 0xFFF7E7, 0xC7C1B4, 0xA8A398)//FIXME darker
                .biomesSpecs(BiomesSpecs.PLAINS)
                .spawnType(FungusSpawn.PLAINS)
                .build();
        speciesBuilder.createSpecies(LACTARIUS_VIRIDIS)//sunflower plains native
                .warpedType( 0xBF98BF, 0x6bb83c, 0x99110F, 0xF502D3)//FIXME
                .spreading(25)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.PLAINS)
                .areaEffect(FungusEffects.NO_EFFECT)
                .spawnType(FungusSpawn.SUNFLOWER_PLAINS)
                .build();
        speciesBuilder.createDefaultSpecies(LECCINUM_VERSIPELLE) //Birch forest native
                .warpedType(0xFFFBFB, 0xFF7C2D, 0x885431, 0xBD7142)//FIXME
                .biomesSpecs(BiomesSpecs.BIRCH_FOREST)
                .spawnType(FungusSpawn.BIRCH_FOREST)
                .build();
        speciesBuilder.createDefaultSpecies(BOLETUS_EDULIS) //Forest native
                .crimsonType(0xecd7ae, 0xa5887d, 0xa5887d, 0xffe6dd)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FOREST)
                .build();
        speciesBuilder.createDefaultSpecies(SUILLUS_GRANULATUS)
                .warpedType(0xFFF7E7, 0xFFA376, 0xC47D5A, 0xD88A64)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_PINE_TAIGA)
                .spawnType(FungusSpawn.OLD_GROWTH_PINE_TAIGA)
                .build();
        speciesBuilder.createDefaultSpecies(CHALCIPORUS_PIPERATUS)//non edible
                .crimsonType(0xFFC741, 0xAE5913, 0x64330B, 0x8E6C24)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_SPRUCE_TAIGA)
                .spawnType(FungusSpawn.OLD_GROWTH_SPRUCE_TAIGA)
                .build();
        speciesBuilder.createDefaultSpecies(HYGROPHORUS_NIVEUS)
                .crimsonType(0x6c4026 ,0xd5eeff, 0xd4e3ec, 0xffffff)
                .biomesSpecs(BiomesSpecs.SNOWY_TAIGA)
                .spawnType(FungusSpawn.SNOWY_TAIGA)
                .build();
        speciesBuilder.createDefaultSpecies(AMANITA_MUSCARIA)//poisonous
                .warpedType(0xFFFCD9, 0xFF521E, 0xFFFFFF, 0xFFB171)
                .biomesSpecs(BiomesSpecs.JUNGLE)
                .spawnType(FungusSpawn.JUNGLE)
                .build();
        speciesBuilder.createDefaultSpecies(AMANITA_PHALLOIDES)
                .crimsonType(0xffdb94, 0xc71c12, 0xe8e8e8, 0xF2F2F2)
                .biomesSpecs(BiomesSpecs.SWAMP)
                .spawnType(FungusSpawn.SWAMP)
                .build();
        speciesBuilder.createDefaultSpecies(YELLOW_FUNGUS)//meadow native
                .warpedType(0xffeebd, 0xffd047, 0xc6a046, 0xf08342)
                //.colors4(0xffeebd, 0xffdf7f, 0x729bf3, 0x4370c2)//old colors
                .biomesSpecs(BiomesSpecs.MEADOW)
                .spawnType(FungusSpawn.MEADOW)
                .build();
        speciesBuilder.createDefaultSpecies(BLUE_FUNGUS)//flower forest native
                .crimsonType(0xF6DFB5, 0x4f94ee, 0xF6DFB5, 0xfff7e9)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FLOWER_FOREST)
                .build();
        speciesBuilder.createDefaultSpecies(LACTARIUS_PROLEFERENS)
                .warpedType(0x81696b, 0x933c3e, 0x933c3e, 0xd28d77)
                //.colors4(0x81696b, 0x81696b, 0x933c3e, 0x81696b)
                //.colors4(0x81696b, 0xbfab77, 0xbfab77, 0xbfab77)
                .areaEffect(FungusEffects.SPORING_EFFECT)
                .areaRadius(4)
                .biomesSpecs(BiomesSpecs.MUSHROOM_FIELDS)
                .spawnType(FungusSpawn.MUSHROOM_FIELDS)
                .build();
        speciesBuilder.createDefaultSpecies(BOLBITIUS_PROFONDORUM)//fungus found in caves
                .crimsonType(0x8c909c, 0x94989C, 0x3f4045, 0x2b2d31)
                .spawnType(FungusSpawn.NO_SPAWN)
                .light(3)
                .terrain(ModBlockTags.DEEPSLATE)
                .build();
        /////////////////////////////
        //   Nether native fungi   //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(CHALCIPORUS_INFERNALIS)//nether wastes native
                .crimsonType(0xb5917a, 0xEE2E3D, 0xff6500, 0xffa468)
                .terrain(Blocks.NETHERRACK)
                .biomesSpecs(BiomesSpecs.NETHER)
                .spawnType(FungusSpawn.NETHER_WASTES)
                .build();

        speciesBuilder.createDefaultSpecies(AGARICUS_ANIMI)//soul sand valley native
                .crimsonType(0x7b929c, 0x796251, 0x614e43, 0x887265)
                .terrain(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .biomesSpecs(BiomesSpecs.NETHER)
                .spawnType(FungusSpawn.SOUL_SAND_VALLEY)
                .build();
        //////////////////////////
        //   End native fungi   //
        //////////////////////////
        speciesBuilder.createDefaultSpecies(END_FUNGUS)
                .crimsonType(0xe7f1b1, 0x3c0581, 0xa058ae, 0x490a61)
                .terrain(Blocks.END_STONE)
                .biomesSpecs(BiomesSpecs.END)
                .spawnType(FungusSpawn.END)
                .build();
        speciesBuilder.createDefaultSpecies(CHORUS_FUNGUS)
                .crimsonType(0xe1dab6, 0xa078db, 0xeee9ff, 0xbea9b8)
                .terrain(Blocks.END_STONE)
                .biomesSpecs(BiomesSpecs.END)
                .spawnType(FungusSpawn.END_HIGHLANDS)
                .areaRadius(3)
                .build();
        ////////////////////////////////
        //   Very rare native fungi   //
        ////////////////////////////////
        speciesBuilder.createDefaultSpecies(BLINDING_FUNGUS) // could be cool if this very rarely spawns in the overworld
                .warpedType(0xD36146, 0x7EA144, 0x619B68, 0x3A734C)
                .areaEffect(FungusEffects.BLINDING_EFFECT)
                .areaRadius(10)
                .spawnType(FungusSpawn.VERY_RARE.withBiomes(Biomes.DARK_FOREST))
                .build();
        /////////////////////////////
        //   Environmental fungi   //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(FREEZING_FUNGUS)
                .crimsonType(0x6c4026 ,0x6bbeff, 0xd4e3ec, 0xffffff)
                .areaEffect(FungusEffects.FREEZING_EFFECT)
                .areaRadius(8)
                .build();

        //////////////////////
        //   Nether fungi   //
        //////////////////////
        speciesBuilder.createDefaultSpecies(CRYING_FUNGUS) //randomly cries (i.e. drops ghast tears)
                .crimsonType(0xc18c6d, 0xccebff, 0xffffff, 0xe5f5ff)
                .build();
        speciesBuilder.createDefaultSpecies(WITHERING_FUNGUS)
                .crimsonType(0x9E928F, 0x3e3e3e, 0x585858, 0xe1e1e1)
                .terrain(ModBlockTags.NETHER)
                .areaEffect(FungusEffects.WITHERING_EFFECT)
                .build();

        //////////////////////
        //   Nature fungi   //
        //////////////////////
        speciesBuilder.createDefaultSpecies(PLANTING_FUNGUS)
                .crimsonType(0xffd0a3, 0xe76542, 0xfde5cd, 0xa7492f)
                .areaEffect(FungusEffects.PLANT_EFFECT)
                .areaRadius(10)
                .build();

        speciesBuilder.createDefaultSpecies(COCOA_FUNGUS)
                .crimsonType(0xeeaa3c, 0x8c4614, 0x64330b, 0x4e2407)
                .areaEffect(FungusEffects.ANTHESIS_EFFECT)
                .areaRadius(10)
                .build();

        speciesBuilder.createDefaultSpecies(FLOWERS_FUNGUS)
                .warpedType(0xbc8364, 0x51beff, 0xffdf7f, 0xff8f4c)
                .build();

        ///////////////////////////
        //   Existential fungi   //
        ///////////////////////////
        speciesBuilder.createDefaultSpecies(EXPERIENCE_FUNGUS)
                .crimsonType(0x87CFEC, 0x2d81e2, 0x398D4C, 0xB4DF57)
                .areaEffect(FungusEffects.EXPORBS_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(GOODCHANCE_FUNGUS)
                .crimsonType(0x20b189, 0x22b84d, 0x75dd62, 0xd2ffcc)
                .areaEffect(FungusEffects.GOODCHANCE_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(LEARNING_FUNGUS)
                .crimsonType(0xb95b61, 0x19508f, 0x414bdb, 0xf6aff4)
                .areaEffect(FungusEffects.LEARNING_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(KNOWLEDGE_FUNGUS)
                .crimsonType(0xCD725A, 0xD00369, 0x730F17, 0x99B2FF)
                .areaEffect(FungusEffects.KNOWLEDGE_EFFECT)
                .build();
        ///////////////////////////
        //      Magic fungi      //
        ///////////////////////////
        speciesBuilder.createDefaultSpecies(CURING_FUNGUS)
                .warpedType(0xfece69, 0xd32daf, 0xb048eb, 0xff99e5)
                .areaEffect(FungusEffects.CURING_EFFECT)
                .areaRadius(5)
                .build();

        speciesBuilder.createDefaultSpecies(SKELETONS_FUNGUS)
                .warpedType(0xe2dfd4, 0xffffff, 0xffffff, 0x909090)
                .areaRadius(2)
                .areaEffect(FungusEffects.SKELETONS_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(LIFE_UP_FUNGUS)
                .crimsonType(0xffd08d, 0x52e13d, 0xffffff, 0xffffff)
                .eatingEffect(ModEffects.LAST_CHANCE)
                .build();
        ///////////////////////////
        //    Phase Two fungi    //
        ///////////////////////////
        /*speciesBuilder.createProtoSpecies("GRANITE_FUNGUS")
                .build();
        speciesBuilder.createProtoSpecies("ANDESITE_FUNGUS")
                .build();
        speciesBuilder.createDefaultSpecies("OBSIDIAN_FUNGUS")
                .crimsonType()
                .colors4(0x300b5f, 0x2a1e4b, 0x36205a, 0x432e69)
                .build();
        speciesBuilder.createDefaultSpecies("RADIOACTIVE_EFFECT_FUNGUS")
                .crimsonType()
                .colors4(0xcc052a, 0xc0b334, 0xb79655, 0x514d1d)
                .areaEffect(FungusEffects.RADIOACTIVE_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("PHANTOM_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.PHANTOM_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("SHINING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SHINING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("SPARKLING_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.SPARKLING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies(POISON_FUNGUS)
                .areaEffect(FungusEffects.POISON_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies(SCHIZO_FUNGUS)
                .areaEffect(FungusEffects.SCHIZO_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("LIGHTFUL_EFFECT_FUNGUS")
                .areaEffect(FungusEffects.LIGHTFUL_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies("CREEPING_EFFECT_FUNGUS")
                .areaRadius(2)
                .areaEffect(FungusEffects.CREEPING_EFFECT)
                .build();
        speciesBuilder.createProtoSpecies(NIGHTLY_FUNGUS)
                .areaEffect(FungusEffects.NIGHTLY_EFFECT)
                .build();*/

        /////////////////////////
        //      DEV fungi      //
        /////////////////////////
        speciesBuilder.createDefaultSpecies("DEV_FUNGUS")
                .crimsonType(0x5567E5, 0x9F55B5, 0xBF5DAF, 0xD32BD9)
                .areaEffect(FungusEffects.DEV_TEST_EFFECT)
                .areaRadius(2)
                .build();
        speciesBuilder.createDefaultSpecies("TNT_FUNGUS")
                .crimsonType(0xc72e25, 0xc72e25, 0xe8e8e8, 0x303030)
                .areaEffect(FungusEffects.TNT_EFFECT)
                .areaRadius(4)
                .build();

        //some colors
        //(0x9c2b17, 0x9cd424, 0xb6e6be, 0x860a18)
        //(0x9c2b17, 0x9cd424, 0xfade85, 0x860a18)

        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName()
    {
        return "Fungi species";
    }
}
