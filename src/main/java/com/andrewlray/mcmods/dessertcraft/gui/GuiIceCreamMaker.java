package com.andrewlray.mcmods.dessertcraft.gui;

import org.lwjgl.opengl.GL11;

import com.andrewlray.mcmods.dessertcraft.container.ContainerIceCreamMaker;
import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;
import com.andrewlray.mcmods.dessertcraft.tileentities.TileEntityIceCreamMaker;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiIceCreamMaker extends GuiContainer {

	private final static ResourceLocation TEXTURE = new ResourceLocation(DCConstants.MODID
			+ ":" + "/textures/gui/iceCreamMakerGui.png");
	private final TileEntityIceCreamMaker iceCreamMaker;

	public GuiIceCreamMaker(InventoryPlayer invPlayer,
			TileEntityIceCreamMaker te) {
		super(new ContainerIceCreamMaker(invPlayer, te));
		iceCreamMaker = te;
		xSize = 176;
		ySize = 187;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.iceCreamMaker.hasCustomInventoryName() ? this.iceCreamMaker
				.getInventoryName() : I18n.format(iceCreamMaker
				.getInventoryName());
		fontRendererObj.drawString(name,
				(xSize - fontRendererObj.getStringWidth(name)) / 2, 6, 4210752);
		fontRendererObj.drawString(I18n.format("container.inventory"), 8,
				ySize - 98 + 5, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		int j1 = iceCreamMaker.getProgressScaled(22);
		this.drawTexturedModalRect(guiLeft + 50, guiTop + 69, 178, 15, j1 + 1,
				15);
		this.drawTexturedModalRect(guiLeft + 125 - j1, guiTop + 69, 199 - j1,
				0, j1 + 1, 15);
		this.drawTexturedModalRect(guiLeft + 81, guiTop + 39, 202, 2, 15,
				j1 + 1);
	}

}
