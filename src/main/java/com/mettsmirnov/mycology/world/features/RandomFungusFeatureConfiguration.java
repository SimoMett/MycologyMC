package com.mettsmirnov.mycology.world.features;

import com.mettsmirnov.mycology.blocks.ModBlocks;
import com.mettsmirnov.mycology.data.FungusSpeciesList;
import com.mettsmirnov.mycology.entities.ColoredFungusBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import org.jline.utils.Log;

import java.util.List;
import java.util.Random;

public class RandomFungusFeatureConfiguration extends Feature<SimpleBlockConfiguration>
{
    //FIXME command "/place feature" doesn't work
    public RandomFungusFeatureConfiguration()
    {
        super(SimpleBlockConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> placeContext)
    {
        List<FungusSpeciesList.FungusSpecies> speciesList = FungusSpeciesList.INSTANCE.getSpeciesList();
        BlockPos origin = placeContext.origin();
        String biomeName = placeContext.level().registryAccess().registryOrThrow(Registries.BIOME).getKey(placeContext.level().getBiome(origin).get()).toString();
        speciesList = speciesList.stream().filter(s -> s.spawnType != null && s.spawnType.biomes.contains(biomeName)).toList();
        if(!speciesList.isEmpty())
        {
            float biomeTemp = placeContext.level().getBiome(origin).get().getModifiedClimateSettings().temperature();
            float biomeDownfall = placeContext.level().getBiome(origin).get().getModifiedClimateSettings().downfall();

            //get random species
            Random random = new Random();
            FungusSpeciesList.FungusSpecies randomSpecies = speciesList.get(random.nextInt(speciesList.size()));

            if (random.nextFloat(0f, 1f) < randomSpecies.spawnType.chance)
            {
                //spawn fungus with the correct type
                if (randomSpecies.fungusType.equals(ModBlocks.COLORED_CRIMSON_STRING))
                    placeContext.level().setBlock(origin, ModBlocks.COLORED_CRIMSON_FUNGUS.get().defaultBlockState(), 0); //WTF is the third parameter??
                else
                    placeContext.level().setBlock(origin, ModBlocks.COLORED_WARPED_FUNGUS.get().defaultBlockState(), 0);

                //edit its block entity
                BlockEntity blockEntity = placeContext.level().getBlockEntity(origin);
                if (blockEntity instanceof ColoredFungusBlockEntity coloredFungusBlockEntity) {
                    coloredFungusBlockEntity.getFungusData().loadFrom(randomSpecies);
                } else {
                    Log.error("WHY THIS BLOCKENTITY ISN'T A COLORED FUNGUS?");
                    return false;
                }
            }
            return true;
        }
        else
            return false;
    }
}
