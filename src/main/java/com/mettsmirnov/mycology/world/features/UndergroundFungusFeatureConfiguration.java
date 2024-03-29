package com.mettsmirnov.mycology.world.features;

import com.mettsmirnov.mycology.blocks.ModBlocks;
import com.mettsmirnov.mycology.data.FungusSpeciesList;
import com.mettsmirnov.mycology.datagen.common.FungusSpawn;
import com.mettsmirnov.mycology.entities.ColoredFungusBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraftforge.registries.ForgeRegistries;
import org.jline.utils.Log;

import java.util.List;
import java.util.Random;

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

                ResourceLocation res = new ResourceLocation(randomSpecies.defaultTraits.terrain);
                TagKey<Block> tag = BlockTags.create(res);

                if( (terrainBlockState.is(tag) || terrainBlockState.is(ForgeRegistries.BLOCKS.getValue(res)) ) && level.getBlockState(origin.above()).isAir())
                {
                    BlockPos pos = origin.above();
                    BlockState blockState = ModBlocks.getDefaultBlockStateFromFungusType(randomSpecies.fungusType);
                    level.setBlock(pos, blockState, 0);

                    //edit its block entity
                    BlockEntity blockEntity = level.getBlockEntity(pos);
                    if (blockEntity instanceof ColoredFungusBlockEntity coloredFungusBlockEntity) {
                        coloredFungusBlockEntity.getFungusData().loadFrom(randomSpecies);
                    } else {
                        Log.error("WHY THIS BLOCKENTITY ISN'T A COLORED FUNGUS?");
                        return false;
                    }
                }
            }
            return true;
        }
        else
            return false;
    }
}
