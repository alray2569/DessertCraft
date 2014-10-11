package andrew.dessertcraft.container;

import static andrew.dessertcraft.gui.GuiPastryCounter.GRID_SPACING;
import static andrew.dessertcraft.gui.GuiPastryCounter.GRID_TOPLEFT_X;
import static andrew.dessertcraft.gui.GuiPastryCounter.GRID_TOPLEFT_Y;
import static andrew.dessertcraft.gui.GuiPastryCounter.INVENTORY_TOPLEFT_X;
import static andrew.dessertcraft.gui.GuiPastryCounter.INVENTORY_TOPLEFT_Y;
import static andrew.dessertcraft.gui.GuiPastryCounter.SLOT_SIZE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerPastryCounter extends Container {

	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;

	public ContainerPastryCounter(InventoryPlayer playerInv, World world,
			int x, int y, int z) {
		this.craftMatrix = new InventoryCrafting(this, 5, 5);
		this.craftResult = new InventoryCraftResult();
		this.worldObj = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;

		this.addSlotToContainer(new SlotCrafting(playerInv.player,
				this.craftMatrix, this.craftResult, 0, 131, 36));

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 5
						+ 1, GRID_TOPLEFT_X + (GRID_SPACING + SLOT_SIZE) * i,
						GRID_TOPLEFT_Y + (GRID_SPACING + SLOT_SIZE) * j));
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9,
						INVENTORY_TOPLEFT_X + SLOT_SIZE * i,
						INVENTORY_TOPLEFT_Y + SLOT_SIZE * j));
			}
		}

		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(playerInv, i, INVENTORY_TOPLEFT_X
					+ i * SLOT_SIZE, INVENTORY_TOPLEFT_Y + 158));
		}

		onCraftMatrixChanged(craftMatrix);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return false;
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 == 0) {
				if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (par2 >= 10 && par2 < 37) {
				if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
					return null;
				}
			} else if (par2 >= 37 && par2 < 46) {
				if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}

		return itemstack;
	}

}
