package andrew.dessertcraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import andrew.dessertcraft.lib.DCConstants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSoup;

public class IceCream extends ItemSoup {
	
	public IceCream(int heal, String name) {
		super(heal);
		this.setUnlocalizedName(DCConstants.MODID + "_" + name);
		this.setTextureName(DCConstants.MODID + ":" + name);
		this.setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, name);
	}
	
}
