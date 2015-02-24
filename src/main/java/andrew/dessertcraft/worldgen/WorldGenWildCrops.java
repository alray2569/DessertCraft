package andrew.dessertcraft.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWildCrops extends WorldGenerator {
	
	private Block crop;
	private int cropmeta;
	
	public WorldGenWildCrops(Block crop, int metacrop) {
		this.crop = crop;
		this.cropmeta = metacrop;
	}
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		Block blockAt;
		Block blockBelow;
		
		blockAt = world.getBlock(x, y, z);
		blockBelow = world.getBlock(x, y - 1, z);
		
		if (blockAt.isAir(world, x, y, z) || blockAt == Blocks.tallgrass) {
			if (blockBelow == Blocks.grass || blockBelow == Blocks.dirt) {
				this.setBlockAndNotifyAdequately(world, x, y, z, this.crop, this.cropmeta);
				return true;
			}
		}
		
		return false;
	}
	
}
