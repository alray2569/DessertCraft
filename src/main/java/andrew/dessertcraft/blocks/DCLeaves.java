package andrew.dessertcraft.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.items.ItemLeafBlocks;
import andrew.dessertcraft.lib.DCConstants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DCLeaves extends BlockLeaves {

	public static final String[][] LEAFTYPES = new String[][] { { "cherry" },
			{ "cherry_opaque" } };

	public static final String[] LEAVES = new String[] { "cherry" };

	public DCLeaves(int i) {
		super();
		this.setBlockName(DCConstants.MODID + "_" + DCConstants.LEAF);
		this.setBlockTextureName(DCConstants.MODID + ":" + DCConstants.LEAF);
		GameRegistry.registerBlock(this, ItemLeafBlocks.class, this
				.getUnlocalizedName().substring(5));
	}

	@Override
	protected void func_150124_c(World world, int x, int y, int z, int meta,
			int chance) {
		if ((meta & 3) == 0 && world.rand.nextInt(chance) == 0) {
			this.dropBlockAsItem(world, x, y, z, new ItemStack(DCItems.cherry, 1, 0));
		}
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z,
			int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		int chance = this.func_150123_b(metadata);

		if (fortune > 0) {
			chance -= 2 << fortune;
			if (chance < 10)
				chance = 10;
		}

		if (world.rand.nextInt(chance) == 0)
			ret.add(new ItemStack(this.getItemDropped(metadata, world.rand,
					fortune), 1, this.damageDropped(metadata)));

		chance = 10;

		this.captureDrops(true);
		this.func_150124_c(world, x, y, z, metadata, chance);
		ret.addAll(this.captureDrops(false));
		return ret;
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemFromBlock(DCBlocks.sapling);
	}

	@Override
	public int damageDropped(int damage) {
		return super.damageDropped(damage) + 4;
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z) & 3;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < LEAVES.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		for (int i = 0; i < LEAFTYPES.length; ++i) {
			this.field_150129_M[i] = new IIcon[LEAFTYPES[i].length];

			for (int j = 0; j < LEAFTYPES[i].length; ++j) {
				this.field_150129_M[i][j] = iconRegister.registerIcon(this
						.getTextureName() + "_" + LEAFTYPES[i][j]);
			}
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1]
				: this.field_150129_M[this.field_150127_b][0];
	}

	@Override
	public String[] func_150125_e() {
		return LEAVES;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y,
			int z, int side) {
		return true;
	}
}
