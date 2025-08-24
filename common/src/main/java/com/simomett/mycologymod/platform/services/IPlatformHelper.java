package com.simomett.mycologymod.platform.services;

import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.genetics.FungusGenoma;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public interface IPlatformHelper {

    /**
     * Gets the name of the current platform
     *
     * @return The name of the current platform.
     */
    String getPlatformName();

    /**
     * Checks if a mod with the given id is loaded.
     *
     * @param modId The mod to check if it is loaded.
     * @return True if the mod is loaded, false otherwise.
     */
    boolean isModLoaded(String modId);

    /**
     * Check if the game is currently in a development environment.
     *
     * @return True if in a development environment, false otherwise.
     */
    boolean isDevelopmentEnvironment();

    /**
     * Gets the name of the environment type as a string.
     *
     * @return The name of the environment type.
     */
    default String getEnvironmentName() {
        return isDevelopmentEnvironment() ? "development" : "production";
    }

    // Mod specific stuff
    <T extends Item> T registerItem(String name, Supplier<T> supplier);
    <T extends Block> T registerBlock(String name, Supplier<T> supplier);
    Holder<MobEffect> registerMobEffect(String name, Supplier<MobEffect> mobEffectSupplier);
    Holder<Potion> registerPotion(String name, Supplier<Potion> potionSupplier);

    IModCommonConfigs getCommonConfigs();

    Supplier<DataComponentType<FungusGenoma>> registerDataComponentType();

    <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String recipeSerializerName, Supplier<T> supplier);



    interface BlockEntitySupplier<T extends BlockEntity> {
        T create(BlockPos blockPos, BlockState blockState);
    }
    BlockEntityType<? extends BlockEntity> registerBlockEntityType(String name, BlockEntitySupplier<? extends BlockEntity> supplier, Block... blocks);

    interface MenuSupplier<T extends AbstractContainerMenu> {
        T create(int var1, Inventory var2);
    }
    MenuType<? extends AbstractContainerMenu> registerMenu(String name, MenuSupplier<? extends AbstractContainerMenu> menuSupplier);
}
