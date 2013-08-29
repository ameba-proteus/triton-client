package com.amebame.triton.client.elasticsearch.method;

import com.fasterxml.jackson.databind.JsonNode;


public class UpdateDocumentResult {
	
	private String id;
	
	private long version;
	
	private JsonNode source;

	public UpdateDocumentResult() {
	}
	
	public long getVersion() {
		return version;
	}
	
	public String getId() {
		return id;
	}
	
	public JsonNode getSource() {
		return source;
	}
	
	public void setSource(JsonNode source) {
		this.source = source;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setVersion(long version) {
		this.version = version;
	}

}
