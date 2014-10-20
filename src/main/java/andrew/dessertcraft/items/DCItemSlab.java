package andrew.dessertcraft.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;
import andrew.dessertcraft.blocks.DCSlab;

public class DCItemSlab extends ItemSlab {

	public DCItemSlab(Block block) {
		this(block, ((DCSlab) block).singleSlab, ((DCSlab) block).doubleSlab);
	}

	public DCItemSlab(Block block, BlockSlab singleSlab, BlockSlab doubleSlab) {
		super(block, singleSlab, doubleSlab, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
}