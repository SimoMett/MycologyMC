package com.simomett.mycologymod.world;

import com.simomett.mycologymod.world.features.OverworldFungusFeature;
import com.simomett.mycologymod.world.features.UndergroundFungusFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.simomett.mycologymod.Constants.MOD_ID;

public class FeaturesDefinitions
{
    enum Dimension
    {
        OVERWORLD,
        NETHER,
        END
    }

    private static <T extends Feature<?>> IRegisteredFeature<T> registerFeatureConfig(String name, Supplier<T> supplier, Dimension dimension, GenerationStep.Decoration genStepDecoration)
    {
        Identifier resLoc = Identifier.fromNamespaceAndPath(MOD_ID, name);
        var tt = Registry.register(BuiltInRegistries.FEATURE,
                resLoc,
                supplier.get());

        Predicate<BiomeSelectionContext> biomeSelector;

        switch (dimension)
        {
            case OVERWORLD -> biomeSelector = BiomeSelectors.foundInOverworld();
            case NETHER -> biomeSelector = BiomeSelectors.foundInTheNether();
            case END -> biomeSelector = BiomeSelectors.foundInTheEnd();
            default -> biomeSelector = BiomeSelectors.all();
        }

        BiomeModifications.addFeature(
                biomeSelector,
                genStepDecoration,
                ResourceKey.create(Registries.PLACED_FEATURE, resLoc)
        );
        return new FabricFeature<>(tt);
    }

    public static final IRegisteredFeature<OreFeature> ORE_CHROMIUM_SMALL = registerFeatureConfig("ore_chromium_small", () -> new OreFeature(OreConfiguration.CODEC), Dimension.OVERWORLD, GenerationStep.Decoration.UNDERGROUND_ORES);
    public static final IRegisteredFeature<OverworldFungusFeature> SURFACE_FUNGUS = registerFeatureConfig("surface_fungus", OverworldFungusFeature::new, Dimension.OVERWORLD, GenerationStep.Decoration.VEGETAL_DECORATION);
    public static final IRegisteredFeature<UndergroundFungusFeature> UNDERGROUND_FUNGUS = registerFeatureConfig("underground_fungus", UndergroundFungusFeature::new, Dimension.OVERWORLD, GenerationStep.Decoration.VEGETAL_DECORATION);

    public static void init(){}
}
