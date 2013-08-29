package com.amebame.triton.client.elasticsearch.method;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class SearchDocumentResult {
	
	private List<SearchDocumentHit> hits;
	
	private String scrollId;
	
	private JsonNode facets;
	
	private long total;
	
	private long took;
	
	public SearchDocumentResult() {
	}
	
	public String getScrollId() {
		return scrollId;
	}
	
	public void setScrollId(String scrollId) {
		this.scrollId = scrollId;
	}
	
	public long getTook() {
		return took;
	}
	
	public void setTook(long took) {
		this.took = took;
	}
	
	public JsonNode getFacets() {
		return facets;
	}
	
	public long getTotal() {
		return total;
	}
	
	public void setTotal(long total) {
		this.total = total;
	}
	
	public void setFacets(JsonNode facets) {
		this.facets = facets;
	}
	
	public List<SearchDocumentHit> getHits() {
		return hits;
	}
	
	public void addHit(SearchDocumentHit hit) {
		if (hits == null) {
			hits = new ArrayList<>();
		}
		hits.add(hit);
	}
	
	public void setHits(List<SearchDocumentHit> hits) {
		this.hits = hits;
	}
}
