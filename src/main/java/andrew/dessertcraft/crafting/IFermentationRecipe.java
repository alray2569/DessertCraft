package andrew.dessertcraft.crafting;

import net.minecraftforge.fluids.Fluid;

public interface IFermentationRecipe {
	
	public Fluid getIn();
	
	public Fluid getOut();
	
	public String toString();
}
