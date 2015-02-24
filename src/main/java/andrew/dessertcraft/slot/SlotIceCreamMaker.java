package andrew.dessertcraft.slot;

import andrew.dessertcraft.handler.DCAchievementHandler;
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
	protected void onCrafting(ItemStack stack) {
		super.onCrafting(stack);
		
		DCAchievementHandler.instance.churnEvent(this.thePlayer, stack);
	}

}
