package andrew.dessertcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.lib.DCConstants;

/**
 * Handler for all DessertCraft mod-related blocks.
 *
 */
public final class DCBlocks {

	private static boolean preinitialized = false;

	public static Block cherryLog;
	public static Block cherryPlanks;
	public static Block cherryLeaf;
	public static Block sapling;
	public static Block iceCreamMaker;
	public static final int GUI_ID_ICECREAMMAKER = 0;
	public static Block strawberryPlant;
	public static Block peanutPlant;
	public static Block sugarWater;
	public static Block rum;
	public static Block barrel;
	public static final int GUI_ID_BARREL = 1;
	public static Block cherryStair;
	@Deprecated
	public static Block cherrySlab_OLD;
	@Deprecated
	public static Block cherrySlab_double_OLD;
	public static Block cherrySlab;
	public static Block cherrySlab_double;
	public static Block pastryCounter;
	public static final int GUI_ID_PASTRYCOUNTER = 2;

	/**
	 * Runs during pre-initialization. Defines all mod-related blocks.
	 */
	public static void preInit() {
		if (!preinitialized) { // Only run once!
			cherryLog = new DCLogs(0);
			cherryPlanks = new CherryPlanks();
			cherryLeaf = new DCLeaves(0);
			sapling = new DCSaplings();

			iceCreamMaker = new IceCreamMaker();

			strawberryPlant = new StrawberryCrop(DCConstants.STRAWBERRY_PLANT,
					4, DCItems.strawberrySeeds, DCItems.strawberry);
			peanutPlant = new PeanutCrop(DCConstants.PEANUT_PLANT, 4);

			rum = new BlockRum();
			sugarWater = new BlockSugarWater();

			barrel = new Barrel();

			cherryStair = new DCStair(cherryPlanks, 0, "cherryStair");
			/*
			cherrySlab_OLD = new DCSlab_OLD(false, cherryPlanks, 0,
					"cherrySlab", (DCSlab_OLD) cherrySlab_double_OLD);
			cherrySlab_double_OLD = new DCSlab_OLD(true, cherryPlanks, 0,
					"cherrySlab_double", (DCSlab_OLD) cherrySlab_OLD);
			*/

			cherrySlab = new DCSlab(false, Material.wood, "cherryPlanks");
			cherrySlab_double = new DCSlab(true, Material.wood, "cherryPlanks");
			DCSlab.registerSlabs((DCSlab) cherrySlab,
					(DCSlab) cherrySlab_double);

			pastryCounter = new PastryCounter();

			preinitialized = true;
		}
	}
}
