package com.andrewlray.mcmods.dessertcraft.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import org.apache.logging.log4j.Level;

import com.andrewlray.mcmods.dessertcraft.DessertCraft;
import com.andrewlray.mcmods.dessertcraft.blocks.DCBlocks;
import com.andrewlray.mcmods.dessertcraft.crafting.icecreammaker.IceCreamMakerOreRecipe;
import com.andrewlray.mcmods.dessertcraft.crafting.mixingbowl.MixingBowlIngredientRecipe;
import com.andrewlray.mcmods.dessertcraft.crafting.mixingbowl.MixingBowlRecipe;
import com.andrewlray.mcmods.dessertcraft.crafting.pastrycounter.PastryCounterShapedOreRecipe;
import com.andrewlray.mcmods.dessertcraft.crafting.pastrycounter.PastryCounterShapelessOreRecipe;
import com.andrewlray.mcmods.dessertcraft.fluids.DCFluids;
import com.andrewlray.mcmods.dessertcraft.items.DCItems;
import com.andrewlray.mcmods.dessertcraft.registry.FermentationRecipeRegistry;
import com.andrewlray.mcmods.dessertcraft.registry.IceCreamMakerRecipeRegistry;
import com.andrewlray.mcmods.dessertcraft.registry.PastryCounterRecipeRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

public final class DCRecipes {
	
	private static boolean initialized = false;
	
	public static void init() {
		
		if (!initialized) {
			// Remove extraneous vanilla recipes
			RecipeRemover.removeRecipe(Items.pumpkin_pie);
			
			// Furnace Recipes
			GameRegistry.addSmelting(DCBlocks.cherryLog, new ItemStack(Items.coal, 1, 1), 0);
			
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
					new Object[] { "SS ", "WWW", "WWW", 'S', "stickWood", 'W', "plankWood" }));
			
			// PASTRY COUNTER
			GameRegistry.addRecipe(new ShapedOreRecipe(DCBlocks.pastryCounter,
					new Object[] { "SSS", "WWW", "WWW", 'S', "stone", 'W', "plankWood" }));
			
			// SUGAR WATER
			GameRegistry.addRecipe(new ItemStack(DCItems.bottleSugarWater),
					new Object[] { "S", "W", 'S', Items.sugar, 'W', new ItemStack(Items.potionitem, 1, 0) });
			
			// MIXING BOWL
			GameRegistry.addRecipe(new ItemStack(DCItems.mixingBowl), new Object[] { "B", 'B', Items.bowl });
			
			// TRIFLE
			GameRegistry.addRecipe(new ShapelessOreRecipe(DCItems.trifle,
					"foodPudding", "foodCake", "foodStrawberries"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(DCItems.trifle,
					"foodPudding", "foodCake", "foodStrawberry"));
			
			// Ice Cream Maker Recipes
			// CHOCOLATE ICE CREAM
			IceCreamMakerRecipeRegistry.addRecipe(new ItemStack(
					DCItems.iceCream, 1, 0), new ItemStack(Items.dye, 1, 3));
			// CHERRY ICE CREAM
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream, 1, 1), "foodCherry"));
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream, 1, 1), "foodCherries"));
			// STRAWBERRY
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream, 1, 2), "foodStrawberry"));
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream, 1, 2), "foodStrawberries"));
			
			// PEANUT BUTTER
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream, 1, 3), "foodPeanut"));
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream, 1, 3), "foodPeanuts"));
			IceCreamMakerRecipeRegistry.addRecipe(new IceCreamMakerOreRecipe(
					new ItemStack(DCItems.iceCream, 1, 3), "foodPeanutButter"));
			
			// Barrel Fermentation Recipes
			FermentationRecipeRegistry.addRecipe(DCFluids.sugarWater.getName(),
					DCFluids.rum.getName());
			
			// Pastry Counter Recipes
			// GERMAN CAKE
			PastryCounterRecipeRegistry.addRecipe(new PastryCounterShapedOreRecipe(DCItems.germanCake,
					new Object[] { "CCC", "WOW", 'C', "foodCherry", 'W', "cropWheat", 'O', new ItemStack(Items.dye, 1, 3) }));
			
			PastryCounterRecipeRegistry.addRecipe(new PastryCounterShapedOreRecipe(DCItems.germanCake,
					new Object[] { "CCC", "WOW", 'C', "cropCherry", 'W', "cropWheat", 'O', new ItemStack(Items.dye, 1, 3) }));
			
			// APPLE PIE
			PastryCounterRecipeRegistry.addRecipe(new PastryCounterShapedOreRecipe(DCItems.applePie,
					new Object[] { "WAAW", "WWWW", 'W', "cropWheat", 'A', Items.apple }));
			
			// Pumpkin Pie
			PastryCounterRecipeRegistry.addRecipe(new PastryCounterShapelessOreRecipe(Items.pumpkin_pie,
					new Object[] { Blocks.pumpkin, Items.sugar, Items.egg, "cropWheat" }));
			
			PastryCounterRecipeRegistry.addRecipe(new PastryCounterShapelessOreRecipe(DCItems.rumCake,
					new Object[] { DCItems.bottleRum, Items.sugar, Items.milk_bucket, Items.egg }));
			
			// Mixing Bowl Recipes
			GameRegistry.addRecipe(new MixingBowlIngredientRecipe());
			
			GameRegistry.addRecipe(new MixingBowlRecipe(new ItemStack(DCItems.pudding),
					new Object[] { new ItemStack(Items.milk_bucket), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.sugar) }));
			
			GameRegistry.addRecipe(new MixingBowlRecipe(new ItemStack(DCItems.rumBall),
					new Object[] { new ItemStack(DCItems.bottleRum), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.sugar), new ItemStack(DCItems.peanut) }));
			
			initialized = true;
		}
	}
}
