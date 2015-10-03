package com.andrewlray.mcmods.dessertcraft.items;

import com.andrewlray.mcmods.dessertcraft.blocks.DCBlocks;
import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class StrawberrySeed extends ItemSeeds {

	public StrawberrySeed() {
		super(DCBlocks.strawberryPlant, Blocks.farmland);
		this.setUnlocalizedName(DCConstants.MODID + "_"
				+ DCConstants.STRAWBERRY_SEEDS);
		this.setTextureName(DCConstants.MODID + ":" + DCConstants.STRAWBERRY_SEEDS);
		GameRegistry.registerItem(this, DCConstants.STRAWBERRY_SEEDS);
	}

}
