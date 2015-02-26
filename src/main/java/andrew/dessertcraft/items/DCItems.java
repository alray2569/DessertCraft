package andrew.dessertcraft.items;

import static andrew.dessertcraft.lib.DCConstants.APPLE_PIE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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
	public static Item rumBall;
	public static Item rumCake;
	
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
			
			applePie = new DCFood(5, .5f, false, DCConstants.APPLE_PIE);
			
			trifle = new Trifle();
			
			mixingBowl = new MixingBowl();
			
			pudding = new DCFood(4, .5f, false, DCConstants.PUDDING) {
				@Override
				public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
					super.onEaten(stack, world, player);
					return new ItemStack(Items.bowl);
				}
			};
			
			rumCake = new DCFood(6, 0.5f, false, DCConstants.RUMCAKE);
			
			iceCream = new IceCreamNew();
			
			rumBall = new DCFood(3, .5f, false, DCConstants.RUMBALL);
			
			preinitialized = true;
		}
	}

	public static int isDessert(Item item) {
		if (item == germanCake) return 0;
		if (item == applePie) return 1;
		if (item == trifle) return 2;
		if (item == pudding) return 3;
		if (item == iceCream) return 4;
		if (item == rumBall) return 5;
		if (item == rumCake) return 6;
		return -1;
	}
}
