package andrew.dessertcraft.blocks;

import java.util.Random;

import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.lib.DCConstants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class DCCrop extends BlockCrops {
	private int stages;
	private Item cropSeed;
	private Item crop;

	public DCCrop(String name, int stages, Item cropSeed, Item crop) {
		this.setBlockName(name);
		this.stages = stages;
		this.cropSeed = cropSeed;
		this.crop = crop;
		GameRegistry.registerBlock(this, name);
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.icons = new IIcon[this.stages];

		for (int i = 0; i < this.stages; i++) {
			this.icons[i] = iconRegister.registerIcon(DCConstants.MODID + ":"
					+ this.getUnlocalizedName().substring(5) + (i + 1));
		}
	}

	@Override
	public IIcon getIcon(int side, int metadata) {
		if (metadata < 7) {
			if (metadata == 6) {
				metadata = 5;
			}
			return this.icons[metadata >> 1];
		}
		return this.icons[3];
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	@Override
	protected Item func_149866_i() {
		return this.cropSeed;
	}

	@Override
	protected Item func_149865_P() {
		return this.crop;
	}
}
