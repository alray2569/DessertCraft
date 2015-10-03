package com.andrewlray.mcmods.dessertcraft.items;

import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class DCItem extends Item {

	public DCItem(String constName, CreativeTabs creativeTab) {
		this.setUnlocalizedName(DCConstants.MODID + "_" + constName);
		this.setTextureName(DCConstants.MODID + ":" + constName);
		this.setCreativeTab(creativeTab);
		GameRegistry.registerItem(this, constName);
	}
}
