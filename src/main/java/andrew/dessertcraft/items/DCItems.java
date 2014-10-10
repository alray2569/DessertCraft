package andrew.dessertcraft.items;

import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.lib.DCConstants;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public final class DCItems {

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

	public static void preInit() {

		germanCake = new GermanCake(8, 0.5F, false);
		cherry = new Cherry(3, 0.5F, false);
		iceCream_chocolate = new IceCream(6, DCConstants.ICE_CREAM_CHOCOLATE);
		iceCream_cherry = new IceCream(6, DCConstants.ICE_CREAM_CHERRY);
		iceCream_strawberry = new IceCream(6, DCConstants.ICE_CREAM_STRAWBERRY);
		iceCream_peanutButter = new IceCream(6, DCConstants.ICE_CREAM_PEANUT_BUTTER);

		strawberrySeeds = new StrawberrySeed();
		MinecraftForge.addGrassSeed(new ItemStack(strawberrySeeds), 10);
		
		peanut = new Peanut(1, 0.5f);
		
		strawberry = new Strawberry();
		
		bottleRum = new BottleRum();
		bottleSugarWater = new BottleSugarWater();
	}
}
