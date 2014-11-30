package andrew.dessertcraft.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;

import java.io.IOException;

import org.apache.logging.log4j.Level;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.PacketBuffer;
import andrew.dessertcraft.DessertCraft;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.tileentities.TileEntityBarrel;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Sharable
public class DCNetworkHandler {
	@SubscribeEvent
	public void onServerPacket(ServerCustomPacketEvent e) {
		ByteBuf bytebuffer = e.packet.payload();
		PacketBuffer packetbuffer = new PacketBuffer(bytebuffer);
		try {
			e.packet.readPacketData(packetbuffer);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		System.out.println(bytebuffer.toString());
		
		int guiID = bytebuffer.getByte(0);
		DessertCraft.log(Level.DEBUG, guiID);
		switch (guiID) {
		case DCBlocks.GUI_ID_BARREL:
			int x = bytebuffer.getInt((Byte.SIZE) / 8);
			int y = bytebuffer.getInt((Byte.SIZE + Integer.SIZE) / 8);
			int z = bytebuffer.getInt((Byte.SIZE + 2 * Integer.SIZE) / 8);
			int j = bytebuffer.getByte((Byte.SIZE + 3 * Integer.SIZE) / 8);
			DessertCraft.log(Level.DEBUG, x, y, z, j);
			TileEntityBarrel teb = (TileEntityBarrel) Minecraft.getMinecraft().getIntegratedServer().getEntityWorld().getTileEntity(x, y, z);
			teb.handleButton(j);
		}
	}

	@SubscribeEvent
	public void onClientPacket(ClientCustomPacketEvent e) {

	}

	private EntityPlayerMP getSendingPlayer(ServerCustomPacketEvent e) {
		return ((NetHandlerPlayServer) e.handler).playerEntity;
	}
}
