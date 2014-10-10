package andrew.dessertcraft.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;

import org.lwjgl.opengl.GL11;

import andrew.dessertcraft.DessertCraft;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.container.ContainerBarrel;
import andrew.dessertcraft.lib.DCConstants;
import andrew.dessertcraft.tileentities.TileEntityBarrel;

public class GuiBarrel extends GuiContainer {

	private static final String BUTTON0_TEXT = I18n.format(DCConstants.MODID
			+ "_" + DCConstants.GUI_BARREL_FERMENT);
	private static final String BUTTON1_TEXT = I18n.format(DCConstants.MODID
			+ "_" + DCConstants.GUI_BARREL_EMPTY_BUTTON);
	private static final int BUTTON_WIDTH = Math.max(
			Minecraft.getMinecraft().fontRenderer.getStringWidth(BUTTON0_TEXT),
			Minecraft.getMinecraft().fontRenderer.getStringWidth(BUTTON1_TEXT));
	private static final int BUTTON_PADDING = 5;

	private static final ResourceLocation TEXTURE = new ResourceLocation(
			DCConstants.MODID + ":" + "/textures/gui/barrelGui.png");
	private final TileEntityBarrel barrelTE;

	public GuiBarrel(InventoryPlayer inventory, TileEntityBarrel entity) {
		super(new ContainerBarrel(inventory, entity));
		barrelTE = entity;
		xSize = 176;
		ySize = 148;
	}

	@Override
	public void initGui() {
		super.initGui();

		this.buttonList
				.add(new GuiButton(0, guiLeft + xSize - 5
						- (2 * BUTTON_PADDING) - BUTTON_WIDTH, guiTop + 17
						- BUTTON_PADDING, 2 * BUTTON_PADDING + BUTTON_WIDTH,
						fontRendererObj.FONT_HEIGHT + 2 * BUTTON_PADDING,
						BUTTON0_TEXT));
		this.buttonList.add(new GuiButton(1, guiLeft + xSize - 5
				- (2 * BUTTON_PADDING) - BUTTON_WIDTH, guiTop + 22
				+ fontRendererObj.FONT_HEIGHT + BUTTON_PADDING, 2
				* BUTTON_PADDING + BUTTON_WIDTH, fontRendererObj.FONT_HEIGHT
				+ 2 * BUTTON_PADDING, BUTTON1_TEXT));
	}

	@Override
	public void actionPerformed(GuiButton button) {
		int i, j;
		switch (button.id) {
		case 0: // Ferment
			i = DCBlocks.GUI_ID_BARREL;
			j = 0;
			break;
		default:
			i = -1;
			j = -1;
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream(
				(2 * Byte.SIZE + 3 * Integer.SIZE) / 8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			outputStream.writeByte(i);
			outputStream.writeInt(this.barrelTE.xCoord);
			outputStream.writeInt(this.barrelTE.yCoord);
			outputStream.writeInt(this.barrelTE.zCoord);
			outputStream.writeByte(j);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println(outputStream.toString());

		S3FPacketCustomPayload packet = new S3FPacketCustomPayload(
				DCConstants.MODID, bos.toByteArray());

		DessertCraft.dcnet.sendToServer(new FMLProxyPacket(packet));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.barrelTE.hasCustomInventoryName() ? this.barrelTE
				.getInventoryName() : I18n.format(barrelTE.getInventoryName());
		fontRendererObj.drawString(name, 10, 6, 4210752);

		if (this.barrelTE.getTank().getFluid() != null) {
			String fluidInfo = this.barrelTE.getTank().getFluid().getFluid()
					.getName()
					+ ": " + this.barrelTE.getTank().getFluid().amount + "mB";
			fluidInfo = fluidInfo.substring(0, 1).toUpperCase()
					.concat(fluidInfo.substring(1));

			fontRendererObj.drawString(fluidInfo, 10, 30, 4210752);
		} else
			fontRendererObj.drawString(I18n.format(DCConstants.GUI_BARREL_EMPTY_TEXT),
					10, 30, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		this.drawTexturedModalRect(guiLeft + 10, guiTop + 17, 0 + BUTTON_WIDTH
				+ BUTTON_PADDING + 4, 158, 157 - BUTTON_WIDTH - 4
				- BUTTON_PADDING, 11);
		this.drawTexturedModalRect(guiLeft + 7, guiTop + 43, 176, 24, 18, 18);
		this.drawTexturedModalRect(guiLeft + 7 + 2 * 18, guiTop + 43, 176 + 18,
				24, 18, 18);

		int j1 = this.barrelTE.getFluidContentsScaled(156 - BUTTON_WIDTH - 4
				- BUTTON_PADDING);
		int k1 = this.barrelTE.getProgressScaled(29);

		// if (this.barrelTE.getTank().getFluidAmount() != 0) {
		// this.drawTexturedModelRectFromIcon(guiLeft + 10, guiTop + 18,
		// this.barrelTE.getTank().getFluid().getFluid().getIcon(),
		// j1, 9);
		// }

		this.drawTexturedModalRect(guiLeft + 10, guiTop + 18, 0, 149, j1, 9);
		this.drawTexturedModalRect(guiLeft + 67, guiTop + 46, 176, 0, k1, 11);
	}

}
