package com.simomett.mycologymod.client.screen;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.menu.AnalysingStationMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class AnalysingStationScreen extends AbstractContainerScreen<AnalysingStationMenu>
{
    private static final Identifier CONTAINER_TEXTURE = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/gui/analysing_station.png");

    public AnalysingStationScreen(AnalysingStationMenu menu, Inventory inventory, Component title)
    {
        super(menu, inventory, title);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        super.extractBackground(graphics, mouseX, mouseY, delta);
        graphics.blit(RenderPipelines.GUI_TEXTURED, CONTAINER_TEXTURE, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, BACKGROUND_TEXTURE_WIDTH, BACKGROUND_TEXTURE_HEIGHT);
    }
}
