package com.andrewlray.mcmods.dessertcraft.blocks;

import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DCStair extends BlockStairs {

	private Block block;
	private int meta;
	
	protected DCStair(Block block, int meta, String name) {
		super(block, meta);
		this.block = block;
		this.meta = meta;
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName(DCConstants.MODID + "_" + name);
		this.useNeighborBrightness = true;
		GameRegistry.registerBlock(this, this.getUnlocalizedName().substring(5));
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(this.block.getUnlocalizedName().substring(5));
	}

}
