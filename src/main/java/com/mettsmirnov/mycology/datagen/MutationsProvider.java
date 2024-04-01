package com.mettsmirnov.mycology.datagen;

import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.server.packs.PackType;

import java.nio.file.Path;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static com.mettsmirnov.mycology.constants.Constants.DEFAULT_MUTATION_CHANCE;
import static com.mettsmirnov.mycology.datagen.SpeciesDictionary.*;

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
        addMutation(WHITE_FUNGUS, LACTARIUS_VIRIDIS, LIME_FUNGUS, cachedOutput);
        addMutation(WHITE_FUNGUS, GREY_FUNGUS, LIGHTGREY_FUNGUS, cachedOutput);
        addMutation(WHITE_FUNGUS, BLACK_FUNGUS, GREY_FUNGUS, cachedOutput);
        addMutation(WHITE_FUNGUS, BLUE_FUNGUS, LIGHTBLUE_FUNGUS, cachedOutput);
        addMutation(WHITE_FUNGUS, AMANITA_RUBRA, PINK_FUNGUS, cachedOutput);
        addMutation(BLUE_FUNGUS, AMANITA_RUBRA, OVULUS_VIOLACEUS, cachedOutput);
        addMutation(BLUE_FUNGUS, LACTARIUS_VIRIDIS, CYAN_FUNGUS, cachedOutput);
        addMutation(OVULUS_VIOLACEUS, PINK_FUNGUS, MAGENTA_FUNGUS, cachedOutput);
        addMutation(AMANITA_RUBRA, YELLOW_FUNGUS, ORANGE_FUNGUS, cachedOutput);

        // Materials branch
        addMutation(BOLETUS_EDULIS, SUILLUS_GRANULATUS, POLYPORUS_LIGNEUS, cachedOutput);
        addMutation(POLYPORUS_LIGNEUS, AMANITA_PHALLOIDES, CLAY_FUNGUS, cachedOutput);
        addMutation(CHALCIPORUS_INFERNALIS, AGARICUS_ANIMI, BASALT_FUNGUS ,cachedOutput);
        addMutation(BOLBITIUS_PROFONDORUM, HYGROPHORUS_NIVEUS, DIORITE_FUNGUS, cachedOutput);
        addMutation(BOLBITIUS_PROFONDORUM, DIORITE_FUNGUS, CALCITE_FUNGUS, cachedOutput);

        // Minerals branch
        addMutation(BOLBITIUS_PROFONDORUM,POLYPORUS_LIGNEUS,COAL_FUNGUS, cachedOutput);
        addMutation(BOLBITIUS_PROFONDORUM,COAL_FUNGUS,XEROCOMUS_FERRUGINEUS, cachedOutput);
        addMutation(BOLBITIUS_PROFONDORUM, YELLOW_FUNGUS, AMANITA_CUPREA, cachedOutput);
        addMutation(XEROCOMUS_FERRUGINEUS, AMANITA_CUPREA, GALERINA_AURATA, cachedOutput);
        addMutation(RUSSULA_CONCITATA, RUSSULA_LAZULA, AMETHYST_FUNGUS, cachedOutput);
        addMutation(AMETHYST_FUNGUS, CHALCIPORUS_INFERNALIS, BOLBITIUS_SILEX, cachedOutput);
        addMutation(GALERINA_AURATA, "Polyporus antiquus", "NETHERITE_FUNGUS", cachedOutput);
        addMutation(CALCITE_FUNGUS, CLAY_FUNGUS, RUSSULA_LAZULA, cachedOutput);
        addMutation(RUSSULA_LAZULA, AMANITA_CUPREA, "EMERALD_FUNGUS", cachedOutput);
        addMutation(CALCITE_FUNGUS, COAL_FUNGUS, TUFF_FUNGUS, cachedOutput);
        addMutation(BASALT_FUNGUS, TUFF_FUNGUS, DIAMOND_FUNGUS, cachedOutput);

        // Benefic branch
        addMutation(AGARICUS_CAMPESTRIS, SUILLUS_GRANULATUS, LACTARIUS_DELICIOUS, cachedOutput);
        addMutation(POLYPORUS_LIGNEUS, LACTARIUS_DELICIOUS, LACCARIA_DULCIS, cachedOutput);
        addMutation(BOLETUS_EDULIS, LACTARIUS_DELICIOUS, NOBLE_BOLETUS_SQUISITUS, cachedOutput);

        // Environmental branch
        addMutation(HYGROPHORUS_NIVEUS, NOBLE_BOLETUS_SQUISITUS, FREEZING_FUNGUS, cachedOutput);

        //TODO possible mutations
        addMutation(NOBLE_BOLETUS_SQUISITUS, "???", BOLETUS_SALUBRIUM, cachedOutput);
        addMutation("BONEBLOCK_SUSTAINED_FUNGUS", "???", "FERTILIZING_EFFECT_FUNGUS", cachedOutput);

        addMutation("???", RUSSULA_LAZULA, "EXPERIENCE_FUNGUS", cachedOutput);
        addMutation(AGARICUS_ANIMI, CHALCIPORUS_INFERNALIS, "???", cachedOutput);
        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }

    private void addMutation(String species1, String species2, String result, CachedOutput cache)
    {
        addMutation2(species1, species2, result, DEFAULT_MUTATION_CHANCE, cache);
    }

    private void addMutation2(String species1, String species2, String result, float chance, CachedOutput cache)
    {
        if(species1.equals("???") || species2.equals("???") || result.equals("???"))
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
