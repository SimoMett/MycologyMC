package com.simomett.mycologymod.gui;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.gui.menu.MagnifyingGlassMenu;
import com.simomett.mycologymod.tags.ModBlockTags;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MagnifyingGlassScreen extends AbstractContainerScreen<MagnifyingGlassMenu>
{
    private final int imageWidth;
    private final int imageHeight;
    private int leftPos;
    private int topPos;
    private final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MycologyMod.MODID, "textures/screens/magnifying_glass.png");

    public MagnifyingGlassScreen(MagnifyingGlassMenu magnifyingGlassMenu, Inventory inventory, Component component)
    {
        super(magnifyingGlassMenu, inventory, Component.empty());
        this.imageWidth = 176;
        this.imageHeight = 194;
    }

    @Override
    protected void init()
    {
        super.init();
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;
    }

    private void drawWidgets(GuiGraphics guiGraphics, int xOrigin, int yOrigin)
    {
        guiGraphics.drawString(this.font, Component.literal(menu.fungusGenoma.getDominantTraits().species()), xOrigin, yOrigin, -12829636, false);
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
        guiGraphics.drawString(this.font, ModBlockTags.getTranslatableComponent(menu.fungusGenoma.getDominantTraits().terrain()), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(menu.fungusGenoma.getDominantTraits().light())), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(menu.fungusGenoma.getDominantTraits().humidity())), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(menu.fungusGenoma.getDominantTraits().temp())), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(menu.fungusGenoma.getDominantTraits().spreading())), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(menu.fungusGenoma.getDominantTraits().spreadboost())), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(menu.fungusGenoma.getDominantTraits().area())), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);
        guiGraphics.drawString(this.font, Component.literal(String.valueOf(menu.fungusGenoma.getDominantTraits().effect())), xOrigin+d, yOrigin+a+(b+=o), -12829636, false);

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
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1)
    {
        guiGraphics.blit(RenderType::guiTextured, TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        drawWidgets(guiGraphics, this.leftPos+6, this.topPos+6);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY)
    {
        //guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
        //guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
