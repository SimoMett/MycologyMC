package com.simomett.mycologymod.compatibility.rei;

import com.simomett.mycologymod.data.FungusSpeciesList;
import com.simomett.mycologymod.recipes.crafting.FungusShapelessRecipe;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.crafting.DefaultCraftingDisplay;
import me.shedaniel.rei.plugin.common.displays.crafting.DefaultShapelessDisplay;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Optional;

public class ShapelessRecipesDisplay extends DefaultCraftingDisplay
{
    public ShapelessRecipesDisplay(FungusShapelessRecipe fungusShapelessRecipe)
    {
        super(Collections.singletonList(EntryIngredients.of(FungusSpeciesList.INSTANCE.get(fungusShapelessRecipe.getSpeciesIngredient()).defaultItemStack())),
                Collections.singletonList(EntryIngredients.of(fungusShapelessRecipe.getResult())),
                Optional.empty());
    }

    @Override
    public boolean isShapeless() {
        return true;
    }

    @Override
    public int getWidth() {
        return 2;
    }

    @Override
    public int getHeight() {
        return 2;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return DefaultShapelessDisplay.SERIALIZER;
    }
}
