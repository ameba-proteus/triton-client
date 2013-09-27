package com.amebame.triton.client.cassandra.method;

import java.util.Map;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Create a keyspace
 */
@TritonMethodData("cassandra.keyspace.create")
@JsonInclude(Include.NON_NULL)
public class CreateKeyspace {
	
	// cluster name
	private String cluster;
	
	// keyspace name
	private String keyspace;
	
	// strategy options
	private Map<String, Object> replication;
	
	public CreateKeyspace() {
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
	
	public Map<String, Object> getReplication() {
		return replication;
	}
	
	public void setReplication(Map<String, Object> replication) {
		this.replication = replication;
	}

}
