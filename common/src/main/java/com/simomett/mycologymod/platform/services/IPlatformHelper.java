package com.simomett.mycologymod.platform.services;

import com.simomett.mycologymod.blocks.IRegisteredBlock;
import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.entities.IBlockEntityConstructor;
import com.simomett.mycologymod.entities.IRegisteredBlockEntityType;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.items.IRegisteredItem;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Function;
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

    // Mod specific stuff
    <T extends Item> IRegisteredItem<T> registerItem(String name, Function<Item.Properties, Item> factory);
    <T extends Block> IRegisteredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, Block> factory);
    Holder<MobEffect> registerMobEffect(String name, Supplier<MobEffect> mobEffectSupplier);
    Holder<Potion> registerPotion(String name, Supplier<Potion> potionSupplier);

    IModCommonConfigs getCommonConfigs();

    DataComponentType<FungusGenoma> registerDataComponentType();

    <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String recipeSerializerName, Supplier<T> supplier);

    //<T extends BlockEntity> BlockEntityType<T> registerBlockEntityType(String name, Supplier<T> supplier, Block... blocks);
    <T extends BlockEntity> IRegisteredBlockEntityType<T> registerBlockEntityType(String name, IBlockEntityConstructor<BlockPos, BlockState, T> factory, Block... blocks);

    interface MenuSupplier<T extends AbstractContainerMenu> {
        T create(int var1, Inventory var2);
    }
    MenuType<? extends AbstractContainerMenu> registerMenu(String name, MenuSupplier<? extends AbstractContainerMenu> menuSupplier);
}
