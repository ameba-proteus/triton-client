package com.amebame.triton.client.memcached.method;

import java.util.Arrays;
import java.util.List;

import com.amebame.triton.client.TritonMethodData;

@TritonMethodData("memcached.delete")
public class DeleteCache {
	
	private String cluster;
	
	private List<String> keys;
	
	public DeleteCache() {
	}
	
	public String getCluster() {
		return cluster;
	}
	
	public List<String> getKeys() {
		return keys;
	}
	
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	
	public void setKey(String key) {
		this.keys = Arrays.asList(key);
	}

}
