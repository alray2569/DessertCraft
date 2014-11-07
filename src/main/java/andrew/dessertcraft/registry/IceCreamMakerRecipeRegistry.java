package andrew.dessertcraft.registry;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import andrew.dessertcraft.crafting.icecreammaker.IIceCreamMakerRecipe;
import andrew.dessertcraft.crafting.icecreammaker.IceCreamMakerRecipe;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import org.apache.logging.log4j.Level;

public class IceCreamMakerRecipeRegistry {

	public static ArrayList<IIceCreamMakerRecipe> recipes;

	public static void preInit() {
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