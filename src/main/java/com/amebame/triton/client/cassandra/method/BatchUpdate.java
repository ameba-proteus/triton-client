package com.amebame.triton.client.cassandra.method;

import java.util.ArrayList;
import java.util.List;

import com.amebame.triton.client.TritonMethodData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * BatchUpdate works as atomic batch.
 */
@TritonMethodData("cassandra.column.batch")
@JsonInclude(Include.NON_NULL)
public class BatchUpdate {

	private String cluster;
	
	private String keyspace;
	
	private Consistency consistency;
	
	private List<BatchOperation> operations;
	
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

	public List<BatchOperation> getOperations() {
		return operations;
	}
	
	public void setOperations(List<BatchOperation> operations) {
		this.operations = operations;
	}
	
	public BatchOperation addRemove() {
		BatchOperation op = new BatchOperation();
		op.setMode(BatchOperationMode.remove);
		addOperation(op);
		return op;
	}

	public BatchOperation addSet() {
		BatchOperation op = new BatchOperation();
		op.setMode(BatchOperationMode.set);
		addOperation(op);
		return op;
	}
	
	public void addOperation(BatchOperation operation) {
		if (operations == null) {
			operations = new ArrayList<>();
		}
		operations.add(operation);
	}

}
