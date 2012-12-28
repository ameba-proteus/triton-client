package com.amebame.triton.client.lock.method;

import com.amebame.triton.client.TritonMethodData;

@TritonMethodData("lock.release")
public class LockRelease {
	
	private String key;
	
	public LockRelease() {
	}
	
	public LockRelease(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
}
