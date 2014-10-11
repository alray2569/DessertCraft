package andrew.dessertcraft.blocks;

import static andrew.dessertcraft.lib.DCConstants.MODID;
import static andrew.dessertcraft.lib.DCConstants.PASTRY_COUNTER;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import andrew.dessertcraft.DessertCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PastryCounter extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon side;
	@SideOnly(Side.CLIENT)
	private IIcon bottom;

	public PastryCounter() {
		super(Material.clay);
		this.setBlockName(MODID + "_" + PASTRY_COUNTER);
		this.setHardness(3.5f);
		this.setResistance(5f);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		GameRegistry.registerBlock(this, PASTRY_COUNTER);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.top : side == 0 ? this.bottom : this.side;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.side = iconRegister.registerIcon(MODID + ":" + PASTRY_COUNTER
				+ "_side");
		this.top = iconRegister.registerIcon(MODID + ":" + PASTRY_COUNTER
				+ "_top");
		this.bottom = iconRegister.registerIcon(MODID + ":" + PASTRY_COUNTER
				+ "_bottom");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float xHit, float yHit, float zHit) {
		if (!player.isSneaking()) {
			player.openGui(DessertCraft.instance,
					DCBlocks.GUI_ID_PASTRYCOUNTER, world, x, y, z);
			return true;
		} else {
			return false;
		}
	}
}
