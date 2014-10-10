package andrew.dessertcraft.crafting;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class IceCreamMakerRecipe implements IIceCreamMakerRecipe {

	private final ItemStack in;
	private final ItemStack out;

	public IceCreamMakerRecipe(ItemStack out, ItemStack in) {
		this.in = in;
		this.out = out;
	}

	@Override
	public ArrayList<ItemStack> getIn() {
		ArrayList<ItemStack> inArray = new ArrayList<ItemStack>();
		inArray.add(this.in);
		return inArray;
	}

	@Override
	public ItemStack getOut() {
		return out;
	}

	@Override
	public String toString() {
		return in.toString() + " -> " + out.toString();
	}

}
