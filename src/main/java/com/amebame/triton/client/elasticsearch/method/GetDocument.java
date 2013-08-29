package com.amebame.triton.client.elasticsearch.method;

import com.amebame.triton.client.TritonMethodData;

@TritonMethodData("elasticsearch.get")
public class GetDocument {
	
	private String cluster;
	
	private String index;
	
	private String type;
	
	private String id;
	
	private String routing;
	
	private long timeout;

	public GetDocument() {
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public long getTimeout() {
		return timeout;
	}
	
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	
	public String getRouting() {
		return routing;
	}
	
	public void setRouting(String routing) {
		this.routing = routing;
	}

}
