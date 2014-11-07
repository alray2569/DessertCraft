package andrew.dessertcraft.fluids;

import org.apache.logging.log4j.Level;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import andrew.dessertcraft.DessertCraft;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.lib.DCConstants;

public class SugarWater extends Fluid {

	protected final String name;

	public SugarWater() {
		super("sugarWater");
		this.name = "sugarWater";
		if (FluidRegistry.registerFluid(this) == false) {
			DessertCraft.log(Level.WARN, "Fluid SugarWater failed to register! This could be an issue.");
		}
	}
	
	
}
