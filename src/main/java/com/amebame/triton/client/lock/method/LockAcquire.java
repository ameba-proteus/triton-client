package com.amebame.triton.client.lock.method;

import com.amebame.triton.client.TritonMethodData;

@TritonMethodData("lock.acquire")
public class LockAcquire {
	
	private String key;
	
	private int timeout = 10000;

	public LockAcquire() {
	}
	
	public LockAcquire(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public int getTimeout() {
		return timeout;
	}
	
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
}
