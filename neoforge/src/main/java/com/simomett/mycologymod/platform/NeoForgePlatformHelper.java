package com.simomett.mycologymod.platform;

import com.simomett.mycologymod.blocks.IRegisteredBlock;
import com.simomett.mycologymod.blocks.NeoForgeRegisteredBlock;
import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.config.NeoForgeCommonConfigs;
import com.simomett.mycologymod.datacomponents.IRegisteredDataComponentType;
import com.simomett.mycologymod.datacomponents.NeoForgeDataComponentType;
import com.simomett.mycologymod.effects.player.IRegisteredMobEffect;
import com.simomett.mycologymod.effects.player.NeoForgeMobEffect;
import com.simomett.mycologymod.effects.player.NeoForgeModEffects;
import com.simomett.mycologymod.entities.IBlockEntityConstructor;
import com.simomett.mycologymod.entities.IRegisteredBlockEntityType;
import com.simomett.mycologymod.entities.NeoForgeRegisteredBlockEntityType;
import com.simomett.mycologymod.items.IRegisteredItem;
import com.simomett.mycologymod.items.NeoForgeRegisteredItem;
import com.simomett.mycologymod.items.potions.NeoForgePotions;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import com.simomett.mycologymod.world.IRegisteredFeature;
import com.simomett.mycologymod.world.features.NeoForgeFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.effect.MobEffect;
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
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static com.simomett.mycologymod.blocks.NeoForgeRegisteredBlock.BLOCKS;
import static com.simomett.mycologymod.datacomponents.NeoForgeDataComponents.DATA_COMPONENTS;
import static com.simomett.mycologymod.entities.NeoForgeBlockEntities.ENTITIES;
import static com.simomett.mycologymod.items.ModItems.ITEMS;
import static com.simomett.mycologymod.recipes.ModRecipes.RECIPE_SERIALIZERS;
import static com.simomett.mycologymod.world.features.NeoForgeFeatures.FEATURES;

public class NeoForgePlatformHelper implements IPlatformHelper
{
    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public <T extends Item> IRegisteredItem<T> registerItem(String name, Function<Item.Properties, Item> factory)
    {
        return new NeoForgeRegisteredItem(ITEMS.registerItem(name, factory));
    }

    @Override
    public <T extends Block> IRegisteredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, Block> factory)
    {
        return new NeoForgeRegisteredBlock<>(BLOCKS.registerBlock(name, factory));
    }

    @Override
    public <T extends MobEffect> IRegisteredMobEffect<T> registerMobEffect(String name, Supplier<T> mobEffectSupplier)
    {
        return new NeoForgeMobEffect<>(NeoForgeModEffects.EFFECTS.register(name, mobEffectSupplier));
    }

    @Override
    public Holder<Potion> registerPotion(String name, Supplier<Potion> potionSupplier)
    {
        return NeoForgePotions.POTIONS.register(name, potionSupplier);
    }

    @Override
    public IModCommonConfigs getCommonConfigs()
    {
        return NeoForgeCommonConfigs.INSTANCE;
    }

    @Override
    public <T> IRegisteredDataComponentType<T> registerDataComponentType(String name, UnaryOperator<DataComponentType.Builder<T>> builder)
    {
        return new NeoForgeDataComponentType<>(DATA_COMPONENTS.registerComponentType(name, builder));
    }

    @Override
    public <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String recipeSerializerName, Supplier<T> supplier)
    {
        return RECIPE_SERIALIZERS.register(recipeSerializerName, supplier);
    }

    @Override
    public <T extends BlockEntity> IRegisteredBlockEntityType<T> registerBlockEntityType(String name, IBlockEntityConstructor<BlockPos, BlockState, T> factory, IRegisteredBlock<?>... blocks)
    {
        DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> tt =
            ENTITIES.register(name, ()-> new BlockEntityType<>(
                    factory::apply,
                    Arrays.stream(blocks).map(IRegisteredBlock::get).collect(Collectors.toSet())
            ));
        return new NeoForgeRegisteredBlockEntityType<>(tt);
    }

    @Override
    public MenuType<? extends AbstractContainerMenu> registerMenu(String name, MenuSupplier<? extends AbstractContainerMenu> menuSupplier)
    {
        return null;//MENU_TYPES.register(name, menuSupplier).get();
    }

    @Override
    public <T extends Feature<?>> IRegisteredFeature<T> registerFeature(String name, Supplier<T> supplier, Dimension d, GenerationStep.Decoration genStepDecoration)
    {
        return new NeoForgeFeature<>(FEATURES.register(name, supplier));
    }
}
