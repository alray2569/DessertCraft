package andrew.dessertcraft.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;

import org.apache.logging.log4j.Level;

import andrew.dessertcraft.DessertCraft;
import andrew.dessertcraft.lib.DCConstants;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;

@Sharable
public class DCPacketPipeline extends MessageToMessageCodec<FMLProxyPacket, AbsDCPacket> {
	
	private EnumMap<Side, FMLEmbeddedChannel> channels;
	private LinkedList<Class<? extends AbsDCPacket>> packets = new LinkedList<>(); 
	private boolean isPostInitialized = false;
	
	public boolean registerPacket(Class<? extends AbsDCPacket> cl) {
		if (this.packets.size() >= 256) {
			DessertCraft.log(Level.ERROR, "DCPacketPipeline failed to register new packet class ", cl, " because maximum number of packets reached.");
			return false;
		}
		if (this.packets.contains(cl)) {
			DessertCraft.log(Level.ERROR, "DCPacketPipeline failed to register new packet class ", cl, " because this class has already been registered.");
			return false;
		}
		if (this.isPostInitialized) {
			DessertCraft.log(Level.ERROR, "DCPacketPipeline failed to register new packet class ", cl, " because DCPacketPipeline has already been post-initialized.");
			return false;
		}
		
		this.packets.add(cl);
		DessertCraft.log(Level.INFO, "Packet class ", cl, " was registered with the DCPacketPipeline.");
		return true;
	}
	
	public void init() {
		this.channels = NetworkRegistry.INSTANCE.newChannel(DCConstants.MODID, this);
		
		this.registerPackets();
	}
	
	public void postinit() {
		if (this.isPostInitialized)
			return;
		
		this.isPostInitialized = true;
		
		Collections.sort(this.packets, new Comparator<Class<? extends AbsDCPacket>>() {

			@Override
			public int compare(Class<? extends AbsDCPacket> o1,	Class<? extends AbsDCPacket> o2) {
				int com = String.CASE_INSENSITIVE_ORDER.compare(o1.getCanonicalName(), o2.getCanonicalName());
				
				if (com == 0) {
					com = o1.getCanonicalName().compareTo(o2.getCanonicalName());
				}
				
				return com;
			}
			
		});
	}
	
	public void registerPackets() {
		registerPacket(GUIButtonPressPacket.class);
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, AbsDCPacket msg, List<Object> out) 
			throws IllegalArgumentException {
		ByteBuf buffer = Unpooled.buffer();
		Class<? extends AbsDCPacket> cl = msg.getClass();
		
		if (!this.packets.contains(cl)) {
			throw new IllegalArgumentException("The packet is not registered: " + cl.getCanonicalName());
		}
		
		byte disc = (byte) this.packets.indexOf(cl);
		buffer.writeByte(disc);
		msg.encodeInto(ctx, buffer);
		
		FMLProxyPacket pxypack = new FMLProxyPacket(buffer.copy(), ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
		
		out.add(pxypack);
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg, List<Object> out) 
			throws NullPointerException, InstantiationException, IllegalAccessException {
		ByteBuf payload = msg.payload();
		byte disc = payload.readByte();
		Class<? extends AbsDCPacket> cl = this.packets.get(disc);
		
		if (cl == null) {
			throw new NullPointerException("The packet is not registered: " + disc);
		}
		
		AbsDCPacket pack = cl.newInstance();
		pack.decodeInto(ctx, payload.slice());
		
		EntityPlayer player;
		switch (FMLCommonHandler.instance().getEffectiveSide()) {
		case CLIENT:
			player = Minecraft.getMinecraft().thePlayer;
			pack.handleClientSide(player);
			
			break;
			
		case SERVER:
			INetHandler neth = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
			player = ((NetHandlerPlayServer) neth).playerEntity;
			pack.handleServerSide(player);
			
			break;
			
		default:
			break;
		}
		
		out.add(pack);
	}
	
	public void sendToServer(AbsDCPacket pack) {
		this.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
		this.channels.get(Side.CLIENT).writeAndFlush(pack);
	}

}
