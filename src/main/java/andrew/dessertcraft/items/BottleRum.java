package andrew.dessertcraft.items;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import andrew.dessertcraft.lib.DCConstants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class BottleRum extends Item {

	protected final String name;
	private static final int AMOUNT = 1000;

	public BottleRum() {
		this.name = "Rum";
		setUnlocalizedName(DCConstants.MODID + "_" + this.name + "_bottle");
		setTextureName(DCConstants.MODID + ":" + this.name + "_bottle");
		GameRegistry.registerItem(this, this.getUnlocalizedName().substring(5));
		FluidContainerRegistry.registerFluidContainer(
				FluidRegistry.getFluidStack(this.name.toLowerCase(), AMOUNT),
				new ItemStack(this), new ItemStack(Items.glass_bottle));
		setHasSubtypes(false);
		this.setContainerItem(Items.glass_bottle);
		setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.drink;
	}
	
	@Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) {
			--stack.stackSize;
		}

		if (!world.isRemote) {
			player.addPotionEffect(new PotionEffect(9, 400));
		}

		if (!player.capabilities.isCreativeMode) {
			if (stack.stackSize <= 0) {
				return new ItemStack(Items.glass_bottle);
			}

			player.inventory.addItemStackToInventory(new ItemStack(
					Items.glass_bottle));
		}

		return stack;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int a, float b, float c, float d) {
		return false;
	}
}
