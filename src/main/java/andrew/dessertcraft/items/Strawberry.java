package andrew.dessertcraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import andrew.dessertcraft.lib.DCConstants;
import net.minecraft.item.ItemFood;

public class Strawberry extends ItemFood {

	public Strawberry() {
		super(2, .4F, false);
		this.setUnlocalizedName(DCConstants.MODID + "_" + DCConstants.STRAWBERRY);
		this.setTextureName(DCConstants.MODID + ":" + DCConstants.STRAWBERRY);
		GameRegistry.registerItem(this, DCConstants.STRAWBERRY);
	}

}
