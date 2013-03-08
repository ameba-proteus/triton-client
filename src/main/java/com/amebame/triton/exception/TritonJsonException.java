package com.amebame.triton.exception;

public class TritonJsonException extends TritonRuntimeException {

	private static final long serialVersionUID = -5916693574413964335L;

	public TritonJsonException() {
		super(TritonErrors.json_format);
	}

	public TritonJsonException(String message, Throwable cause) {
		super(TritonErrors.json_format, message, cause);
	}

	public TritonJsonException(String message) {
		super(TritonErrors.json_format, message);
	}

	public TritonJsonException(Throwable cause) {
		super(TritonErrors.json_format, cause.getMessage(), cause);
	}

}
