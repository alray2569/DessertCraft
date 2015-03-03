package andrew.dessertcraft.net;

import io.netty.buffer.ByteBuf;
import andrew.dessertcraft.tileentities.IButtonHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class GUIButtonPress implements IMessage {
	
	public byte buttonID, guiID;
	public int xpos, ypos, zpos;
	
	public GUIButtonPress() {}
	
	public GUIButtonPress(byte buttonID, byte guiID, int xpos, int ypos, int zpos) {
		this.buttonID = buttonID;
		this.guiID = guiID;
		this.xpos = xpos;
		this.ypos = ypos;
		this.zpos = zpos;
	}
	
	public GUIButtonPress(int buttonID, int guiID, int xpos, int ypos, int zpos) {
		this((byte) buttonID, (byte) guiID, xpos, ypos, zpos);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.buttonID = buf.readByte();
		this.guiID = buf.readByte();
		this.xpos = buf.readInt();
		this.ypos = buf.readInt();
		this.zpos = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeByte(this.buttonID);
		buf.writeByte(this.guiID);
		buf.writeInt(this.xpos);
		buf.writeInt(this.ypos);
		buf.writeInt(this.zpos);
	}
	
	public static class Handler implements IMessageHandler<GUIButtonPress, IMessage> {

		@Override
		public IMessage onMessage(GUIButtonPress message, MessageContext ctx) {
			IButtonHandler te = (IButtonHandler) ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.xpos, message.ypos, message.zpos);
			te.handleButton(message.buttonID, message.guiID);
			return null;
		}
		
	}
	
	
}
