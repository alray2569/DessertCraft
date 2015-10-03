package com.andrewlray.mcmods.dessertcraft.renderers;

import org.lwjgl.opengl.GL11;

import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;
import com.andrewlray.mcmods.dessertcraft.models.ModelIceCreamMaker;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderIceCreamMaker extends TileEntitySpecialRenderer {

	private static final ResourceLocation TEXTURE = new ResourceLocation(
			DCConstants.MODID + ":" + "textures/models/IceCreamMaker.png");

	private ModelIceCreamMaker model;

	public RenderIceCreamMaker() {
		this.model = new ModelIceCreamMaker();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z,
			float f) {
		GL11.glPushMatrix();
		{
			GL11.glTranslatef((float) x + .5f, (float) y + 1.5f,
					(float) z + .5f);
			GL11.glRotatef(180, 0f, 0f, 1f);

			this.bindTexture(TEXTURE);

			GL11.glPushMatrix();
			{
				this.model.renderModel(0.0625f);
			}
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();

	}

}
