package andrew.dessertcraft.blocks;

import java.util.List;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import andrew.dessertcraft.items.ItemLogBlocks;
import andrew.dessertcraft.lib.DCConstants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DCLogs extends BlockLog {

	public static final String[] LOGS = new String[] { "cherry" };

	@SideOnly(Side.CLIENT)
	protected static IIcon topIcon;
	@SideOnly(Side.CLIENT)
	protected static IIcon sideIcon;

	public DCLogs(int i) {
		super();
		this.setBlockName(DCConstants.MODID + "_" + DCConstants.LOG);
		this.setBlockTextureName(DCConstants.MODID + ":" + DCConstants.LOG);
		GameRegistry.registerBlock(this, ItemLogBlocks.class, this
				.getUnlocalizedName().substring(5));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < LOGS.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.field_150167_a = new IIcon[LOGS.length];
		this.field_150166_b = new IIcon[LOGS.length];

		for (int i = 0; i < this.field_150167_a.length; i++) {
			this.field_150167_a[i] = iconRegister.registerIcon(this
					.getTextureName() + "_" + LOGS[i]);
			this.field_150166_b[i] = iconRegister.registerIcon(this
					.getTextureName() + "_" + LOGS[i] + "_top");
		}
	}

	/*
	 * @Override
	 * 
	 * @SideOnly(Side.CLIENT) public void registerBlockIcons(IIconRegister icon)
	 * { topIcon = icon.registerIcon(Constants.MODID + ":" + Constants.cherryLog
	 * + "_top"); sideIcon = icon.registerIcon(Constants.MODID + ":" +
	 * Constants.cherryLog + "_side"); }
	 * 
	 * @Override
	 * 
	 * @SideOnly(Side.CLIENT) public IIcon getIcon(int side, int meta) { if
	 * (side == 1 || side == 0) return topIcon; else return sideIcon; }
	 */
}
