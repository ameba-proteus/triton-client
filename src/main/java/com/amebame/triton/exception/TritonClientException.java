package com.amebame.triton.exception;

public class TritonClientException extends TritonException {
	
	private static final long serialVersionUID = 8716954986231799899L;

	public TritonClientException() {
	}

	public TritonClientException(String message) {
		super(message);
	}

	public TritonClientException(Throwable cause) {
		super(cause.getMessage(), cause);
	}

	public TritonClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public TritonClientException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
