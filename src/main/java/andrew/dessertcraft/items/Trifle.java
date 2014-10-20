package andrew.dessertcraft.items;

import static andrew.dessertcraft.lib.DCConstants.TRIFLE;
import static andrew.dessertcraft.lib.DCConstants.MODID;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class Trifle extends ItemFood {

	public Trifle() {
		super(4, false);
		this.setUnlocalizedName(MODID + "_" + TRIFLE);
		this.setTextureName(MODID + ":" + TRIFLE);
		this.setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, TRIFLE);
	}

}
