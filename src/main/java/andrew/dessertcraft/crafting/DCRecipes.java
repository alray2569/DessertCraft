package andrew.dessertcraft.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.crafting.icecreammaker.IceCreamMakerOreRecipe;
import andrew.dessertcraft.crafting.mixingbowl.MixingBowlIngredientRecipe;
import andrew.dessertcraft.crafting.mixingbowl.MixingBowlRecipe;
import andrew.dessertcraft.crafting.pastrycounter.PastryCounterShapedOreRecipe;
import andrew.dessertcraft.crafting.pastrycounter.PastryCounterShapelessOreRecipe;
import andrew.dessertcraft.fluids.DCFluids;
import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.registry.FermentationRecipeRegistry;
import andrew.dessertcraft.registry.IceCreamMakerRecipeRegistry;
import andrew.dessertcraft.registry.PastryCounterRecipeRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public final class DCRecipes {

	private static boolean initialized = false;

	public static void init() {

		if (!initialized) {
			// Remove extraneous vanilla recipes
			RecipeRemover.removeRecipe(Items.pumpkin_pie);

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

			// CHERRY SLABS
			GameRegistry.addRecipe(new ItemStack(DCBlocks.cherrySlab, 6),
					new Object[] { "PPP", 'P', DCBlocks.cherryPlanks });

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

			// SUGAR WATER
			GameRegistry.addRecipe(new ItemStack(DCItems.bottleSugarWater),
					new Object[] { "S", "W", 'S', Items.sugar, 'W',
							new ItemStack(Items.potionitem, 1, 0) });

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
			FermentationRecipeRegistry.addRecipe(DCFluids.sugarWater.getName(),
					DCFluids.rum.getName());

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

			// APPLE PIE
			PastryCounterRecipeRegistry
					.addRecipe(new PastryCounterShapedOreRecipe(
							DCItems.applePie, new Object[] { "WAAW", "WWWW",
									'W', "cropWheat", 'A', Items.apple }));

			// Pumpkin Pie
			PastryCounterRecipeRegistry
					.addRecipe(new PastryCounterShapelessOreRecipe(
							Items.pumpkin_pie, new Object[] { Blocks.pumpkin,
									Items.sugar, Items.egg, "cropWheat" }));

			// Mixing Bowl Recipes
			GameRegistry.addRecipe(new MixingBowlIngredientRecipe());

			GameRegistry.addRecipe(new MixingBowlRecipe(new ItemStack(
					DCItems.pudding),
					new Object[] { new ItemStack(Items.milk_bucket),
							new ItemStack(Items.dye, 1, 3),
							new ItemStack(Items.sugar) }));

			initialized = true;
		}
	}
}
