package com.simomett.mycologymod.items;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.blocks.ModBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.simomett.mycologymod.items.ColoredFungusBlockItem.EFFECTS_WHEN_EATEN_RAW;


public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MycologyMod.MODID);

    public static final DeferredItem<ColoredFungusBlockItem> COLORED_CRIMSON_FUNGUS = ITEMS.register(ModBlocks.COLORED_CRIMSON_STRING, r ->
            new ColoredFungusBlockItem(ModBlocks.COLORED_CRIMSON_FUNGUS.get(), r));
    public static final DeferredItem<ColoredFungusBlockItem> COLORED_WARPED_FUNGUS = ITEMS.register(ModBlocks.COLORED_WARPED_STRING, r ->
            new ColoredFungusBlockItem(ModBlocks.COLORED_WARPED_FUNGUS.get(), r));

    //all the items below...
    public static final DeferredItem<Item> COOKED_CRIMSON_FUNGUS = ITEMS.registerSimpleItem("cooked_crimson_fungus", new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(2).build()));
    public static final DeferredItem<Item> COOKED_WARPED_FUNGUS = ITEMS.registerSimpleItem("cooked_warped_fungus", new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(2).build()));
    public static final DeferredItem<Item> COOKED_POISONOUS_CRIMSON_FUNGUS = ITEMS.registerSimpleItem("cooked_poisonous_crimson_fungus",
            new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(1).build(), Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(EFFECTS_WHEN_EATEN_RAW)).build()));
    public static final DeferredItem<Item> COOKED_POISONOUS_WARPED_FUNGUS = ITEMS.registerSimpleItem("cooked_poisonous_warped_fungus",
            new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(1).build(), Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(EFFECTS_WHEN_EATEN_RAW)).build()));
    public static final DeferredItem<MagnifyingGlassItem> MAGNIFYING_GLASS = ITEMS.register("magnifying_glass", MagnifyingGlassItem::new);
    public static final DeferredItem<Item> TEST_TUBE = ITEMS.registerSimpleItem("test_tube");
    public static final DeferredItem<BlockItem> CHROMIUM_ORE = ITEMS.registerSimpleBlockItem("chromium_ore", ModBlocks.CHROMIUM_ORE);
    public static final DeferredItem<Item> CHROMITE_POWDER = ITEMS.registerSimpleItem("chromite_powder");
    public static final DeferredItem<Item> CHROMIUM_MUTAGEN = ITEMS.registerItem("chromium_mutagen", MutagenItem::new); // Ammonium dichromate
    public static final DeferredItem<Item> CHROMIUM_INGOT = ITEMS.registerSimpleItem("chromium_ingot");
    public static final DeferredItem<Item> CHROMIUM_NUGGET = ITEMS.registerSimpleItem("chromium_nugget");
    public static final DeferredItem<BlockItem> CHROMIUM_BLOCK = ITEMS.registerSimpleBlockItem("chromium_block", ModBlocks.CHROMIUM_BLOCK);
}
