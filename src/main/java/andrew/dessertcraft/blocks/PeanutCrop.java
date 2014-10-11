package andrew.dessertcraft.blocks;

import java.util.Random;

import andrew.dessertcraft.blocks.DCCrop;
import andrew.dessertcraft.items.DCItems;
import net.minecraft.item.Item;

public class PeanutCrop extends DCCrop {

	public PeanutCrop(String name, int stages) {
		super(name, stages, DCItems.peanut, DCItems.peanut);
	}
	
	@Override
	protected Item func_149866_i() {
		return DCItems.peanut;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		return 4;
	}
}
