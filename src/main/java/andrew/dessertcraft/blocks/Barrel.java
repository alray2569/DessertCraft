package andrew.dessertcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import andrew.dessertcraft.DessertCraft;
import andrew.dessertcraft.lib.DCConstants;
import andrew.dessertcraft.tileentities.TileEntityBarrel;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Describes the barrel block in the game.
 * 
 */
public class Barrel extends BlockContainer {

	/** Specifies whether this block's inventory should be kept. */
	private static boolean keepInventory = false;

	/**
	 * Constructor for the barrel block. Defines and registers the barrel block.
	 */
	protected Barrel() {
		super(Material.wood);
		this.setBlockName(DCConstants.MODID + "_" + DCConstants.BARREL);
		this.setBlockTextureName(DCConstants.MODID + ":" + DCConstants.BARREL);
		this.setHardness(2f);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		GameRegistry.registerBlock(this, DCConstants.BARREL);
	}

	/**
	 * Instantiates this block's tile entity and returns it.
	 * 
	 * @param world
	 *            The world in which the block is located.
	 * @param meta
	 *            The metadata of the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBarrel();
	}

	/**
	 * Called when a neighboring block is changed.
	 * 
	 * @param world
	 *            The world in which the block is located.
	 * @param x
	 *            The x-coordinate of the block.
	 * @param y
	 *            The y-coordinate of the block.
	 * @param z
	 *            The z-coordinate of the block.
	 * @param block
	 *            The type of this block.
	 */
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z,
			Block block) {
		super.onNeighborBlockChange(world, x, y, z, block);
		// world.getTileEntity(x, y, z).updateEntity();
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

	/**
	 * Called when this block is placed.
	 * 
	 * @param world
	 *            The world in which the block is located.
	 * @param x
	 *            The x-coordinate of the block.
	 * @param y
	 *            The y-coordinate of the block.
	 * @param z
	 *            The z-coordinate of the block.
	 */
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
	}

	/**
	 * Called when this block is placed.
	 * 
	 * @param world
	 *            The world in which the block is located.
	 * @param x
	 *            The x-coordinate of the block.
	 * @param y
	 *            The y-coordinate of the block.
	 * @param z
	 *            The z-coordinate of the block.
	 * @param p
	 *            The entity that placed the block.
	 * @param m
	 *            The ItemStack from which this block was taken, before it was
	 *            placed.
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase p, ItemStack m) {
		if (m.hasDisplayName()) {
			((TileEntityBarrel) world.getTileEntity(x, y, z)).setCustomName(m
					.getDisplayName());
		}
	}

	/**
	 * Opens the GUI on the client side when the block is activated.
	 * 
	 * @param world
	 *            The world in which the block is located.
	 * @param x
	 *            The x-coordinate of the block.
	 * @param y
	 *            The y-coordinate of the block.
	 * @param z
	 *            The z-coordinate of the block.
	 * @param player
	 *            The player that activated the block.
	 * @param side
	 *            The side of the block that was clicked.
	 * @param hitX
	 *            The x-coordinate where the block was hit.
	 * @param hitY
	 *            The y-coordinate where the block was hit.
	 * @param hitZ
	 *            The z-coordinate where the block was hit.
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return true;
		else if (!player.isSneaking()) {
			TileEntityBarrel entity = (TileEntityBarrel) world.getTileEntity(x,
					y, z);
			if (entity != null) {
				FMLNetworkHandler.openGui(player, DessertCraft.instance,
						DCBlocks.GUI_ID_BARREL, world, x, y, z);
			}
			return true;
		} else
			return false;
	}
}
