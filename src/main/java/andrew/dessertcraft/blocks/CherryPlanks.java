package andrew.dessertcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import andrew.dessertcraft.lib.DCConstants;
import cpw.mods.fml.common.registry.GameRegistry;

public class CherryPlanks extends Block {

	/**
	 * Constructor for Cherry Planks Block. Defines and registers this block.
	 */
	public CherryPlanks() {
		super(Material.wood);
		this.setBlockName(DCConstants.MODID + "_" + DCConstants.CHERRY_PLANKS);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockTextureName(DCConstants.MODID + ":"
				+ DCConstants.CHERRY_PLANKS);
		this.setHardness(2f);
		GameRegistry.registerBlock(this, DCConstants.CHERRY_PLANKS);
	}
}
