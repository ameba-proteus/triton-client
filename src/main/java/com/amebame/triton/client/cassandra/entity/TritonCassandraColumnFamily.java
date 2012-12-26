package com.amebame.triton.client.cassandra.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TritonCassandraColumnFamily {
	
	private String name;
	
	private String caching;
	
	private String comment;
	
	private String compactionStrategy;
	
	private Map<String, String> compactionStrategyOptions;
	
	private String comparatorType;
	
	private Map<String, String> compressionOptions;
	
	private String defaultValidationClass;
	
	private String keyValidationClass;
	
	private int gcGraceSeconds;
	
	public TritonCassandraColumnFamily() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaching() {
		return caching;
	}

	public void setCaching(String caching) {
		this.caching = caching;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCompactionStrategy() {
		return compactionStrategy;
	}

	public void setCompactionStrategy(String compactionStrategy) {
		this.compactionStrategy = compactionStrategy;
	}

	public Map<String, String> getCompactionStrategyOptions() {
		return compactionStrategyOptions;
	}

	public void setCompactionStrategyOptions(
			Map<String, String> compactionStrategyOptions) {
		this.compactionStrategyOptions = compactionStrategyOptions;
	}

	public String getComparatorType() {
		return comparatorType;
	}

	public void setComparatorType(String comparatorType) {
		this.comparatorType = comparatorType;
	}

	public Map<String, String> getCompressionOptions() {
		return compressionOptions;
	}

	public void setCompressionOptions(Map<String, String> compressionOptions) {
		this.compressionOptions = compressionOptions;
	}

	public String getDefaultValidationClass() {
		return defaultValidationClass;
	}

	public void setDefaultValidationClass(String defaultValidationClass) {
		this.defaultValidationClass = defaultValidationClass;
	}

	public String getKeyValidationClass() {
		return keyValidationClass;
	}

	public void setKeyValidationClass(String keyValidationClass) {
		this.keyValidationClass = keyValidationClass;
	}

	public int getGcGraceSeconds() {
		return gcGraceSeconds;
	}

	public void setGcGraceSeconds(int gcGraceSeconds) {
		this.gcGraceSeconds = gcGraceSeconds;
	}

}
