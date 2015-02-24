package andrew.dessertcraft.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldProvider;

public abstract class GUIToContainerPacket extends AbsDCPacket {
	
	private TileEntity container;
	
	public GUIToContainerPacket(TileEntity container) {
		if (!(this.container instanceof IInventory)) {
			throw new IllegalArgumentException("Container is invalid.");
		}
		this.container = container;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(this.container.xCoord);
		buffer.writeInt(this.container.yCoord);
		buffer.writeInt(this.container.zCoord);
		buffer.writeInt(this.container.getWorldObj().provider.dimensionId);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		int x = buffer.readInt();
		int y = buffer.readInt();
		int z = buffer.readInt();
		int dimID = buffer.readInt();
		this.container = WorldProvider.getProviderForDimension(dimID).worldObj.getTileEntity(x, y, z);
	}
	
	@SuppressWarnings("unchecked")
	protected IInventory getInventory() {
		return (IInventory) this.container;
	}
	
}
