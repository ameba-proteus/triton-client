package com.amebame.triton.exception;

public class TritonException extends Exception {

	private static final long serialVersionUID = 6884306643710263861L;

	private TritonErrors error;

	public TritonException(TritonErrors error, String message) {
		super(message);
		this.error = error;
	}

	public TritonException(TritonErrors error, Throwable cause) {
		super(cause.getMessage(), cause);
		this.error = error;
	}

	public TritonException(TritonErrors error, String message, Throwable cause) {
		super(message, cause);
		this.error = error;
	}
	
	public TritonErrors getError() {
		return error;
	}
}
