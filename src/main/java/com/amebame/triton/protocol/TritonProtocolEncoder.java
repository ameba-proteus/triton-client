package com.amebame.triton.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Triton Protocol Encoder
 * to encode data to TritonMesasge
 * 
 */
public class TritonProtocolEncoder extends MessageToByteEncoder<TritonMessage> {
	
	@Override
	protected void encode(
			ChannelHandlerContext ctx,
			TritonMessage msg,
			ByteBuf out) throws Exception {
		// write to message
		msg.writeTo(out);
	}
}
