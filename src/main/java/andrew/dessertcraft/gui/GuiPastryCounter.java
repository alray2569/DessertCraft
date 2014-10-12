package andrew.dessertcraft.gui;

import static andrew.dessertcraft.lib.DCConstants.MODID;
import static andrew.dessertcraft.lib.DCConstants.PASTRY_COUNTER;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import andrew.dessertcraft.container.ContainerPastryCounter;

public class GuiPastryCounter extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation(MODID
			+ ":" + "textures/gui/" + "pastryCounterGui.png");

	public static final int GRID_TOPLEFT_X = 25;
	public static final int GRID_TOPLEFT_Y = 25;
	public static final int GRID_SPACING = 0;
	public static final int SLOT_SIZE = 18;
	public static final int INVENTORY_TOPLEFT_X = 8;
	public static final int INVENTORY_TOPLEFT_Y = 130;
	private static final int X_SIZE = 176;
	private static final int Y_SIZE = 212;
	public static final int OUTPUT_X = 131;
	public static final int OUTPUT_Y = 61;

	public GuiPastryCounter(InventoryPlayer playerInv, World world, int x,
			int y, int z) {
		super(new ContainerPastryCounter(playerInv, world, x, y, z));

		this.xSize = X_SIZE;
		this.ySize = Y_SIZE;
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {

		this.fontRendererObj
				.drawString(
						I18n.format("container.dessertcraft_pastryCounter.name"),
						(xSize - fontRendererObj.getStringWidth(I18n
								.format("container.dessertcraft_pastryCounter.name"))) / 2,
						5, 0x000000);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int i,
			int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		drawTexturedModalRect(guiLeft + OUTPUT_X, guiTop + OUTPUT_Y, xSize, 0,
				SLOT_SIZE, SLOT_SIZE);

		for (int xpos = GRID_TOPLEFT_X; xpos < GRID_TOPLEFT_X
				+ (GRID_SPACING + SLOT_SIZE) * 5; xpos += (GRID_SPACING + SLOT_SIZE)) {
			for (int ypos = GRID_TOPLEFT_Y; ypos < GRID_TOPLEFT_Y
					+ (GRID_SPACING + SLOT_SIZE) * 5; ypos += (GRID_SPACING + SLOT_SIZE)) {
				drawTexturedModalRect(guiLeft + xpos, guiTop + ypos, xSize, 0,
						SLOT_SIZE, SLOT_SIZE);
			}
		}
	}
}
