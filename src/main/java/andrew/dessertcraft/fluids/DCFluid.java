package andrew.dessertcraft.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class DCFluid extends Fluid {
	
	private final String name;
	
	public DCFluid(String name) {
		super(name);
		this.name = name;
		FluidRegistry.registerFluid(this);
	}
	
	public String getInternalName() {
		return this.name;
	}
	
	
}
