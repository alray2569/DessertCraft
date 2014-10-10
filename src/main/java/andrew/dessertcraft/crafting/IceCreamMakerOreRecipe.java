package andrew.dessertcraft.crafting;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class IceCreamMakerOreRecipe implements IIceCreamMakerRecipe {
	
	private final String oreIn;
	private final ItemStack out;

	public IceCreamMakerOreRecipe(ItemStack out, String in) {
		this.out = out;
		this.oreIn = in;
	}

	@Override
	public ArrayList<ItemStack> getIn() {
		return OreDictionary.getOres(oreIn);
	}

	@Override
	public ItemStack getOut() {
		return out;
	}
	
	@Override
	public String toString() {
		return oreIn + " -> " + out.toString();
	}

}
