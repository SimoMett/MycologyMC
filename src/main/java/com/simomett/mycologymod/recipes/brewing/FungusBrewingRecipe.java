package com.simomett.mycologymod.recipes.brewing;

import com.simomett.mycologymod.tags.ModItemTags;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

public class FungusBrewingRecipe implements IBrewingRecipe
{
    private final Holder<Potion> inputPotion;
    public final ItemStack inputItem;

    public final Holder.Reference<Potion> resultPotion;
    public final String speciesName;
    public final ItemStack result;

    public FungusBrewingRecipe(Holder<Potion> inputPotion, Item inputItem, String species, String resultPotion)
    {
        this.inputPotion = inputPotion;
        this.inputItem = PotionContents.createItemStack(inputItem, inputPotion);
        this.speciesName = species;
        this.resultPotion = BuiltInRegistries.POTION.get(ResourceLocation.parse(resultPotion)).get();
        this.result = PotionContents.createItemStack(this.inputItem.getItem(), this.resultPotion);
    }

    public boolean isInput(ItemStack stack)
    {
        return stack.is(inputItem.getItem()) && stack.has(DataComponents.POTION_CONTENTS) && stack.get(DataComponents.POTION_CONTENTS).is(inputPotion);
    }

    public boolean isIngredient(ItemStack ingredient)
    {
        if (ingredient.is(ModItemTags.COLORED_FUNGUS_ITEMS))
        {
            String species = ingredient.get(FUNGUS_GENOMA).getDominantTraits().species();
            return species.equals(this.speciesName);
        }
        return false;
    }

    public ItemStack getOutput(ItemStack input, ItemStack ingredient)
    {
        if (!input.isEmpty() && !ingredient.isEmpty() && isIngredient(ingredient) && isInput(input))
            return result;

        return ItemStack.EMPTY;
    }
}
