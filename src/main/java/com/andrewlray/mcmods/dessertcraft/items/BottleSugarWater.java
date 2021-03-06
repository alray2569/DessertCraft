package com.andrewlray.mcmods.dessertcraft.items;

import java.util.Locale;

import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class BottleSugarWater extends Item {
	
	private final static int AMOUNT = 1000;

	public BottleSugarWater() {
		setUnlocalizedName(DCConstants.MODID + "_" + DCConstants.SUGAR_WATER
				+ "_bottle");
		setTextureName(DCConstants.MODID + ":" + DCConstants.SUGAR_WATER + "_bottle");
		setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, this.getUnlocalizedName().substring(5));
		this.setContainerItem(Items.glass_bottle);
		FluidContainerRegistry.registerFluidContainer(
				FluidRegistry.getFluidStack(
						DCConstants.SUGAR_WATER.toLowerCase(Locale.ENGLISH), AMOUNT),
				new ItemStack(this), new ItemStack(Items.glass_bottle));
	}

}
