package com.andrewlray.mcmods.dessertcraft.items;

import static com.andrewlray.mcmods.dessertcraft.lib.DCConstants.APPLE_PIE;
import static com.andrewlray.mcmods.dessertcraft.lib.DCConstants.MODID;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ApplePie extends DCFood {

	public ApplePie() {
		super(5, .5f, false, APPLE_PIE);
	}

}
