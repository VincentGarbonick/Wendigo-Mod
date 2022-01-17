package com.ThaddeusHalifax.WendigoMod.screens;

import com.ThaddeusHalifax.WendigoMod.Wendigo;
import com.ThaddeusHalifax.WendigoMod.container.FleshAltarContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.util.WeakHashMap;

public class FleshAltarScreen extends ContainerScreen<FleshAltarContainer>
{
    private final ResourceLocation GUI = new ResourceLocation(Wendigo.MOD_ID,
            "textures/gui/flesh_altar_gui.png");

    public FleshAltarScreen(FleshAltarContainer screenContainer, PlayerInventory inv, ITextComponent titleIn)
    {
        super(screenContainer,inv,titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int x, int y, float partialTicks)
    {
        this.renderBackground(matrixStack);
        super.render(matrixStack, x, y, partialTicks);
        this.renderComponentHoverEffect(matrixStack, null, x, y);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y)
    {
        RenderSystem.color4f(1f, 1f,1f,1f);
        this.minecraft.getTextureManager().bind(GUI);
        int i = this.getGuiLeft();
        int j = this.getGuiTop();
        this.blit(matrixStack, i, j, 0, 0, this.getXSize(), this.getYSize());
        //TODO for loading in sprite for moon phase

    }




}
