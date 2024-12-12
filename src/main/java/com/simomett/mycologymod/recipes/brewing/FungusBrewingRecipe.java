package com.simomett.mycologymod.recipes.brewing;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;

public class FungusBrewingRecipe implements IBrewingRecipe
{
    private String species;
    private String resultPotion;

    public FungusBrewingRecipe(String species, String resultPotion)
    {
        this.species=species;
        this.resultPotion=resultPotion;
    }

    public boolean isInput(ItemStack stack)
    {
        Item item = stack.getItem();
        if(item == Items.POTION || item == Items.SPLASH_POTION || item == Items.LINGERING_POTION || item == Items.GLASS_BOTTLE)
        {
            ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace(stack.getComponents().get(DataComponents.POTION_CONTENTS).toString());
            return resourceLocation.getPath().equals("awkward");
        }
        return false;
    }

    public boolean isIngredient(ItemStack ingredient)
    {
        /*if (ingredient.is(ModItems.COLORED_CRIMSON_FUNGUS.get()) || ingredient.is(ModItems.COLORED_WARPED_FUNGUS.get()))
        {
            String species = (String)ingredient.getCapability(FungusDataCapability.INSTANCE).resolve().get().getField("species", IFungusData.GeneType.DOMINANT);
            return species.equals(this.species);
        }*/
        return false;
    }

    public ItemStack getOutput(ItemStack input, ItemStack ingredient)
    {
        if (!input.isEmpty() && !ingredient.isEmpty() && isIngredient(ingredient) && isInput(input))
        {
            ItemStack result = PotionContents.createItemStack(Items.POTION, Holder.direct(BuiltInRegistries.POTION.get(ResourceLocation.parse(resultPotion))));
            if (result != input)
            {
                return result;
            }
            return ItemStack.EMPTY;
        }
        return ItemStack.EMPTY;
    }
}
