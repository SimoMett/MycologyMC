package com.simomett.mycologymod.items;

import com.simomett.mycologymod.blocks.BlocksDefinitions;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

import static com.simomett.mycologymod.Constants.MOD_ID;
import static com.simomett.mycologymod.blocks.BlocksDefinitions.COLORED_CRIMSON_STRING;
import static com.simomett.mycologymod.blocks.BlocksDefinitions.COLORED_WARPED_STRING;

public class ItemsDefinitions
{
    private static <T extends Item> IRegisteredItem<T> registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties settings)
    {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));

        Item item = factory.apply(settings.setId(key));

        return new FabricRegisteredItem(Registry.register(BuiltInRegistries.ITEM, key, item));
    }

    private static <T extends Item> IRegisteredItem<T> registerSimpleItem(String name)
    {
        return registerItem(name, Item::new, new Item.Properties());
    }

    public static final IRegisteredItem<ColoredFungusBlockItem> COLORED_CRIMSON_FUNGUS = registerItem(
            COLORED_CRIMSON_STRING,
            (p -> new ColoredFungusBlockItem(BlocksDefinitions.COLORED_CRIMSON_FUNGUS.get(), p)),
            new Item.Properties()
                    //.stacksTo(DEFAULT_MAX_STACK_SIZE)
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(1).build())
    );

    public static final IRegisteredItem<ColoredFungusBlockItem> COLORED_WARPED_FUNGUS = registerItem(
            COLORED_WARPED_STRING,
            (p -> new ColoredFungusBlockItem(BlocksDefinitions.COLORED_WARPED_FUNGUS.get(), p)),
            new Item.Properties()
                    //.stacksTo(DEFAULT_MAX_STACK_SIZE)
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(1).build())
    );

    // Ammonium dichromate
    public static final IRegisteredItem<Item> CHROMIUM_MUTAGEN = registerItem(
            "chromium_mutagen",
            MutagenItem::new,
            new Item.Properties()
    );

    /*public static final IRegisteredItem<MagnifyingGlassItem> MAGNIFYING_GLASS = Services.PLATFORM.registerItem("magnifying_glass", (p) ->
            new MagnifyingGlassItem(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "magnifying_glass")));*/

    // Simple items
    public static final IRegisteredItem<Item> COOKED_CRIMSON_FUNGUS = registerItem(
            "cooked_crimson_fungus",
            Item::new,
            new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(2).build())
    );

    public static final IRegisteredItem<Item> COOKED_WARPED_FUNGUS = registerItem(
            "cooked_warped_fungus",
            Item::new,
            new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(2).build())
    );

    public static final IRegisteredItem<Item> COOKED_POISONOUS_CRIMSON_FUNGUS = registerItem(
            "cooked_poisonous_crimson_fungus",
            Item::new,
            new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(2).build())
    );

    public static final IRegisteredItem<Item> COOKED_POISONOUS_WARPED_FUNGUS = registerItem(
            "cooked_poisonous_warped_fungus",
            Item::new,
            new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(2).build())
    );

    /*public static final IRegisteredItem<Item> TEST_TUBE = Services.PLATFORM.registerItem("test_tube", (p) ->
            new Item(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "test_tube")))));*/

    public static final IRegisteredItem<BlockItem> CHROMIUM_ORE = registerItem(
            "chromium_ore",
            (p) -> new BlockItem(BlocksDefinitions.CHROMIUM_ORE.get(), p),
            new Item.Properties()
    );

    public static final IRegisteredItem<Item> CHROMITE_POWDER = registerSimpleItem("chromite_powder");
    public static final IRegisteredItem<Item> CHROMIUM_INGOT = registerSimpleItem("chromium_ingot");
    public static final IRegisteredItem<Item> CHROMIUM_NUGGET = registerSimpleItem("chromium_nugget");
    public static final IRegisteredItem<BlockItem> CHROMIUM_BLOCK = registerItem(
            "chromium_block",
            (p) -> new BlockItem(BlocksDefinitions.CHROMIUM_BLOCK.get(), p),
            new Item.Properties()
    );
    public static final IRegisteredItem<BlockItem> CHROMIUM_STAIRS = registerItem(
            "chromium_stairs",
            (p) -> new BlockItem(BlocksDefinitions.CHROMIUM_STAIRS.get(), p),
            new Item.Properties()
    );
    public static final IRegisteredItem<BlockItem> FUNGUS_POT = registerItem(
            "fungus_pot",
            (p) -> new BlockItem(BlocksDefinitions.FUNGUS_POT.get(), p),
            new Item.Properties()
    );

    public static final IRegisteredItem<Item> SPORE_MASK = registerItem(
            "spore_mask",
            Item::new,
            new Item.Properties().humanoidArmor(ArmorMaterials.CHAINMAIL, ArmorType.HELMET)
    );

    public static final IRegisteredItem<BlockItem> ANALYSING_STATION = registerItem("analysing_station",
            p-> new BlockItem(BlocksDefinitions.ANALYSING_STATION.get(), p),
            new Item.Properties()
    );

    // Debug item
    public static final IRegisteredItem<Item> SPEEDYZER = registerItem(
            "speedyzer",
            SpeedyzerItem::new,
            new Item.Properties()
    );

    public static boolean isFungus(ItemStack itemStack)
    {
        return itemStack.is(COLORED_WARPED_FUNGUS.get()) || itemStack.is(COLORED_CRIMSON_FUNGUS.get());
    }

    public static void init(){}
}
