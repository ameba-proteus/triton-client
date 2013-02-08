package com.amebame.triton.client.lock.method;

import com.amebame.triton.client.TritonMethodData;

@TritonMethodData("lock.release")
public class LockRelease {
	
	private String key;
	
	private int ownerId;
	
	public LockRelease() {
	}
	
	public LockRelease(String key, int ownerId) {
		this.key = key;
		this.ownerId = ownerId;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public int getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
}
