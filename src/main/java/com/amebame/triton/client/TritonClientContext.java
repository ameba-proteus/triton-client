package com.amebame.triton.client;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.amebame.triton.entity.TritonFuture;

public class TritonClientContext {
	
	private TritonClientConfiguration config;
	
	private ConcurrentHashMap<Integer, TritonFuture> callmap;
	
	private AtomicInteger futureCount;
	
	public TritonClientContext(TritonClientConfiguration config) {
		// call map exceed if it stores over 1000 items
		this.callmap = new ConcurrentHashMap<>();
		this.config = config;
		this.futureCount = new AtomicInteger();
	}
	
	public TritonClientConfiguration getConfig() {
		return config;
	}

	/**
	 * Add future to the context which wait
	 * @param future
	 */
	public void addFuture(TritonFuture future) {
		if (callmap.put(future.getCallId(), future) == null) {
			int total = this.futureCount.incrementAndGet();
			// if future is stored more than 1000 entries,
			// clearing expired futures
			if (total > 1000) {
				clearExpiredFutures();
			}
		}
	}
	
	/**
	 * Get future which waits for the reply.
	 * @param callId
	 * @return
	 */
	public TritonFuture getFuture(int callId) {
		return callmap.get(callId);
	}
	
	/**
	 * Remove future fron the waiting map in the context.
	 * @param callId
	 * @return
	 */
	public TritonFuture removeFuture(int callId) {
		TritonFuture removed = callmap.remove(callId);
		if (removed != null) {
			this.futureCount.decrementAndGet();
		}
		return removed;
	}
	
	/**
	 * Clear expired futures
	 */
	public void clearExpiredFutures() {
		Iterator<TritonFuture> iterator = callmap.values().iterator();
		long now = System.currentTimeMillis();
		while (iterator.hasNext()) {
			TritonFuture future = iterator.next();
			if (future.isExpired(now)) {
				iterator.remove();
			}
		}
	}
}
