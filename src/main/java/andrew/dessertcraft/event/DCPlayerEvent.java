package andrew.dessertcraft.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class DCPlayerEvent extends PlayerEvent {

	public DCPlayerEvent(EntityPlayer player) {
		super(player);
	}

	public static class ChurnEvent extends PlayerEvent {
		
		public final ItemStack churning;

		public ChurnEvent(EntityPlayer player, ItemStack item) {
			super(player);
			this.churning = item;
		}
		
	}
	
}
