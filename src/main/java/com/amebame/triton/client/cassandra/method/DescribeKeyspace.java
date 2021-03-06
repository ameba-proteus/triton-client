package com.amebame.triton.client.cassandra.method;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Get detail of the keyspace
 */
@TritonMethodData("cassandra.keyspace.create")
@JsonInclude(Include.NON_NULL)
public class DescribeKeyspace {
	
	// cluster name
	private String cluster;
	
	// keyspace name
	private String keyspace;
	
	public DescribeKeyspace() {
	}
	
	public String getCluster() {
		return cluster;
	}
	
	public String getKeyspace() {
		return keyspace;
	}
	
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	
	public void setKeyspace(String keyspace) {
		this.keyspace = keyspace;
	}
	
}
