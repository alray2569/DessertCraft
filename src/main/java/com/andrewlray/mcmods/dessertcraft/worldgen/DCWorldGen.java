package com.andrewlray.mcmods.dessertcraft.worldgen;

import java.util.Random;

import com.andrewlray.mcmods.dessertcraft.blocks.DCBlocks;
import com.andrewlray.mcmods.dessertcraft.worldgen.*;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DCWorldGen extends WorldGenerator implements IWorldGenerator {
	
	private void generateNether(World world, Random random, int x, int z) {
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
	}
	
	private void generateSurface(World world, Random random, int x, int z) {
		for (int i = 0; i < 20; i++) {
			int Xcoord1 = x * 16 + random.nextInt(16);
			int Ycoord1 = random.nextInt(100);
			int Zcoord1 = random.nextInt(16) + z * 16;
			
			int biomeID = world.getBiomeGenForCoords(Xcoord1, Zcoord1).biomeID;
			String biomeName = world.getBiomeGenForCoords(Xcoord1, Zcoord1).biomeName;
			
			if ((biomeID == 3 && random.nextFloat() > .95)
					|| (biomeID == 34 && random.nextFloat() > .8)
					|| (biomeName.contains("Forest")))
				new WorldGenCherryTree(DCBlocks.cherryLog,
						DCBlocks.cherryLeaf, 0, 0).generate(world, random,
						Xcoord1, Ycoord1, Zcoord1);
		}
		
		{
			int j = 0;
			boolean isGrown = false;
			
			for (; j < 4 && !isGrown; j++) {
				for (int i = 0; i < 20; i++) {
					int Xcoord1 = x * 16 + random.nextInt(16);
					int Ycoord1 = random.nextInt(256);
					int Zcoord1 = random.nextInt(16) + z * 16;
					
					float biomeTemp = world.getBiomeGenForCoords(Xcoord1, Zcoord1).temperature;
					int biomeID = world.getBiomeGenForCoords(Xcoord1, Zcoord1).biomeID;
					
					if (biomeTemp < 1 && biomeTemp >= .5) {
						if (biomeID != 0 && biomeID != 24 && biomeID != 14 && biomeID != 15) {
							new WorldGenWildCrops(DCBlocks.peanutPlant, 5).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
						}
					}
				}
			}
		}
		
		{
			int j = 0;
			boolean isGrown = false;
			
			for (; j < 4 && !isGrown; j++) {
				for (int i = 0; i < 20; i++) {
					int Xcoord1 = x * 16 + random.nextInt(16);
					int Ycoord1 = random.nextInt(256);
					int Zcoord1 = random.nextInt(16) + z * 16;
					
					float biomeTemp = world.getBiomeGenForCoords(Xcoord1, Zcoord1).temperature;
					int biomeID = world.getBiomeGenForCoords(Xcoord1, Zcoord1).biomeID;
					
					if (biomeTemp <= .7 && biomeTemp >= .1) {
						if (biomeID != 0 && biomeID != 24) {
							new WorldGenWildCrops(DCBlocks.strawberryPlant, 5).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, rand, chunkX, chunkZ);
			break;
		case 0:
			generateSurface(world, rand, chunkX, chunkZ);
			break;
		case 1:
			generateEnd(world, rand, chunkX, chunkZ);
		}
	}
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		// TODO Auto-generated method stub
		return true;
	}
}