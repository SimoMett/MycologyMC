package com.simomett.mycologymod.world.features;

import com.simomett.mycologymod.blocks.ModBlocks;
import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.datagen.common.FungusSpawn;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.genetics.FungusGenoma;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

import java.util.List;
import java.util.Random;

import static com.simomett.mycologymod.utils.Utils.parseStringOrTag;

public class UndergroundFungusFeatureConfiguration extends Feature<SimpleBlockConfiguration>
{

    public UndergroundFungusFeatureConfiguration()
    {
        super(SimpleBlockConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> placeContext)
    {
        BlockPos origin = placeContext.origin();
        WorldGenLevel level = placeContext.level();

        List<FungusSpeciesList.FungusSpecies> speciesList = FungusSpeciesList.INSTANCE.getSpeciesList();
        speciesList = speciesList.stream().filter(s -> s.spawnInfo != null && s.spawnInfo.equals(FungusSpawn.CAVES)).toList();
        if(!speciesList.isEmpty())
        {
            //get random species
            Random random = new Random();
            FungusSpeciesList.FungusSpecies randomSpecies = speciesList.get(random.nextInt(speciesList.size()));

            if (random.nextFloat(0f, 1f) < randomSpecies.spawnInfo.chance)
            {
                //spawn fungus with the correct type
                BlockState terrainBlockState = level.getBlockState(origin);
                String terrain = randomSpecies.defaultTraits.terrain();

                ResourceLocation res = parseStringOrTag(terrain);
                boolean blockMatchesTerrain = terrainBlockState.is(ResourceKey.create(Registries.BLOCK, res)) || terrainBlockState.is(BlockTags.create(res));

                if(blockMatchesTerrain && level.getBlockState(origin.above()).isAir())
                {
                    BlockPos pos = origin.above();
                    BlockState blockState = ModBlocks.getDefaultBlockStateFromFungusType(randomSpecies.fungusType);
                    level.setBlock(pos, blockState, 0);

                    //edit its block entity
                    ColoredFungusBlockEntity blockEntity = (ColoredFungusBlockEntity) level.getBlockEntity(pos);
                    blockEntity.applyGenoma(new FungusGenoma(randomSpecies));
                }
            }
            return true;
        }
        else
            return false;
    }
}
