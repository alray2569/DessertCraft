package com.andrewlray.mcmods.dessertcraft.registry;

import com.andrewlray.mcmods.dessertcraft.crafting.pastrycounter.IPastryCounterRecipe;
import com.andrewlray.mcmods.dessertcraft.crafting.pastrycounter.IPastryCounterShapedRecipe;
import com.andrewlray.mcmods.dessertcraft.crafting.pastrycounter.IPastryCounterShapelessRecipe;
import com.andrewlray.mcmods.dessertcraft.crafting.pastrycounter.PastryCounterCraftingManager;

import net.minecraft.item.ItemStack;

public class PastryCounterRecipeRegistry {

	public static void addRecipe(ItemStack stack, Object... objs) {
		PastryCounterCraftingManager.getInstance().addRecipe(stack, objs);
	}

	public static void addRecipe(IPastryCounterRecipe recipe) {
		if (recipe instanceof IPastryCounterShapedRecipe)
			PastryCounterCraftingManager.getInstance().addRecipe(
					(IPastryCounterShapedRecipe) recipe);
		else if (recipe instanceof IPastryCounterShapelessRecipe)
			PastryCounterCraftingManager.getInstance().addShapelessRecipe(
					(IPastryCounterShapelessRecipe) recipe);
	}

	public static void addRecipe(ItemStack stack, Object obj) {
		PastryCounterCraftingManager.getInstance().addShapelessRecipe(stack, obj);
	}
}
