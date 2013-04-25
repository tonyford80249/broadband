package com.resqsoft.exception;

public class BaseRuntimeException extends RuntimeException {

	public BaseRuntimeException() {
		super();
	}
	
	public BaseRuntimeException(String message) {
        super(message);
    }

    public BaseRuntimeException(Throwable cause) {
        super(cause);
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}