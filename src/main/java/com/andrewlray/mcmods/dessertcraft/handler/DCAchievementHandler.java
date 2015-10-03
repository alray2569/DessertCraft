package com.andrewlray.mcmods.dessertcraft.handler;

import com.andrewlray.mcmods.dessertcraft.event.DCPlayerEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class DCAchievementHandler extends FMLCommonHandler {
	
	public static DCAchievementHandler instance;
	
	public static void init() {
		instance = new DCAchievementHandler();
	}

	public void churnEvent(EntityPlayer player, ItemStack stack) {
		super.bus().post(new DCPlayerEvent.ChurnEvent(player, stack));
	}
}
