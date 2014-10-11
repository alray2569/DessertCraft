package andrew.dessertcraft.blocks;

import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.lib.DCConstants;
import andrew.dessertcraft.liquids.Rum;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;

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
	public static Block cherrySlab;
	public static Block cherrySlab_double;

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
			peanutPlant = new CropPeanut(DCConstants.PEANUT_PLANT, 4);

			rum = new BlockRum();
			sugarWater = new BlockSugarWater();

			barrel = new Barrel();

			cherryStair = new DCStair(cherryPlanks, 0, "cherryStair");
			cherrySlab = new DCSlab(false, cherryPlanks, 0, "cherrySlab",
					(DCSlab) cherrySlab_double);
			cherrySlab_double = new DCSlab(true, cherryPlanks, 0,
					"cherrySlab_double", (DCSlab) cherrySlab);
			
			preinitialized = true;
		}
	}
}
