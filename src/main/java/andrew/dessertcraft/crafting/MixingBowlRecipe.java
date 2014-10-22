package andrew.dessertcraft.crafting;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.items.MixingBowl;

public class MixingBowlRecipe implements IRecipe {
	private ItemStack mixingBowl;
	private Object toAdd;

	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	public boolean matches(InventoryCrafting inventory, World world) {
		this.mixingBowl = null;
		this.toAdd = null;

		for (int k1 = 0; k1 < inventory.getSizeInventory(); ++k1) {
			ItemStack itemstack = inventory.getStackInSlot(k1);

			if (itemstack != null) {
				if ((itemstack.getItem() != Items.dye || itemstack
						.getItemDamage() != 3)
						&& itemstack.getItem() != Items.milk_bucket
						&& !(itemstack.getItem() instanceof ItemFood)
						&& (itemstack.getItem() != Items.potionitem || itemstack
								.getItemDamage() != 0)
						&& itemstack.getItem() != Items.sugar
						&& itemstack.getItem() != DCItems.mixingBowl) {
					return false;
				} else if (itemstack.getItem() == DCItems.mixingBowl) {
					this.mixingBowl = itemstack.copy();
				} else {
					this.toAdd = itemstack.copy();
				}
			}
		}

		if (mixingBowl != null
				&& mixingBowl.getItem() instanceof MixingBowl
				&& ((MixingBowl) mixingBowl.getItem()).readNBT(mixingBowl) != null) {
			if (((MixingBowl) mixingBowl.getItem()).readNBT(mixingBowl).size() < 5
					&& !((MixingBowl) mixingBowl.getItem()).readNBT(mixingBowl)
							.contains(toAdd)) {

				if (toAdd instanceof ItemStack) {
					((MixingBowl) mixingBowl.getItem()).addIngredient(
							mixingBowl, (ItemStack) toAdd);
				} else if (toAdd instanceof FluidStack) {
					((MixingBowl) mixingBowl.getItem()).addIngredient(
							mixingBowl, (FluidStack) toAdd);
				} else {
					return false;
				}

			} else {
				return false;
			}
			return true;
		} else if (mixingBowl != null
				&& mixingBowl.getItem() instanceof MixingBowl
				&& ((MixingBowl) mixingBowl.getItem()).readNBT(mixingBowl) == null) {
			((MixingBowl) this.mixingBowl.getItem()).emptyBowl(this.mixingBowl);
			if (toAdd instanceof ItemStack) {
				((MixingBowl) mixingBowl.getItem()).addIngredient(mixingBowl,
						(ItemStack) toAdd);
			} else if (toAdd instanceof FluidStack) {
				((MixingBowl) mixingBowl.getItem()).addIngredient(mixingBowl,
						(FluidStack) toAdd);

			} else {
				return false;
			}
			return true;
		} else
			return false;
	}

	/**
	 * Returns an Item that is the result of this recipe
	 */
	public ItemStack getCraftingResult(InventoryCrafting p_77572_1_) {
		return this.mixingBowl;
	}

	/**
	 * Returns the size of the recipe area
	 */
	public int getRecipeSize() {
		return 10;
	}

	public ItemStack getRecipeOutput() {
		return this.mixingBowl;
	}
}