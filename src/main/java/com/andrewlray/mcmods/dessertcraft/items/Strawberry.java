package com.andrewlray.mcmods.dessertcraft.items;

import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemFood;

public class Strawberry extends ItemFood {

	public Strawberry() {
		super(2, .4F, false);
		this.setUnlocalizedName(DCConstants.MODID + "_" + DCConstants.STRAWBERRY);
		this.setTextureName(DCConstants.MODID + ":" + DCConstants.STRAWBERRY);
		GameRegistry.registerItem(this, DCConstants.STRAWBERRY);
	}

}
