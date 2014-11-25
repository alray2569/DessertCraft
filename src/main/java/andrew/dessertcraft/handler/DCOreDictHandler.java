package andrew.dessertcraft.handler;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.items.DCItems;

public class DCOreDictHandler {

	private static boolean initialized = false;

	public static final void init() {

		if (!initialized) { // Only run once!
			OreDictionary.registerOre("foodCherry", DCItems.cherry);
			OreDictionary.registerOre("cropCherry", DCItems.cherry);

			OreDictionary.registerOre("foodStrawberry", DCItems.strawberry);
			OreDictionary.registerOre("cropStrawberry", DCItems.strawberry);
			OreDictionary.registerOre("foodStrawberries", DCItems.strawberry);
			OreDictionary.registerOre("cropStrawberries", DCItems.strawberry);

			OreDictionary.registerOre("foodGermanCake", DCItems.germanCake);
			OreDictionary
					.registerOre("foodBlackForestCake", DCItems.germanCake);
			OreDictionary.registerOre("foodChocolateCake", DCItems.germanCake);

			OreDictionary.registerOre("foodIceCream", DCItems.iceCream);

			OreDictionary.registerOre("plankWood", DCBlocks.cherryPlanks);

			OreDictionary.registerOre("slabWood", DCBlocks.cherrySlab);

			OreDictionary.registerOre("stairWood", DCBlocks.cherryStair);

			OreDictionary.registerOre("treeWood", DCBlocks.cherryLog);

			OreDictionary.registerOre("treeLeaves", DCBlocks.cherryLeaf);

			OreDictionary.registerOre("saplingCherry", new ItemStack(
					DCBlocks.sapling, 1, 0));

			OreDictionary
					.registerOre("seedStrawberry", DCItems.strawberrySeeds);

			OreDictionary.registerOre("foodPeanut", DCItems.peanut);
			OreDictionary.registerOre("cropPeanut", DCItems.peanut);

			initialized = true;
		}
	}

}
