package com.mettsmirnov.mycology.gui;

import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.capabilities.FungusDataModel;
import com.mettsmirnov.mycology.capabilities.IFungusData;
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

    private void drawWidgets(GuiGraphics guiGraphics, int xOrigin, int yOrigin)
    {
        guiGraphics.drawString(this.font, Component.literal((String)fungusDataModel.getField(FungusDataModel.SPECIES)), xOrigin, yOrigin, -12829636, false);
        //Dominant column
        int a = 6;
        int b = 0;
        final int o = 10;
        int d = 0;
        guiGraphics.drawString(this.font, Component.literal("dominant"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.TERRAIN))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.LIGHT))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.HUMIDITY))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.TEMP))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.SPREADING))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.SPREAD_BOOST))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.AREA))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.EFFECT))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);

        //Recessive column
        b = 0;
        int c = 100;
        guiGraphics.drawString(this.font, Component.literal("recessive"), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.TERRAIN, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.LIGHT, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.HUMIDITY, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.TEMP, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.SPREADING, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.SPREAD_BOOST, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.AREA, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.EFFECT, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks)
    {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        drawWidgets(guiGraphics, this.leftPos+6, this.topPos+6);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
