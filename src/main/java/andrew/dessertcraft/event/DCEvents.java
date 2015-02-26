package andrew.dessertcraft.event;

import org.apache.logging.log4j.Level;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import andrew.dessertcraft.DessertCraft;
import andrew.dessertcraft.achievement.DCAchievements;
import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.lib.DCConstants;
import andrew.dessertcraft.lib.DCMathHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class DCEvents {
	
	private static boolean initialized = false;
	
	public static void init() {
		
		if (!initialized) { // Only run once!
			FMLCommonHandler.instance().bus().register(new DCEvents.ChurnEvent());
			FMLCommonHandler.instance().bus().register(new DCEvents.OnCraftEvent());
			
			initialized = true;
		}
	}
	
	public static class ChurnEvent {
		@SubscribeEvent
		public void whenChurnComplete(DCPlayerEvent.ChurnEvent e) {
			
			DessertCraft.log(Level.INFO, DCItems.isDessert(e.churning.getItem()));
			long l1 = DCMathHelper.longBinExp(DCItems.isDessert(e.churning.getItem()));
			
			if (l1 != 0L) {
				Long l2 = e.entityPlayer.getEntityData().getLong("dessertcraft_dessertsmade");
				if (l2 == null) {
					l2 = DCMathHelper.longBinExp(DCConstants.MAX_DESSERT_ID + 1);
				}
				l2 = l1 & l2;
				e.entityPlayer.getEntityData().setLong("dessertcraft_dessertsmade", l2);
				
				e.entityPlayer.addStat(DCAchievements.dessertLover, 1);
				
				if (DCMathHelper.bitwiseFoldAnd(l2)) {
					e.entityPlayer.addStat(DCAchievements.gourmand, 1);
				}
			}
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
			
			long l1 = DCMathHelper.longBinExp(DCItems.isDessert(e.crafting.getItem()));
			
			if (l1 != 0L) {
				Long l2 = e.player.getEntityData().getLong("dessertcraft_dessertsmade");
				if (l2 == null) {
					l2 = DCMathHelper.longBinExp(DCConstants.MAX_DESSERT_ID + 1);
				}
				l2 = l1 & l2;
				e.player.getEntityData().setLong("dessertcraft_dessertsmade", l2);
				
				e.player.addStat(DCAchievements.dessertLover, 1);
				
				if (DCMathHelper.bitwiseFoldAnd(l2)) {
					e.player.addStat(DCAchievements.gourmand, 1);
				}
			}
			
			if (e.crafting.getItem().equals(DCItems.rumBall)) {
				if (!e.player.inventory.addItemStackToInventory((new ItemStack(Items.bowl)))) {
					e.player.dropPlayerItemWithRandomChoice(new ItemStack(Items.bowl), false);
				}
			}
		}
	}
}
