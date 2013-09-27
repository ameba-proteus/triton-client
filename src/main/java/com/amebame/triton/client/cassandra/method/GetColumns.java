package com.amebame.triton.client.cassandra.method;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;

@TritonMethodData("cassandra.column.get")
@JsonInclude(Include.NON_NULL)
public class GetColumns {
	
	private String cluster;
	
	private String keyspace;
	
	private String table;
	
	private Consistency consitency;
	
	/**
	 * various row key definitions
	 * "a" = single key
	 * ["a","b","c"] = key array
	 * { "start": "starttoken", "end": "endtoken" }
	 * { "start": {"value":"starttoken","exclusive": true }, "end": "endtoken" } = column range with start exclusive
	 * { "start": "starttoken", "reversed": true, "end": "endtoken" }
	 * 
	 * note that the key is sorted by what partitioner you use.
	 * if start is specified, end must be also specified.
	 */
	private JsonNode keys;
	
	/**
	 * various column key definitions
	 * "a" = single column
	 * ["a","b","c"] = column array
	 * { "start": "fromkey", "end": "tokey" } = column range
	 * { "startWith": "prefix" } = column start with prefix. if start or end is specified, startWith will be ignored.
	 * { "start": {"value": "fromkey", "exclusive": true}, "end": "tokey" } = column range with start exclusive
	 * { "end": "endcolumn", "reversed": true } = column range with limit and reversed order.
	 */
	private JsonNode columns;
	
	public GetColumns() {
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

	@JsonIgnore
	public boolean isSingleKey() {
		return keys != null && !keys.isArray() && !keys.isObject();
	}
	
	public boolean hasKeys() {
		return keys != null;
	}
	
	public boolean hasKeyArray() {
		return keys != null && keys.isArray();
	}
	
	public boolean hasKeyRange() {
		return keys != null && keys.isObject();
	}
	
	public JsonNode getKeys() {
		return keys;
	}
	
	public void setKeys(JsonNode keys) {
		this.keys = keys;
	}
	
	public void setKey(JsonNode key) {
		this.keys = key;
	}

	public boolean hasColumns() {
		return columns != null;
	}
	
	public boolean hasSingleColumn() {
		return columns != null && !columns.isArray() && !columns.isObject();
	}
	
	public boolean hasColumnRange() {
		return columns != null && columns.isObject();
	}
	
	public boolean hasColumnNames() {
		return columns != null && columns.isArray();
	}
	
	public void setColumn(JsonNode column) {
		this.columns = column;
	}
	
	public void setColumns(JsonNode columns) {
		this.columns = columns;
	}
	
	public JsonNode getColumns() {
		return columns;
	}
	
	public Consistency getConsitency() {
		return consitency;
	}
	
	public void setConsitency(Consistency consitency) {
		this.consitency = consitency;
	}
	
	public boolean hasConsistency() {
		return consitency != null;
	}

}
