package andrew.dessertcraft.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import andrew.dessertcraft.renderers.RenderBarrel;
import andrew.dessertcraft.renderers.RenderIceCreamMaker;
import andrew.dessertcraft.tileentities.TileEntityBarrel;
import andrew.dessertcraft.tileentities.TileEntityIceCreamMaker;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

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
}
