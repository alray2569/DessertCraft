package com.andrewlray.mcmods.dessertcraft.worldgen;

import com.andrewlray.mcmods.dessertcraft.worldgen.DCWorldGen;

import net.minecraft.world.World;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGen {

	private static boolean initialized = false;

	private final static IWorldGenerator CHERRY_GEN = new DCWorldGen();
	
	public static void init() {

		if (!initialized) {
			GameRegistry.registerWorldGenerator(CHERRY_GEN, 100000);
			
			initialized = true;
		}
	}

}
