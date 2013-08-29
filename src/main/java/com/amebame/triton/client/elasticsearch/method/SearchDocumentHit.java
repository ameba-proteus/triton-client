package com.amebame.triton.client.elasticsearch.method;

import com.fasterxml.jackson.databind.JsonNode;

public class SearchDocumentHit {
	
	private String id;
	
	private String index;
	
	private String type;
	
	private JsonNode source;
	
	private float score;

	public SearchDocumentHit() {
	}
	
	public String getId() {
		return id;
	}
	
	public String getIndex() {
		return index;
	}
	
	public JsonNode getSource() {
		return source;
	}
	
	public String getType() {
		return type;
	}
	
	public float getScore() {
		return score;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setIndex(String index) {
		this.index = index;
	}
	
	public void setSource(JsonNode source) {
		this.source = source;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setScore(float score) {
		this.score = score;
	}
	
}
