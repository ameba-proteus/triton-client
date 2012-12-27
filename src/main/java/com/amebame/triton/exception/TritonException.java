package com.amebame.triton.exception;

public class TritonException extends Exception {

	private static final long serialVersionUID = 6884306643710263861L;

	public TritonException() {
	}

	public TritonException(String message) {
		super(message);
	}

	public TritonException(Throwable cause) {
		super(cause.getMessage(), cause);
	}

	public TritonException(String message, Throwable cause) {
		super(message, cause);
	}

	public TritonException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	/**
	 * Get root cause of {@link Throwable} instance.
	 * @param throwable
	 * @return
	 */
	public static final Throwable getRootCause(Throwable throwable) {
		int max = 10;
		while (max-- > 0) {
			Throwable cause = throwable.getCause();
			if (cause == null || cause == throwable) {
				break;
			}
			throwable = cause;
		}
		return throwable;
	}

}
