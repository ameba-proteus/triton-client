package com.amebame.triton.client;

import com.amebame.triton.protocol.TritonProtocolDecoder;
import com.amebame.triton.protocol.TritonProtocolEncoder;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class TritonClientChannelInitializer extends ChannelInitializer<SocketChannel> {
	
	private TritonClientContext context;
	
	public TritonClientChannelInitializer(TritonClientContext context) {
		this.context = context;
	}
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast("encoder", new TritonProtocolEncoder());
		pipeline.addLast("decoder", new TritonProtocolDecoder());
		pipeline.addLast("handler", new TritonClientHandler(context));
	}
}
