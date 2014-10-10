package andrew.dessertcraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import andrew.dessertcraft.lib.DCConstants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class Cherry extends ItemFood {

	public Cherry(int heal, float saturation, boolean wolfMeat) {
		super(heal, saturation, wolfMeat);
		this.setUnlocalizedName(DCConstants.MODID + "_" + DCConstants.CHERRY);
		this.setTextureName(DCConstants.MODID + ":" + DCConstants.CHERRY);
		this.setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, DCConstants.CHERRY);
	}
}
