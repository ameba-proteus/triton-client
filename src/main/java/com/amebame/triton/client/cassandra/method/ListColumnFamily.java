package com.amebame.triton.client.cassandra.method;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * List column families
 */
@TritonMethodData("cassandra.columnfamily.list")
@JsonInclude(Include.NON_NULL)
public class ListColumnFamily {
	
	// cluster name
	private String cluster;
	
	// keyspace name
	private String keyspace;
	
	public ListColumnFamily() {
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

}
