package com.amebame.triton.client.cassandra.method;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.amebame.triton.json.Json;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@JsonInclude(Include.NON_NULL)
public class BatchOperation {
	
	private Integer ttl;
	
	private BatchOperationMode mode;
	
	private String table;
	
	private List<String> keys;
	
	private List<String> columns;
	
	private JsonNode rows;
	
	public BatchOperation() {
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
	
	public BatchOperationMode getMode() {
		return mode;
	}
	
	public void setMode(BatchOperationMode mode) {
		this.mode = mode;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public JsonNode getRows() {
		return rows;
	}
	
	public void setRows(JsonNode rows) {
		this.rows = rows;
	}
	
	public ObjectNode createRows() {
		ObjectNode rows = Json.object();
		this.rows = rows;
		return rows;
	}

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	
	public void setKey(String key) {
		this.keys = Arrays.asList(key);
	}

	public List<String> getColumns() {
		return columns;
	}
	
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	
	public void setColumn(String column) {
		this.columns = Arrays.asList(column);
	}

}
