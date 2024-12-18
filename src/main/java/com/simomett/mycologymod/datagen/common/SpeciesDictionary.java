package com.simomett.mycologymod.datagen.common;

import static com.simomett.mycologymod.datagen.common.FungusGeni.*;

public class SpeciesDictionary
{
    /*
     *   Everything starts from the natives species:
     */
    //  Native Overworld
    public static final String AGARICUS_CAMPESTRIS = AGARICUS+" campestris";       //(plains)
    public static final String LACTARIUS_VIRENS = LACTARIUS+" virens";           //(sunflower plains)
    public static final String LECCINUM_VERSIPELLE = LECCINUM+" versipelle";       //(birch forest)
    public static final String BOLETUS_EDULIS = BOLETUS+" edulis";                 //(forest)
    public static final String SUILLUS_GRANULATUS = SUILLUS+" granulatus";         //(old growth pine taiga)
    public static final String CHALCIPORUS_PIPERATUS = CHALCIPORUS+" piperatus";   //(old growth spruce taiga)
    public static final String AMANITA_MUSCARIA = AMANITA+" muscaria";             //(jungle)
    public static final String AMANITA_PHALLOIDES = AMANITA+" phalloides";         //(swamp)
    public static final String YELLOW_FUNGUS = HYGROCYBE+" pratensis";             //(meadow)
    public static final String BLUE_FUNGUS = BOLETELLUS+" caeruleus";              //(flower forest)
    public static final String LACTARIUS_PROLEFERENS = LACTARIUS+" proleferens";   //(mushroom fields)
    public static final String HYGROPHORUS_NIVEUS = HYGROPHORUS+" niveus";         //(snowy taiga)
    public static final String BOLBITIUS_PROFONDORUM = BOLBITIUS+" profundorum";   //(caves)
    public static final String BLINDING_FUNGUS = COPRINUS+" caecans";              //(overworld, very rare)

    // Native Nether
    public static final String AGARICUS_ANIMI = AGARICUS+" animi";
    public static final String CHALCIPORUS_INFERNALIS = CHALCIPORUS+" infernalis";

    // Native End
    public static final String END_FUNGUS = AGARICUS+" transdimensionalis";
    public static final String CHORUS_FUNGUS = BOLETELLUS+" choruum";

    // Colors branch
    public static final String AMANITA_RUBRA = AMANITA+" rubra";
    public static final String WHITE_FUNGUS = LACCARIA+" candida";
    public static final String GREY_FUNGUS = BOLETELLUS+" cineraceus";
    public static final String LIME_FUNGUS = CANTHARELLUS+" viridis";
    public static final String LIGHTGREY_FUNGUS = CRATERELLUS+" pallidus";
    public static final String BLACK_FUNGUS = COPRINUS+" comatus";
    public static final String LIGHTBLUE_FUNGUS = LECCINUM+" caelestis";
    public static final String PINK_FUNGUS = HYGROPHORUS+" rosaceus";
    public static final String BROWN_FUNGUS = BOLBITIUS+" fuscus";
    public static final String OVULUS_VIOLACEUS = OVULUS+" violaceus";
    public static final String CYAN_FUNGUS = RUSSULA+" cyanea";
    public static final String MAGENTA_FUNGUS = RUSSULA+" fuchsia";
    public static final String ORANGE_FUNGUS = LACCARIA+" lutea";

    // Materials branch
    public static final String POLYPORUS_LIGNEUS = POLYPORUS+" ligneus";
    public static final String CLAY_FUNGUS = LACCARIA+" cretae";
    public static final String BASALT_FUNGUS = TRICHOLOMOPSIS+" fundamentorum";
    public static final String DIORITE_FUNGUS = HYGROCYBE+" dioritis";
    public static final String CALCITE_FUNGUS = OVULUS+" calcareus";
    public static final String BONEBLOCK_FUNGUS = XEROCOMUS+" osseus";

    // Minerals branch
    public static final String COAL_FUNGUS = LECCINUM+" carbonis";
    public static final String XEROCOMUS_FERRUGINEUS = XEROCOMUS+" ferrugineus";
    public static final String AMANITA_CUPREA = AMANITA+" cuprea";
    public static final String TUFF_FUNGUS = HYGROCYBE+" tophi";
    public static final String AMETHYST_FUNGUS = SUILLUS+" amethystis";
    public static final String BUDDING_FUNGUS = XEROCOMUS+" gemmans";
    public static final String RUSSULA_LAZULA = RUSSULA+" lazula";
    public static final String RUSSULA_CONCITATA = RUSSULA+" concitata";
    public static final String GALERINA_AURATA = GALERINA+" aurata";
    public static final String DIAMOND_FUNGUS = LECCINUM+" adamantinus";
    public static final String EMERALD_FUNGUS = CRATERELLUS+" smaragdi";
    public static final String BOLBITIUS_SILEX = BOLBITIUS+" silex";

    // Removed due to non-conformity with the lore of netherite.
    //public static final String POLYPORUS_ANTIQUUS = POLYPORUS+" antiquus";
    //public static final String NETHERITE_FUNGUS = "NETHERITE_FUNGUS";

    // Benefic branch
    public static final String LACTARIUS_DELICIOUS = LACTARIUS+" deliciosus";
    public static final String LACCARIA_DULCIS = LACCARIA+" dulcis";
    public static final String NOBLE_BOLETUS_SQUISITUS = "Noble "+BOLETUS+" squisitus";
    public static final String BOLETUS_SALUBRIUM = BOLETUS+" salubrium";
    public static final String STRENGTH_FUNGUS = SUILLUS+" roborans";
    public static final String SPEED_FUNGUS = LACTARIUS+" agilis";
    public static final String CRATERELLUS_CORNUCOPIOIDES = CRATERELLUS+" cornucopioides";

    // Alcoholic branch
    public static final String FERMENTER_FUNGUS = HYGROCYBE+" saccharoidis";
    public static final String DRUNK_FUNGUS = COPRINUS+" ebrius";
    public static final String TOXIC_METILIC_FUNGUS = CORTINARIUS+" venenatus";

    // Toxic branch
    public static final String FATIGUE_FUNGUS = XEROCOMUS+" exhaustus";
    //public static final String POISON_FUNGUS = "POISON_FUNGUS";

    // Psico branch
    public static final String ANESTHETIC_FUNGUS = HYGROPHORUS+" medens";
    public static final String ILLUCINATING_FUNGUS = OVULUS+" pavoris";
    public static final String HALLUCINATING_FUNGUS = "Psilocybe baeocystis";
    public static final String SENSING_FUNGUS = TRICHOLOMOPSIS+" sensibilis";
    //public static final String SCHIZO_FUNGUS = "SCHIZO_FUNGUS";
    //public static final String NIGHTLY_FUNGUS = "NIGHTLY_FUNGUS";

    // Environmental branch
    public static final String FREEZING_FUNGUS = GALERINA+" gelans";

    // Nether branch
    public static final String BLAZE_FUNGUS = BOLETELLUS+" fulgens";
    public static final String CRYING_FUNGUS = AMANITA+" lacrimosa";
    public static final String WITHERING_FUNGUS = SARCOSPHAERA+" arescens";

    // End branch
    public static final String TRICHOLOMOPSIS_EVANESCENS = TRICHOLOMOPSIS+" evanescens";
    public static final String RAPTING_FUNGUS = CHALCIPORUS+" rapiens";
    public static final String TELEPORTING_FUNGUS = OVULUS+" expeditus";
    public static final String ENDER_EYE_FUNGUS = BOLBITIUS+" dirigens";

    // Nature branch
    public static final String COCOA_FUNGUS = CRATERELLUS+" cacao";
    public static final String PLANTING_FUNGUS = IMLERIA+" agricola";
    public static final String FLOWERS_FUNGUS = SUILLUS+" florens";
    public static final String FERTILIZING_FUNGUS = LECCINUM+" fertilis";

    // Mutant branch
    public static final String DYEING_FUNGUS = GALERINA+" colorata";
    public static final String UNDEAD_FUNGUS = "Cordyceps malignus";

    // Energetic branch
    public static final String GLOWSTONE_FUNGUS = GALERINA+" luminosa";
    public static final String LIGHTNING_FUNGUS = POLYPORUS+" irruens";

    // Existential branch
    public static final String EXPERIENCE_FUNGUS = GALERINA+" peritia";
    public static final String GOODCHANCE_FUNGUS = AGARICUS+" fortunatus";
    public static final String LEARNING_FUNGUS = CHALCIPORUS+" studens";
    public static final String KNOWLEDGE_FUNGUS = RUSSULA+" docta";

    // Magic branch
    public static final String CURING_FUNGUS = LACTARIUS+" curans";
    public static final String SKELETONS_FUNGUS = POLYPORUS+" exsceletro";
    public static final String LIFE_UP_FUNGUS = BOLETUS+" parcens";
}
