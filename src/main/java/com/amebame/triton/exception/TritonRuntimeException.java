package com.amebame.triton.exception;

public class TritonRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7958464770082357800L;
	
	private TritonErrors error;

	public TritonRuntimeException() {
		super();
		this.error = TritonErrors.server_error;
	}

	public TritonRuntimeException(TritonErrors error) {
		super();
		this.error = error;
	}

	public TritonRuntimeException(TritonErrors error, String message, Throwable cause) {
		super(message, cause);
		this.error = error;
	}
	
	public TritonRuntimeException(TritonErrors error, String message) {
		super(message);
		this.error = error;
	}

	public TritonRuntimeException(TritonErrors error, Throwable cause) {
		super(cause.getMessage(), cause);
		this.error = error;
	}

	public TritonErrors getError() {
		return error;
	}
}
