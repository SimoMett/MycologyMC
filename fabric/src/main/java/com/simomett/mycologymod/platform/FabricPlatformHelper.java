package com.simomett.mycologymod.platform;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.config.FabricCommonConfigs;
import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

import static com.simomett.mycologymod.Constants.MOD_ID;
import static com.simomett.mycologymod.datacomponents.DataComponentTypes.FUNGUS_GENOMA_BUILDER;
import static com.simomett.mycologymod.datacomponents.DataComponentTypes.GENOMA_DATA_COMPONENT_NAME;

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
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public <T extends Item> T registerItem(String name, Supplier<T> supplier)
    {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
        return Registry.register(BuiltInRegistries.ITEM, key, supplier.get());
    }

    @Override
    public <T extends Block> T registerBlock(String name, Supplier<T> supplier)
    {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
        return Registry.register(BuiltInRegistries.BLOCK, key, supplier.get());
    }

    @Override
    public Holder<MobEffect> registerMobEffect(String name, Supplier<MobEffect> mobEffectSupplier)
    {
        return Holder.direct(Registry.register(BuiltInRegistries.MOB_EFFECT, name, mobEffectSupplier.get()));
    }

    @Override
    public Holder<Potion> registerPotion(String name, Supplier<Potion> potionSupplier)
    {
        return Holder.direct(Registry.register(BuiltInRegistries.POTION, name, potionSupplier.get()));
    }

    @Override
    public IModCommonConfigs getCommonConfigs()
    {
        // TODO
        return new FabricCommonConfigs();
    }

    @Override
    public DataComponentType<FungusGenoma> registerDataComponentType()
    {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, GENOMA_DATA_COMPONENT_NAME),
                FUNGUS_GENOMA_BUILDER.apply(DataComponentType.builder()).build()
        );
    }

    @Override
    public <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String recipeSerializerName, Supplier<T> supplier)
    {
        return null;
    }

    @Override
    public BlockEntityType<? extends BlockEntity> registerBlockEntityType(String name, BlockEntitySupplier<? extends BlockEntity> supplier, Block... blocks)
    {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name),
                FabricBlockEntityTypeBuilder.create(supplier::create, blocks).build()
        );
    }

    @Override
    public MenuType<? extends AbstractContainerMenu> registerMenu(String name, MenuSupplier<? extends AbstractContainerMenu> menuSupplier) {
        return Registry.register(BuiltInRegistries.MENU,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name),
                new MenuType<>(menuSupplier::create, FeatureFlags.DEFAULT_FLAGS)
        );
    }
}
