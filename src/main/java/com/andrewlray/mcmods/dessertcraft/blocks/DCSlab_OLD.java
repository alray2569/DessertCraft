package com.andrewlray.mcmods.dessertcraft.blocks;

import java.util.Random;

import com.andrewlray.mcmods.dessertcraft.items.DCItems;
import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Deprecated
public class DCSlab_OLD extends BlockSlab {

	private Block block;
	private int blockMeta;
	private boolean isDouble;
	private DCSlab_OLD singleSlab;
	private DCSlab_OLD doubleSlab;

	@Deprecated
	public DCSlab_OLD(boolean isDouble, Block block, int meta, String name,
			DCSlab_OLD otherSlab) {
		super(isDouble, block.getMaterial());
		this.block = block;
		this.blockMeta = meta;
		this.setBlockName(DCConstants.MODID + "_" + name);
		this.setCreativeTab(!isDouble ? CreativeTabs.tabBlock : null);
		this.setBlockTextureName(this.block.getUnlocalizedName().substring(5)
				.replaceFirst("_", ":"));
		GameRegistry
				.registerBlock(this, this.getUnlocalizedName().substring(5));
		this.useNeighborBrightness = !isDouble;
		this.isDouble = isDouble;
		if (isDouble) {
			this.doubleSlab = this;
			this.singleSlab = otherSlab;
		} else {
			this.singleSlab = this;
			this.doubleSlab = otherSlab;
		}
	}

	@Deprecated
	protected void setDoubleSlab(DCSlab_OLD doubleSlab) {
		this.doubleSlab = doubleSlab;
	}

	@Override
	/** getFullSlabName */
	public String func_150002_b(int meta) {
		return this.getUnlocalizedName();
	}

	@Deprecated
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(this.block
				.getUnlocalizedName().substring(5));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getPickBlock(MovingObjectPosition target, World world,
			int x, int y, int z) {
		return new ItemStack(this.singleSlab);
	}
	

}
