package andrew.dessertcraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import andrew.dessertcraft.lib.DCConstants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class GermanCake extends ItemFood {
	
	public GermanCake(int heal, float saturation, boolean wolfMeat) {
		super(heal, saturation, wolfMeat);
		setUnlocalizedName(DCConstants.MODID + "_" + DCConstants.GERMAN_CAKE);
		setTextureName(DCConstants.MODID + ":" + DCConstants.GERMAN_CAKE);
		setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, DCConstants.GERMAN_CAKE);
	}
	
}
