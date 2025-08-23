package com.simomett.mycologymod.platform;

import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.config.IModCommonConfigs;
import com.simomett.mycologymod.data.AbstractFungusSpeciesColorsMap;
import com.simomett.mycologymod.data.AbstractFungusSpeciesList;
import com.simomett.mycologymod.data.FungusSpeciesColorsMap;
import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.effects.player.NeoForgeModEffects;
import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.items.potions.NeoForgePotions;
import com.simomett.mycologymod.platform.services.IPlatformHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.effect.MobEffect;
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
    public AbstractFungusSpeciesList initFungusSpeciesList()
    {
        return new FungusSpeciesList();
    }

    @Override
    public AbstractFungusSpeciesColorsMap initFungusSpeciesColorsMap() {
        return new FungusSpeciesColorsMap();
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
                BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(),
                BlocksDefinitions.COLORED_WARPED_FUNGUS.get()
            /*BlockNames.FUNGUS_POT.get(),
            BlockNames.POTTED_COLORED_CRIMSON.get(),
            BlockNames.POTTED_COLORED_WARPED.get()*/)
        ).get();
    }
}
