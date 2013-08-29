package com.amebame.triton.client.elasticsearch.method;

import java.util.List;

import com.amebame.triton.client.TritonMethodData;

@TritonMethodData("elasticsearch.multiget")
public class MultiGetDocument {
	
	private String cluster;
	
	private String index;
	
	private String type;
	
	private List<String> ids;
	
	private long timeout;

	public MultiGetDocument() {
	}
	
	public String getCluster() {
		return cluster;
	}
	
	public List<String> getIds() {
		return ids;
	}
	
	public String getIndex() {
		return index;
	}
	
	public String getType() {
		return type;
	}
	
	public long getTimeout() {
		return timeout;
	}
	
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
	public void setIndex(String index) {
		this.index = index;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
}
