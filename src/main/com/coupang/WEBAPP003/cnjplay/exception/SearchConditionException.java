package com.coupang.WEBAPP003.cnjplay.exception;

public class SearchConditionException extends Exception {

	private String exceptionMessage;

	private static final long serialVersionUID = 1372309230400572542L;

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public SearchConditionException() {
	}

	public SearchConditionException(String message) {
		super(message);
		this.exceptionMessage = message;
	}

	public SearchConditionException(Throwable arg0) {
		super(arg0);
	}

	public SearchConditionException(String message, Throwable arg1) {
		super(message, arg1);
		this.exceptionMessage = message;

	}

}
