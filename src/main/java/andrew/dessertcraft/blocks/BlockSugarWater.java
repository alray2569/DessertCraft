package andrew.dessertcraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import andrew.dessertcraft.lib.DCConstants;
import andrew.dessertcraft.liquids.DCLiquids;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSugarWater extends BlockFluidClassic {

	/** Icon for block when not flowing. */
	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;
	/** Icon for block when flowing */
	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;

	/**
	 * Constructor for the Block of Sugar Water. Defines and registers this
	 * block.
	 */
	public BlockSugarWater() {
		super(DCLiquids.sugarWater, Material.water);
		this.setBlockName(DCConstants.MODID + "_"
				+ DCConstants.BLOCK_SUGAR_WATER);
		this.setBlockTextureName(DCConstants.MODID + ":"
				+ DCConstants.BLOCK_SUGAR_WATER);
		GameRegistry.registerBlock(this, DCConstants.BLOCK_SUGAR_WATER);
	}

	/**
	 * @param side
	 *            The side from which the block is being viewed.
	 * @param meta
	 *            The metadata of the block being viewed.
	 * @return The appropriate icon (IIcon) to display.
	 */
	@Override
	public IIcon getIcon(int side, int meta) {
		return (side == 0 || side == 1) ? stillIcon : flowingIcon;
	}

	/**
	 * Registers the appropriate block icons with the given IIconRegister.
	 * 
	 * @param iconRegister
	 *            The appropriate IIconRegister with which to register the
	 *            icons.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.stillIcon = iconRegister.registerIcon(DCConstants.MODID + ":"
				+ DCConstants.BLOCK_SUGAR_WATER + "_still");
		this.flowingIcon = iconRegister.registerIcon(DCConstants.MODID + ":"
				+ DCConstants.BLOCK_SUGAR_WATER + "_flowing");
	}

	/**
	 * Checks if this liquid can displace a given block.
	 * 
	 * @param world
	 *            The world (cast to IBlockAccess).
	 * @param x
	 *            The x-coordinate of the block to displace
	 * @param y
	 *            The y-coordinate of the block to displace
	 * @param z
	 *            The z-coordinate of the block to displace
	 * @return true if this block can displace the given block.
	 */
	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.canDisplace(world, x, y, z);
	}

	/**
	 * Displaces the block if it can be displaced.
	 * 
	 * @param world
	 *            The world.
	 * @param x
	 *            The x-coordinate of the block to replace
	 * @param y
	 *            The y-coordinate of the block to replace
	 * @param z
	 *            The z-coordinate of the block to replace
	 * @return true if successful
	 */
	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.displaceIfPossible(world, x, y, z);
	}
}
