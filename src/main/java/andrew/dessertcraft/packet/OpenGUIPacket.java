package andrew.dessertcraft.packet;

import andrew.dessertcraft.DessertCraft;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public class OpenGUIPacket extends AbsDCPacket {
	
	private byte id;
	
	public OpenGUIPacket() {
		
	}
	
	public OpenGUIPacket(byte id) {
		this.id = id;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeByte(this.id);
	}
	
	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		this.id = buffer.readByte();
	}
	
	@Override
	public void handleClientSide(EntityPlayer player) {}
	
	@Override
	public void handleServerSide(EntityPlayer player) {
		FMLNetworkHandler.openGui(player, DessertCraft.instance, id, player.worldObj,  (int) player.posX,  (int) player.posY, (int) player.posZ);
	}
	
}
