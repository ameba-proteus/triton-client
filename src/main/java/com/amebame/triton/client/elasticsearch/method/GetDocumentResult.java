package com.amebame.triton.client.elasticsearch.method;

import java.util.Map;

public class GetDocumentResult {
	
	private String id;
	
	private long version;
	
	private Map<String, Object> source;

	public GetDocumentResult() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Map<String, Object> getSource() {
		return source;
	}

	public void setSource(Map<String, Object> source) {
		this.source = source;
	}

}
