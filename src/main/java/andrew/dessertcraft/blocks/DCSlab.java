package andrew.dessertcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import andrew.dessertcraft.lib.DCConstants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DCSlab extends BlockSlab {

	private Block block;
	private int blockMeta;
	private boolean isDouble;
	private DCSlab singleSlab;
	private DCSlab doubleSlab;

	public DCSlab(boolean isDouble, Block block, int meta, String name,
			DCSlab otherSlab) {
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

	protected void setDoubleSlab(DCSlab doubleSlab) {
		this.doubleSlab = doubleSlab;
	}

	@Override
	/** getFullSlabName */
	public String func_150002_b(int meta) {
		return this.getUnlocalizedName();
	}

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
