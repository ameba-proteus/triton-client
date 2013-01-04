package com.amebame.triton.exception;

public class TritonClientConnectException extends TritonClientException {
	
	private static final long serialVersionUID = 6361241566200424L;

	public TritonClientConnectException(String message) {
		super(TritonErrors.not_connected, message);
	}

	public TritonClientConnectException(Throwable cause) {
		super(TritonErrors.not_connected, cause.getMessage(), cause);
	}

	public TritonClientConnectException(String message, Throwable cause) {
		super(TritonErrors.not_connected, message, cause);
	}

}
