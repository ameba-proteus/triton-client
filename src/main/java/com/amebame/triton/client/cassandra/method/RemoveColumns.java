package com.amebame.triton.client.cassandra.method;

import java.util.Arrays;
import java.util.List;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;

@TritonMethodData("cassandra.column.remove")
@JsonInclude(Include.NON_NULL)
public class RemoveColumns {
	
	private String cluster;
	
	private String keyspace;
	
	private String table;
	
	private List<String> keys;
	
	private List<String> columns;
	
	// Map<String, Map<String, JsonNode>>
	private JsonNode rows;
	
	private Consistency consistency;

	public RemoveColumns() {
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getKeyspace() {
		return keyspace;
	}

	public void setKeyspace(String keyspace) {
		this.keyspace = keyspace;
	}
	
	public String getTable() {
		return table;
	}
	
	public void setTable(String table) {
		this.table = table;
	}

	public boolean hasRows() {
		return rows != null && rows.size() > 0;
	}

	public JsonNode getRows() {
		return rows;
	}
	
	public void setRows(JsonNode rows) {
		this.rows = rows;
	}
	
	public Consistency getConsistency() {
		return consistency;
	}

	public void setConsistency(Consistency consistency) {
		this.consistency = consistency;
	}
	
	public boolean hasKeys() {
		return keys != null && keys.size() > 0;
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
	
	public boolean hasColumns() {
		return columns != null && columns.size() > 0;
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
