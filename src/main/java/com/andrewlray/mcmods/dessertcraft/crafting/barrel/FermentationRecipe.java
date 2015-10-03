package com.andrewlray.mcmods.dessertcraft.crafting.barrel;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class FermentationRecipe implements IFermentationRecipe {

	private final Fluid in;
	private final Fluid out;
	
	public FermentationRecipe(String in, String out) {
		this.in = FluidRegistry.getFluid(in.toLowerCase());
		this.out = FluidRegistry.getFluid(out.toLowerCase());
	}
	
	@Override
	public Fluid getIn() {
		return in;
	}

	@Override
	public Fluid getOut() {
		return this.out;
	}
	
	@Override
	public String toString() {
		return this.in + " -> " + this.out;
	}

}
