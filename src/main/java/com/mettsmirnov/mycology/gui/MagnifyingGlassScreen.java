package com.mettsmirnov.mycology.gui;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class MagnifyingGlassScreen extends Screen
{
    private final int imageWidth;
    private final int imageHeight;
    private int leftPos;
    private int topPos;
    private final ResourceLocation TEXTURE = new ResourceLocation(MycologyMod.MODID+":textures/screens/magnifying_glass.png");
    private final FungusDataModel fungusDataModel;
    public MagnifyingGlassScreen(FungusDataModel fungusDataModel)
    {
        super(Component.literal("MYTITLE"));
        this.fungusDataModel = fungusDataModel;
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
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        guiGraphics.drawString(this.font, Component.literal((String)fungusDataModel.getField(FungusDataModel.SPECIES)), this.leftPos+6, this.topPos+6, -12829636, false);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
