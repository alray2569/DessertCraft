package andrew.dessertcraft.fluids;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import andrew.dessertcraft.blocks.DCBlocks;

public final class DCFluids {

	private static boolean preinitialized = false;
	private static boolean initialized = false;

	public static Fluid rum;
	public static Fluid sugarWater;

	public static void preInit() {

		if (!preinitialized) { // Run only once!
			rum = new Rum();
			sugarWater = new SugarWater();

			preinitialized = true;
		}
	}

	public static void init() {
		if (!initialized) {// run only once!
			setBlockAndIcons(rum, DCBlocks.rum);
			setBlockAndIcons(sugarWater, DCBlocks.sugarWater);

			initialized = true;
		}
	}

	private static void setBlockAndIcons(Fluid fluid, Block block) {
		fluid.setBlock(block);
		fluid.setIcons(fluid.getBlock().getIcon(0, 0));
	}

}
