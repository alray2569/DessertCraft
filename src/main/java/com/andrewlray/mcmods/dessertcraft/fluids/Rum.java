package com.andrewlray.mcmods.dessertcraft.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import org.apache.logging.log4j.Level;

import com.andrewlray.mcmods.dessertcraft.DessertCraft;

public class Rum extends Fluid {

	protected final String name;

	public Rum() {
		super("rum");
		this.name = "rum";
		//this.setUnlocalizedName(Constants.MODID + this.name);
		if (FluidRegistry.registerFluid(this) == false) {
			DessertCraft.log(Level.WARN, "Fluid Rum failed to register! This could be an issue.");
		}
	}

}
