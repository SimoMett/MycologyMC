package com.simomett.mycologymod.platform;

import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.data.FungusSpeciesColorsMap;
import com.simomett.mycologymod.data.FungusSpeciesColorsMapDatapackSync;
import com.simomett.mycologymod.effects.player.NeoForgeModEffects;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.items.potions.NeoForgePotions;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

import java.util.function.Supplier;

import static com.simomett.mycologymod.datacomponents.DataComponentTypes.FUNGUS_GENOMA_BUILDER;
import static com.simomett.mycologymod.datacomponents.DataComponentTypes.GENOMA_DATA_COMPONENT_NAME;
import static com.simomett.mycologymod.datacomponents.NeoForgeDataComponents.DATA_COMPONENTS;
import static com.simomett.mycologymod.entities.NeoForgeBlockEntities.ENTITIES;
import static com.simomett.mycologymod.items.ModItems.ITEMS;
import static com.simomett.mycologymod.recipes.ModRecipes.RECIPE_SERIALIZERS;

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
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public <T extends Item> T registerItem(String name, Supplier<T> supplier)
    {
        return ITEMS.register(name, supplier).get();
    }

    @Override
    public <T extends Block> T registerBlock(String name, Supplier<T> supplier)
    {
        return null;
    }

    @Override
    public Holder<MobEffect> registerMobEffect(String name, Supplier<MobEffect> mobEffectSupplier)
    {
        return NeoForgeModEffects.EFFECTS.register(name, mobEffectSupplier);
    }

    @Override
    public Holder<Potion> registerPotion(String name, Supplier<Potion> potionSupplier)
    {
        return NeoForgePotions.POTIONS.register(name, potionSupplier);
    }

    @Override
    public IModCommonConfigs getCommonConfigs()
    {
        return null;
    }

    @Override
    public Supplier<DataComponentType<FungusGenoma>> registerDataComponentType()
    {
        return DATA_COMPONENTS.registerComponentType(GENOMA_DATA_COMPONENT_NAME, FUNGUS_GENOMA_BUILDER);
    }

    @Override
    public <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String recipeSerializerName, Supplier<T> supplier)
    {
        return RECIPE_SERIALIZERS.register(recipeSerializerName, supplier);
    }

    @Override
    public BlockEntityType<? extends BlockEntity> registerBlockEntityType(String name, BlockEntitySupplier<? extends BlockEntity> supplier, Block... blocks)
    {
        return ENTITIES.register(name, ()-> new BlockEntityType<>(ColoredFungusBlockEntity::new,
                BlocksDefinitions.COLORED_CRIMSON_FUNGUS,
                BlocksDefinitions.COLORED_WARPED_FUNGUS
            /*BlockNames.FUNGUS_POT.get(),
            BlockNames.POTTED_COLORED_CRIMSON.get(),
            BlockNames.POTTED_COLORED_WARPED.get()*/)
        ).get();
    }

    @Override
    public MenuType<? extends AbstractContainerMenu> registerMenu(String name, MenuSupplier<? extends AbstractContainerMenu> menuSupplier)
    {
        return null;//MENU_TYPES.register(name, menuSupplier).get();
    }
}
