package com.andrewlray.mcmods.dessertcraft.proxy;

import com.andrewlray.mcmods.dessertcraft.handler.KeyHandler;
import com.andrewlray.mcmods.dessertcraft.renderers.RenderBarrel;
import com.andrewlray.mcmods.dessertcraft.renderers.RenderIceCreamMaker;
import com.andrewlray.mcmods.dessertcraft.tileentities.TileEntityBarrel;
import com.andrewlray.mcmods.dessertcraft.tileentities.TileEntityIceCreamMaker;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderThings() {
		//IceCreamMaker
		TileEntitySpecialRenderer renderIceCreamMaker = new RenderIceCreamMaker();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIceCreamMaker.class, renderIceCreamMaker);
		
		//Barrel
		TileEntitySpecialRenderer renderBarrel = new RenderBarrel();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, renderBarrel);
		 
	}

	@Override
	public void registerTileEntitySpecialRenderer() {

	}
	
	@Override
	public void registerProxyHandlers() {
		FMLCommonHandler.instance().bus().register(new KeyHandler());
	}
}
