package andrew.dessertcraft.event;

import java.util.HashSet;
import java.util.Iterator;

import org.apache.logging.log4j.Level;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.JsonSerializableSet;
import andrew.dessertcraft.DessertCraft;
import andrew.dessertcraft.achievement.DCAchievements;
import andrew.dessertcraft.items.DCItems;

import com.google.common.collect.Sets;

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
	
	public static void dessertCraftedHelper(EntityPlayer player, ItemStack stack) {
		if (DCItems.isDessert(stack.getItem())) {
			player.addStat(DCAchievements.dessertLover, 1);
			
			if (player.worldObj.isRemote) {
				JsonSerializableSet jss = (JsonSerializableSet) ((EntityClientPlayerMP) player).getStatFileWriter().func_150870_b(DCAchievements.gourmand);
				
				System.out.println(jss);
				
				if (jss == null) {
					jss = (JsonSerializableSet) ((EntityClientPlayerMP) player).getStatFileWriter().func_150872_a(DCAchievements.gourmand, new JsonSerializableSet());
				}
				
				jss.add(stack.getItem().getUnlocalizedName());
				
				if (((EntityClientPlayerMP) player).getStatFileWriter().canUnlockAchievement(DCAchievements.gourmand) && jss.size() == DCItems.DESSERTLIST.size()) {
					
					HashSet hashset = Sets.newHashSet(DCItems.DESSERTLIST);
					Iterator iterator = jss.iterator();
					
					while (iterator.hasNext()) {
						String s1 = (String) iterator.next();
						Iterator iterator1 = hashset.iterator();
						
						while (iterator1.hasNext()) {
							Item item = (Item) iterator1.next();
							
							if (item.getUnlocalizedName().equals(s1)) {
								iterator1.remove();
							}
						}
						
						if (hashset.isEmpty()) {
							player.addStat(DCAchievements.gourmand, 1);
						}
					}
				}
			} else {
				JsonSerializableSet jss = (JsonSerializableSet) ((EntityPlayerMP) player).func_147099_x().func_150870_b(DCAchievements.gourmand);
				
				System.out.println(jss);
				
				if (jss == null) {
					jss = (JsonSerializableSet) ((EntityPlayerMP) player).func_147099_x().func_150872_a(DCAchievements.gourmand, new JsonSerializableSet());
				}
				
				jss.add(stack.getItem().getUnlocalizedName());
				
				if (((EntityPlayerMP) player).func_147099_x().canUnlockAchievement(DCAchievements.gourmand) && jss.size() == DCItems.DESSERTLIST.size()) {
					
					HashSet hashset = Sets.newHashSet(DCItems.DESSERTLIST);
					Iterator iterator = jss.iterator();
					
					while (iterator.hasNext()) {
						String s1 = (String) iterator.next();
						Iterator iterator1 = hashset.iterator();
						
						while (iterator1.hasNext()) {
							Item item = (Item) iterator1.next();
							
							if (item.getUnlocalizedName().equals(s1)) {
								iterator1.remove();
							}
						}
						
						if (hashset.isEmpty()) {
							player.addStat(DCAchievements.gourmand, 1);
						}
					}
				}
			}
		}
	}
	
	public static class ChurnEvent {
		@SubscribeEvent
		public void whenChurnComplete(DCPlayerEvent.ChurnEvent e) {
			
			dessertCraftedHelper(e.entityPlayer, e.churning);
			
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
			
			dessertCraftedHelper(e.player, e.crafting);
			
			if (e.crafting.getItem().equals(DCItems.rumBall)) {
				if (!e.player.inventory.addItemStackToInventory((new ItemStack(Items.bowl)))) {
					e.player.dropPlayerItemWithRandomChoice(new ItemStack(Items.bowl), false);
				}
			}
		}
	}
}
