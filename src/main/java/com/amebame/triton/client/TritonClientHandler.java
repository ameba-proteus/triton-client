package com.amebame.triton.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.amebame.triton.entity.TritonFuture;
import com.amebame.triton.protocol.TritonMessage;

public class TritonClientHandler extends ChannelInboundHandlerAdapter {
	
	private TritonClientContext context;
	
	public TritonClientHandler(TritonClientContext context) {
		this.context = context;
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		TritonMessage message = (TritonMessage) msg;
		if (message.isReply() || message.isError()) {
			TritonFuture future = context.removeFuture(message.getCallId());
			if (future != null) {
				future.setResult(message);
			}
		}
	}

}
