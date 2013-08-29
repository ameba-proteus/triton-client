package com.amebame.triton.client.elasticsearch.method;

import com.amebame.triton.client.TritonMethodData;

@TritonMethodData("elasticsearch.delete")
public class DeleteDocument {
	
	private String cluster;
	
	private String index;
	
	private String type;
	
	private String id;
	
	private boolean refresh;

	public DeleteDocument() {
		refresh = false;
	}
	
	public String getCluster() {
		return cluster;
	}
	
	public String getId() {
		return id;
	}
	
	public String getIndex() {
		return index;
	}
	
	public String getType() {
		return type;
	}
	
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setIndex(String index) {
		this.index = index;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isRefresh() {
		return refresh;
	}
	
	public void setRefresh(boolean refresh) {
		this.refresh = refresh;
	}
}
