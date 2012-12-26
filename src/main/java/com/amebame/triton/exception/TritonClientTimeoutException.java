package com.amebame.triton.exception;

public class TritonClientTimeoutException extends TritonClientException {
	
	private static final long serialVersionUID = -7740109050086234544L;

	public TritonClientTimeoutException(String message) {
		super(message);
	}

}
