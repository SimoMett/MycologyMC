package com.mettsmirnov.mycology.recipes;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBrewingRecipes
{
    public static void register()
    {
        //I think I can add all the potions from here:
        //BrewingRecipeRegistry.addRecipe(input, ingredient, output);
        Ingredient input = Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER));
        Ingredient ingredient = Ingredient.of(ModItems.COLORED_CRIMSON_FUNGUS.get());
        ItemStack output = PotionUtils.setPotion(new ItemStack(Items.POTION),Potions.STRONG_POISON);
        BrewingRecipeRegistry.addRecipe(input, ingredient, output);
    }
}
