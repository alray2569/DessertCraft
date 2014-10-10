package andrew.dessertcraft.handler;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.items.DCItems;

public class DCOreDictHandler {

	public static final void init() {
		OreDictionary.registerOre("foodCherry", DCItems.cherry);
		OreDictionary.registerOre("cropCherry", DCItems.cherry);
		
		OreDictionary.registerOre("foodStrawberry", DCItems.strawberry);
		OreDictionary.registerOre("cropStrawberry", DCItems.strawberry);
		OreDictionary.registerOre("foodStrawberries", DCItems.strawberry);
		OreDictionary.registerOre("cropStrawberries", DCItems.strawberry);
		
		OreDictionary.registerOre("foodGermanCake", DCItems.germanCake);
		OreDictionary.registerOre("foodBlackForestCake", DCItems.germanCake);
		OreDictionary.registerOre("foodChocolateCake", DCItems.germanCake);
		
		OreDictionary.registerOre("foodIceCream", DCItems.iceCream_cherry);
		OreDictionary.registerOre("foodCherryIceCream", DCItems.iceCream_cherry);
		
		OreDictionary.registerOre("foodIceCream", DCItems.iceCream_chocolate);
		OreDictionary.registerOre("foodChocolateIceCream", DCItems.iceCream_chocolate);
		
		OreDictionary.registerOre("foodIceCream", DCItems.iceCream_strawberry);
		OreDictionary.registerOre("foodStrawberryIceCream", DCItems.iceCream_strawberry);
		
		OreDictionary.registerOre("plankWood", DCBlocks.cherryPlanks);
		
		OreDictionary.registerOre("treeWood", DCBlocks.cherryLog);
		
		OreDictionary.registerOre("treeLeaves", DCBlocks.cherryLeaf);
		
		OreDictionary.registerOre("saplingCherry", new ItemStack(DCBlocks.sapling, 1, 0));
		
		OreDictionary.registerOre("seedStrawberry", DCItems.strawberrySeeds);
	}
	
}
