package com.andrewlray.mcmods.dessertcraft.registry;

import java.util.ArrayList;

import com.andrewlray.mcmods.dessertcraft.crafting.barrel.FermentationRecipe;
import com.andrewlray.mcmods.dessertcraft.crafting.barrel.IFermentationRecipe;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class FermentationRecipeRegistry {

	private static ArrayList<IFermentationRecipe> recipes;

	public static void preInit() {
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
