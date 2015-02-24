package andrew.dessertcraft.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.tileentities.ButtonHandler;
import andrew.dessertcraft.tileentities.TileEntityBarrel;

public class GUIButtonPressPacket extends GUIToContainerPacket {
	
	private byte buttonID;
	
	public GUIButtonPressPacket(TileEntity container, byte buttonID, byte guiID) {
		super(container);
		this.buttonID = buttonID;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		super.encodeInto(ctx, buffer);
		buffer.writeByte(this.buttonID);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		super.decodeInto(ctx, buffer);
		this.buttonID = buffer.readByte();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		
	}
	
	@Override
	public void handleServerSide(EntityPlayer player) {
		
		IInventory inv = this.getInventory();
		
		if (inv instanceof ButtonHandler) {
			((ButtonHandler) inv).handleButton(this.buttonID);
		}
	}
	
}
