package andrew.dessertcraft.event;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import andrew.dessertcraft.achievement.DCAchievements;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.items.IceCream;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class DCEvents {

	public static void init() {
		MinecraftForge.EVENT_BUS.register(new DCEvents.ChurnEvent());
		FMLCommonHandler.instance().bus().register(new DCEvents.OnCraftEvent());
	}

	public static class ChurnEvent {
		@SubscribeEvent
		public void whenChurnComplete(DCPlayerEvent.ChurnEvent e) {
			if (e.churning.getItem() instanceof IceCream) {
				e.entityPlayer.addStat(DCAchievements.churnIceCream, 1);
			}
		}
	}

	public static class OnCraftEvent {
		@SubscribeEvent
		public void whenCrafted(PlayerEvent.ItemCraftedEvent e) {
			if (e.crafting.getItem().equals(DCItems.germanCake)) {
				e.player.addStat(DCAchievements.makeGermanCake, 1);
			} else if (Block.getBlockFromItem(e.crafting.getItem()).equals(
					DCBlocks.iceCreamMaker)) {
				e.player.addStat(DCAchievements.makeIceCreamChurn, 1);
			}
		}
	}

}
