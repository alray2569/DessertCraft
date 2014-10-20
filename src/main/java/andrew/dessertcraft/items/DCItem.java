package andrew.dessertcraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import andrew.dessertcraft.lib.DCConstants;
import cpw.mods.fml.common.registry.GameRegistry;

public class DCItem extends Item {

	public DCItem(String constName, CreativeTabs creativeTab) {
		this.setUnlocalizedName(DCConstants.MODID + "_" + constName);
		this.setTextureName(DCConstants.MODID + ":" + constName);
		this.setCreativeTab(creativeTab);
		GameRegistry.registerItem(this, constName);
	}
}
