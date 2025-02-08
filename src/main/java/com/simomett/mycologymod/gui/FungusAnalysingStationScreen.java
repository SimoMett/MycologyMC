package com.simomett.mycologymod.gui;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.datacomponents.ModDataComponentTypes;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.genetics.FungusTraits;
import com.simomett.mycologymod.gui.menu.FungusAnalysingStationMenu;
import com.simomett.mycologymod.gui.menu.slot.FungusSlot;
import com.simomett.mycologymod.tags.ModBlockTags;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.ItemSlotMouseAction;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;

public class FungusAnalysingStationScreen extends AbstractContainerScreen<FungusAnalysingStationMenu>
{
    private final int imageWidth;
    private final int imageHeight;
    private int leftPos;
    private int topPos;
    private final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "textures/screens/fungus_analysing_station.png");
    public FungusAnalysingStationScreen(FungusAnalysingStationMenu menu, Inventory playerInventory, Component title)
    {
        super(menu, playerInventory, title);
        this.imageWidth = 176;
        this.imageHeight = 256;
        this.inventoryLabelY = 118;
        this.titleLabelY = -38;
    }

    @Override
    protected void init()
    {
        super.init();
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;
    }

    @Override
    protected void handleSlotStateChanged(int slotId, int containerId, boolean newState)
    {
        super.handleSlotStateChanged(slotId, containerId, newState);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick)
    {
        //FIXME too expensive get genoma from slot in each 'render' call
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        FungusGenoma currentGenoma = ((FungusSlot) (menu.getSlot(0))).getGenoma();
        if(currentGenoma!=null)
            drawGenomaInfo(guiGraphics, currentGenoma);
    }

    private void drawGenomaInfo(GuiGraphics guiGraphics, FungusGenoma currentGenoma)
    {
        //FIXME awful (I hate GUIs)
        int xOrigin = this.leftPos+76;
        int yOrigin = this.topPos+43;
        guiGraphics.drawString(this.font, Component.translatable("gui."+MycologyMod.MODID+".magnifyingglass.dominant"), xOrigin, yOrigin-12, -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(currentGenoma.getDominantTraits().species()), xOrigin, yOrigin, -12829636, false);
        //Index column
        int a = 3;
        final int o = 10;
        int b = 0;
        guiGraphics.drawString(this.font, ModBlockTags.getTranslatableComponent(currentGenoma.getDominantTraits().terrain()), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getDominantTraits().light())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getDominantTraits().humidity())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getDominantTraits().temp())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getDominantTraits().spreading())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getDominantTraits().spreadboost())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getDominantTraits().area())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, currentGenoma.getDominantTraits().effectGene().translatableComponent(), xOrigin, yOrigin+a+(b+=o), -12829636, false);

        b=0;
        xOrigin+=100;
        guiGraphics.drawString(this.font, Component.translatable("gui."+MycologyMod.MODID+".magnifyingglass.recessive"), xOrigin, yOrigin-12, -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(currentGenoma.getDominantTraits().species()), xOrigin, yOrigin, -12829636, false);
        guiGraphics.drawString(this.font, ModBlockTags.getTranslatableComponent(currentGenoma.getRecessiveTraits().terrain()), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getRecessiveTraits().light())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getRecessiveTraits().humidity())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getRecessiveTraits().temp())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getRecessiveTraits().spreading())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getRecessiveTraits().spreadboost())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(currentGenoma.getRecessiveTraits().area())), xOrigin, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, currentGenoma.getRecessiveTraits().effectGene().translatableComponent(), xOrigin, yOrigin+a+(b+=o), -12829636, false);
    }

    private void drawWidgets(GuiGraphics guiGraphics, int xOrigin, int yOrigin)
    {
        //Index column
        int a = 6;
        final int o = 10;
        int b = o;
        int d = 0; // X alignment
        guiGraphics.drawString(this.font, Component.translatable("gui."+MycologyMod.MODID+".magnifyingglass.terrain"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui."+MycologyMod.MODID+".magnifyingglass.light"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui."+MycologyMod.MODID+".magnifyingglass.humidity"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui."+MycologyMod.MODID+".magnifyingglass.temp"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui."+MycologyMod.MODID+".magnifyingglass.spreading"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui."+MycologyMod.MODID+".magnifyingglass.spreadboost"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui."+MycologyMod.MODID+".magnifyingglass.area"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui."+MycologyMod.MODID+".magnifyingglass.effect"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1)
    {
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        drawWidgets(guiGraphics, this.leftPos+6, this.topPos+30);
        //FIXME
        guiGraphics.drawString(this.font, "WARNING: ITEM WILL BE DELETED ", this.leftPos+6, this.topPos+140, 0, false);
        guiGraphics.drawString(this.font, "IF YOU CLOSE THIS GUI WITHOUT", this.leftPos+6, this.topPos+150, 0, false);
        guiGraphics.drawString(this.font, "PICKING IT UP", this.leftPos+100, this.topPos+160, 0, false);
    }
}
