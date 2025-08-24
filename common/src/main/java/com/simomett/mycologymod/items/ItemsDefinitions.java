package com.simomett.mycologymod.items;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.function.Supplier;

import static com.simomett.mycologymod.items.ColoredFungusBlockItem.EFFECTS_WHEN_EATEN_RAW;

public class ItemsDefinitions
{
    public static final Supplier<ColoredFungusBlockItem> COLORED_CRIMSON_FUNGUS = () ->
            new ColoredFungusBlockItem(BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(),
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, BlocksDefinitions.COLORED_CRIMSON_STRING));

    public static final Supplier<ColoredFungusBlockItem> COLORED_WARPED_FUNGUS = () ->
            new ColoredFungusBlockItem(BlocksDefinitions.COLORED_WARPED_FUNGUS.get(),
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, BlocksDefinitions.COLORED_WARPED_STRING));

    public static final Item CHROMIUM_MUTAGEN = Services.PLATFORM.registerItem("chromium_mutagen", () ->
            new MutagenItem(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_mutagen"))))); // Ammonium dichromate

    public static final MagnifyingGlassItem MAGNIFYING_GLASS = Services.PLATFORM.registerItem("magnifying_glass", () ->
            new MagnifyingGlassItem(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "magnifying_glass")));

    // Simple items
    public static final Item COOKED_CRIMSON_FUNGUS = Services.PLATFORM.registerItem("cooked_crimson_fungus", () ->
            new Item(new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooked_crimson_fungus")))
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(2).build())));

    public static final Item COOKED_WARPED_FUNGUS = Services.PLATFORM.registerItem("cooked_warped_fungus", () ->
            new Item(new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooked_warped_fungus")))
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(2).build()))
    );

    public static final Item COOKED_POISONOUS_CRIMSON_FUNGUS = Services.PLATFORM.registerItem("cooked_poisonous_crimson_fungus", () ->
            new Item(new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooked_poisonous_crimson_fungus")))
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(1).build(), Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(EFFECTS_WHEN_EATEN_RAW)).build()))
    );
    public static final Item COOKED_POISONOUS_WARPED_FUNGUS = Services.PLATFORM.registerItem("cooked_poisonous_warped_fungus", () ->
            new Item(new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooked_poisonous_warped_fungus")))
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(1).build(), Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(EFFECTS_WHEN_EATEN_RAW)).build()))
    );
    public static final Item TEST_TUBE = Services.PLATFORM.registerItem("test_tube", () ->
            new Item(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "test_tube")))));
    public static final BlockItem CHROMIUM_ORE = Services.PLATFORM.registerItem("chromium_ore", () ->
            new BlockItem(BlocksDefinitions.CHROMIUM_ORE, new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_ore"))))
    );
    public static final Item CHROMITE_POWDER = Services.PLATFORM.registerItem("chromite_powder", ()->
            new Item(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromite_powder")))));
    public static final Item CHROMIUM_INGOT = Services.PLATFORM.registerItem("chromium_ingot", ()->
            new Item(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_ingot")))));
    public static final Item CHROMIUM_NUGGET = Services.PLATFORM.registerItem("chromium_nugget", ()->
            new Item(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_nugget")))));
    public static final BlockItem CHROMIUM_BLOCK = Services.PLATFORM.registerItem("chromium_block", () ->
            new BlockItem(BlocksDefinitions.CHROMIUM_BLOCK, new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_block"))))
    );

    // Debug item
    public static final Item SPEEDYZER = Services.PLATFORM.registerItem("speedyzer", ()->
            new SpeedyzerItem(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "speedyzer")))));

    public static boolean isFungus(ItemStack itemStack)
    {
        return itemStack.is(COLORED_WARPED_FUNGUS.get()) || itemStack.is(COLORED_CRIMSON_FUNGUS.get());
    }

    public static void init(){}
}
