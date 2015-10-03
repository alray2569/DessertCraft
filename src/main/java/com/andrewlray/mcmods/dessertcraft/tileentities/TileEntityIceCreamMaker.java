package com.andrewlray.mcmods.dessertcraft.tileentities;

import com.andrewlray.mcmods.dessertcraft.registry.IceCreamMakerRecipeRegistry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityIceCreamMaker extends TileEntity implements
		ISidedInventory {

	private ItemStack slots[];

	public int processtime;

	private String customName;

	private static final int[] SLOTS_TOP = new int[] { 1 };
	private static final int[] SLOTS_SIDE = new int[] { 0, 2, 3 };
	private static final int[] SLOTS_BOTTOM = new int[] { 3, 0 };

	public static final int RUNTIME = 256;

	public TileEntityIceCreamMaker() {
		slots = new ItemStack[4];
	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return slots[i];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (slots[i] != null) {
			ItemStack itemstack = slots[i];
			slots[i] = null;
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		slots[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return hasCustomInventoryName() ? customName
				: "container.dessertcraft_iceCreamMaker";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.customName != null && this.customName.length() > 0;
	}

	public void setCustomName(String displayName) {
		customName = displayName;

	}

	public void setGuiDisplayName(String name) {
		customName = name;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
			return false;
		else
			return player.getDistanceSq((double) xCoord + .5d,
					(double) yCoord + .5d, (double) zCoord + .5d) <= 64;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		switch (slot) {
		case 0:
			return itemstack.getItem() == Items.milk_bucket;
		case 1:
			return true;
		case 2:
			return itemstack.getItem() == Items.sugar;
		case 3:
			return itemstack.getItem() == Items.bowl;
		default:
			return false;
		}
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (slots[i] != null) {
			if (slots[i].stackSize <= j) {
				ItemStack itemstack = slots[i];
				slots[i] = null;
				return itemstack;
			}

			ItemStack itemstack1 = slots[i].splitStack(j);
			if (slots[i].stackSize == 0)
				slots[i] = null;
			return itemstack1;
		}
		return null;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("Items", 10);
		slots = new ItemStack[getSizeInventory()];

		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound nbt1 = (NBTTagCompound) list.getCompoundTagAt(i);
			byte b0 = nbt1.getByte("Slot");

			if (b0 >= 0 && b0 < slots.length)
				slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);

		}

		processtime = nbt.getShort("ProcTime");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setShort("ProcTime", (short) processtime);

		NBTTagList list = new NBTTagList();

		for (int i = 0; i < slots.length; i++) {
			if (slots[i] != null) {
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte) i);
				slots[i].writeToNBT(nbt1);
				list.appendTag(nbt1);
			}
		}

		nbt.setTag("Items", list);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int i) {
		return i == 0 ? SLOTS_BOTTOM : (i == 1 ? SLOTS_TOP : SLOTS_SIDE);
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
		return this.isItemValidForSlot(slot, itemstack);
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int side) {
		return (side == 0 && itemstack.getItem() != Items.bowl && slot == 3)
				|| (slot == 0 && itemstack.getItem() == Items.bucket);
	}

	public int getProgressScaled(int scale) {
		return processtime * scale / RUNTIME;
	}

	private boolean canChurn() {
		if (slots[0] == null || slots[1] == null || slots[2] == null
				|| slots[3] == null)
			return false;

		if (slots[0].getItem() != Items.milk_bucket)
			return false;

		if (slots[2].getItem() != Items.sugar)
			return false;

		if (slots[3].getItem() != Items.bowl)
			return false;

		ItemStack itemstack = IceCreamMakerRecipeRegistry.getChurnResult(slots[1]);

		if (itemstack == null)
			return false;

		return true;

	}

	private void churn() {
		if (canChurn()) {
			ItemStack itemstack = IceCreamMakerRecipeRegistry.getChurnResult(slots[1]);

			slots[0] = new ItemStack(Items.bucket);
			slots[1] = null;
			slots[2] = null;
			slots[3] = itemstack.copy();

	 	}
	}
	
	public boolean isChurning() {
		return this.processtime > 0;
	}

	@Override
	public void updateEntity() {
		boolean flag1 = false;
		
		if (!worldObj.isRemote) {
			 if (canChurn()) {
				 processtime++;
				 if (processtime == RUNTIME) {
					 processtime = 0;
					 this.churn();
					 flag1 = true;
				 }
			 } else {
				 processtime = 0;
			 }
		}
	}
}
