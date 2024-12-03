package com.mettsmirnov.mycology.recipes.brewing;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;

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
            ResourceLocation resourceLocation = new ResourceLocation(stack.getTag().getString("Potion"));
            return resourceLocation.getPath().equals("awkward");
        }
        return false;
    }

    public boolean isIngredient(ItemStack ingredient)
    {
        if (ingredient.is(ModItems.COLORED_CRIMSON_FUNGUS.get()) || ingredient.is(ModItems.COLORED_WARPED_FUNGUS.get()))
        {
            String species = (String)ingredient.getCapability(FungusDataCapability.INSTANCE).resolve().get().getField("species", IFungusData.GeneType.DOMINANT);
            return species.equals(this.species);
        }
        return false;
    }

    public ItemStack getOutput(ItemStack input, ItemStack ingredient)
    {
        if (!input.isEmpty() && !ingredient.isEmpty() && isIngredient(ingredient) && isInput(input))
        {
            ItemStack result = new ItemStack(Items.POTION);
            PotionUtils.setPotion(result, Potion.byName(resultPotion));
            if (result != input)
            {
                return result;
            }
            return ItemStack.EMPTY;
        }
        return ItemStack.EMPTY;
    }
}
