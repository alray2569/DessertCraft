package andrew.dessertcraft.items;

import static andrew.dessertcraft.lib.DCConstants.MODID;
import static andrew.dessertcraft.lib.DCConstants.APPLE_PIE;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ApplePie extends DCFood {

	public ApplePie() {
		super(5, .5f, false, APPLE_PIE);
	}

}
