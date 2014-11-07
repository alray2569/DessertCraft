package andrew.dessertcraft.handler;

import org.apache.logging.log4j.Level;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import andrew.dessertcraft.DessertCraft;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.container.ContainerBarrel;
import andrew.dessertcraft.container.ContainerIceCreamMaker;
import andrew.dessertcraft.container.ContainerPastryCounter;
import andrew.dessertcraft.gui.GuiBarrel;
import andrew.dessertcraft.gui.GuiIceCreamMaker;
import andrew.dessertcraft.gui.GuiPastryCounter;
import andrew.dessertcraft.tileentities.TileEntityBarrel;
import andrew.dessertcraft.tileentities.TileEntityIceCreamMaker;
import cpw.mods.fml.common.network.IGuiHandler;

public class DCGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (id) {
			case DCBlocks.GUI_ID_ICECREAMMAKER:
				if (entity instanceof TileEntityIceCreamMaker) {
					return new ContainerIceCreamMaker(player.inventory,
							(TileEntityIceCreamMaker) entity);
				} 
				DessertCraft.log(Level.ERROR, "An IceCreamMaker exists that does not contain a TileEntityIceCreamMaker");
				return null;
			case DCBlocks.GUI_ID_BARREL:
				if (entity instanceof TileEntityBarrel) {
					return new ContainerBarrel(player.inventory,
							(TileEntityBarrel) entity);
				}
				DessertCraft.log(Level.ERROR, "A Barrel exists that does not contain a TileEntityBarrel");
				return null;
			}
		} else if (id == DCBlocks.GUI_ID_PASTRYCOUNTER) {
			if (world.getBlock(x, y, z) == DCBlocks.pastryCounter) {
				return new ContainerPastryCounter(player.inventory, world, x, y, z);
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {

		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (id) {
			case DCBlocks.GUI_ID_ICECREAMMAKER:
				if (entity instanceof TileEntityIceCreamMaker) {
					return new GuiIceCreamMaker(player.inventory,
							(TileEntityIceCreamMaker) entity);
				}
				DessertCraft.log(Level.ERROR, "An IceCreamMaker exists that does not contain a TileEntityIceCreamMaker");
				return null;
			case DCBlocks.GUI_ID_BARREL:
				if (entity instanceof TileEntityBarrel) {
					return new GuiBarrel(player.inventory,
							(TileEntityBarrel) entity);
				}
				DessertCraft.log(Level.ERROR, "A Barrel exists that does not contain a TileEntityBarrel");
				return null;
			}
		} else if (id == DCBlocks.GUI_ID_PASTRYCOUNTER) {
			if (world.getBlock(x, y, z) == DCBlocks.pastryCounter) {
				return new GuiPastryCounter(player.inventory, world, x, y, z);
			} else {
				return null;
			}
		}
		return null;
	}

}
