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
        *   Everything starts from the natives species:
        */
        //  Overworld
        final String AGARICUS_CAMPESTRIS = "Agaricus campestris";       //(plains)
        final String LACTARIUS_VIRIDIS = "Lactarius viridis";           //(sunflower plains)
        final String LECCINUM_VERSIPELLE = "Leccinum versipelle";       //(birch forest)
        final String BOLETUS_EDULIS = "Boletus edulis";                 //(forest)
        final String SUILLUS_GRANULATUS = "Suillus granulatus";         //(old growth pine taiga)
        final String CHALCIPORUS_PIPERATUS = "Chalciporus piperatus";   //(old growth spruce taiga)
        final String AMANITA_MUSCARIA = "Amanita muscaria";             //(jungle)
        final String YELLOW_FUNGUS = "YELLOW_FUNGUS";                   //(meadow)
        final String BLUE_FUNGUS = "BLUE_FUNGUS";                       //(flower forest)
        final String LACTARIUS_PROLEFERENS = "Lactarius proleferens";   //(mushroom fields)
        final String HYGROPHORUS_NIVEUS = "Hygrophorus niveus";         //(snowy taiga)

        // Nether
        final String AGARICUS_ANIMI = "Agaricus animi";
        final String CHALCIPORUS_INFERNALIS = "Chalciporus infernalis";
        /*
        *   Rule #1: Cross-breeding between Warped fungi can only generate Warped fungi.
        *               Cross-breeding between Crimson fungi can only generate Crimson fungi.
        */

        // Colors branch
        final String AMANITA_RUBRA = "Amanita rubra";
        final String WHITE_FUNGUS = "WHITE_FUNGUS";
        final String GREY_FUNGUS = "GREY_FUNGUS";
        final String LIME_FUNGUS = "LIME_FUNGUS";
        final String LIGHTGREY_FUNGUS = "LIGHTGREY_FUNGUS";
        final String BLACK_FUNGUS = "BLACK_FUNGUS";
        final String LIGHTBLUE_FUNGUS = "LIGHTBLUE_FUNGUS";
        final String PINK_FUNGUS = "PINK_FUNGUS";
        final String OVULUS_VIOLACEUS = "Ovulus violaceus";
        final String CYAN_FUNGUS = "CYAN_FUNGUS";
        final String MAGENTA_FUNGUS = "MAGENTA_FUNGUS";
        final String ORANGE_FUNGUS = "ORANGE_FUNGUS";
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
        final String POLYPORUS_LIGNEUS = "Polyporus ligneus";
        addMutation(BOLETUS_EDULIS, SUILLUS_GRANULATUS, POLYPORUS_LIGNEUS, cachedOutput);

        // Minerals branch
        final String BOLBITIUS_PROFONDORUM = "Bolbitius profundorum";
        final String COAL_FUNGUS = "COAL_FUNGUS";
        final String XEROCOMUS_FERRUGINEUS = "Xerocomus ferrugineus";
        final String DIORITE_FUNGUS = "DIORITE_FUNGUS";
        final String CALCITE_FUNGUS = "CALCITE_FUNGUS";
        final String AMETHYST_FUNGUS = "AMETHYST_FUNGUS";
        final String RUSSULA_LAZULA = "Russula lazula";
        addMutation(BOLBITIUS_PROFONDORUM,POLYPORUS_LIGNEUS,COAL_FUNGUS, cachedOutput);
        addMutation(BOLBITIUS_PROFONDORUM,COAL_FUNGUS,XEROCOMUS_FERRUGINEUS, cachedOutput);
        addMutation(BOLBITIUS_PROFONDORUM, HYGROPHORUS_NIVEUS, DIORITE_FUNGUS, cachedOutput);
        addMutation(BOLBITIUS_PROFONDORUM, DIORITE_FUNGUS, CALCITE_FUNGUS, cachedOutput);
        addMutation("Russula concitata", RUSSULA_LAZULA, AMETHYST_FUNGUS, cachedOutput);
        addMutation(AMETHYST_FUNGUS, CHALCIPORUS_INFERNALIS, "Bolbitius silex", cachedOutput);
        addMutation("Galerina aurata", "Polyporus antiquus", "NETHERITE_FUNGUS", cachedOutput);
        addMutation(CALCITE_FUNGUS, "CLAY_FUNGUS", RUSSULA_LAZULA, cachedOutput);
        addMutation(RUSSULA_LAZULA, "Amanita cuprea", "EMERALD_FUNGUS", cachedOutput);

        // Benefic branch
        final String LACTARIUS_DELICIOUS = "Lactarius deliciosus";
        final String LACCARIA_DULCIS = "Laccaria dulcis";
        final String NOBLE_BOLETUS_SQUISITUS = "Noble boletus squisitus";
        addMutation(AGARICUS_CAMPESTRIS, SUILLUS_GRANULATUS, LACTARIUS_DELICIOUS, cachedOutput);
        addMutation(POLYPORUS_LIGNEUS, LACTARIUS_DELICIOUS, LACCARIA_DULCIS, cachedOutput);
        addMutation(BOLETUS_EDULIS, LACTARIUS_DELICIOUS, NOBLE_BOLETUS_SQUISITUS, cachedOutput);

        // Environmental branch
        final String FREEZING_FUNGUS = "FREEZING_FUNGUS";
        addMutation(HYGROPHORUS_NIVEUS, NOBLE_BOLETUS_SQUISITUS, FREEZING_FUNGUS, cachedOutput);

        //TODO possible mutations
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
