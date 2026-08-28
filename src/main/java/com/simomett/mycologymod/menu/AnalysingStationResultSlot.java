package com.simomett.mycologymod.menu;

import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.network.Filterable;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.WritableBookContent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnalysingStationResultSlot extends Slot
{
    private final FungusSlot fungusSlot;
    private final BookAndQuillOnlySlot bookAndQuillOnlySlot;
    public AnalysingStationResultSlot(FungusSlot fungusSlot, BookAndQuillOnlySlot bookAndQuillOnlySlot, Container container, int slot, int x, int y)
    {
        super(container, slot, x, y);
        this.fungusSlot = fungusSlot;
        this.bookAndQuillOnlySlot = bookAndQuillOnlySlot;
    }

    @Override
    public boolean mayPlace(ItemStack itemStack)
    {
        return false;
    }

    @Override
    public void onTake(Player player, ItemStack carried)
    {
        super.onTake(player, carried);
        bookAndQuillOnlySlot.remove(1);
    }

    public void updateOutput()
    {
        if(null != fungusSlot.getGenoma() && bookAndQuillOnlySlot.hasItem())
        {
            //TODO prettify
            List<Filterable<String>> originalPages = bookAndQuillOnlySlot.getItem().getComponents().get(DataComponents.WRITABLE_BOOK_CONTENT).pages();

            List<Filterable<String>> newPages = new ArrayList<>(originalPages);
            String newPage = "Dominant traits: " +
            "\n" + fungusSlot.getGenoma().dominantTraits().species() + "\n" +
            "\nSpreading: "+ fungusSlot.getGenoma().dominantTraits().spreading() +
            "\nSpread boost: "+ fungusSlot.getGenoma().dominantTraits().spreadboost() +
            "\nLight: "+ fungusSlot.getGenoma().dominantTraits().light() +
            "\nTerrain: "+ fungusSlot.getGenoma().dominantTraits().terrain() +
            "\nHumidity: "+ fungusSlot.getGenoma().dominantTraits().humidity() +
            "\nTemperature: "+ fungusSlot.getGenoma().dominantTraits().temp() +
            "\nSpores radius: "+ fungusSlot.getGenoma().dominantTraits().area() +
            "\nSpores effect: "+ fungusSlot.getGenoma().dominantTraits().effect() +
            "\nEating effect: "+ fungusSlot.getGenoma().dominantTraits().eatingEffect().orElse("none");
            newPages.addLast(new Filterable<>(newPage, Optional.empty()));
            WritableBookContent newBookContent = new WritableBookContent(newPages);

            ItemStack newBook = new ItemStack(Items.WRITABLE_BOOK);
            DataComponentPatch patch = DataComponentPatch.builder().set(DataComponents.WRITABLE_BOOK_CONTENT, newBookContent).build();
            newBook.applyComponents(patch);

            this.set(newBook);
        }
        else
        {
            this.set(ItemStack.EMPTY);
        }
    }
}
