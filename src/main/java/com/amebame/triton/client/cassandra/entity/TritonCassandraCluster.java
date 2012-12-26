package com.amebame.triton.client.cassandra.entity;

/**
 * Cluster info
 */
public class TritonCassandraCluster {
	
	private String name;

	public TritonCassandraCluster() {
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
