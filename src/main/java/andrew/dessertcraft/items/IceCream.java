package andrew.dessertcraft.items;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.registry.GameRegistry;
import andrew.dessertcraft.DessertCraft;
import andrew.dessertcraft.lib.DCConstants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSoup;

@Deprecated
public class IceCream extends ItemSoup {
	
	public IceCream(int heal, String name) {
		super(heal);
		DessertCraft.log(Level.WARN, "The IceCream class was instantiated! This class is deprecated and is going away soon!");
		this.setUnlocalizedName(DCConstants.MODID + "_" + name);
		this.setTextureName(DCConstants.MODID + ":" + name);
		this.setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, name);
	}
	
}
