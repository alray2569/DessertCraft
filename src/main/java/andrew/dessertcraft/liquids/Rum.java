package andrew.dessertcraft.liquids;

import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.lib.DCConstants;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Rum extends Fluid {

	protected final String name;

	public Rum() {
		super("rum");
		this.name = "rum";
		//this.setUnlocalizedName(Constants.MODID + this.name);
		FluidRegistry.registerFluid(this);
	}

}
