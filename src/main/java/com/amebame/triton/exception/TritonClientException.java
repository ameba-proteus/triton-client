package com.amebame.triton.exception;

public class TritonClientException extends TritonException {
	
	private static final long serialVersionUID = 8716954986231799899L;

	public TritonClientException(TritonErrors error, String message) {
		super(error, message);
	}

	public TritonClientException(TritonErrors error, Throwable cause) {
		super(error, cause.getMessage(), cause);
	}

	public TritonClientException(TritonErrors error, String message, Throwable cause) {
		super(error, message, cause);
	}


}
