package com.simomett.mycologymod.recipes.brewing;

import com.simomett.mycologymod.Constants;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class FungusBrewingRecipesRegister
{
    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent evt)
    {
        PotionBrewing.Builder builder = evt.getBuilder();
        for(FungusBrewingRecipe r : FungusBrewingRecipeLoader.INSTANCE.getQueue())
        {
            builder.addRecipe(new IBrewingRecipe() {
                @Override
                public boolean isInput(ItemStack itemStack) {
                    return r.isInput(itemStack);
                }

                @Override
                public boolean isIngredient(ItemStack itemStack) {
                    return r.isIngredient(itemStack);
                }

                @Override
                public ItemStack getOutput(ItemStack itemStack, ItemStack itemStack1) {
                    return r.getOutput(itemStack, itemStack1);
                }
            });
            //do the recipes need to be removed from BrewingRecipeRegistry when all the resources reload?
        }
    }
}
