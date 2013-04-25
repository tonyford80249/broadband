package com.resqsoft.exception;

public class PageNotFoundException extends BaseRuntimeException {
	
	public PageNotFoundException() {
		super();
	}
	
	public PageNotFoundException(String message) {
        super(message);
    }

    public PageNotFoundException(Throwable cause) {
        super(cause);
    }

    public PageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
