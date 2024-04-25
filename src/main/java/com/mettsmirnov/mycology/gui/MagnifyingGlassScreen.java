package com.mettsmirnov.mycology.gui;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.menu.MagnifyingGlassMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MagnifyingGlassScreen extends AbstractContainerScreen<MagnifyingGlassMenu>
{
    public MagnifyingGlassScreen(MagnifyingGlassMenu p_98409_, Inventory inventory, Component text)
    {
        super(p_98409_, inventory, text);

        this.imageWidth = 176;
        this.imageHeight = 194;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks)
    {
        //super.render(p_283479_, p_283661_, p_281248_, p_281886_);
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
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
    public boolean keyPressed(int key, int b, int c)
    {
        if (key == 256)
        {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY)
    {
        //guiGraphics.drawString(this.font, Component.translatable("gui.particlez.lens_gui.label_info_here"), 96, 8, -12829636, false);
        guiGraphics.drawString(this.font, Component.literal("test info here"), 96, 8, -12829636, false);
    }
}
