package com.amebame.triton.client.cassandra.method;

import java.util.ArrayList;
import java.util.List;

import com.amebame.triton.client.TritonMethodData;
import com.amebame.triton.client.cassandra.entity.TritonCassandraBatchOperation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * BatchUpdate works as atomic batch.
 */
@TritonMethodData("cassandra.columnfamily.batch")
@JsonInclude(Include.NON_NULL)
public class BatchUpdate {

	private String cluster;
	
	private String keyspace;
	
	private Consistency consistency;
	
	private List<TritonCassandraBatchOperation> operations;
	
	public BatchUpdate() {
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

	public Consistency getConsistency() {
		return consistency;
	}

	public void setConsistency(Consistency consistency) {
		this.consistency = consistency;
	}
	
	public boolean hasOperations() {
		return operations != null && operations.size() > 0;
	}

	public List<TritonCassandraBatchOperation> getOperations() {
		return operations;
	}
	
	public void setOperations(List<TritonCassandraBatchOperation> operations) {
		this.operations = operations;
	}
	
	public void addOperation(TritonCassandraBatchOperation operation) {
		if (operations == null) {
			operations = new ArrayList<>();
		}
		operations.add(operation);
	}

}
