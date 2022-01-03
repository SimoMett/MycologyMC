package com.mettsmirnov.mycology.blocks;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public class ColoredFungusBlock extends MushroomBlock
{
    public ColoredFungusBlock()
    {
        super(BlockBehaviour.Properties.of(Material.PLANT),null);
    }
}
