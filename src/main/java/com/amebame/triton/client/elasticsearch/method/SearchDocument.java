package com.amebame.triton.client.elasticsearch.method;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.databind.JsonNode;

@TritonMethodData("elasticsearch.search")
public class SearchDocument {
	
	private String cluster;
	
	private String[] indices;
	
	private String[] types;
	
	private String[] routings;
	
	private JsonNode filter;
	
	private JsonNode query;
	
	private JsonNode facets;
	
	private String searchType;
	
	private String scrollId;
	
	private int from;

	private int size = 100;
	
	private long timeout;

	public SearchDocument() {
	}
	
	public String getCluster() {
		return cluster;
	}
	
	public String[] getIndices() {
		return indices;
	}
	
	public String[] getTypes() {
		return types;
	}
	
	public String[] getRoutings() {
		return routings;
	}
	
	public boolean hasRoutings() {
		return routings != null;
	}
	
	public JsonNode getQuery() {
		return query;
	}
	
	public boolean hasQuery() {
		return query != null && !query.isNull();
	}
	
	public JsonNode getFilter() {
		return filter;
	}
	
	public boolean hasFilter() {
		return filter != null && !filter.isNull();
	}
	
	public JsonNode getFacets() {
		return facets;
	}
	
	public boolean hasFacets() {
		return facets != null && !facets.isNull();
	}
	
	public int getFrom() {
		return from;
	}
	
	public String getScrollId() {
		return scrollId;
	}
	
	public boolean hasScrollId() {
		return scrollId != null;
	}
	
	public String getSearchType() {
		return searchType;
	}
	
	public boolean hasSearchType() {
		return searchType != null;
	}
	
	public int getSize() {
		return size;
	}
	
	public long getTimeout() {
		return timeout;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	
	public void setIndex(String index) {
		this.indices = new String[] { index };
	}
	
	public void setIndices(String[] indices) {
		this.indices = indices;
	}
	
	public void setTypes(String[] types) {
		this.types = types;
	}
	
	public void setType(String type) {
		this.types = new String[] { type };
	}
	
	public void setRoutings(String[] routings) {
		this.routings = routings;
	}
	
	public void setRouting(String routing) {
		this.routings = new String[] { routing };
	}
	
	public void setFacets(JsonNode facets) {
		this.facets = facets;
	}
	
	public void setFilter(JsonNode filter) {
		this.filter = filter;
	}
	
	public void setFrom(int from) {
		this.from = from;
	}
	
	public void setQuery(JsonNode query) {
		this.query = query;
	}
	
	public void setScrollId(String scrollId) {
		this.scrollId = scrollId;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

}
