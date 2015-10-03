package com.andrewlray.mcmods.dessertcraft.items;

import static com.andrewlray.mcmods.dessertcraft.lib.DCConstants.MODID;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class DCFood extends ItemFood {

	public DCFood(int heals, float saturation, boolean isMeat, String constName) {
		super(heals, saturation, isMeat);
		this.setUnlocalizedName(MODID + "_" + constName);
		this.setTextureName(MODID + ":" + constName);
		this.setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, constName);
	}

}
