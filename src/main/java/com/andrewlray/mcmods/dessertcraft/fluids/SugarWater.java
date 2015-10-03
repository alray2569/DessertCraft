package com.andrewlray.mcmods.dessertcraft.fluids;

import org.apache.logging.log4j.Level;

import com.andrewlray.mcmods.dessertcraft.DessertCraft;
import com.andrewlray.mcmods.dessertcraft.blocks.DCBlocks;
import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

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
