package andrew.dessertcraft.event;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import andrew.dessertcraft.items.DCItems;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class DCEvents {

	private static boolean initialized = false;

	public static void init() {

		if (!initialized) { // Only run once!
			MinecraftForge.EVENT_BUS.register(new DCEvents.ChurnEvent());
			FMLCommonHandler.instance().bus()
					.register(new DCEvents.OnCraftEvent());

			initialized = true;
		}
	}

	public static class ChurnEvent {
		@SubscribeEvent
		public void whenChurnComplete(DCPlayerEvent.ChurnEvent e) {
			/*
			 * if (e.churning.getItem() instanceof IceCream) {
			 * e.entityPlayer.addStat(DCAchievements.churnIceCream, 1); }
			 */
		}
	}

	public static class OnCraftEvent {
		@SubscribeEvent
		public void whenCrafted(PlayerEvent.ItemCraftedEvent e) {
			/*
			 * if (e.crafting.getItem().equals(DCItems.germanCake)) {
			 * e.player.addStat(DCAchievements.makeGermanCake, 1); } else if
			 * (Block.getBlockFromItem(e.crafting.getItem()).equals(
			 * DCBlocks.iceCreamMaker)) {
			 * e.player.addStat(DCAchievements.makeIceCreamChurn, 1); }
			 */
			
			if (e.crafting.getItem().equals(DCItems.rumBall)) {
				if (!e.player.inventory.addItemStackToInventory((new ItemStack(Items.bowl)))) {
					e.player.dropPlayerItemWithRandomChoice(new ItemStack(Items.bowl), false);
				}
			}
		}
	}
}
