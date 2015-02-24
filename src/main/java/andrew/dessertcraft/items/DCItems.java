package andrew.dessertcraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import andrew.dessertcraft.lib.DCConstants;

public final class DCItems {
	
	private static boolean preinitialized = false;

	public static Item germanCake;
	public static Item cherry;
	public static Item strawberrySeeds;
	public static Item strawberry;
	public static Item bottleRum;
	public static Item bottleSugarWater;
	public static Item peanut;
	public static Item applePie;
	public static Item trifle;
	public static Item mixingBowl;
	public static Item pudding;
	public static Item iceCream;

	/**
	 * Runs at pre-initialization. Initializes mod-added items and registers
	 * them with the game registry.
	 */
	public static void preInit() {

		if (!preinitialized) { // Only run once!
			germanCake = new GermanCake(8, 0.5F, false);
			cherry = new Cherry(3, 0.5F, false);

			strawberrySeeds = new StrawberrySeed();

			peanut = new Peanut(1, 0.5f);

			strawberry = new Strawberry();

			bottleRum = new BottleRum();
			bottleSugarWater = new BottleSugarWater();
			
			applePie = new ApplePie();
			
			trifle = new Trifle();
			
			mixingBowl = new MixingBowl();
			
			pudding = new DCFood(4, .5f, false, DCConstants.PUDDING);
			
			iceCream = new IceCreamNew();
			
			preinitialized = true;
		}
	}
}
