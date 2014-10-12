package andrew.dessertcraft.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.crafting.pastrycounter.PastryCounterShapedOreRecipe;
import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.registry.FermentationRecipeRegistry;
import andrew.dessertcraft.registry.IceCreamMakerRecipeRegistry;
import andrew.dessertcraft.registry.PastryCounterRecipeRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public final class DCRecipes {

	private static boolean preinitialized = false;

	public static void init() {

		if (!preinitialized) {
			// Crafting Recipes
			// CHERRY PLANKS
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(
					DCBlocks.cherryPlanks, 4), DCBlocks.cherryLog));

			// CHERRY STAIRS
			GameRegistry.addRecipe(new ItemStack(DCBlocks.cherryStair, 4),
					new Object[] { "S  ", "SS ", "SSS", 'S',
							DCBlocks.cherryPlanks });

			GameRegistry.addRecipe(new ItemStack(DCBlocks.cherryStair, 4),
					new Object[] { "  S", " SS", "SSS", 'S',
							DCBlocks.cherryPlanks });

			// BARREL
			GameRegistry.addRecipe(new ShapedOreRecipe(DCBlocks.barrel,
					new Object[] { "P P", "P P", "PPP", 'P', "plankWood" }));

			// ICE CREAM MAKER
			GameRegistry.addRecipe(new ShapedOreRecipe(DCBlocks.iceCreamMaker,
					new Object[] { "SS ", "WWW", "WWW", 'S', "stickWood", 'W',
							"plankWood" }));

			// PASTRY COUNTER
			GameRegistry
					.addRecipe(new ShapedOreRecipe(DCBlocks.pastryCounter,
							new Object[] { "SS", "WW", 'S', "stone", 'W',
									"plankWood" }));

			// Ice Cream Maker Recipes
			// CHOCOLATE ICE CREAM
			IceCreamMakerRecipeRegistry
					.addRecipe(new ItemStack(DCItems.iceCream_chocolate),
							new ItemStack(Items.dye, 1, 3));
			// CHERRY ICE CREAM
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream_cherry), "foodCherry"));
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream_cherry), "foodCherries"));
			// STRAWBERRY
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream_strawberry),
					"foodStrawberry"));
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream_strawberry),
					"foodStrawberries"));

			// PEANUT BUTTER
			IceCreamMakerRecipeRegistry
					.addRecipe(new IceCreamMakerOreRecipe(new ItemStack(
							DCItems.iceCream_peanutButter), "foodPeanut"));
			IceCreamMakerRecipeRegistry
					.addRecipe(new IceCreamMakerOreRecipe(new ItemStack(
							DCItems.iceCream_peanutButter), "foodPeanuts"));
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream_peanutButter),
					"foodPeanutButter"));

			// Barrel Fermentation Recipes
			FermentationRecipeRegistry.addRecipe("sugarWater", "rum");

			// Pastry Counter Recipes
			// GERMAN CAKE
			PastryCounterRecipeRegistry
					.addRecipe(new PastryCounterShapedOreRecipe(
							DCItems.germanCake, new Object[] { "CCC", "WOW",
									'C', "foodCherry", 'W', "cropWheat", 'O',
									new ItemStack(Items.dye, 1, 3) }));

			PastryCounterRecipeRegistry
					.addRecipe(new PastryCounterShapedOreRecipe(
							DCItems.germanCake, new Object[] { "CCC", "WOW",
									'C', "cropCherry", 'W', "cropWheat", 'O',
									new ItemStack(Items.dye, 1, 3) }));

			preinitialized = true;
		}
	}
}
