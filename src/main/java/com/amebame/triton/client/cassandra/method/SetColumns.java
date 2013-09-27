package com.amebame.triton.client.cassandra.method;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;

@JsonInclude(Include.NON_NULL)
@TritonMethodData("cassandra.column.set")
public class SetColumns {
	
	// Map<String, Map<String, JsonNode>>
	private JsonNode rows;
	
	private String cluster;
	
	private String keyspace;
	
	private Integer ttl;
	
	private String table;
	
	private Consistency consistency;
	
	public SetColumns() {
	}
	
	public JsonNode getRows() {
		return rows;
	}
	
	public void setRows(JsonNode rows) {
		this.rows = rows;
	}
	
	public void setConsistency(Consistency consistency) {
		this.consistency = consistency;
	}
	
	public Consistency getConsistency() {
		return consistency;
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

	public Integer getTtl() {
		return ttl;
	}
	
	public void setTtl(Integer ttl) {
		this.ttl = ttl;
	}
}
