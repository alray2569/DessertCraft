package andrew.dessertcraft.registry;

import java.util.ArrayList;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import andrew.dessertcraft.crafting.FermentationRecipe;
import andrew.dessertcraft.crafting.IFermentationRecipe;

public class FermentationRecipeRegistry {

	private static ArrayList<IFermentationRecipe> recipes;

	public static void init() {
		recipes = new ArrayList<IFermentationRecipe>();
	}

	public static Fluid getFermentationResult(FluidStack fluid) {
		return getOutput(fluid);
	}

	public static Fluid getOutput(FluidStack fluid) {
		if (fluid == null)
			return null;
		for (IFermentationRecipe recipe : recipes) {
			if (recipe.getIn().equals(fluid.getFluid()))
				return recipe.getOut();
		}
		return null;
	}

	public static void addRecipe(String in, String out) {
		recipes.add(new FermentationRecipe(in, out));
	}

	public static void addRecipe(IFermentationRecipe recipe) {
		recipes.add(recipe);
	}

}
