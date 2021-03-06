package com.andrewlray.mcmods.dessertcraft.tileentities;

import com.andrewlray.mcmods.dessertcraft.tileentities.TileEntityIceCreamMaker;

import cpw.mods.fml.common.registry.GameRegistry;

public class DCTileEntities {

	private static boolean initialized = false;

	public static void preInit() {

		if (!initialized) { // Only run once!
			GameRegistry.registerTileEntity(TileEntityIceCreamMaker.class,
					"IceCreamMaker");
			GameRegistry.registerTileEntity(TileEntityBarrel.class, "Barrel");

			initialized = true;
		}
	}
}
