package com.amebame.triton.client;


public class TritonClientConfiguration {
	
	// Maximum boss thread
	private int boss = 1;
	
	// Maximum worker thread
	private int worker = 4;
	
	private int connectTimeout = 5000;
	
	private long commandTimeout = 5000L;
	
	public TritonClientConfiguration() {
	}
	
	public int getBoss() {
		return boss;
	}
	
	public void setBoss(int boss) {
		this.boss = boss;
	}
	
	public int getWorker() {
		return worker;
	}
	
	public void setWorker(int worker) {
		this.worker = worker;
	}
	
	public int getConnectTimeout() {
		return connectTimeout;
	}
	
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	
	public long getCommandTimeout() {
		return commandTimeout;
	}
	
	public void setCommandTimeout(long commandTimeout) {
		this.commandTimeout = commandTimeout;
	}
	
}
