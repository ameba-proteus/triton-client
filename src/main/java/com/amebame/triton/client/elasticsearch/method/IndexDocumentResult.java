package com.amebame.triton.client.elasticsearch.method;

public class IndexDocumentResult {
	
	private String id;
	
	private long version;

	public IndexDocumentResult() {
	}
	
	public IndexDocumentResult(String id, long version) {
		this.id = id;
		this.version = version;
	}
	
	public String getId() {
		return id;
	}
	
	public long getVersion() {
		return version;
	}

}
