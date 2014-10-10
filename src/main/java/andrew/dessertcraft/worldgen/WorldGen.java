package andrew.dessertcraft.worldgen;

import andrew.dessertcraft.worldgen.DCWorldGen;
import net.minecraft.world.World;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGen {

	private final static IWorldGenerator CHERRY_GEN = new DCWorldGen();
	
	public static void init() {
		
		GameRegistry.registerWorldGenerator(CHERRY_GEN, 100000);
	}
	
}
