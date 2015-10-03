package com.andrewlray.mcmods.dessertcraft.container;

import com.andrewlray.mcmods.dessertcraft.slot.SlotIceCreamMaker;
import com.andrewlray.mcmods.dessertcraft.tileentities.TileEntityIceCreamMaker;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerIceCreamMaker extends Container {

	private TileEntityIceCreamMaker icm;
	private int procTime;

	public ContainerIceCreamMaker(InventoryPlayer invPlayer,
			TileEntityIceCreamMaker te) {
		procTime = 0;
		icm = te;

		addSlotToContainer(new Slot(te, 0, 30, 69));
		addSlotToContainer(new Slot(te, 1, 80, 19));
		addSlotToContainer(new Slot(te, 2, 130, 69));
		addSlotToContainer(new SlotIceCreamMaker(invPlayer.player, te, 3, 80,
				69));

		// Inventory
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9,
						8 + j * 18, 105 + i * 18));
			}
		}

		// Hotbar
		for (int j = 0; j < 9; j++) {
			this.addSlotToContainer(new Slot(invPlayer, j, 8 + j * 18, 163));
		}
	}

	@Override
	public void addCraftingToCrafters(ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 1, this.icm.processtime);
		crafting.sendProgressBarUpdate(this, 0, this.icm.processtime);
		crafting.sendProgressBarUpdate(this, 0, this.icm.processtime);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return icm.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		return null;
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting k = (ICrafting) this.crafters.get(i);

			if (this.procTime != this.icm.processtime) {
				k.sendProgressBarUpdate(this, 0, this.icm.processtime);
				k.sendProgressBarUpdate(this, 1, this.icm.processtime);
				k.sendProgressBarUpdate(this, 2, this.icm.processtime);
			}
		}
		this.procTime = this.icm.processtime;
	}

	@Override
	public void updateProgressBar(int i, int j) {
		if (i == 0) {
			icm.processtime = j;
		}
	}

}
