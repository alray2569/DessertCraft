package andrew.dessertcraft.liquids;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import andrew.dessertcraft.blocks.DCBlocks;

public final class DCLiquids {

	public static Fluid rum;
	public static Fluid sugarWater;

	public static void preInit() {
		rum = new Rum();
		sugarWater = new SugarWater();
	}
	
	public static void init() {
		setBlockAndIcons(rum, DCBlocks.rum);
		setBlockAndIcons(sugarWater, DCBlocks.sugarWater);
	}
	
	private static void setBlockAndIcons(Fluid fluid, Block block) {
		fluid.setBlock(block);
		fluid.setIcons(fluid.getBlock().getIcon(0, 0));
	}

}
