package com.andrewlray.mcmods.dessertcraft.items;

import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class Cherry extends ItemFood {

	public Cherry(int heal, float saturation, boolean wolfMeat) {
		super(heal, saturation, wolfMeat);
		this.setUnlocalizedName(DCConstants.MODID + "_" + DCConstants.CHERRY);
		this.setTextureName(DCConstants.MODID + ":" + DCConstants.CHERRY);
		this.setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, DCConstants.CHERRY);
	}
}
