package com.andrewlray.mcmods.dessertcraft.items;

import static com.andrewlray.mcmods.dessertcraft.lib.DCConstants.MODID;
import static com.andrewlray.mcmods.dessertcraft.lib.DCConstants.TRIFLE;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemSoup;
import cpw.mods.fml.common.registry.GameRegistry;

public class Trifle extends ItemSoup {

	public Trifle() {
		super(4);
		this.setUnlocalizedName(MODID + "_" + TRIFLE);
		this.setTextureName(MODID + ":" + TRIFLE);
		this.setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, TRIFLE);
	}

}
