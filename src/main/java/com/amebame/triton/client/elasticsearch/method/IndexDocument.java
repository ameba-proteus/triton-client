package com.amebame.triton.client.elasticsearch.method;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.databind.JsonNode;

@TritonMethodData("elasticsearch.index")
public class IndexDocument {
	
	private String cluster;
	
	private String index;
	
	private String type;
	
	private String id;
	
	private JsonNode source;
	
	private String routing;
	
	private long timeout;
	
	private long ttl;
	
	private boolean refresh = false;
	
	public IndexDocument() {
	}
	
	public String getCluster() {
		return cluster;
	}
	
	public String getIndex() {
		return index;
	}
	
	public String getType() {
		return type;
	}
	
	public String getId() {
		return id;
	}
	
	public JsonNode getSource() {
		return source;
	}
	
	public long getTimeout() {
		return timeout;
	}
	
	public String getRouting() {
		return routing;
	}
	
	public long getTtl() {
		return ttl;
	}
	
	public boolean isRefresh() {
		return refresh;
	}
	
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	
	public void setIndex(String index) {
		this.index = index;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setSource(JsonNode source) {
		this.source = source;
	}
	
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setRefresh(boolean refresh) {
		this.refresh = refresh;
	}
	
	public void setRouting(String routing) {
		this.routing = routing;
	}
	
	public void setTtl(long ttl) {
		this.ttl = ttl;
	}
}
