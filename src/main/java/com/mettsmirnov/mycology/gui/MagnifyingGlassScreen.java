package com.mettsmirnov.mycology.gui;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.menu.MagnifyingGlassMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MagnifyingGlassScreen extends Screen
{
    private final int imageWidth;
    private final int imageHeight;
    private int leftPos;
    private int topPos;
    //private final FungusDataModel fungusDataModel;
    public MagnifyingGlassScreen(Component title)
    {
        super(title);
        //this.fungusDataModel = magnifyingGlassMenu.fungusDataModel;
        this.imageWidth = 176;
        this.imageHeight = 194;
    }

    @Override
    protected void init() {
        super.init();
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks)
    {
        //super.render(p_283479_, p_283661_, p_281248_, p_281886_);
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderBg(guiGraphics, partialTicks, mouseX, mouseY);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        //this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1)
    {
        ResourceLocation texture = new ResourceLocation(MycologyMod.MODID+":textures/screens/magnifying_glass.png");
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    /*@Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY)
    {
        //guiGraphics.drawString(this.font, Component.translatable("gui.particlez.lens_gui.label_info_here"), 96, 8, -12829636, false);
        guiGraphics.drawString(this.font, Component.literal((String)fungusDataModel.getField(FungusDataModel.SPECIES)), 96, 8, -12829636, false);
    }*/
}
