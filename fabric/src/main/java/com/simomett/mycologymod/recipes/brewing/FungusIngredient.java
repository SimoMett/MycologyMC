package com.simomett.mycologymod.recipes.brewing;

import com.simomett.mycologymod.datacomponents.DataComponentTypes;
import com.simomett.mycologymod.items.ItemsDefinitions;
import com.simomett.mycologymod.tags.ModItemTags;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public final class FungusIngredient extends Ingredient
{
    private final String speciesName;
    private FungusIngredient(String speciesName)
    {
        super(HolderSet.direct(
                BuiltInRegistries.ITEM.wrapAsHolder(ItemsDefinitions.COLORED_CRIMSON_FUNGUS.get()),
                BuiltInRegistries.ITEM.wrapAsHolder(ItemsDefinitions.COLORED_WARPED_FUNGUS.get()))
        );

        this.speciesName = speciesName;
    }

    public static FungusIngredient of(String speciesName)
    {
        return new FungusIngredient(speciesName);
    }

    @Override
    public boolean test(ItemStack stack)
    {
        boolean sameSpecies = false;
        if(stack.getComponents().has(DataComponentTypes.FUNGUS_GENOMA.dataComponentType()))
            sameSpecies = stack.getComponents().get(DataComponentTypes.FUNGUS_GENOMA.dataComponentType()).getDominantTraits().species().equals(speciesName);

        return super.test(stack) || sameSpecies;
    }

    @Override
    public boolean acceptsItem(Holder<Item> holder)
    {
        return super.acceptsItem(holder) || holder.is(ModItemTags.COLORED_FUNGUS_ITEMS);
    }
}
