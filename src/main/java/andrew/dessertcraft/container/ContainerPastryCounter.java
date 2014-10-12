package andrew.dessertcraft.container;

import static andrew.dessertcraft.gui.GuiPastryCounter.GRID_SPACING;
import static andrew.dessertcraft.gui.GuiPastryCounter.GRID_TOPLEFT_X;
import static andrew.dessertcraft.gui.GuiPastryCounter.GRID_TOPLEFT_Y;
import static andrew.dessertcraft.gui.GuiPastryCounter.INVENTORY_TOPLEFT_X;
import static andrew.dessertcraft.gui.GuiPastryCounter.INVENTORY_TOPLEFT_Y;
import static andrew.dessertcraft.gui.GuiPastryCounter.OUTPUT_X;
import static andrew.dessertcraft.gui.GuiPastryCounter.OUTPUT_Y;
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
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.crafting.pastrycounter.PastryCounterCraftingManager;

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
				this.craftMatrix, this.craftResult, 0, OUTPUT_X + 1,
				OUTPUT_Y + 1));

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 5,
						GRID_TOPLEFT_X + (GRID_SPACING + SLOT_SIZE) * j + 1,
						GRID_TOPLEFT_Y + (GRID_SPACING + SLOT_SIZE) * i + 1));
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9,
						INVENTORY_TOPLEFT_X + SLOT_SIZE * j,
						INVENTORY_TOPLEFT_Y + SLOT_SIZE * i));
			}
		}

		for (int j = 0; j < 9; j++) {
			this.addSlotToContainer(new Slot(playerInv, j, INVENTORY_TOPLEFT_X
					+ j * SLOT_SIZE, INVENTORY_TOPLEFT_Y + 58));
		}

		onCraftMatrixChanged(craftMatrix);
	}

	@Override
	public void onCraftMatrixChanged(IInventory inv) {
		this.craftResult.setInventorySlotContents(
				0,
				PastryCounterCraftingManager.getInstance().findMatchingRecipe(
						this.craftMatrix, worldObj));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.worldObj.getBlock(this.posX, this.posY, this.posZ) == DCBlocks.pastryCounter
				&& player.getDistanceSq((double) posX + .5d,
						(double) posY + .5d, (double) posZ + .5d) <= 64d;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotNo) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotNo);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (slotNo == 0) {
				if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (slotNo >= 10 && slotNo < 37) {
				if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
					return null;
				}
			} else if (slotNo >= 37 && slotNo < 46) {
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

			slot.onPickupFromSlot(player, itemstack1);
		}

		return itemstack;
	}

	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);

		if (!this.worldObj.isRemote) {
			for (int i = 0; i < 25; ++i) {
				ItemStack itemstack = this.craftMatrix
						.getStackInSlotOnClosing(i);

				if (itemstack != null) {
					player.dropPlayerItemWithRandomChoice(itemstack, false);
				}
			}
		}
	}
}
