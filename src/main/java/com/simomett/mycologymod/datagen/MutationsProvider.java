package com.simomett.mycologymod.datagen;

import com.google.gson.JsonObject;
import com.simomett.mycologymod.MycologyMod;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.server.packs.PackType;

import java.nio.file.Path;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static com.simomett.mycologymod.config.ModCommonConfigs.DEFAULT_MUTATION_CHANCE;
import static com.simomett.mycologymod.datagen.common.SpeciesDictionary.*;

public class MutationsProvider implements DataProvider
{
    private final DataGenerator generator;
    private final ArrayList<CompletableFuture<?>> list = new ArrayList<>();
    public MutationsProvider(DataGenerator dataGenerator)
    {
        this.generator = dataGenerator;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput)
    {
        /*
        *   Rule #1: Cross-breeding between Warped fungi can only generate Warped fungi.
        *               Cross-breeding between Crimson fungi can only generate Crimson fungi.
        */

        // Colors branch
        addMutation(AMANITA_MUSCARIA, CHALCIPORUS_PIPERATUS, AMANITA_RUBRA, cachedOutput);
        addMutation(AGARICUS_CAMPESTRIS, LECCINUM_VERSIPELLE, WHITE_FUNGUS, cachedOutput);
        addMutation(AGARICUS_CAMPESTRIS, BOLETUS_EDULIS, GREY_FUNGUS, cachedOutput);
        addMutation(WHITE_FUNGUS, LACTARIUS_VIRENS, LIME_FUNGUS, cachedOutput);
        addMutation(WHITE_FUNGUS, GREY_FUNGUS, LIGHTGREY_FUNGUS, cachedOutput);
        addMutation(WHITE_FUNGUS, BLACK_FUNGUS, GREY_FUNGUS, cachedOutput);
        addMutation(WHITE_FUNGUS, BLUE_FUNGUS, LIGHTBLUE_FUNGUS, cachedOutput);
        addMutation(WHITE_FUNGUS, AMANITA_RUBRA, PINK_FUNGUS, cachedOutput);
        addMutation(BLUE_FUNGUS, AMANITA_RUBRA, OVULUS_VIOLACEUS, cachedOutput);
        addMutation(BLUE_FUNGUS, LACTARIUS_VIRENS, CYAN_FUNGUS, cachedOutput);
        addMutation(OVULUS_VIOLACEUS, PINK_FUNGUS, MAGENTA_FUNGUS, cachedOutput);
        addMutation(AMANITA_RUBRA, YELLOW_FUNGUS, ORANGE_FUNGUS, cachedOutput);
        addMutation(POLYPORUS_LIGNEUS, AMANITA_MUSCARIA, BROWN_FUNGUS, cachedOutput);

        // Materials branch
        addMutation(BOLETUS_EDULIS, SUILLUS_GRANULATUS, POLYPORUS_LIGNEUS, .7f, cachedOutput);
        addMutation(POLYPORUS_LIGNEUS, AMANITA_PHALLOIDES, CLAY_FUNGUS, cachedOutput);
        addMutation(CHALCIPORUS_INFERNALIS, BOLBITIUS_PROFONDORUM, BASALT_FUNGUS ,cachedOutput);
        addMutation(BOLBITIUS_PROFONDORUM, HYGROPHORUS_NIVEUS, DIORITE_FUNGUS, cachedOutput);
        addMutation(BOLBITIUS_PROFONDORUM, DIORITE_FUNGUS, CALCITE_FUNGUS, cachedOutput);
        addMutation(AMANITA_PHALLOIDES, BONEBLOCK_FUNGUS, SLIME_FUNGUS, cachedOutput);

        // Minerals branch
        addMutation(BOLBITIUS_PROFONDORUM,POLYPORUS_LIGNEUS,COAL_FUNGUS, cachedOutput);
        addMutation(BOLBITIUS_PROFONDORUM,COAL_FUNGUS,XEROCOMUS_FERRUGINEUS, cachedOutput);
        addMutation(BOLBITIUS_PROFONDORUM, YELLOW_FUNGUS, AMANITA_CUPREA, cachedOutput);
        addMutation(XEROCOMUS_FERRUGINEUS, AMANITA_CUPREA, GALERINA_AURATA, cachedOutput);
        addMutation(AMANITA_CUPREA, BLAZE_FUNGUS, RUSSULA_CONCITATA, cachedOutput);
        addMutation(RUSSULA_CONCITATA, RUSSULA_LAZULA, AMETHYST_FUNGUS, cachedOutput);
        addMutation(AMETHYST_FUNGUS, CHALCIPORUS_INFERNALIS, BOLBITIUS_SILEX, cachedOutput);
        addMutation(LACTARIUS_PROLEFERENS, AMETHYST_FUNGUS, BUDDING_FUNGUS, cachedOutput);
        //addMutation(GALERINA_AURATA, POLYPORUS_ANTIQUUS, NETHERITE_FUNGUS, cachedOutput); // Removed due to non-conformity with the lore of netherite.
        addMutation(CALCITE_FUNGUS, CLAY_FUNGUS, RUSSULA_LAZULA, cachedOutput);
        addMutation(RUSSULA_LAZULA, AMANITA_CUPREA, EMERALD_FUNGUS, cachedOutput);
        addMutation(CALCITE_FUNGUS, COAL_FUNGUS, TUFF_FUNGUS, cachedOutput);
        addMutation(AGARICUS_ANIMI, CHALCIPORUS_INFERNALIS, BASALT_FUNGUS, cachedOutput);
        addMutation(BASALT_FUNGUS, TUFF_FUNGUS, DIAMOND_FUNGUS, cachedOutput);

        // Benefic branch
        addMutation(AGARICUS_CAMPESTRIS, SUILLUS_GRANULATUS, LACTARIUS_DELICIOUS, cachedOutput);
        addMutation(POLYPORUS_LIGNEUS, LACTARIUS_DELICIOUS, LACCARIA_DULCIS, cachedOutput);
        addMutation(BOLETUS_EDULIS, LACTARIUS_DELICIOUS, NOBLE_BOLETUS_SQUISITUS, cachedOutput);
        addMutation(NOBLE_BOLETUS_SQUISITUS, LACCARIA_DULCIS, BOLETUS_SALUBRIUM, cachedOutput);
        addMutation(CRYING_FUNGUS, BOLETUS_SALUBRIUM, STRENGTH_FUNGUS, cachedOutput);
        addMutation(LACCARIA_DULCIS, BLAZE_FUNGUS, SPEED_FUNGUS, cachedOutput);
        addMutation(BLACK_FUNGUS, LACTARIUS_DELICIOUS, CRATERELLUS_CORNUCOPIOIDES, cachedOutput);

        // Alcoholic branch
        addMutation(LACCARIA_DULCIS, LECCINUM_VERSIPELLE, FERMENTER_FUNGUS, cachedOutput);
        addMutation(FERMENTER_FUNGUS, BLAZE_FUNGUS, DRUNK_FUNGUS, cachedOutput);
        addMutation(DRUNK_FUNGUS, BLINDING_FUNGUS, TOXIC_METILIC_FUNGUS, cachedOutput);

        // Toxic branch
        addMutation(FERMENTER_FUNGUS, SPEED_FUNGUS, FATIGUE_FUNGUS, cachedOutput);

        // Psico branch
        addMutation(STRENGTH_FUNGUS, AMANITA_MUSCARIA, ANESTHETIC_FUNGUS, cachedOutput);
        addMutation(ANESTHETIC_FUNGUS, FERMENTER_FUNGUS, ILLUCINATING_FUNGUS, cachedOutput);
        addMutation(ILLUCINATING_FUNGUS, DRUNK_FUNGUS, HALLUCINATING_FUNGUS, cachedOutput);
        addMutation(BLINDING_FUNGUS, KNOWLEDGE_FUNGUS, SENSING_FUNGUS, cachedOutput);
        //addMutation(BLINDING_FUNGUS, "???", NIGHTLY_FUNGUS, cachedOutput);

        // Environmental branch
        addMutation(HYGROPHORUS_NIVEUS, NOBLE_BOLETUS_SQUISITUS, FREEZING_FUNGUS, cachedOutput);

        // Nether branch
        addMutation(CHALCIPORUS_INFERNALIS, AGARICUS_ANIMI, BLAZE_FUNGUS, cachedOutput);
        addMutation(AGARICUS_ANIMI, CHALCIPORUS_PIPERATUS, CRYING_FUNGUS, cachedOutput);
        addMutation(CRYING_FUNGUS, SKELETONS_FUNGUS, WITHERING_FUNGUS, cachedOutput);

        // End branch
        addMutation(TRICHOLOMOPSIS_EVANESCENS, BLAZE_FUNGUS, ENDER_EYE_FUNGUS, cachedOutput);
        addMutation(CHORUS_FUNGUS, END_FUNGUS, TRICHOLOMOPSIS_EVANESCENS, cachedOutput);
        addMutation(TRICHOLOMOPSIS_EVANESCENS, CHORUS_FUNGUS, RAPTING_FUNGUS, cachedOutput);
        addMutation(KNOWLEDGE_FUNGUS, RAPTING_FUNGUS, TELEPORTING_FUNGUS, cachedOutput);

        // Nature branch
        addMutation(BROWN_FUNGUS, CHORUS_FUNGUS, COCOA_FUNGUS, cachedOutput);
        addMutation(FERTILIZING_FUNGUS, CHORUS_FUNGUS, PLANTING_FUNGUS, cachedOutput);

        // Mutant branch
        addMutation(LACTARIUS_PROLEFERENS, FLOWERS_FUNGUS, DYEING_FUNGUS, cachedOutput);
        addMutation(LACTARIUS_PROLEFERENS, CRATERELLUS_CORNUCOPIOIDES, UNDEAD_FUNGUS, cachedOutput);

        // Energetic branch
        addMutation(BLAZE_FUNGUS, CHALCIPORUS_INFERNALIS, LIGHTNING_FUNGUS, cachedOutput);
        addMutation(LACTARIUS_PROLEFERENS, GLOWSTONE_FUNGUS, LIGHTNING_FUNGUS, cachedOutput);

        // Existential branch
        addMutation(EMERALD_FUNGUS, RUSSULA_LAZULA, EXPERIENCE_FUNGUS, cachedOutput);
        addMutation(BOLBITIUS_SILEX, DIAMOND_FUNGUS, LEARNING_FUNGUS, cachedOutput);
        addMutation(LEARNING_FUNGUS, EXPERIENCE_FUNGUS, KNOWLEDGE_FUNGUS, cachedOutput);
        addMutation(EXPERIENCE_FUNGUS, KNOWLEDGE_FUNGUS, GOODCHANCE_FUNGUS, cachedOutput); //very rare

        // Magic branch
        addMutation(UNDEAD_FUNGUS, KNOWLEDGE_FUNGUS, CURING_FUNGUS, cachedOutput);
        addMutation(BONEBLOCK_FUNGUS, UNDEAD_FUNGUS, SKELETONS_FUNGUS, cachedOutput);
        addMutation(BOLETUS_SALUBRIUM, CURING_FUNGUS, LIFE_UP_FUNGUS, cachedOutput);

        // Not yet identified branch
        addMutation(AGARICUS_CAMPESTRIS, POLYPORUS_LIGNEUS, BONEBLOCK_FUNGUS, cachedOutput);
        addMutation(BONEBLOCK_FUNGUS, AGARICUS_CAMPESTRIS, FERTILIZING_FUNGUS, cachedOutput);

        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    private void addMutation(String species1, String species2, String result, CachedOutput cache)
    {
        addMutation(species1, species2, result, DEFAULT_MUTATION_CHANCE, cache);
    }

    private void addMutation(String species1, String species2, String result, float chance, CachedOutput cache)
    {
        if(species1.equals("???") || species2.equals("???") || result.equals("???")) //TODO remove
            return;
        if (chance > 1f || chance <= 0f)
            throw new InvalidParameterException("Invalid 'chance' parameter");
        JsonObject mutationJson = new JsonObject();
        mutationJson.addProperty("species1", species1);
        mutationJson.addProperty("species2", species2);
        mutationJson.addProperty("result", result);
        mutationJson.addProperty("chance", chance);

        Path path = generator.getPackOutput().getOutputFolder();
        String jsonFileName = result.toLowerCase().replace(' ', '_')+".json";
        Path jsonLocation = path.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), MycologyMod.MODID, "mutations", jsonFileName));

        list.add(DataProvider.saveStable(cache, mutationJson, jsonLocation));
    }

    @Override
    public String getName() { return "Mutations"; }
}
