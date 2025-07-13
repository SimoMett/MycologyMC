package com.simomett.mycologymod.items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Function;

import static com.simomett.mycologymod.Constants.MOD_ID;

public class ModItems
{
    public static final Item TEST_ITEM = register("test_item", Item::new, new Item.Properties());

    public static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties properties)
    {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
        Item item = factory.apply(properties.setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void initialize() {}
}
