package com.andrewlray.mcmods.dessertcraft.items;

import com.andrewlray.mcmods.dessertcraft.blocks.DCSlab;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class DCItemSlab extends ItemSlab {

	public DCItemSlab(Block block) {
		this(block, ((DCSlab) block).singleSlab, ((DCSlab) block).doubleSlab);
	}

	public DCItemSlab(Block block, BlockSlab singleSlab, BlockSlab doubleSlab) {
		super(block, singleSlab, doubleSlab, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
}