package andrew.dessertcraft.renderers;

import org.lwjgl.opengl.GL11;

import andrew.dessertcraft.lib.DCConstants;
import andrew.dessertcraft.models.ModelBarrel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderBarrel extends TileEntitySpecialRenderer {

	private static final ResourceLocation TEXTURE = new ResourceLocation(
			DCConstants.MODID + ":" + "textures/models/Barrel.png");

	private ModelBarrel model;

	public RenderBarrel() {
		this.model = new ModelBarrel();
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
