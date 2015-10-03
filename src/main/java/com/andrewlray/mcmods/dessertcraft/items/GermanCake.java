package com.andrewlray.mcmods.dessertcraft.items;

import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class GermanCake extends ItemFood {
	
	public GermanCake(int heal, float saturation, boolean wolfMeat) {
		super(heal, saturation, wolfMeat);
		setUnlocalizedName(DCConstants.MODID + "_" + DCConstants.GERMAN_CAKE);
		setTextureName(DCConstants.MODID + ":" + DCConstants.GERMAN_CAKE);
		setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, DCConstants.GERMAN_CAKE);
	}
	
}
