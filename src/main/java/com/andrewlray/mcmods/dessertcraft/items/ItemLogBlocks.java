package com.andrewlray.mcmods.dessertcraft.items;

import com.andrewlray.mcmods.dessertcraft.blocks.DCLogs;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLogBlocks extends ItemBlock {

	public ItemLogBlocks(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int i = stack.getItemDamage();
		if (i < 0 || i >= DCLogs.LOGS.length)
			i = 0;
		return super.getUnlocalizedName() + "_" + DCLogs.LOGS[i];
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}

}
