package com.mettsmirnov.mycology.world.features;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.blocks.ModBlocks;
import com.mettsmirnov.mycology.world.features.configs.MyTestFeatureConfiguration;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModFeatures
{
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MycologyMod.MODID);
    //public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY,MycologyMod.MODID);

    //public static final RegistryObject<Feature<SimpleBlockConfiguration>> MUSHROOMS = FEATURES.register("mycology_mushrooms",() -> new RandomFungusFeature(SimpleBlockConfiguration.CODEC));
    //public static final RegistryObject<ConfiguredFeature<?,?>> CONFIGURED_MUSHROOMS = CONFIGURED_FEATURES.register("patch_mushrooms", TestConfiguredFeature::new);

    //public static final RegistryObject<ConfiguredFeature<RandomPatchConfiguration, ?>> TEST_FEAT = CONFIGURED_FEATURES.register("test_feature", );
    /*public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TEST_FEAT =
            FeatureUtils.register("test_feat", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.COLORED_CRIMSON_FUNGUS.get())))));

    public static final Holder<PlacedFeature> PLACED_TEST_FEAT = PlacementUtils.register("test_placed",
            TEST_FEAT, RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP);
*/
}
