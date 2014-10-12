package andrew.dessertcraft.registry;

import andrew.dessertcraft.crafting.pastrycounter.IPastryCounterRecipe;
import andrew.dessertcraft.crafting.pastrycounter.IPastryCounterShapedRecipe;
import andrew.dessertcraft.crafting.pastrycounter.IPastryCounterShapelessRecipe;
import andrew.dessertcraft.crafting.pastrycounter.PastryCounterCraftingManager;
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
