package com.mettsmirnov.mycology.blocks;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MycologyMod.MODID);

    public static final String COLORED_CRIMSON_STRING = "colored_crimson_fungus";
    public static final String COLORED_WARPED_STRING = "colored_warped_fungus";
    public static final RegistryObject<Block> COLORED_CRIMSON_FUNGUS = BLOCKS.register(COLORED_CRIMSON_STRING,ColoredFungusBlock::new);
    public static final RegistryObject<Block> COLORED_WARPED_FUNGUS = BLOCKS.register(COLORED_WARPED_STRING,ColoredFungusBlock::new);
}
