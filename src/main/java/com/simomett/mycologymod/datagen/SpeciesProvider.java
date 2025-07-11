package com.simomett.mycologymod.datagen;

import com.simomett.mycologymod.datagen.common.BiomesSpecs;
import com.simomett.mycologymod.datagen.common.FungusSpawn;
import com.simomett.mycologymod.datagen.common.SpeciesBuilder;
import com.simomett.mycologymod.effects.FungusEffects;
import com.simomett.mycologymod.effects.PlayerEffects.ModEffects;
import com.simomett.mycologymod.tags.ModBlockTags;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.simomett.mycologymod.datagen.common.SpeciesDictionary.*;

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

        //////////////////////////////
        //     Overworld branch     //
        //////////////////////////////
        speciesBuilder.createSpecies(AGARICUS_CAMPESTRIS)
                .warpedType(0xFFF7E7, 0xFFF7E7, 0xC7C1B4, 0xA8A398)//FIXME darker
                .spreading(SpeciesBuilder.DEFAULT_SPREADING)
                .spreadBoost(1.1F)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.PLAINS)
                .spawnType(FungusSpawn.PLAINS)
                .build();

        speciesBuilder.createSpecies(AMANITA_RUBRA)
                .crimsonType(0xFFFFCC, 0xC41717, 0xF2F2F2, 0xF2F2F2)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .spawnType(FungusSpawn.DARK_FOREST)
                .build();

        speciesBuilder.createSpecies(LACTARIUS_VIRENS)
                .warpedType( 0xBF98BF, 0x6bb83c, 0x99110F, 0xF502D3)//FIXME
                .spreading(SpeciesBuilder.DEFAULT_SPREADING)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.PLAINS)
                .spawnType(FungusSpawn.SUNFLOWER_PLAINS)
                .build();

        speciesBuilder.createSpecies(LECCINUM_VERSIPELLE)
                .warpedType(0xFFFBFB, 0xFF7C2D, 0x885431, 0xBD7142)//FIXME
                .spreading(SpeciesBuilder.DEFAULT_SPREADING)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.BIRCH_FOREST)
                .spawnType(FungusSpawn.BIRCH_FOREST)
                .build();

        speciesBuilder.createSpecies(BOLETUS_EDULIS)
                .crimsonType(0xb3a384, 0x62514a, 0x8f7c75, 0xd0c6c6)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FOREST)
                .build();

        speciesBuilder.createSpecies(SUILLUS_GRANULATUS)
                .warpedType(0xFFF7E7, 0xFFA376, 0xC47D5A, 0xD88A64)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_PINE_TAIGA)
                .spawnType(FungusSpawn.OLD_GROWTH_PINE_TAIGA)
                .build();

        speciesBuilder.createSpecies(CHALCIPORUS_PIPERATUS)//non edible
                .crimsonType(0xFFC741, 0xAE5913, 0x64330B, 0x8E6C24)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.OLD_GROWTH_SPRUCE_TAIGA)
                //.areaEffect(FungusEffects.SNEEZING)
                .spawnType(FungusSpawn.OLD_GROWTH_SPRUCE_TAIGA)
                .build();

        speciesBuilder.createSpecies(HYGROPHORUS_NIVEUS)
                .crimsonType(0x6c4026 ,0xd5eeff, 0xd4e3ec, 0xffffff)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.SNOWY_TAIGA)
                .spawnType(FungusSpawn.SNOWY_TAIGA)
                .build();

        speciesBuilder.createSpecies(AMANITA_MUSCARIA)//poisonous
                .warpedType(0xFFFCD9, 0xFF521E, 0xFFFFFF, 0xFFB171)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.JUNGLE)
                .spawnType(FungusSpawn.JUNGLES)
                .build();

        speciesBuilder.createSpecies(AMANITA_PHALLOIDES)
                .crimsonType(0xffdb94, 0xc71c12, 0xe8e8e8, 0xF2F2F2)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-2)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.SWAMP)
                .spawnType(FungusSpawn.SWAMP)
                .build();

        speciesBuilder.createSpecies(YELLOW_FUNGUS)
                .warpedType(0xffeebd, 0xffd047, 0xc6a046, 0xf08342)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.MEADOW)
                .spawnType(FungusSpawn.MEADOW)
                .build();

        speciesBuilder.createSpecies(BLUE_FUNGUS)
                .crimsonType(0xF6DFB5, 0x4f94ee, 0xF6DFB5, 0xfff7e9)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.FOREST)
                .spawnType(FungusSpawn.FLOWER_FOREST)
                .build();

        speciesBuilder.createSpecies(LACTARIUS_PROLEFERENS)
                .warpedType(0x81696b, 0x933c3e, 0x933c3e, 0xd28d77)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(Blocks.MYCELIUM)
                .biomesSpecs(BiomesSpecs.MUSHROOM_FIELDS)
                .spawnType(FungusSpawn.MUSHROOM_FIELDS)
                .areaEffect(FungusEffects.SPORING_EFFECT)
                .areaRadius(4)
                .build();

        speciesBuilder.createSpecies(BOLBITIUS_PROFONDORUM)
                .crimsonType(0x8c909c, 0x94989C, 0x3f4045, 0x2b2d31)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(1.1f)
                .light(3)
                .terrain(ModBlockTags.DEEPSLATE)
                .spawnType(FungusSpawn.CAVES)
                .biomesSpecs(BiomesSpecs.FOREST)
                .build();

        speciesBuilder.createSpecies(BLINDING_FUNGUS)
                .warpedType(0xD36146, 0x7EA144, 0x619B68, 0x3A734C)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(1.1f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .areaEffect(FungusEffects.BLINDING_EFFECT)
                .areaRadius(10)
                .spawnType(FungusSpawn.VERY_RARE.withBiomes(Biomes.DARK_FOREST))
                .biomesSpecs(BiomesSpecs.FOREST)
                .build();

        ///////////////////////
        //   Nether branch   //
        ///////////////////////
        speciesBuilder.createSpecies(CHALCIPORUS_INFERNALIS)//nether wastes native
                .crimsonType(0xb5917a, 0xEE2E3D, 0xff6500, 0xffa468)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING)
                .spreadBoost(1.1f)
                .light(13)
                .terrain(Blocks.NETHERRACK)
                .biomesSpecs(BiomesSpecs.NETHER)
                .spawnType(FungusSpawn.NETHER_WASTES)
                .build();

        speciesBuilder.createSpecies(AGARICUS_ANIMI)//soul sand valley native
                .crimsonType(0x7b929c, 0x796251, 0x614e43, 0x887265)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+1)
                .spreadBoost(1.1f)
                .light(13)
                .terrain(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .biomesSpecs(BiomesSpecs.NETHER)
                .spawnType(FungusSpawn.SOUL_SAND_VALLEY)
                .build();

        speciesBuilder.createSpecies(BLAZE_FUNGUS)
                .crimsonType(0xcb6c13, 0xe49a2b, 0xFFDD36, 0xFFFF73)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(13)
                .terrain(ModBlockTags.NETHER_BRICKS)
                .biomesSpecs(BiomesSpecs.NETHER)
                .areaEffect(FungusEffects.BLAZING_EFFECT)
                .areaRadius(9)
                .build();

        speciesBuilder.createSpecies(CRYING_FUNGUS) //randomly cries (i.e. drops ghast tears)
                .crimsonType(0xc18c6d, 0xccebff, 0xffffff, 0xe5f5ff)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+2)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(13)
                .terrain(Blocks.NETHERRACK)
                .biomesSpecs(BiomesSpecs.NETHER)
                .areaEffect(FungusEffects.CRYING_EFFECT)
                .areaRadius(2)
                .build();

        speciesBuilder.createSpecies(WITHERING_FUNGUS)
                .crimsonType(0x9E928F, 0x3e3e3e, 0x585858, 0xe1e1e1)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+2)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(8)
                .terrain(ModBlockTags.NETHER)
                .biomesSpecs(BiomesSpecs.NETHER)
                .areaEffect(FungusEffects.WITHERING_EFFECT)
                .areaRadius(4)
                .build();

        ////////////////////
        //   End branch   //
        ////////////////////
        speciesBuilder.createSpecies(END_FUNGUS)
                .crimsonType(0xe7f1b1, 0x3c0581, 0xa058ae, 0x490a61)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+1)
                .spreadBoost(1.4f)
                .light(10)
                .terrain(Blocks.END_STONE)
                .biomesSpecs(BiomesSpecs.END)
                .spawnType(FungusSpawn.END)
                .build();

        speciesBuilder.createSpecies(CHORUS_FUNGUS)
                .crimsonType(0xe1dab6, 0xa078db, 0xeee9ff, 0xbea9b8)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+1)
                .spreadBoost(1.4f)
                .light(10)
                .terrain(Blocks.END_STONE)
                .biomesSpecs(BiomesSpecs.END)
                .spawnType(FungusSpawn.END_HIGHLANDS)
                .areaRadius(3)
                .build();

        speciesBuilder.createSpecies(TRICHOLOMOPSIS_EVANESCENS)
                .crimsonType(0x87cfec, 0x06d192, 0x69d0af, 0x068054)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+2)
                .spreadBoost(1.3f)
                .light(10)
                .terrain(Blocks.END_STONE)
                .biomesSpecs(BiomesSpecs.END)
                .build();

        speciesBuilder.createSpecies(ENDER_EYE_FUNGUS)
                .crimsonType(0x90c074, 0x06d192, 0x72ac49, 0xb4e45b)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+3)
                .spreadBoost(1.3f)
                .light(10)
                .terrain(Blocks.END_STONE)
                .biomesSpecs(BiomesSpecs.END)
                .areaEffect(FungusEffects.EYE_OF_ENDER_EFFECT)
                .build();

        speciesBuilder.createSpecies(RAPTING_FUNGUS)
                .crimsonType(0x71ecad, 0xc575ff, 0xb8dce5, 0x157865)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+3)
                .spreadBoost(1.3f)
                .light(10)
                .terrain(Blocks.END_STONE)
                .biomesSpecs(BiomesSpecs.END)
                .areaEffect(FungusEffects.RAPTING_EFFECT)
                .build();

        speciesBuilder.createSpecies(TELEPORTING_FUNGUS)
                .crimsonType(0x4b6ae5, 0x2bd9a1, 0x37e3bd, 0x5ef9e2)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+4)
                .spreadBoost(1.3f)
                .light(10)
                .terrain(Blocks.END_STONE)
                .biomesSpecs(BiomesSpecs.END)
                .areaEffect(FungusEffects.TELEPORTING_EFFECT)
                .build();

        /////////////////////////////
        //      Colors fungi       //
        /////////////////////////////
        speciesBuilder.createSpecies(ORANGE_FUNGUS)
                .warpedType(0xffe0bd, 0xfc9646, 0xc98d6a, 0x844432)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .build();

        speciesBuilder.createSpecies(LIME_FUNGUS)
                .warpedType(0x9e885f, 0xdd6544, 0x20b482, 0x50ec6c)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.PLAINS)
                .build();

        speciesBuilder.createSpecies(CYAN_FUNGUS)
                .warpedType(0xdcab8a, 0x45af9c, 0xd3907c, 0x0c6c91)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.FOREST)
                .build();

        speciesBuilder.createSpecies(LIGHTBLUE_FUNGUS)
                .warpedType(0xc9f38e, 0x87cfec, 0xcaeef9, 0x8ad4f1)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.BIRCH_FOREST)
                .build();

        speciesBuilder.createSpecies(OVULUS_VIOLACEUS)
                .crimsonType(0xAA48FB, 0x9c133f, 0xA23F19, 0xE105EF)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .build();

        speciesBuilder.createSpecies(MAGENTA_FUNGUS)
                .crimsonType(0xffb2cf, 0xef459d, 0x981c33, 0xffffff)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .build();

        speciesBuilder.createSpecies(PINK_FUNGUS)
                .crimsonType(0xf6dfb5, 0xffc0cb, 0xffc0cb, 0xffeef0)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.PLAINS)
                .build();

        speciesBuilder.createSpecies(BROWN_FUNGUS)
                .warpedType(0xeeaa3c, 0xae5913, 0x64330b, 0x4e2407)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.JUNGLE)
                .build();

        speciesBuilder.createSpecies(BLACK_FUNGUS)
                .crimsonType(0xffdcc7, 0xffffff, 0xe4d6cd, 0x262626)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.FOREST)
                .build();

        speciesBuilder.createSpecies(GREY_FUNGUS)
                .crimsonType(0xffe0bd, 0x949494, 0x938b7f, 0xaa988e)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.FOREST)
                .build();

        speciesBuilder.createSpecies(LIGHTGREY_FUNGUS)
                .warpedType(0xffdfcc, 0xf8feff, 0xdcdcdc, 0xbfbfbf)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.BIRCH_FOREST)
                .build();

        speciesBuilder.createSpecies(WHITE_FUNGUS)
                .warpedType(0xfbf4e1, 0xfffdf6, 0xf3f3f3, 0xf3edd5) //FIXME I don't like it too much
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.BIRCH_FOREST)
                .build();

        /////////////////////////////
        //     Benefic branch      //
        /////////////////////////////
        speciesBuilder.createSpecies(BOLETUS_SALUBRIUM)
                .crimsonType(0xC176C0, 0x95778C, 0xD01B05, 0xB99AA7)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(1.0f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.HEALING_EFFECT)
                .areaRadius(3)
                .build();

        speciesBuilder.createDefaultSpecies(SPEED_FUNGUS)
                .warpedType(0xfebf98, 0xd0eaff, 0xffffff, 0x92c5e4)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-5)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .areaRadius(3)
                .build();

        speciesBuilder.createDefaultSpecies(STRENGTH_FUNGUS)
                .crimsonType(0xc04774, 0x916a7a, 0xc70d09, 0xda8d46)
                .light(14)
                .areaEffect(FungusEffects.STRENGTH_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(LACCARIA_DULCIS)//Sugar fungus
                .warpedType(0x97634a, 0x7695ff, 0xcdd7ff, 0x9aa8ff)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-3)
                .light(14)
                .build();

        speciesBuilder.createDefaultSpecies(LACTARIUS_DELICIOUS)
                .warpedType(0xffc2a5, 0xff9e76, 0xe8a689, 0xd86b63)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .light(14)
                .build();

        speciesBuilder.createDefaultSpecies(CRATERELLUS_CORNUCOPIOIDES)
                .warpedType(0x382b30, 0x211c31, 0x141220, 0x0d0a1c)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-3)
                .light(12)
                .biomesSpecs(BiomesSpecs.PLAINS)
                .areaEffect(FungusEffects.DEFENSE_EFFECT)
                .areaRadius(6)
                .build();

        speciesBuilder.createSpecies(NOBLE_BOLETUS_SQUISITUS)
                .crimsonType(0xcdb9ae, 0x7b615b, 0xa27771, 0xbfaaa9)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(14)
                .terrain(ModBlockTags.PODZOL)
                .biomesSpecs(BiomesSpecs.TAIGA)
                .areaEffect(FungusEffects.NO_EFFECT)
                .build();

        ///////////////////////////
        //    Alcoholic fungi    //
        ///////////////////////////
        speciesBuilder.createSpecies(FERMENTER_FUNGUS)
                .warpedType(0xa98565, 0xf9bcc1, 0xc7bdce, 0x6d719a)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-2)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST*2)
                .light(13)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.SWAMP)
                .areaEffect(FungusEffects.FERMENTING_EFFECT)
                .build();

        speciesBuilder.createSpecies(DRUNK_FUNGUS)
                .crimsonType(0x663321, 0x4d9268, 0x2aa65a, 0xf9af46)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST+0.2f)
                .light(13)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.SWAMP)
                .areaEffect(FungusEffects.DRUNK_EFFECT)
                .build();

        speciesBuilder.createSpecies(TOXIC_METILIC_FUNGUS)
                .warpedType(0x9b8ac5, 0xf3dbec, 0x883674, 0xc797ab)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-2)
                .spreadBoost(1.4f)
                .light(12)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.SWAMP)
                .build();

        /////////////////////////////
        //      Toxic fungi        //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(FATIGUE_FUNGUS)
                .warpedType(0xabd9ed, 0x8aabaf, 0x596e77, 0xe2c6b5)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-2)
                .light(14)
                .areaEffect(FungusEffects.FATIGUE_EFFECT)
                .build();

        /////////////////////////////
        //     Materials fungi     //
        /////////////////////////////
        speciesBuilder.createSpecies(POLYPORUS_LIGNEUS)
                .warpedType(0xbba77a, 0x8d664b, 0xb38f6e, 0x4f3a2d)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(BlockTags.LOGS)
                .biomesSpecs(BiomesSpecs.FOREST)
                .areaRadius(7)
                .areaEffect(FungusEffects.DECOMPOSING_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(DIORITE_FUNGUS)
                .crimsonType(0xffb796, 0xffffff, 0xffffff, 0x8f8f8f)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .light(13)
                .terrain(Blocks.DIORITE)
                .build();

        speciesBuilder.createDefaultSpecies(CALCITE_FUNGUS)
                .crimsonType(0xf8f0d5, 0xffffff, 0xffffff, 0xbbb89d)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-2)
                .light(12)
                .terrain(Blocks.CALCITE)
                .build();

        speciesBuilder.createDefaultSpecies(BASALT_FUNGUS)
                .crimsonType(0x4f4b4f, 0x838383, 0x878787, 0x1b2632)
                .light(9)
                .terrain(Blocks.BASALT)
                .build();

        speciesBuilder.createDefaultSpecies(TUFF_FUNGUS)
                .warpedType(0x95978d, 0x63625c, 0x6b6b5f, 0x393c34)
                .light(9)
                .terrain(Blocks.TUFF)
                .build();

        speciesBuilder.createDefaultSpecies(CLAY_FUNGUS)
                .warpedType(0xffdbb2, 0xb2c5ff, 0x8896c3, 0xadbfee)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(14)
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
                .light(14)
                .terrain(Blocks.BONE_BLOCK)
                .biomesSpecs(BiomesSpecs.PLAINS)
                .build();

        speciesBuilder.createDefaultSpecies(SLIME_FUNGUS)
                .warpedType(0xdcc98e, 0x9fda67, 0x86d274, 0xa5ff99)
                .light(14)
                .terrain(Blocks.MOSS_BLOCK)
                .biomesSpecs(BiomesSpecs.SWAMP)
                .build();

        /////////////////////////////
        //      Mineral fungi      //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(COAL_FUNGUS)
                .warpedType(0xa19b88, 0x8a8a8a, 0x383838, 0x2e2e2e)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-2)
                .light(9)
                .terrain(ModBlockTags.COAL)
                .build();

        speciesBuilder.createDefaultSpecies(EMERALD_FUNGUS)
                .crimsonType(0x8c909c, 0x5f6269, 0x287441, 0x96ffaa)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-3)
                .light(9)
                .terrain(BlockTags.EMERALD_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(GALERINA_AURATA) //Gold
                .warpedType(0xeed484, 0xFF9900, 0xFFDD36, 0xffe56b)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-3)
                .light(8)
                .terrain(BlockTags.GOLD_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(BOLBITIUS_SILEX) //Quartz
                .crimsonType(0xc83825, 0xfff1eb, 0xe0dcda, 0xffffff)
                .light(8)
                .terrain(ModBlockTags.QUARTZ_ORES)
                .build();

        speciesBuilder.createSpecies(RUSSULA_LAZULA) //Lapislazuli
                .crimsonType(0xffffcc, 0x837672, 0x183679, 0x2653b9)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-2)
                .spreadBoost(1.0f)
                .light(8)
                .terrain(BlockTags.LAPIS_ORES)
                .biomesSpecs(BiomesSpecs.FOREST)
                .areaEffect(FungusEffects.NO_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(RUSSULA_CONCITATA)
                .crimsonType(0xFFF9EE, 0x760a00, 0x730000, 0xda0000)
                .light(9)
                .terrain(BlockTags.REDSTONE_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(AMANITA_CUPREA) //Copper
                .warpedType(0xbb9173, 0xe8693d, 0x208068, 0x20a387)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-1)
                .light(9)
                .terrain(BlockTags.COPPER_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(XEROCOMUS_FERRUGINEUS)
                .warpedType(0xffffcc, 0x95867e, 0xC0997F, 0xFBD3B8)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING-3)
                .light(9)
                .terrain(BlockTags.IRON_ORES)
                .build();

        speciesBuilder.createDefaultSpecies(AMETHYST_FUNGUS)
                .crimsonType(0xfad2d4, 0xae80ff, 0xba8ed6, 0xf6c3da)
                .light(8)
                .terrain(Blocks.AMETHYST_BLOCK)
                .build();

        speciesBuilder.createDefaultSpecies(BUDDING_FUNGUS)
                .warpedType(0xebb9d2, 0x8e61ff, 0xd665b8, 0xf6b0d0)
                .light(8)
                .terrain(Blocks.AMETHYST_BLOCK)
                .areaEffect(FungusEffects.BUDDING_EFFECT)
                .areaRadius(4)
                .build();

        speciesBuilder.createDefaultSpecies(DIAMOND_FUNGUS)
                .crimsonType(0x848d9b, 0x5d636f, 0x21202a, 0x00ecff)
                .light(8)
                .terrain(BlockTags.DIAMOND_ORES)
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

        ////////////////////////
        //    Psico branch    //
        ////////////////////////
        speciesBuilder.createDefaultSpecies(ANESTHETIC_FUNGUS)
                .warpedType(0x59a6cf, 0xe61e65, 0xe03775, 0xffffff)
                .light(12)
                .areaEffect(FungusEffects.ANESTHETIC_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(ILLUCINATING_FUNGUS)
                .warpedType(0xa86a30, 0xb8ba81, 0xbe1339, 0xeeb97a)
                .light(12)
                .areaEffect(FungusEffects.ILLUCINATING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(HALLUCINATING_FUNGUS)
                .warpedType(0xefe8de, 0x50483b, 0x1f3132, 0x28a6af)
                .light(12)
                .areaEffect(FungusEffects.HALLUCINATING_EFFECT)
                .build();
        speciesBuilder.createDefaultSpecies(SENSING_FUNGUS)
                .warpedType(0xcec2c5, 0xffcf42, 0xffffff, 0x1984a1)
                .light(12)
                .areaEffect(FungusEffects.SENSING_EFFECT)
                .build();

        //////////////////////
        //   Nature fungi   //
        //////////////////////
        speciesBuilder.createSpecies(FERTILIZING_FUNGUS)
                .warpedType(0xFFE3BF, 0xFFF8DC, 0xDBDAD7, 0xC8C1B5)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+4)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.MEADOW)
                .areaEffect(FungusEffects.FERTILIZING_EFFECT)
                .build();

        speciesBuilder.createSpecies(PLANTING_FUNGUS)
                .crimsonType(0xffd0a3, 0xe76542, 0xfde5cd, 0xa7492f)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+4)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.MEADOW)
                .areaEffect(FungusEffects.PLANT_EFFECT)
                .areaRadius(10)
                .build();

        speciesBuilder.createSpecies(COCOA_FUNGUS)
                .crimsonType(0xeeaa3c, 0x8c4614, 0x64330b, 0x4e2407)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+3)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.JUNGLE)
                .areaEffect(FungusEffects.ANTHESIS_EFFECT)
                .areaRadius(10)
                .build();

        speciesBuilder.createSpecies(FLOWERS_FUNGUS)
                .warpedType(0xbc8364, 0x51beff, 0xffdf7f, 0xff8f4c)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+2)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.PLAINS)
                .build();

        /////////////////////////
        //    Mutant branch    //
        /////////////////////////
        speciesBuilder.createDefaultSpecies(DYEING_FUNGUS)
                .warpedType(0xffcb99, 0xff66d8, 0xf8fa53, 0x49b2e3)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .areaEffect(FungusEffects.DYEING_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(UNDEAD_FUNGUS)
                .warpedType(0x9b4e3b, 0x6a8a3d, 0x457ae3, 0x4b54bb)
                .light(13)
                .areaRadius(2)
                .areaEffect(FungusEffects.UNDEAD_EFFECT)
                .build();

        ////////////////////////////
        //    Energetic branch    //
        ////////////////////////////
        speciesBuilder.createSpecies(GLOWSTONE_FUNGUS)
                .crimsonType(0xff4d45, 0xffdb4a, 0xdcc677, 0xfff3cd)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+1)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST)
                .light(15)
                .terrain(ModBlockTags.NETHER)
                .biomesSpecs(BiomesSpecs.NETHER)
                .build();

        speciesBuilder.createSpecies(LIGHTNING_FUNGUS)
                .warpedType(0xfeffcc, 0xffcf42, 0xffffff, 0xb2ffff)
                .spreading(SpeciesBuilder.DEFAULT_SPREADING+4)
                .spreadBoost(SpeciesBuilder.DEFAULT_SPREADBOOST-0.3f)
                .light(15)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.FOREST)
                .areaEffect(FungusEffects.LIGHTNING_EFFECT)
                .build();

        /////////////////////////////
        //   Environmental fungi   //
        /////////////////////////////
        speciesBuilder.createDefaultSpecies(FREEZING_FUNGUS)
                .crimsonType(0x6c4026 ,0x6bbeff, 0xd4e3ec, 0xffffff)
                .light(14)
                .areaEffect(FungusEffects.FREEZING_EFFECT)
                .areaRadius(8)
                .build();

        ///////////////////////////
        //   Existential fungi   //
        ///////////////////////////
        speciesBuilder.createDefaultSpecies(EXPERIENCE_FUNGUS)
                .crimsonType(0x87CFEC, 0x2d81e2, 0x398D4C, 0xB4DF57)
                .light(14)
                .terrain(ModBlockTags.GRASS)
                .areaEffect(FungusEffects.EXPORBS_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(GOODCHANCE_FUNGUS)
                .crimsonType(0x20b189, 0x22b84d, 0x75dd62, 0xd2ffcc)
                .light(14)
                .terrain(ModBlockTags.GRASS)
                .areaEffect(FungusEffects.GOODCHANCE_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(LEARNING_FUNGUS)
                .crimsonType(0xb95b61, 0x19508f, 0x414bdb, 0xf6aff4)
                .light(14)
                .terrain(ModBlockTags.GRASS)
                .areaEffect(FungusEffects.LEARNING_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(KNOWLEDGE_FUNGUS)
                .crimsonType(0xCD725A, 0xD00369, 0x730F17, 0x99B2FF)
                .light(14)
                .terrain(ModBlockTags.GRASS)
                .areaEffect(FungusEffects.KNOWLEDGE_EFFECT)
                .build();

        ///////////////////////////
        //      Magic fungi      //
        ///////////////////////////
        speciesBuilder.createDefaultSpecies(CURING_FUNGUS)
                .warpedType(0xfece69, 0xd32daf, 0xb048eb, 0xff99e5)
                .light(14)
                .areaEffect(FungusEffects.CURING_EFFECT)
                .areaRadius(5)
                .build();

        speciesBuilder.createDefaultSpecies(SKELETONS_FUNGUS)
                .warpedType(0xe2dfd4, 0xffffff, 0xffffff, 0x909090)
                .light(12)
                .areaRadius(2)
                .areaEffect(FungusEffects.SKELETONS_EFFECT)
                .build();

        speciesBuilder.createDefaultSpecies(LIFE_UP_FUNGUS)
                .crimsonType(0xffd08d, 0x52e13d, 0xffffff, 0xffffff)
                .spreading(SpeciesBuilder.VERY_SLOW_SPREADING)
                .light(14)
                .areaEffect(FungusEffects.NO_EFFECT)
                .areaRadius(0)
                .eatingEffect(ModEffects.LAST_CHANCE)
                .build();

        speciesBuilder.createSpecies(ZOMBIES_FUNGUS)
                .warpedType(0xc0725a, 0xfff8eb,0x745691, 0xdfc6ff)
                .spreading(4)
                .spreadBoost(1f)
                .light(14)
                .terrain(ModBlockTags.GRASS)
                .biomesSpecs(BiomesSpecs.PLAINS)
                .areaRadius(5)
                .areaEffect(FungusEffects.ZOMBIES_EFFECT)
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
        /*speciesBuilder.createDefaultSpecies("DEV_FUNGUS")
                .crimsonType(0x5567E5, 0x9F55B5, 0xBF5DAF, 0xD32BD9)
                .areaEffect(FungusEffects.DEV_TEST_EFFECT)
                .areaRadius(2)
                .build();*/
        /*speciesBuilder.createDefaultSpecies("TNT_FUNGUS")
                .crimsonType(0xc72e25, 0xc72e25, 0xe8e8e8, 0x303030)
                .areaEffect(FungusEffects.TNT_EFFECT)
                .areaRadius(4)
                .build();*/

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
