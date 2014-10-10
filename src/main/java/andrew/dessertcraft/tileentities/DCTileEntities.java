package andrew.dessertcraft.tileentities;

import andrew.dessertcraft.tileentities.TileEntityIceCreamMaker;
import cpw.mods.fml.common.registry.GameRegistry;

public class DCTileEntities {

	public static void init() {
		GameRegistry.registerTileEntity(TileEntityIceCreamMaker.class, "IceCreamMaker");
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "Barrel");
	}
}
