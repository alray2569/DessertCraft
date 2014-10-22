package andrew.dessertcraft.crafting;

import java.util.ArrayList;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.items.MixingBowl;

public class MixingBowlRecipe implements IRecipe {

	ItemStack output;
	ArrayList<Object> ingredients;

	public MixingBowlRecipe(ItemStack output, Object[] ingredients) {
		this.output = output;
		ArrayList<Object> arraylist = new ArrayList<Object>();
		for (Object ingredient : ingredients) {
			arraylist.add(ingredient);
		}

		this.ingredients = arraylist;
	}

	@Override
	public boolean matches(InventoryCrafting inventory, World world) {
		ItemStack mixingbowl = null;
		for (int i = 0; i < inventory.getSizeInventory(); ++i) {
			ItemStack stackInSlot = inventory.getStackInSlot(i);
			if (stackInSlot != null) {
				if (stackInSlot.getItem() == DCItems.mixingBowl) {
					mixingbowl = stackInSlot;
				} else {
					return false;
				}
			}
		}
		if (mixingbowl == null) {
			return false;
		}
		System.out.println("NBT: "
				+ ((MixingBowl) mixingbowl.getItem()).readNBT(mixingbowl));
		System.out.println("INGREDIENTS: " + ingredients);
		for (Object ingredient : ingredients) {
			if (!hasStack(ingredient,
					((MixingBowl) mixingbowl.getItem()).readNBT(mixingbowl))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting p_77572_1_) {
		return this.output.copy();
	}

	@Override
	public int getRecipeSize() {
		return 10;
	}

	@Override
	public ItemStack getRecipeOutput() {
		// TODO Auto-generated method stub
		return this.output.copy();
	}

	private boolean hasStack(Object stack, ArrayList<Object> stackArray) {
		if (stack instanceof ItemStack) {
			return hasStack((ItemStack) stack, stackArray);
		} else if (stack instanceof FluidStack) {
			return hasStack((FluidStack) stack, stackArray);
		} else {
			return false;
		}
	}

	private boolean hasStack(FluidStack stack, ArrayList<Object> stackArray) {
		for (int x = 0; x < stackArray.size(); x++) {
			if (stackArray.get(x) instanceof FluidStack
					&& ((FluidStack) stackArray.get(x)).equals(stack)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasStack(ItemStack stack, ArrayList<Object> stackArray) {
		if (stackArray == null) {
			return false;
		}
		for (int x = 0; x < stackArray.size(); x++) {
			if (stackArray.get(x) instanceof ItemStack
					&& ItemStack.areItemStacksEqual(
							((ItemStack) stackArray.get(x)), stack)) {
				return true;
			}
		}
		return false;
	}
}
