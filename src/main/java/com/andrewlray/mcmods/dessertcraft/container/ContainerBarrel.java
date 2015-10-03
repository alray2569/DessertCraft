package com.andrewlray.mcmods.dessertcraft.container;

import com.andrewlray.mcmods.dessertcraft.tileentities.TileEntityBarrel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerBarrel extends Container {

	private int procTime;
	private int fluidAmt;
	private TileEntityBarrel barrelTE;

	public ContainerBarrel(InventoryPlayer invPlayer, TileEntityBarrel te) {
		procTime = 0;
		fluidAmt = 0;
		barrelTE = te;

		addSlotToContainer(new Slot(te, 0, 8, 44));
		addSlotToContainer(new Slot(te, 1, 8 + 2 * 18, 44));

		// Inventory
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9,
						8 + j * 18, 67 + i * 18));
			}
		}

		// Hotbar
		for (int j = 0; j < 9; j++) {
			this.addSlotToContainer(new Slot(invPlayer, j, 8 + j * 18, 125));
		}
	}

	@Override
	public void addCraftingToCrafters(ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		if (this.fluidAmt != this.barrelTE.getTank().getFluidAmount()) {
			crafting.sendProgressBarUpdate(this, 2, this.barrelTE.getTank()
					.getFluid().fluidID);
		}
		crafting.sendProgressBarUpdate(this, 1, this.barrelTE.getTank()
				.getFluidAmount());
		crafting.sendProgressBarUpdate(this, 0, this.barrelTE.processtime);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return barrelTE.isUseableByPlayer(player);
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

			if (this.fluidAmt != (this.barrelTE.getTank().getFluidAmount())) {
				if (this.barrelTE.getTank().getFluidAmount() != 0)
					k.sendProgressBarUpdate(this, 2, this.barrelTE.getTank()
							.getFluid().fluidID);
				k.sendProgressBarUpdate(this, 1, this.barrelTE.getTank()
						.getFluidAmount());
			}

			if (this.procTime != this.barrelTE.processtime) {
				k.sendProgressBarUpdate(this, 0, this.barrelTE.processtime);
			}
		}
		this.procTime = this.barrelTE.processtime;
		this.fluidAmt = this.barrelTE.getTank().getFluidAmount();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int i, int j) {
		if (i == 0) {
			barrelTE.processtime = j;
		} else if (i == 1) {
			if (j == 0) {
				this.barrelTE.getTank().setFluid(null);
			} else {
				this.barrelTE.getTank().setFluid(
						new FluidStack(this.barrelTE.getTank().getFluid(), j));
			}
		} else if (i == 2) {
			this.barrelTE.getTank().setFluid(new FluidStack(j, 1));
		}
	}
}
