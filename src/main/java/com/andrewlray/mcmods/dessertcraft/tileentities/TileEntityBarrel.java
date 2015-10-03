package com.andrewlray.mcmods.dessertcraft.tileentities;

import org.apache.logging.log4j.Level;

import com.andrewlray.mcmods.dessertcraft.DessertCraft;
import com.andrewlray.mcmods.dessertcraft.blocks.DCBlocks;
import com.andrewlray.mcmods.dessertcraft.registry.FermentationRecipeRegistry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.TileFluidHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityBarrel extends TileFluidHandler implements IInventory, IButtonHandler {
	
	private ItemStack slots[];
	
	public int processtime;
	
	private String customName;
	
	private static final int MAXAMT = 10000;
	
	public static final int RUNTIME = 256;
	
	public TileEntityBarrel() {
		super();
		slots = new ItemStack[2];
		this.tank = new FluidTank(MAXAMT);
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
				: "container.dessertcraft_barrel";
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
		return false;
	}
	
	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.slots[i] != null) {
			if (this.slots[i].stackSize <= j) {
				ItemStack itemstack = slots[i];
				this.slots[i] = null;
				return itemstack;
			}
			
			ItemStack itemstack1 = slots[i].splitStack(j);
			if (this.slots[i].stackSize == 0)
				this.slots[i] = null;
			return itemstack1;
		}
		return null;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[getSizeInventory()];
		
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound nbt1 = (NBTTagCompound) list.getCompoundTagAt(i);
			byte b0 = nbt1.getByte("Slot");
			
			if (b0 >= 0 && b0 < slots.length)
				this.slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
			
		}
		
		this.processtime = nbt.getShort("ProcTime");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setShort("ProcTime", (short) this.processtime);
		
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
	
	public int getProgressScaled(int scale) {
		return this.processtime * scale / RUNTIME;
	}
	
	public boolean isFermenting() {
		return this.processtime > 0;
	}
	
	@Override
	public void updateEntity() {
		boolean flag = true;
		
		if (!this.worldObj.isRemote) {
			if (canFerment()
					&& (this.worldObj.isBlockIndirectlyGettingPowered(
							this.xCoord, this.yCoord, this.zCoord) || this
							.isFermenting())) {
				this.processtime++;
				if (this.processtime == RUNTIME) {
					this.processtime = 0;
					this.ferment();
				}
			} else {
				this.processtime = 0;
			}
			
			/*
			 * if (this.slots[0] != null &&
			 * FluidContainerRegistry.isFilledContainer(slots[0])) { if
			 * (this.fluid == null) { for (int i = 0; i < FluidContainerRegistry
			 * .getRegisteredFluidContainerData().length; i++) {
			 * FluidContainerData data =
			 * FluidContainerRegistry.getRegisteredFluidContainerData()[i]; if
			 * (this.slots[0].isItemEqual(data.filledContainer)) { this.fluid =
			 * data.fluid.copy(); this.slots[0] = data.emptyContainer.copy();
			 * break; } else continue; } } }
			 */
			
			for (int i = 0; i < FluidContainerRegistry
					.getRegisteredFluidContainerData().length; i++) {
				FluidContainerData data = FluidContainerRegistry
						.getRegisteredFluidContainerData()[i];
				if (this.slots[0] != null
						&& this.slots[0].getItem() == data.filledContainer
								.getItem()) {
					if (this.tank.getFluid() == null) {
						if (this.tank.fill(data.fluid.copy(), false) == data.fluid.amount) {
							this.tank.fill(data.fluid.copy(), true);
							this.slots[0] = data.emptyContainer;
							this.markDirty();
						}
					} else if (this.tank.getFluid().fluidID == data.fluid.fluidID) {
						if (this.tank.getFluidAmount() + data.fluid.amount <= this.tank
								.getCapacity()) {
							this.slots[0] = data.emptyContainer.copy();
							this.tank.fill(data.fluid.copy(), true);
							this.markDirty();
						}
					}
				}
				
				if (this.slots[1] != null
						&& this.slots[1].getItem() == data.emptyContainer
								.getItem()) {
					
					if (this.tank.getFluidAmount() >= data.fluid.amount) {
						this.slots[1] = FluidContainerRegistry
								.fillFluidContainer(this.tank.getFluid(),
										slots[1]);
						this.tank.drain(data.fluid.amount, true);
						this.markDirty();
					}
				}
			}
		}
		
		// System.out.print("\n");
	}
	
	public boolean canFerment() {
		return FermentationRecipeRegistry.getOutput(this.tank.getFluid()) != null;
	}
	
	private void ferment() {
		Fluid fluidOut = FermentationRecipeRegistry
				.getFermentationResult(this.tank.getFluid());
		
		int amount = this.tank.drain(this.tank.getFluidAmount(), true).amount;
		this.tank.fill(new FluidStack(fluidOut, amount), true);
	}
	
	public FluidTank getTank() {
		return this.tank;
	}
	
	public int getFluidContentsScaled(int scale) {
		return this.tank.getFluidAmount() * scale / this.tank.getCapacity();
	}
	
	public void handleButton(byte id, byte guiID) throws IllegalArgumentException {
		if (guiID == DCBlocks.GUI_ID_BARREL) handleButton(id);
		else DessertCraft.log(Level.ERROR, "A button press message was recieved at a TE Barrel which did not originate from a GUI Barrel! GUI ID = " + guiID);
	}
	
	public void handleButton(byte id) throws IllegalArgumentException {
		
		switch (id) {
		case 0: // Ferment button
			if (this.canFerment()) {
				this.processtime++;
				this.updateEntity();
			}
			break;
		case 1: // Empty button
			this.tank.drain(MAXAMT, true);
			break;
		default:
			DessertCraft.log(Level.ERROR, "A button press message was recieved at a TE Barrel with an invalid button ID! ID = " + id);
			throw new IllegalArgumentException("Invalid button id");
		}
	}
}
