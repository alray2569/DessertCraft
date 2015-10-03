package com.andrewlray.mcmods.dessertcraft.crafting.icecreammaker;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public interface IIceCreamMakerRecipe {
	
	public ArrayList<ItemStack> getIn();
	
	public ItemStack getOut();
	
	public String toString();
}
