package com.amebame.triton.client;

import java.net.InetSocketAddress;
import java.nio.channels.NotYetConnectedException;
import java.util.concurrent.Executors;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.socket.nio.NioClientBossPool;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioWorkerPool;
import org.jboss.netty.util.HashedWheelTimer;
import org.jboss.netty.util.ThreadNameDeterminer;

import com.amebame.triton.entity.TritonCall;
import com.amebame.triton.entity.TritonFuture;
import com.amebame.triton.exception.TritonClientClosedException;
import com.amebame.triton.exception.TritonClientConnectException;
import com.amebame.triton.exception.TritonClientException;
import com.amebame.triton.exception.TritonClientTimeoutException;
import com.amebame.triton.exception.TritonRuntimeException;
import com.amebame.triton.json.Json;
import com.amebame.triton.protocol.TritonMessage;
import com.amebame.triton.util.NamedThreadFactory;
import com.fasterxml.jackson.databind.JsonNode;

public class TritonClient {
	
	private TritonClientContext context;
	private ChannelPipeline pipeline;
	private ChannelFactory channelFactory;
	private Channel channel;
	
	private static final JsonNode EMPTY_NODE = Json.object();
	
	private static final ThreadNameDeterminer DETERMINER = new ThreadNameDeterminer() {
		@Override
		public String determineThreadName(
				String currentThreadName,
				String proposedThreadName) throws Exception {
			return currentThreadName;
		}
	};
	
	/**
	 * Create triton client with default configuraiton.
	 */
	public TritonClient() {
		this(new TritonClientConfiguration());
	}
	
	/**
	 * Create triton client with the custom configuration.
	 * @param config
	 */
	public TritonClient(TritonClientConfiguration config) {
		context = new TritonClientContext(config);
		NioClientBossPool bossPool = new NioClientBossPool(
				Executors.newCachedThreadPool(new NamedThreadFactory("triton-client-boss-")),
				config.getBoss(),
				new HashedWheelTimer(),
				DETERMINER
		);
		NioWorkerPool workerPool = new NioWorkerPool(
				Executors.newCachedThreadPool(new NamedThreadFactory("triton-client-worker-")),
				config.getWorker(),
				DETERMINER);
		channelFactory = new NioClientSocketChannelFactory(bossPool, workerPool);
		try {
			pipeline = new TritonClientPipelineFactory(context).getPipeline();
		} catch (Exception e) {
			throw new TritonRuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * Opening connection to the server
	 * @param host
	 * @throws TritonClientConnectException
	 */
	public void open(String host) throws TritonClientConnectException {
		open(host, 4848);
	}
	
	/**
	 * Opening connection to the server
	 * @param host
	 * @param port
	 * @throws TritonClientConnectException
	 */
	public void open(String host, int port) throws TritonClientConnectException {
		channel = channelFactory.newChannel(pipeline);
		try {
			ChannelFuture future = channel.connect(new InetSocketAddress(host, port));
			if (!future.await(context.getConfig().getConnectTimeout())) {
				throw new TritonClientConnectException("failed to connect to the server");
			}
		} catch (InterruptedException e) {
		}
	}
	
	/**
	 * Check client status.
	 * @return
	 */
	public boolean isOpen() {
		return channel != null && channel.isConnected();
	}
	
	private void checkOpen() throws TritonClientClosedException {
		if (channel == null || !channel.isOpen()) {
			throw new TritonClientClosedException();
		}
	}
	
	private void write(TritonCall call) throws TritonClientClosedException {
		try {
			channel.write(call.build());
		} catch (NotYetConnectedException e) {
			throw new TritonClientClosedException();
		}
	}
	
	/**
	 * send data to the server and not wait for reply.
	 * @param name
	 * @param data
	 */
	public void sendAsyncFully(String name, Object data) throws TritonClientException {
		checkOpen();
		TritonCall call = new TritonCall(name, data);
		write(call);
	}
	
	/**
	 * Send data to the server and reply future object.
	 * Use future object can to wait for the reply from the server.
	 * @param name
	 * @param data
	 * @return
	 */
	public TritonFuture sendAsync(String name, Object data) throws TritonClientException {
		checkOpen();
		TritonCall call = new TritonCall(name, data);
		TritonFuture future = new TritonFuture(call, context.getConfig().getCommandTimeout());
		context.addFuture(future);
		// send message to the server
		write(call);
		return future;
	}
	
	/**
	 * send only method to the server with future object.
	 * future will be invoked when server send reply
	 * @param name
	 * @param data
	 * @return
	 */
	public TritonFuture sendAsync(String name) throws TritonClientException {
		return sendAsync(name, EMPTY_NODE);
	}
	
	/**
	 * send data to the server with annotated object instance.
	 * object class should have {@link TritonMethodData} annotation.
	 * @param command
	 * @return
	 */
	public TritonFuture sendAsync(Object data) throws TritonClientException {
		TritonMethodData methodData = data.getClass().getAnnotation(TritonMethodData.class);
		if (methodData == null) {
			throw new TritonRuntimeException("method data must annotated with TritonMethodData");
		}
		return sendAsync(methodData.value(), data);
	}
	
	/**
	 * Send datat to the server and waiting for reply.
	 * @param data
	 * @return
	 */
	public JsonNode send(Object data) throws TritonClientException {
		TritonMethodData methodData = data.getClass().getAnnotation(TritonMethodData.class);
		if (methodData == null) {
			throw new TritonRuntimeException("method data must annotated with TritonMethodData");
		}
		return send(methodData.value(), data);
	}
	
	/**
	 * Send datat to the server and waiting for reply.
	 * @param data
	 * @return
	 */
	public <E> E send(Object data, Class<E> resultClass) throws TritonClientException {
		TritonMethodData methodData = data.getClass().getAnnotation(TritonMethodData.class);
		if (methodData == null) {
			throw new TritonRuntimeException("method data must annotated with TritonMethodData");
		}
		JsonNode result = send(methodData.value(), data);
		return Json.convert(result, resultClass);
	}
	
	/**
	 * send data to the server and waiting for reply.
	 * @param name
	 * @param data
	 * @return
	 * @throws TritonClientException throws if server replies error result
	 */
	public JsonNode send(String name, Object data) throws TritonClientException {
		TritonFuture future = sendAsync(name, data);
		TritonMessage message = future.getResult();
		if (message == null) {
			throw new TritonClientTimeoutException("method " + name + " has been timed out");
		}
		if (message.isError()) {
			if (message.hasBody()) {
				JsonNode messageNode = message.getBodyJson().get("message");
				String errorMessage = messageNode == null ? "" : messageNode.asText();
				throw new TritonClientException(errorMessage);
			} else {
				throw new TritonClientException("unknown exception caused at server");
			}
		}
		return message.getBodyJson();
	}
	
	/**
	 * sent data to the server and wait the reply.
	 * this method coverts result data to specified class.
	 * 
	 * @param name
	 * @param data
	 * @param resultClass
	 * @return
	 * @throws TritonClientException
	 */
	public <E> E send(String name, Object data, Class<E> resultClass) throws TritonClientException {
		JsonNode result = send(name, data);
		return Json.convert(result, resultClass);
	}

	/**
	 * Close the client connection
	 */
	public void close() {
		if (channel != null && channel.isConnected()) {
			try {
				channel.close().await(5000L);
			} catch (InterruptedException e) {
			}
		}
		channelFactory.shutdown();
	}
}
