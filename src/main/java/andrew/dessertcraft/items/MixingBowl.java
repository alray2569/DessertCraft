package andrew.dessertcraft.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import andrew.dessertcraft.lib.DCConstants;
import cpw.mods.fml.common.registry.GameRegistry;

public class MixingBowl extends Item {

	private static final byte TYPE_EOL = -1;
	private static final byte TYPE_ITEMSTACK = 0;
	private static final byte TYPE_FLUID = 1;

	public MixingBowl() {
		this.setUnlocalizedName(DCConstants.MODID + "_"
				+ DCConstants.MIXING_BOWL);
		this.setTextureName(DCConstants.MODID + ":" + DCConstants.MIXING_BOWL
				+ "_empty");
		this.setCreativeTab(CreativeTabs.tabMisc);
		GameRegistry.registerItem(this, DCConstants.MIXING_BOWL);
	}

//	@Override
//	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
//		itemStack.stackTagCompound = new NBTTagCompound();
//		NBTTagList list = new NBTTagList();
//		NBTTagCompound nbt1 = new NBTTagCompound();
//		nbt1.setByte("Type", TYPE_EOL);
//		list.appendTag(nbt1);
//		itemStack.stackTagCompound.setTag("Ingredients", list);
//	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player,
			List list, boolean par4) {
		if (this.readNBTAsStrings(itemStack) != null)
			list.addAll(this.readNBTAsStrings(itemStack));
		else
			list.add(I18n.format("text_empty_adj"));
	}

	public ArrayList<Object> readNBT(ItemStack itemStack) {
		ArrayList<Object> list = new ArrayList<Object>();

		if (itemStack.stackTagCompound != null) {

			NBTTagList nbtList = itemStack.stackTagCompound.getTagList(
					"Ingredients", 10);
			iteration: for (byte x = 0;; x++) {
				NBTTagCompound nbt1;
				String str;
				switchcase: switch (nbtList.getCompoundTagAt(x).getByte("Type")) {
				case TYPE_EOL:
					break iteration;
				case TYPE_ITEMSTACK:
					nbt1 = (NBTTagCompound) nbtList.getCompoundTagAt(x);
					ItemStack item = ItemStack.loadItemStackFromNBT(nbt1);
					list.add(item);
					break switchcase;
				case TYPE_FLUID:
					nbt1 = (NBTTagCompound) nbtList.getCompoundTagAt(x);
					FluidStack fluid = FluidStack.loadFluidStackFromNBT(nbt1);
					list.add(fluid);
					break switchcase;
				}
			}
			return list;
		} else
			return null;
	}

	private ArrayList<String> readNBTAsStrings(ItemStack itemStack) {
		ArrayList<Object> objList = this.readNBT(itemStack);
		ArrayList<String> strList = new ArrayList<String>();

		if (objList != null) {
			for (Object i : objList) {
				if (i instanceof ItemStack) {
					strList.add(((ItemStack) i).getDisplayName());
				} else if (i instanceof FluidStack) {
					strList.add(((FluidStack) i).getFluid().getLocalizedName((FluidStack) i));
				}
			}
			return strList;
		}
		return null;
	}

	private void writeNBT(ItemStack itemStack, ArrayList<Object> list) {
		itemStack.stackTagCompound = new NBTTagCompound();
		NBTTagList nbtList = new NBTTagList();
		for (Object i : list) {
			NBTTagCompound nbt1 = new NBTTagCompound();
			if (i instanceof ItemStack) {
				nbt1.setByte("Type", TYPE_ITEMSTACK);
				((ItemStack) i).writeToNBT(nbt1);
			} else if (i instanceof FluidStack) {
				nbt1.setByte("Type", TYPE_FLUID);
				((FluidStack) i).writeToNBT(nbt1);
			}
			nbtList.appendTag(nbt1);
		}

		NBTTagCompound nbt2 = new NBTTagCompound();
		nbt2.setByte("Type", TYPE_EOL);
		nbtList.appendTag(nbt2);

		itemStack.stackTagCompound.setTag("Ingredients", nbtList);
	}

	public void addIngredient(ItemStack itemStack, ItemStack toAdd) {
		this.addIngredient(itemStack, (Object) toAdd);
	}

	public void addIngredient(ItemStack itemStack, FluidStack toAdd) {
		this.addIngredient(itemStack, (Object) toAdd);
	}

	private void addIngredient(ItemStack itemStack, Object toAdd) {
		ArrayList<Object> objects = this.readNBT(itemStack);

		if (objects.size() < 5) {
			objects.add(toAdd);
			this.writeNBT(itemStack, objects);
		}
	}

	public void emptyBowl(ItemStack itemStack) {
		itemStack.stackTagCompound = new NBTTagCompound();
		NBTTagList list = new NBTTagList();
		NBTTagCompound nbt1 = new NBTTagCompound();
		nbt1.setByte("Type", TYPE_EOL);
		list.appendTag(nbt1);
		itemStack.stackTagCompound.setTag("Ingredients", list);
	}
}
