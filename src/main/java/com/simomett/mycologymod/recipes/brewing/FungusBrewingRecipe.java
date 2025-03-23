package com.simomett.mycologymod.recipes.brewing;

import com.simomett.mycologymod.tags.ModItemTags;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

public class FungusBrewingRecipe implements IBrewingRecipe
{
    public final String species;
    public final Holder.Reference<Potion> resultPotion;

    public FungusBrewingRecipe(String species, String resultPotion)
    {
        this.species=species;
        this.resultPotion=BuiltInRegistries.POTION.get(ResourceLocation.parse(resultPotion)).get();
    }

    public boolean isInput(ItemStack stack)
    {
        return stack.has(DataComponents.POTION_CONTENTS) && stack.get(DataComponents.POTION_CONTENTS).is(Potions.AWKWARD);
    }

    public boolean isIngredient(ItemStack ingredient)
    {
        if (ingredient.is(ModItemTags.COLORED_FUNGUS_ITEMS))
        {
            String species = ingredient.get(FUNGUS_GENOMA).getDominantTraits().species();
            return species.equals(this.species);
        }
        return false;
    }

    public ItemStack getOutput(ItemStack input, ItemStack ingredient)
    {
        if (!input.isEmpty() && !ingredient.isEmpty() && isIngredient(ingredient) && isInput(input))
        {
            ItemStack result = PotionContents.createItemStack(Items.POTION, resultPotion);
            return !result.equals(input) ? result : ItemStack.EMPTY;
        }
        return ItemStack.EMPTY;
    }
}
