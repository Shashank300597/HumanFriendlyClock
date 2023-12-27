package com.humanFriendlyClock.ExceptionHandler;

import org.springframework.stereotype.Component;


@Component
public class IncorrectInputException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5186529782304989438L;

	private String errorCode;
	private String errorMessage;

	public IncorrectInputException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public IncorrectInputException() {

	}
}
