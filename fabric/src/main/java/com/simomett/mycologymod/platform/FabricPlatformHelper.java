package com.simomett.mycologymod.platform;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.blocks.FabricRegisteredBlock;
import com.simomett.mycologymod.blocks.IRegisteredBlock;
import com.simomett.mycologymod.config.FabricClientConfigs;
import com.simomett.mycologymod.config.FabricCommonConfigs;
import com.simomett.mycologymod.config.IModClientConfigs;
import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.datacomponents.FabricDataComponent;
import com.simomett.mycologymod.datacomponents.IRegisteredDataComponentType;
import com.simomett.mycologymod.effects.player.FabricMobEffect;
import com.simomett.mycologymod.effects.player.IRegisteredMobEffect;
import com.simomett.mycologymod.entities.FabricRegisteredBlockEntityType;
import com.simomett.mycologymod.entities.IBlockEntityConstructor;
import com.simomett.mycologymod.entities.IRegisteredBlockEntityType;
import com.simomett.mycologymod.genetics.IBiomeDownfallProvider;
import com.simomett.mycologymod.items.IRegisteredItem;
import com.simomett.mycologymod.items.FabricRegisteredItem;
import com.simomett.mycologymod.particles.FabricParticleType;
import com.simomett.mycologymod.particles.IRegisteredParticleType;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import com.simomett.mycologymod.world.FabricFeature;
import com.simomett.mycologymod.world.IBiomeDownfallGetter;
import com.simomett.mycologymod.world.IRegisteredFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static com.simomett.mycologymod.Constants.MOD_ID;

public class FabricPlatformHelper implements IPlatformHelper
{
    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public <T extends Item> IRegisteredItem<T> registerItem(String name, Function<Item.Properties, Item> factory)
    {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));

        Item item = factory.apply(new Item.Properties());

        return new FabricRegisteredItem(Registry.register(BuiltInRegistries.ITEM, key, item));
    }

    @Override
    public <T extends Block> IRegisteredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> factory)
    {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, name));
        Function<BlockBehaviour.Properties, Block> castFactory = factory::apply;
        return new FabricRegisteredBlock(
                Blocks.register(key, castFactory, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    }

    @Override
    public StairBlock createStairBlock(BlockState baseState, BlockBehaviour.Properties properties)
    {
        return new StairBlock(baseState, properties);
    }

    @Override
    public <T extends MobEffect> IRegisteredMobEffect<T> registerMobEffect(String name, Supplier<T> mobEffectSupplier)
    {
        ResourceKey<MobEffect> key = ResourceKey.create(Registries.MOB_EFFECT, Identifier.fromNamespaceAndPath(MOD_ID, name));
        return new FabricMobEffect<>(Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, key, mobEffectSupplier.get()));
    }

    @Override
    public Holder<Potion> registerPotion(String name, Supplier<Potion> potionSupplier)
    {
        return BuiltInRegistries.POTION.wrapAsHolder(Registry.register(BuiltInRegistries.POTION, name, potionSupplier.get()));
    }

    @Override
    public IModCommonConfigs getCommonConfigs()
    {
        // TODO
        return new FabricCommonConfigs();
    }

    @Override
    public IModClientConfigs getClientConfigs()
    {
        // TODO
        return new FabricClientConfigs();
    }

    @Override
    public <T> IRegisteredDataComponentType<T> registerDataComponentType(String name, UnaryOperator<DataComponentType.Builder<T>> builder)
    {
        DataComponentType<T> dataComponentType = Registry.register(
                BuiltInRegistries.DATA_COMPONENT_TYPE,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, name),
                builder.apply(DataComponentType.builder()).build()
        );

        return new FabricDataComponent<>(dataComponentType);
    }

    @Override
    public <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String recipeSerializerName, Supplier<T> supplier)
    {
        var tt = Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, recipeSerializerName),
                supplier.get());

        return () -> tt;
    }

    @Override
    public <T extends BlockEntity> IRegisteredBlockEntityType<T> registerBlockEntityType(String name, IBlockEntityConstructor<BlockPos, BlockState, T> factory, IRegisteredBlock<?>... blocks)
    {
        // Junk to avoid cast-related crash
        Set<Block> bb = Arrays.stream(blocks).map(IRegisteredBlock::get).collect(Collectors.toSet());
        Block [] actualBlocks = new Block[bb.size()];
        bb.toArray(actualBlocks);
        //

        BlockEntityType<T> blockEntityType = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, name),
                FabricBlockEntityTypeBuilder.create(
                        factory::apply,
                        actualBlocks
                ).build());

        return new FabricRegisteredBlockEntityType<>(blockEntityType);
    }

    @Override
    public IRegisteredParticleType registerSimpleParticleType(String name)
    {
        IRegisteredParticleType tt = new FabricParticleType();
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MOD_ID, name), tt.particleType());
        return tt;
    }

    @Override
    public MenuType<? extends AbstractContainerMenu> registerMenu(String name, MenuSupplier<? extends AbstractContainerMenu> menuSupplier) {
        return Registry.register(BuiltInRegistries.MENU,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, name),
                new MenuType<>(menuSupplier::create, FeatureFlags.DEFAULT_FLAGS)
        );
    }

    @Override
    public <T extends Feature<?>> IRegisteredFeature<T> registerFeatureConfig(String name, Supplier<T> supplier, Dimension dimension, GenerationStep.Decoration genStepDecoration)
    {
        Identifier resLoc = Identifier.fromNamespaceAndPath(MOD_ID, name);
        var tt = Registry.register(BuiltInRegistries.FEATURE,
                resLoc,
                supplier.get());

        Predicate<BiomeSelectionContext> biomeSelector;

        switch (dimension)
        {
            case OVERWORLD -> biomeSelector = BiomeSelectors.foundInOverworld();
            case NETHER -> biomeSelector = BiomeSelectors.foundInTheNether();
            case END -> biomeSelector = BiomeSelectors.foundInTheEnd();
            default -> biomeSelector = BiomeSelectors.all();
        }

        BiomeModifications.addFeature(
                biomeSelector,
                genStepDecoration,
                ResourceKey.create(Registries.PLACED_FEATURE, resLoc)
        );
        return new FabricFeature<>(tt);
    }

    @Override
    public IBiomeDownfallProvider getBiomeDownfallProvider()
    {
        return biome -> ((IBiomeDownfallGetter) (Object) (biome)).getDownfall();
    }
}
