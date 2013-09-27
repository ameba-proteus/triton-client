package com.amebame.triton.client.cassandra.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TritonCassandraKeyspace {
	
	private String name;
	
	private Map<String, String> replication;
	
	private List<TritonCassandraTable> tables;
	
	public TritonCassandraKeyspace() {
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String, String> getReplication() {
		return replication;
	}
	
	public void setReplication(Map<String, String> replication) {
		this.replication = replication;
	}
	
	public void setTables(List<TritonCassandraTable> tables) {
		this.tables = tables;
	}
	
	public List<TritonCassandraTable> getTables() {
		return tables;
	}
	
}
