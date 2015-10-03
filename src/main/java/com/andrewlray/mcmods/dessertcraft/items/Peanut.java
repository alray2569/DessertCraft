package com.andrewlray.mcmods.dessertcraft.items;

import com.andrewlray.mcmods.dessertcraft.blocks.DCBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import static com.andrewlray.mcmods.dessertcraft.lib.DCConstants.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;

public class Peanut extends ItemSeedFood {

	public Peanut(int heal, float saturation) {
		super(heal, saturation, DCBlocks.peanutPlant, Blocks.farmland);
		this.setUnlocalizedName(MODID + "_" + PEANUT);
		this.setTextureName(MODID + ":" + PEANUT);
		GameRegistry.registerItem(this, PEANUT);
	}

}
