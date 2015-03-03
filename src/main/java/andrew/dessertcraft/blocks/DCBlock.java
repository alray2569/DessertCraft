package andrew.dessertcraft.blocks;

import static andrew.dessertcraft.lib.DCConstants.MODID;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class DCBlock extends Block {
	
	public DCBlock(Material material, String constName) {
		this(material, constName, CreativeTabs.tabBlock, 2f, 2f);
	}
	
	public DCBlock(Material material, String constName, CreativeTabs creativeTab) {
		this(material, constName, creativeTab, 2f, 2f);
	}

	public DCBlock(Material material, String constName, CreativeTabs creativeTab, float hardness, float resistance) {
		super(material);
		this.setBlockName(MODID + "_" + constName);
		this.setCreativeTab(creativeTab);
		this.setBlockTextureName(MODID + ":" + constName);
		this.setHardness(hardness);
		this.setResistance(resistance);
		GameRegistry.registerBlock(this, constName);
	}
}
