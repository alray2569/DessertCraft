package com.andrewlray.mcmods.dessertcraft.blocks;

import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class CherryPlanks extends Block {

	/**
	 * Constructor for Cherry Planks Block. Defines and registers this block.
	 */
	public CherryPlanks() {
		super(Material.wood);
		this.setBlockName(DCConstants.MODID + "_" + DCConstants.CHERRY_PLANKS);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockTextureName(DCConstants.MODID + ":"
				+ DCConstants.CHERRY_PLANKS);
		this.setHardness(2f);
		GameRegistry.registerBlock(this, DCConstants.CHERRY_PLANKS);
	}
}
