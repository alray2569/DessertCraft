package andrew.dessertcraft.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import andrew.dessertcraft.blocks.DCLeaves;

public class ItemLeafBlocks extends ItemBlock {

	public ItemLeafBlocks(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int i = stack.getItemDamage();
		if (i < 0 || i >= DCLeaves.LEAVES.length)
			i = 0;
		return super.getUnlocalizedName() + "_" + DCLeaves.LEAVES[i];
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}

}
