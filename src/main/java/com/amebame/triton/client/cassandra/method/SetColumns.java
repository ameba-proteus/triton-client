package com.amebame.triton.client.cassandra.method;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class SetColumns {
	
	private Map<String, Map<String, JsonNode>> rows;
	
	private String cluster;
	
	private String keyspace;
	
	private Integer ttl;
	
	@JsonProperty("column_family")
	private String columnFamily;
	
	private Consistency consistency;
	
	public SetColumns() {
	}
	
	public void setRows(Map<String, Map<String, JsonNode>> rows) {
		this.rows = rows;
	}
	
	public Map<String, Map<String, JsonNode>> getRows() {
		return rows;
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

	public String getColumnFamily() {
		return columnFamily;
	}

	public void setColumnFamily(String columnFamily) {
		this.columnFamily = columnFamily;
	}

	public Integer getTtl() {
		return ttl;
	}
	
	public void setTtl(Integer ttl) {
		this.ttl = ttl;
	}
}
