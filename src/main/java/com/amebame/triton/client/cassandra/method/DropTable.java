package com.amebame.triton.client.cassandra.method;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@TritonMethodData("cassandra.table.drop")
@JsonInclude(Include.NON_NULL)
public class DropTable {
	
	private String cluster;
	
	private String keyspace;
	
	private String table;

	public DropTable() {
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

}
