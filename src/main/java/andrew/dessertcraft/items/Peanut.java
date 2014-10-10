package andrew.dessertcraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import andrew.dessertcraft.blocks.DCBlocks;
import static andrew.dessertcraft.lib.DCConstants.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;

public class Peanut extends ItemSeedFood {

	public Peanut(int heal, float saturation) {
		super(heal, saturation, DCBlocks.peanutPlant, Blocks.farmland);
		this.setUnlocalizedName(MODID + "_" + PEANUT);
		this.setTextureName(MODID + ":" + PEANUT);
		GameRegistry.registerItem(this, PEANUT);
	}

}
