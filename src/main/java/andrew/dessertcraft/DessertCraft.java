package andrew.dessertcraft;

import andrew.dessertcraft.achievement.DCAchievements;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.crafting.DCRecipes;
import andrew.dessertcraft.event.DCEvents;
import andrew.dessertcraft.fluids.DCFluids;
import andrew.dessertcraft.handler.DCGuiHandler;
import andrew.dessertcraft.handler.DCNetworkHandler;
import andrew.dessertcraft.handler.DCOreDictHandler;
import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.lib.DCConstants;
import andrew.dessertcraft.proxy.CommonProxy;
import andrew.dessertcraft.registry.FermentationRecipeRegistry;
import andrew.dessertcraft.registry.IceCreamMakerRecipeRegistry;
import andrew.dessertcraft.tileentities.DCTileEntities;
import andrew.dessertcraft.worldgen.WorldGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;

/*
 * TODO: Fix IceCream as Food
 * TODO: Fix IceCream achievement
 * TODO: Model for Barrel
 */

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
	public static DessertCraft instance;

	/**
	 * The Network handler for DessertCraft.
	 */
	public static FMLEventChannel dcnet;

	/**
	 * The sided proxy used for this class. For the client side, its value is
	 * andrew.dessertcraft.proxy.ClientProxy. For the server side, it is
	 * andrew.dessertcraft.proxy.CommonProxy.
	 */
	@SidedProxy(clientSide = "andrew.dessertcraft.proxy.ClientProxy", serverSide = "andrew.dessertcraft.proxy.CommonProxy")
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
		DCFluids.preInit();
		DCBlocks.preInit();
		DCItems.preInit();
		DCTileEntities.init();
		IceCreamMakerRecipeRegistry.init();
		FermentationRecipeRegistry.init();
		instance = this;
		dessertCraftProxy.registerRenderThings();
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
		DCAchievements.init();
		DCEvents.init();
		DCFluids.init();
		DCRecipes.init();
		DCOreDictHandler.init();
		WorldGen.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(DessertCraft.instance,
				new DCGuiHandler());
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
	 * The ServerLoad Event Handler for DessertCraft.
	 * 
	 * @param e
	 */
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent e) {
		FMLEventChannel net = NetworkRegistry.INSTANCE
				.newEventDrivenChannel(DCConstants.MODID);
		dcnet = net;
		net.register(new DCNetworkHandler());
	}
}
