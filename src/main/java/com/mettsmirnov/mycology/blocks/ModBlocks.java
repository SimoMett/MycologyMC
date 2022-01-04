package com.mettsmirnov.mycology.blocks;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MycologyMod.MODID);

    public static final RegistryObject<Block> COLORED_CRIMSON_FUNGUS = BLOCKS.register("colored_crimson_fungus",ColoredFungusBlock::new);
    public static final RegistryObject<Block> COLORED_WARPED_FUNGUS = BLOCKS.register("colored_warped_fungus",ColoredFungusBlock::new);
}
