package andrew.dessertcraft.liquids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.lib.DCConstants;

public class SugarWater extends Fluid {

	protected final String name;

	public SugarWater() {
		super("sugarWater");
		this.name = "sugarWater";
		FluidRegistry.registerFluid(this);
	}
	
	
}
