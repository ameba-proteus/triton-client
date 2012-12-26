package com.amebame.triton.client.cassandra.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TritonCassandraKeyspace {
	
	private String name;
	
	@JsonProperty("strategy_class")
	private String strategyClass;
	
	@JsonProperty("strategy_options")
	private Map<String, String> strategyOptions;
	
	private List<TritonCassandraColumnFamily> columnFamilies;

	public TritonCassandraKeyspace() {
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStrategyClass() {
		return strategyClass;
	}
	
	public void setStrategyClass(String strategyClass) {
		this.strategyClass = strategyClass;
	}
	
	public Map<String, String> getStrategyOptions() {
		return strategyOptions;
	}
	
	public void setStrategyOptions(Map<String, String> strategyOptions) {
		this.strategyOptions = strategyOptions;
	}
	
	public List<TritonCassandraColumnFamily> getColumnFamilies() {
		return columnFamilies;
	}
	
	public void setColumnFamilies(
			List<TritonCassandraColumnFamily> columnFamilies) {
		this.columnFamilies = columnFamilies;
	}
	
	public void addColumnFamily(TritonCassandraColumnFamily columnFamily) {
		if (columnFamilies == null) {
			columnFamilies = new ArrayList<TritonCassandraColumnFamily>();
		}
		columnFamilies.add(columnFamily);
	}
}
