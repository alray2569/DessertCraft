package com.andrewlray.mcmods.dessertcraft.blocks;

import static com.andrewlray.mcmods.dessertcraft.lib.DCConstants.MODID;

import java.util.Random;

import com.andrewlray.mcmods.dessertcraft.items.DCItemSlab;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DCSlab extends BlockSlab {

	public DCSlab singleSlab;
	public DCSlab doubleSlab;

	@Deprecated
	public DCSlab(boolean doubleSlab, Block block) {
		this(doubleSlab, block.getMaterial(), block.getUnlocalizedName()
				.substring(5).replace(MODID + "_", ""), block
				.getCreativeTabToDisplayOn());
	}

	public DCSlab(boolean doubleSlab, Material material, String constName) {
		this(doubleSlab, material, constName,
				!doubleSlab ? CreativeTabs.tabBlock : null, 2f);
	}

	public DCSlab(boolean doubleSlab, Material material, String constName,
			CreativeTabs creativeTab) {
		this(doubleSlab, material, constName, creativeTab, 2f);
	}

	public DCSlab(boolean doubleSlab, Material material, String constName,
			CreativeTabs creativeTab, float hardness) {
		super(doubleSlab, material);
		this.setBlockName(MODID + "_" + constName
				+ (doubleSlab ? "_double" : "_slab"));
		this.setLightOpacity(0);
		this.setBlockTextureName(MODID + ":" + constName);
		this.setCreativeTab(creativeTab);
		this.setHardness(hardness);
	}

	@Override
	public String func_150002_b(int meta) {
		return this.getUnlocalizedName();
	}

	public static void registerSlabs(DCSlab singleSlab, DCSlab doubleSlab) {
		doubleSlab.singleSlab = singleSlab.singleSlab = singleSlab;
		doubleSlab.doubleSlab = singleSlab.doubleSlab = doubleSlab;

		GameRegistry.registerBlock(singleSlab, DCItemSlab.class, singleSlab
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(doubleSlab, DCItemSlab.class, doubleSlab
				.getUnlocalizedName().substring(5));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getPickBlock(MovingObjectPosition target, World world,
			int x, int y, int z) {
		return new ItemStack(this.singleSlab);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemFromBlock(this.singleSlab);
	}

}
