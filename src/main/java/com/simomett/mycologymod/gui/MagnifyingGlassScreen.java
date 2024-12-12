package com.simomett.mycologymod.gui;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.genetics.FungusGenoma;
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
    private final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, ":textures/screens/magnifying_glass.png");
    private final FungusGenoma fungusGenoma;
    public MagnifyingGlassScreen(FungusGenoma fungusGenoma)
    {
        super(Component.literal("MYTITLE"));
        this.fungusGenoma = fungusGenoma;
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
        guiGraphics.drawString(this.font, Component.literal((String) fungusGenoma.getField(FungusGenoma.SPECIES)), xOrigin, yOrigin, -12829636, false);
        //Index column
        int a = 6;
        final int o = 10;
        int b = o;
        int d = 0;
        guiGraphics.drawString(this.font, Component.translatable("gui.magnifyingglass.terrain"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.magnifyingglass.light"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.magnifyingglass.humidity"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.magnifyingglass.temp"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.magnifyingglass.spreading"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.magnifyingglass.spreadboost"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.magnifyingglass.area"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.magnifyingglass.effect"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);

        //Dominant column
        b = 0;
        d = 83;
        guiGraphics.drawString(this.font, Component.translatable("gui.magnifyingglass.dominant"), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusGenoma.getField(FungusGenoma.TERRAIN))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusGenoma.getField(FungusGenoma.LIGHT))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusGenoma.getField(FungusGenoma.HUMIDITY))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusGenoma.getField(FungusGenoma.TEMP))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusGenoma.getField(FungusGenoma.SPREADING))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusGenoma.getField(FungusGenoma.SPREAD_BOOST))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusGenoma.getField(FungusGenoma.AREA))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusGenoma.getField(FungusGenoma.EFFECT))), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);

        //Recessive column
        //Kinda unreal to have all genoma by just looking through a magnifying glass
        /*b = 0;
        int c = 100;
        guiGraphics.drawString(this.font, Component.literal("recessive"), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.TERRAIN, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.LIGHT, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.HUMIDITY, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.TEMP, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.SPREADING, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.SPREAD_BOOST, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.AREA, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(fungusDataModel.getField(FungusDataModel.EFFECT, IFungusData.GeneType.RECESSIVE))), xOrigin+c, yOrigin+a+(b+=o), -12829636, false);*/
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
