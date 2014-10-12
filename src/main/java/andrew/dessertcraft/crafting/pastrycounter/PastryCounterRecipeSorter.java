package andrew.dessertcraft.crafting.pastrycounter;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class PastryCounterRecipeSorter implements Comparator {

	final PastryCounterCraftingManager pastryCounterCraftingManager;

	public PastryCounterRecipeSorter(PastryCounterCraftingManager pccm) {
		this.pastryCounterCraftingManager = pccm;
	}

	public int compareRecipes(IRecipe recipe1, IRecipe recipe2) {
		if (recipe1 instanceof IPastryCounterShapelessRecipe
				&& recipe2 instanceof IPastryCounterShapedRecipe) {
			return 1;
		} else if (recipe2 instanceof IPastryCounterShapedRecipe
				&& recipe1 instanceof IPastryCounterShapelessRecipe) {
			return -1;
		} else if (recipe1.getRecipeSize() > recipe2.getRecipeSize()) {
			return -1;
		} else if (recipe2.getRecipeSize() > recipe1.getRecipeSize()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}
