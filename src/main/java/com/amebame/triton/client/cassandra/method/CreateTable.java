package com.amebame.triton.client.cassandra.method;

import java.util.Map;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@TritonMethodData("cassandra.table.create")
@JsonInclude(Include.NON_NULL)
public class CreateTable {
	
	private String cluster;
	
	private String keyspace;
	
	private String table;
	
	private String keyType;
	
	private String columnType;
	
	private String comment = "";
	
	private Map<String, Object> options;
	
	public CreateTable() {
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
	
	public String getKeyType() {
		return keyType;
	}
	
	public String getColumnType() {
		return columnType;
	}
	
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Map<String, Object> getOptions() {
		return options;
	}
	
	public void setOptions(Map<String, Object> options) {
		this.options = options;
	}

}