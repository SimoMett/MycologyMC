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
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;

import static com.simomett.mycologymod.blocks.BlocksDefinitions.COLORED_CRIMSON_STRING;
import static com.simomett.mycologymod.blocks.BlocksDefinitions.COLORED_WARPED_STRING;
import static com.simomett.mycologymod.items.ColoredFungusBlockItem.EFFECTS_WHEN_EATEN_RAW;

public class ItemsDefinitions
{
    public static final IRegisteredItem<ColoredFungusBlockItem> COLORED_CRIMSON_FUNGUS = Services.PLATFORM.registerItem(COLORED_CRIMSON_STRING, (p) ->
            new ColoredFungusBlockItem(BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(),
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, COLORED_CRIMSON_STRING))
    );

    public static final IRegisteredItem<ColoredFungusBlockItem> COLORED_WARPED_FUNGUS = Services.PLATFORM.registerItem(COLORED_WARPED_STRING, (p) ->
            new ColoredFungusBlockItem(BlocksDefinitions.COLORED_WARPED_FUNGUS.get(),
                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, COLORED_WARPED_STRING))
    );

    public static final IRegisteredItem<Item> CHROMIUM_MUTAGEN = Services.PLATFORM.registerItem("chromium_mutagen", (p) ->
            new MutagenItem(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_mutagen"))))); // Ammonium dichromate

    /*public static final IRegisteredItem<MagnifyingGlassItem> MAGNIFYING_GLASS = Services.PLATFORM.registerItem("magnifying_glass", (p) ->
            new MagnifyingGlassItem(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "magnifying_glass")));*/

    // Simple items
    public static final IRegisteredItem<Item> COOKED_CRIMSON_FUNGUS = Services.PLATFORM.registerItem("cooked_crimson_fungus", (p) ->
            new Item(new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooked_crimson_fungus")))
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(2).build())));

    public static final IRegisteredItem<Item> COOKED_WARPED_FUNGUS = Services.PLATFORM.registerItem("cooked_warped_fungus", (p) ->
            new Item(new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooked_warped_fungus")))
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(2).build()))
    );

    public static final IRegisteredItem<Item> COOKED_POISONOUS_CRIMSON_FUNGUS = Services.PLATFORM.registerItem("cooked_poisonous_crimson_fungus", (p) ->
            new Item(new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooked_poisonous_crimson_fungus")))
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(1).build(), Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(EFFECTS_WHEN_EATEN_RAW)).build()))
    );
    public static final IRegisteredItem<Item> COOKED_POISONOUS_WARPED_FUNGUS = Services.PLATFORM.registerItem("cooked_poisonous_warped_fungus", (p) ->
            new Item(new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooked_poisonous_warped_fungus")))
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(1).build(), Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(EFFECTS_WHEN_EATEN_RAW)).build()))
    );
    /*public static final IRegisteredItem<Item> TEST_TUBE = Services.PLATFORM.registerItem("test_tube", (p) ->
            new Item(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "test_tube")))));*/
    public static final IRegisteredItem<BlockItem> CHROMIUM_ORE = Services.PLATFORM.registerItem("chromium_ore", (p) ->
            new BlockItem(BlocksDefinitions.CHROMIUM_ORE.get(), new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_ore"))))
    );
    public static final IRegisteredItem<Item> CHROMITE_POWDER = Services.PLATFORM.registerItem("chromite_powder", (p)->
            new Item(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromite_powder")))));
    public static final IRegisteredItem<Item> CHROMIUM_INGOT = Services.PLATFORM.registerItem("chromium_ingot", (p)->
            new Item(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_ingot")))));
    public static final IRegisteredItem<Item> CHROMIUM_NUGGET = Services.PLATFORM.registerItem("chromium_nugget", (p)->
            new Item(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_nugget")))));
    public static final IRegisteredItem<BlockItem> CHROMIUM_BLOCK = Services.PLATFORM.registerItem("chromium_block", (p) ->
            new BlockItem(BlocksDefinitions.CHROMIUM_BLOCK.get(), new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_block"))))
    );
    public static final IRegisteredItem<BlockItem> CHROMIUM_STAIRS = Services.PLATFORM.registerItem("chromium_stairs", (p) ->
            new BlockItem(BlocksDefinitions.CHROMIUM_STAIRS.get(), new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "chromium_stairs"))))
    );
    public static final IRegisteredItem<BlockItem> FUNGUS_POT = Services.PLATFORM.registerItem("fungus_pot", (p)->
            new BlockItem(BlocksDefinitions.FUNGUS_POT.get(), new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "fungus_pot"))))
    );

    public static final IRegisteredItem<Item> SPORE_MASK = Services.PLATFORM.registerItem("spore_mask", (p) ->
            new Item(new Item.Properties()
                    .humanoidArmor(ArmorMaterials.TURTLE_SCUTE, ArmorType.HELMET)
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "spore_mask"))))
    );

    // Debug item
    public static final IRegisteredItem<Item> SPEEDYZER = Services.PLATFORM.registerItem("speedyzer", (p)->
            new SpeedyzerItem(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "speedyzer")))));

    public static boolean isFungus(ItemStack itemStack)
    {
        return itemStack.is(COLORED_WARPED_FUNGUS.get()) || itemStack.is(COLORED_CRIMSON_FUNGUS.get());
    }

    /*public static final IRegisteredItem<BlockItem> FUNGUS_ANALYSING_STATION = Services.PLATFORM.registerItem("fungus_analysing_station", p->
            new BlockItem(BlocksDefinitions.FUNGUS_ANALYSING_STATION.get(), new Item.Properties()
                    .setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "fungus_analysing_station"))))
    );*/

    public static void init(){}
}
