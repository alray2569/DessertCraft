package andrew.dessertcraft.items;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import andrew.dessertcraft.lib.DCConstants;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class IceCreamNew extends ItemSoup {

	private static String[] names = { "chocolate", "cherry", "strawberry",
			"peanutButter" };

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public IceCreamNew() {
		super(6);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(DCConstants.ICE_CREAM);
		this.setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, DCConstants.ICE_CREAM);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int i = this.getDamage(stack);
		if (i < 0 || i > names.length)
			i = 0;
		return super.getUnlocalizedName() + "_" + names[i];
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < names.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.icons = new IIcon[names.length];

		for (int i = 0; i < this.icons.length; i++) {
			this.icons[i] = iconRegister.registerIcon(DCConstants.MODID + ":"
					+ this.getUnlocalizedName().substring(5) + "_" + names[i]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return this.icons[meta % this.icons.length];
	}

}
