package com.amebame.triton.client.cassandra.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;

@JsonInclude(Include.NON_NULL)
public class TritonCassandraTable {
	
	private String name;
	
	private String keyType;
	
	private String columnType;
	
	private JsonNode options;
	
	public TritonCassandraTable() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public JsonNode getOptions() {
		return options;
	}
	
	public void setOptions(JsonNode options) {
		this.options = options;
	}
	
	public String getKeyType() {
		return keyType;
	}
	
	public String getColumnType() {
		return columnType;
	}
	
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

}
