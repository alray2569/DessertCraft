package com.andrewlray.mcmods.dessertcraft;

import org.apache.logging.log4j.Level;

import com.andrewlray.mcmods.dessertcraft.achievement.DCAchievements;
import com.andrewlray.mcmods.dessertcraft.blocks.DCBlocks;
import com.andrewlray.mcmods.dessertcraft.crafting.DCRecipes;
import com.andrewlray.mcmods.dessertcraft.crafting.mixingbowl.MixingBowlIngredientRecipe;
import com.andrewlray.mcmods.dessertcraft.crafting.mixingbowl.MixingBowlRecipe;
import com.andrewlray.mcmods.dessertcraft.event.DCEvents;
import com.andrewlray.mcmods.dessertcraft.fluids.DCFluids;
import com.andrewlray.mcmods.dessertcraft.handler.DCAchievementHandler;
import com.andrewlray.mcmods.dessertcraft.handler.DCGuiHandler;
import com.andrewlray.mcmods.dessertcraft.handler.DCOreDictHandler;
import com.andrewlray.mcmods.dessertcraft.items.DCItems;
import com.andrewlray.mcmods.dessertcraft.lib.DCConstants;
import com.andrewlray.mcmods.dessertcraft.net.GUIButtonPress;
import com.andrewlray.mcmods.dessertcraft.proxy.CommonProxy;
import com.andrewlray.mcmods.dessertcraft.registry.FermentationRecipeRegistry;
import com.andrewlray.mcmods.dessertcraft.registry.IceCreamMakerRecipeRegistry;
import com.andrewlray.mcmods.dessertcraft.tileentities.DCTileEntities;
import com.andrewlray.mcmods.dessertcraft.worldgen.WorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.relauncher.Side;

/**
 * The base class for DessertCraft.
 * 
 * @author Andrew Ray
 * @version %I%%G%
 *
 */
@Mod(modid = DCConstants.MODID, name = DCConstants.MODNAME, version = DCConstants.VERSION)
public class DessertCraft {
	
	/**
	 * The Static instance of this class, since there is only one.
	 */
	@Mod.Instance(DCConstants.MODID)
	public static DessertCraft instance;
	
	/**
	 * The DCNet, which is the Network Channel for DC Packets.
	 */
	public static SimpleNetworkWrapper dcnet;
	
	/**
	 * The sided proxy used for this class. For the client side, its value is
	 * andrew.dessertcraft.proxy.ClientProxy. For the server side, it is
	 * andrew.dessertcraft.proxy.CommonProxy.
	 */
	@SidedProxy(clientSide = "com.andrewlray.mcmods.dessertcraft.proxy.ClientProxy", serverSide = "com.andrewlray.mcmods.dessertcraft.proxy.CommonProxy")
	public static CommonProxy dessertCraftProxy;
	
	/**
	 * The pre-initialization event handler for DessertCraft. Instantiates
	 * liquids, blocks, items, tileentities, and the Recipe Registries for the
	 * IceCreamMaker and the Barrel. Also registers this instance of the class
	 * and registers the Mod's Special Renderers.
	 * 
	 * @param e
	 */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		// Call all the preinitializers
		DCFluids.preInit();
		DCBlocks.preInit();
		DCItems.preInit();
		DCTileEntities.preInit();
		IceCreamMakerRecipeRegistry.preInit();
		FermentationRecipeRegistry.preInit();
		MixingBowlRecipe.init();
		MixingBowlIngredientRecipe.init();
		// Register the DessertCraft block custom renderer
		dessertCraftProxy.registerProxies();
		dcnet = NetworkRegistry.INSTANCE.newSimpleChannel("DessertCraft");
		dcnet.registerMessage(GUIButtonPress.Handler.class, GUIButtonPress.class, 0, Side.SERVER);
	}
	
	/**
	 * The initialization event handler for DessertCraft. Matches liquids to
	 * blocks, which must be done after preInit because of circular
	 * dependencies, instantiates the recipe class which adds all mod-related
	 * recipes to Minecraft, the OreDict class which registers mod-related items
	 * to the Forge Ore Dictionary, and the WorldGen class which adds cherry
	 * trees to the world. Also registers the DessertCraft GuiHandler, which
	 * handles mod-related GUIs.
	 * 
	 * @param e
	 */
	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		// Call all the initializers
		DCAchievements.init();
		DCEvents.init();
		DCFluids.init();
		DCRecipes.init();
		DCOreDictHandler.init();
		WorldGen.init();
		DCAchievementHandler.init();
		// Register the DessertCraft GUI Handler
		NetworkRegistry.INSTANCE.registerGuiHandler(DessertCraft.instance, new DCGuiHandler());
	}
	
	/**
	 * The post-initialization event handler for DessertCraft.
	 * 
	 * @param e
	 */
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	/**
	 * Logs errors to the console using the FMLRelaunchLog.
	 * 
	 * @param level
	 * @param string
	 */
	private static void log(Level level, String string) {
		FMLRelaunchLog.log("DessertCraft", level, string);
	}
	
	/**
	 * Unfolds objects into strings and logs to the console using the
	 * FMLRelaunchLog.
	 * 
	 * @param level
	 *            Level of the log
	 * @param obj
	 *            What to log
	 */
	public static void log(Level level, Object... obj) {
		String str = "";
		
		for (int x = 0; x < obj.length; x++) {
			if (obj[x] instanceof String) {
				str += obj[x];
			} else {
				str += String.valueOf(obj[x]);
			}
		}
		
		log(level, str);
	}
}
