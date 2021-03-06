package com.amebame.triton.exception;

public class TritonClientClosedException extends TritonClientException {
	
	private static final long serialVersionUID = -7740109050086234544L;

	public TritonClientClosedException() {
		super(TritonErrors.not_connected, "client channel has been closed.");
	}

}
