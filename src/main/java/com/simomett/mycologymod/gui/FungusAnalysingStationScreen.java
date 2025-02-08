package com.simomett.mycologymod.gui;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.gui.menu.FungusAnalysingStationMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

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
        this.imageWidth = 256;
        this.imageHeight = 256;
    }

    @Override
    protected void init()
    {
        super.init();
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1)
    {
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
    }
}
