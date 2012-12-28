package com.amebame.triton.client.memcached.method;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.databind.JsonNode;

@TritonMethodData("memcached.set")
public class SetCache {
	
	// cluster
	private String cluster;
	
	// cache key
	private String key;
	
	// seconds to expire (max 30 days)
	private int expire;
	
	// cache value
	private JsonNode value;

	public SetCache() {
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

	public void setKey(String key) {
		this.key = key;
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public JsonNode getValue() {
		return value;
	}

	public void setValue(JsonNode value) {
		this.value = value;
	}

}
