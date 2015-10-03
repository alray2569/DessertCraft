package com.andrewlray.mcmods.dessertcraft.blocks;

import java.util.Random;

import com.andrewlray.mcmods.dessertcraft.DessertCraft;
import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;
import com.andrewlray.mcmods.dessertcraft.tileentities.TileEntityIceCreamMaker;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class IceCreamMaker extends BlockContainer {

	@SideOnly(Side.CLIENT)
	protected static IIcon textureTop;
	@SideOnly(Side.CLIENT)
	protected static IIcon textureSide;

	private static boolean keepInventory = false;

	public IceCreamMaker() {
		super(Material.wood);
		setBlockName(DCConstants.MODID + "_" + DCConstants.ICE_CREAM_MAKER);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockTextureName(DCConstants.MODID + ":" + "iceCreamMaker_side_render");
		setHardness(2f);
		GameRegistry.registerBlock(this, DCConstants.ICE_CREAM_MAKER);
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase p, ItemStack m) {
		if (m.hasDisplayName()) {
			((TileEntityIceCreamMaker) world.getTileEntity(x, y, z))
					.setCustomName(m.getDisplayName());
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return new TileEntityIceCreamMaker();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return true;
		else if (!player.isSneaking()) {
			TileEntityIceCreamMaker entity = (TileEntityIceCreamMaker) world
					.getTileEntity(x, y, z);
			if (entity != null) {
				FMLNetworkHandler.openGui(player, DessertCraft.instance,
						DCBlocks.GUI_ID_ICECREAMMAKER, world, x, y, z);
			}
			return true;
		} else
			return false;
	}
}
