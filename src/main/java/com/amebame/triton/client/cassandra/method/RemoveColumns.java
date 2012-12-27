package com.amebame.triton.client.cassandra.method;

import java.util.List;
import java.util.Map;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@TritonMethodData("cassandra.column.remove")
@JsonInclude(Include.NON_NULL)
public class RemoveColumns {
	
	private String cluster;
	
	private String keyspace;
	
	@JsonProperty("column_family")
	private String columnFamily;
	
	private Map<String, List<String>> rows;
	
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

	public String getColumnFamily() {
		return columnFamily;
	}

	public void setColumnFamily(String columnFamily) {
		this.columnFamily = columnFamily;
	}

	public Map<String, List<String>> getRows() {
		return rows;
	}

	public void setRows(Map<String, List<String>> rows) {
		this.rows = rows;
	}

	public Consistency getConsistency() {
		return consistency;
	}

	public void setConsistency(Consistency consistency) {
		this.consistency = consistency;
	}

}
