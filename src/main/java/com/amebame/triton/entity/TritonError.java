package com.amebame.triton.entity;

public class TritonError {
	
	private int code;
	
	private String message;
	
	public TritonError(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}

}
