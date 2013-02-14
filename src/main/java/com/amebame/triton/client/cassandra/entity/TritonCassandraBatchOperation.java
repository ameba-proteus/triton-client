package com.amebame.triton.client.cassandra.entity;

import java.util.HashMap;
import java.util.Map;

import com.amebame.triton.json.Json;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@JsonInclude(Include.NON_NULL)
public class TritonCassandraBatchOperation {
	
	private Integer ttl;
	
	@JsonProperty("column_family")
	private String columnFamily;
	
	private Map<String, Map<String, JsonNode>> updates;
	
	private Map<String, JsonNode> removes;
	
	public TritonCassandraBatchOperation() {
	}

	public Integer getTtl() {
		return ttl;
	}

	public void setTtl(Integer ttl) {
		this.ttl = ttl;
	}
	
	public boolean hasTtl() {
		return ttl != null;
	}

	public Map<String, Map<String, JsonNode>> getUpdates() {
		return updates;
	}

	public void setUpdates(Map<String, Map<String, JsonNode>> updates) {
		this.updates = updates;
	}
	
	public void putUpdate(String rowKey, String column, JsonNode value) {
		if (updates == null) {
			updates = new HashMap<>();
		}
		Map<String, JsonNode> row = updates.get(rowKey);
		if (row == null) {
			row = new HashMap<>();
			updates.put(rowKey, row);
		}
		row.put(column, value);
	}

	public String getColumnFamily() {
		return columnFamily;
	}
	
	public void setColumnFamily(String columnFamily) {
		this.columnFamily = columnFamily;
	}
	
	public Map<String, JsonNode> getRemoves() {
		return removes;
	}

	public void setRemoves(Map<String, JsonNode> removes) {
		this.removes = removes;
	}
	
	public void putRemove(String rowKey) {
		if (removes == null) {
			removes = new HashMap<>();
		}
		removes.put(rowKey, Json.bool(true));
	}
	
	public void putRemove(String rowKey, String column) {
		if (removes == null) {
			removes = new HashMap<>();
		}
		JsonNode node = removes.get(rowKey);
		if (node == null || !node.isArray()) {
			node = Json.array();
			removes.put(rowKey, node);
		}
		((ArrayNode) node).add(column);
	}

}
