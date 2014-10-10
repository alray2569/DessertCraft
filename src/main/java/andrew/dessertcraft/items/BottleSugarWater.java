package andrew.dessertcraft.items;

import java.util.Locale;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import andrew.dessertcraft.lib.DCConstants;
import cpw.mods.fml.common.registry.GameRegistry;

public class BottleSugarWater extends Item {
	
	private final static int AMOUNT = 1000;

	public BottleSugarWater() {
		setUnlocalizedName(DCConstants.MODID + "_" + DCConstants.SUGAR_WATER
				+ "_bottle");
		setTextureName(DCConstants.MODID + ":" + DCConstants.SUGAR_WATER + "_bottle");
		setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, this.getUnlocalizedName().substring(5));
		FluidContainerRegistry.registerFluidContainer(
				FluidRegistry.getFluidStack(
						DCConstants.SUGAR_WATER.toLowerCase(Locale.ENGLISH), AMOUNT),
				new ItemStack(this), new ItemStack(Items.glass_bottle));
	}

}
