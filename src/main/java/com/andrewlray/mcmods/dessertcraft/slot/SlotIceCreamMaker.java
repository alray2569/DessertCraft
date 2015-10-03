package com.andrewlray.mcmods.dessertcraft.slot;

import com.andrewlray.mcmods.dessertcraft.event.DCEvents;
import com.andrewlray.mcmods.dessertcraft.event.DCPlayerEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;

public class SlotIceCreamMaker extends Slot {
	
	private EntityPlayer thePlayer;

	public SlotIceCreamMaker(EntityPlayer player, IInventory iinv, int i, int j, int k) {
		super(iinv, i, j, k);
		this.thePlayer = player;
	}
	
	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
		super.onPickupFromSlot(player, stack);
		MinecraftForge.EVENT_BUS.post(new DCPlayerEvent.ChurnEvent(player, stack));
	}

}
