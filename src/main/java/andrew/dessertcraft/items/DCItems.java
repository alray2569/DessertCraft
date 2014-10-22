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
	public static Item iceCream_chocolate;
	public static Item iceCream_cherry;
	public static Item iceCream_strawberry;
	public static Item strawberrySeeds;
	public static Item strawberry;
	public static Item bottleRum;
	public static Item bottleSugarWater;
	public static Item peanut;
	public static Item iceCream_peanutButter;
	public static Item applePie;
	public static Item trifle;
	public static Item mixingBowl;
	public static Item pudding;

	/**
	 * Runs at pre-initialization. Initializes mod-added items and registers
	 * them with the game registry.
	 */
	public static void preInit() {

		if (!preinitialized) { // Only run once!
			germanCake = new GermanCake(8, 0.5F, false);
			cherry = new Cherry(3, 0.5F, false);
			iceCream_chocolate = new IceCream(6,
					DCConstants.ICE_CREAM_CHOCOLATE);
			iceCream_cherry = new IceCream(6, DCConstants.ICE_CREAM_CHERRY);
			iceCream_strawberry = new IceCream(6,
					DCConstants.ICE_CREAM_STRAWBERRY);
			iceCream_peanutButter = new IceCream(6,
					DCConstants.ICE_CREAM_PEANUT_BUTTER);

			strawberrySeeds = new StrawberrySeed();
			MinecraftForge.addGrassSeed(new ItemStack(strawberrySeeds), 10);

			peanut = new Peanut(1, 0.5f);
			MinecraftForge.addGrassSeed(new ItemStack(peanut), 2);

			strawberry = new Strawberry();

			bottleRum = new BottleRum();
			bottleSugarWater = new BottleSugarWater();
			
			applePie = new ApplePie();
			
			trifle = new Trifle();
			
			mixingBowl = new MixingBowl();
			
			pudding = new DCFood(4, .5f, false, DCConstants.PUDDING);
			
			preinitialized = true;
		}
	}
}
