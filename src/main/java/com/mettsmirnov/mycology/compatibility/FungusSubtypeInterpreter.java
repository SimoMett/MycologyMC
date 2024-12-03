package com.mettsmirnov.mycology.compatibility;

import com.mettsmirnov.mycology.capabilities.FungusDataCapability;
import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.capabilities.IFungusData;
import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.world.item.ItemStack;

public class FungusSubtypeInterpreter implements IIngredientSubtypeInterpreter<ItemStack>
{

    @Override
    public String apply(ItemStack itemStack, UidContext uidContext)
    {
        IFungusData fungusDataModel = itemStack.getCapability(FungusDataCapability.INSTANCE).resolve().get();
        return (String) fungusDataModel.getField(FungusDataModel.SPECIES, IFungusData.GeneType.DOMINANT);
    }
}
