package com.mettsmirnov.mycology.world.features;

import com.mettsmirnov.mycology.blocks.ModBlocks;
import com.mettsmirnov.mycology.data.FungusSpeciesList;
import com.mettsmirnov.mycology.entities.ColoredFungusBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import org.jline.utils.Log;

import java.util.List;
import java.util.Random;

public class SurfaceFungusFeatureConfiguration extends Feature<SimpleBlockConfiguration>
{
    //command "/place feature" doesn't work (I don't care)
    public SurfaceFungusFeatureConfiguration()
    {
        super(SimpleBlockConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> placeContext)
    {
        List<FungusSpeciesList.FungusSpecies> speciesList = FungusSpeciesList.INSTANCE.getSpeciesList();
        BlockPos origin = placeContext.origin();
        String biomeName = placeContext.level().registryAccess().registryOrThrow(Registries.BIOME).getKey(placeContext.level().getBiome(origin).get()).toString();
        speciesList = speciesList.stream().filter(s -> s.spawnInfo != null && s.spawnInfo.biomes.contains(biomeName)).toList();
        if(!speciesList.isEmpty())
        {
            float biomeTemp = placeContext.level().getBiome(origin).get().getModifiedClimateSettings().temperature();
            float biomeDownfall = placeContext.level().getBiome(origin).get().getModifiedClimateSettings().downfall();

            //get random species
            Random random = new Random();
            FungusSpeciesList.FungusSpecies randomSpecies = speciesList.get(random.nextInt(speciesList.size()));

            if (random.nextFloat(0f, 1f) < randomSpecies.spawnInfo.chance)
            {
                //spawn fungus with the correct type
                BlockState blockState = ModBlocks.getDefaultBlockStateFromFungusType(randomSpecies.fungusType);
                placeContext.level().setBlock(origin, blockState, 0); //WTF is the third parameter??

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
