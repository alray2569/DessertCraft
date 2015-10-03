package com.andrewlray.mcmods.dessertcraft.blocks;

import java.util.List;
import java.util.Random;

import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;
import com.andrewlray.mcmods.dessertcraft.worldgen.WorldGenCherryTree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DCSaplings extends BlockSapling {
	public static final String[] SAPLINGS = new String[] { "cherry" };
	private static final IIcon[] saplingIcons = new IIcon[SAPLINGS.length];

	public DCSaplings() {
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F,
				0.5F + f);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockName(DCConstants.MODID + "_" + DCConstants.CHERRY_SAPLING);
		this.setBlockTextureName(DCConstants.MODID + ":"
				+ DCConstants.CHERRY_SAPLING);
		GameRegistry.registerBlock(this, DCConstants.CHERRY_SAPLING);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!world.isRemote) {
			super.updateTick(world, x, y, z, rand);

			if (world.getBlockLightValue(x, y + 1, z) >= 9
					&& rand.nextInt(7) == 0) {
				this.func_149879_c(world, x, y, z, rand);
			}
		}
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		meta &= 7;
		return saplingIcons[MathHelper.clamp_int(meta, 0, 5)];
	}

	// markOrGrowMarked
	@Override
	public void func_149879_c(World world, int x, int y, int z, Random rand) {
		int l = world.getBlockMetadata(x, y, z);

		if ((l & 8) == 0) {
			world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
		} else {
			this.func_149878_d(world, x, y, z, rand);
		}
	}

	// growTree
	@Override
	public void func_149878_d(World world, int x, int y, int z, Random rand) {
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(
				world, rand, x, y, z))
			return;
		int meta = world.getBlockMetadata(x, y, z) & 7;
		Object object = rand.nextInt(10) == 0 ? new WorldGenBigTree(true)
				: new WorldGenTrees(true);
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;

		switch (meta) {
		case 0:
		default:
			object = new WorldGenCherryTree(DCBlocks.cherryLog,
					DCBlocks.cherryLeaf, 0, 0);
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		}

		Block block = Blocks.air;

		if (flag) {
			world.setBlock(x + i1, y, z + j1, block, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1, block, 0, 4);
			world.setBlock(x + i1, y, z + j1 + 1, block, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
		} else {
			world.setBlock(x, y, z, block, 0, 4);
		}

		if (!((WorldGenerator) object).generate(world, rand, x + i1, y, z + j1)) {
			if (flag) {
				world.setBlock(x + i1, y, z + j1, this, meta, 4);
				world.setBlock(x + i1 + 1, y, z + j1, this, meta, 4);
				world.setBlock(x + i1, y, z + j1 + 1, this, meta, 4);
				world.setBlock(x + i1 + 1, y, z + j1 + 1, this, meta, 4);
			} else {
				world.setBlock(x, y, z, this, meta, 4);
			}
		}
	}

	// isSameSapling
	public boolean func_149880_a(World world, int x, int y, int z, int meta) {
		return world.getBlock(x, y, z) == this
				&& (world.getBlockMetadata(x, y, z) & 7) == meta;
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	public int damageDropped(int p_149692_1_) {
		return MathHelper.clamp_int(p_149692_1_ & 7, 0, 5);
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_,
			List p_149666_3_) {
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		for (int i = 0; i < saplingIcons.length; ++i) {
			saplingIcons[i] = p_149651_1_.registerIcon(DCConstants.MODID + ":"
					+ SAPLINGS[i] + "Sapling");
		}
	}

	public boolean func_149851_a(World world, int x, int y, int z,
			boolean p_149851_5_) {
		return true;
	}

	// Bonemeal
	public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
		return (double) world.rand.nextFloat() < 0.45D;
	}

	public void func_149853_b(World p_149853_1_, Random p_149853_2_,
			int p_149853_3_, int p_149853_4_, int p_149853_5_) {
		this.func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_,
				p_149853_2_);
	}
}
