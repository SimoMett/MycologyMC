package com.mettsmirnov.mycology.recipes.brewing;

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
import org.jline.utils.Log;

public class ModBrewingRecipes
{
    public static void register()
    {
        FungusBrewingRecipe poppedRecipe = null;
        do
        {
            poppedRecipe=FungusBrewingRecipeLoader.INSTANCE.popFromQueue();
            if(poppedRecipe!=null)
            {
                BrewingRecipeRegistry.addRecipe(poppedRecipe);
                Log.info(poppedRecipe.species);
            }
        }
        while (poppedRecipe!=null);
    }
}
