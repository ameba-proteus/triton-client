package com.amebame.triton.client.memcached.method;

import java.util.List;

import com.amebame.triton.client.TritonMethodData;

@TritonMethodData("memcached.get")
public class GetCache {
	
	// cluster
	private String cluster;
	
	// cache key
	private String key;
	
	// cache keys
	private List<String> keys;
	
	// expires for get and touch if set.
	private Integer expire;

	public GetCache() {
	}
	
	public String getCluster() {
		return cluster;
	}
	
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	
	public String getKey() {
		return key;
	}
	
	public List<String> getKeys() {
		return keys;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	
	public Integer getExpire() {
		return expire;
	}
	
	public void setExpire(Integer expire) {
		this.expire = expire;
	}

}
