package com.mettsmirnov.mycology.recipes.brewing;

import com.mettsmirnov.mycology.items.ModItems;
import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.VanillaBrewingRecipe;

public class FungusBrewingRecipe extends VanillaBrewingRecipe
{
    String species;//FIXME should be private (testing only)
    private String resultPotion;
    private int potionLevel;

    public FungusBrewingRecipe(String species, String resultPotion, int level)
    {
        this.species=species;
        this.resultPotion=resultPotion;
        potionLevel=level;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient)
    {
        return ingredient.is(ModItems.COLORED_CRIMSON_FUNGUS.get());
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient)
    {
        //ItemStack superResult = super.getOutput(input, ingredient);
        ItemStack result = new ItemStack(Items.POTION);
        MobEffectInstance mobEffectInstance = new MobEffectInstance(MobEffects.POISON,potionLevel);
        Potion potion = new Potion(resultPotion, mobEffectInstance);
        PotionUtils.setPotion(result, potion);
        return result;
    }
}
