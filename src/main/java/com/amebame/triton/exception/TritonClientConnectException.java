package com.amebame.triton.exception;

public class TritonClientConnectException extends TritonClientException {
	
	private static final long serialVersionUID = 6361241566200424L;

	public TritonClientConnectException() {
	}

	public TritonClientConnectException(String message) {
		super(message);
	}

	public TritonClientConnectException(Throwable cause) {
		super(cause.getMessage(), cause);
	}

	public TritonClientConnectException(String message, Throwable cause) {
		super(message, cause);
	}

	public TritonClientConnectException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
