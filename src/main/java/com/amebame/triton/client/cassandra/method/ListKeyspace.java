package com.amebame.triton.client.cassandra.method;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Create a keyspace
 */
@TritonMethodData("cassandra.keyspace.list")
@JsonInclude(Include.NON_NULL)
public class ListKeyspace {
	
	// cluster name
	private String cluster;
	
	public ListKeyspace() {
	}
	
	public String getCluster() {
		return cluster;
	}
	
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

}
