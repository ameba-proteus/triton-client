package com.amebame.triton.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * Triton Protocol Encoder
 * to encode data to TritonMesasge
 * 
 */
public class TritonProtocolDecoder extends ReplayingDecoder<Void> {
	
	public TritonProtocolDecoder() {
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx,
			ByteBuf buffer, List<Object> out) throws Exception {
		
		// Wait header data
		if (buffer.readableBytes() < 16) {
			return;
		}
		
		buffer.markReaderIndex();
		
		// Read header
		short type = buffer.readShort();
		int length = buffer.readInt();
		int callId = buffer.readInt();
		
		// Skip reserved bytes
		buffer.skipBytes(6);
		
		// return if body has no enough data
		if (buffer.readableBytes() < length) {
			// reset position
			buffer.resetReaderIndex();
			return;
		}
		
		// read body
		ByteBuf body = buffer.readBytes(length);
		
		// add triton message
		out.add(new TritonMessage(type, callId, body));
	}
}
