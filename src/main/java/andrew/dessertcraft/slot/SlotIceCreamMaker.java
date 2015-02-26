package andrew.dessertcraft.slot;

import org.apache.logging.log4j.Level;

import andrew.dessertcraft.DessertCraft;
import andrew.dessertcraft.achievement.DCAchievements;
import andrew.dessertcraft.handler.DCAchievementHandler;
import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.lib.DCConstants;
import andrew.dessertcraft.lib.DCMathHelper;
import andrew.dessertcraft.tileentities.TileEntityIceCreamMaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotIceCreamMaker extends Slot {
	
	private EntityPlayer thePlayer;

	public SlotIceCreamMaker(EntityPlayer player, IInventory iinv, int i, int j, int k) {
		super(iinv, i, j, k);
		this.thePlayer = player;
	}
	
	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
		super.onPickupFromSlot(player, stack);
		DessertCraft.log(Level.INFO, DCItems.isDessert(stack.getItem()));
		long l1 = DCMathHelper.longBinExp(DCItems.isDessert(stack.getItem()));
		
		if (l1 != 0L) {
			Long l2 = player.getEntityData().getLong("dessertcraft_dessertsmade");
			if (l2 == null) {
				l2 = DCMathHelper.longBinExp(DCConstants.MAX_DESSERT_ID + 1);
			}
			l2 = l1 & l2;
			player.getEntityData().setLong("dessertcraft_dessertsmade", l2);
			
			player.addStat(DCAchievements.dessertLover, 1);
			
			if (DCMathHelper.bitwiseFoldAnd(l2)) {
				player.addStat(DCAchievements.gourmand, 1);
			}
		}
	}

}
