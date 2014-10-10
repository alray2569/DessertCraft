package andrew.dessertcraft.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.container.ContainerBarrel;
import andrew.dessertcraft.container.ContainerIceCreamMaker;
import andrew.dessertcraft.gui.GuiBarrel;
import andrew.dessertcraft.gui.GuiIceCreamMaker;
import andrew.dessertcraft.tileentities.TileEntityBarrel;
import andrew.dessertcraft.tileentities.TileEntityIceCreamMaker;
import cpw.mods.fml.common.network.IGuiHandler;

public class DCGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (ID) {
			case DCBlocks.GUI_ID_ICECREAMMAKER:
				if (entity instanceof TileEntityIceCreamMaker) {
					return new ContainerIceCreamMaker(player.inventory,
							(TileEntityIceCreamMaker) entity);
				}
				return null;
			case DCBlocks.GUI_ID_BARREL:
				if (entity instanceof TileEntityBarrel) {
					return new ContainerBarrel(player.inventory,
							(TileEntityBarrel) entity);
				}
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (ID) {
			case DCBlocks.GUI_ID_ICECREAMMAKER:
				if (entity instanceof TileEntityIceCreamMaker) {
					return new GuiIceCreamMaker(player.inventory,
							(TileEntityIceCreamMaker) entity);
				}
				return null;
			case DCBlocks.GUI_ID_BARREL:
				if (entity instanceof TileEntityBarrel) {
					return new GuiBarrel(player.inventory,
							(TileEntityBarrel) entity);
				}
			}
		}
		return null;
	}

}
