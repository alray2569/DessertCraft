package andrew.dessertcraft.registry;

import java.util.ArrayList;
import java.util.LinkedList;

import andrew.dessertcraft.crafting.IIceCreamMakerRecipe;
import andrew.dessertcraft.crafting.IceCreamMakerRecipe;
import andrew.dessertcraft.items.DCItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class IceCreamMakerRecipeRegistry {

	public static ArrayList<IIceCreamMakerRecipe> recipes;

	public static void init() {
		recipes = new ArrayList<IIceCreamMakerRecipe>();
	}

	public static ItemStack getChurnResult(ItemStack item) {
		//System.out.println("Call to getChurnResult()");
		return getOutput(item.getItem(), item.getItemDamage());
	}

	public static ItemStack getOutput(Item item, int damage) {
		for (IIceCreamMakerRecipe recipe : recipes) {
			for (int i = 0; i < recipe.getIn().size(); i++) {
				//System.out.println(recipe.getIn().get(i).getItem().getClass().toString() + "\n" + recipe.getIn().get(i).getItemDamage());
				if (recipe.getIn().get(i).getItem().getClass().equals(item.getClass()) && recipe.getIn().get(i).getItemDamage() == damage)
					return recipe.getOut();
			}
		}
		return null;
	}

	public static void addRecipe(ItemStack in, ItemStack out) {
		recipes.add(new IceCreamMakerRecipe(in, out));
	}

	public static void addRecipe(IIceCreamMakerRecipe recipe) {
		recipes.add(recipe);
	}

}